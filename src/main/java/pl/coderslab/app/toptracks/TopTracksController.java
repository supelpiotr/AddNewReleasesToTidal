package pl.coderslab.app.toptracks;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.tidal.TidalServiceImplementation;
import pl.coderslab.app.user.UserServiceImpl;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class TopTracksController {

    private final TopTracksServiceImpl topTracksService;
    private final TopTrack topTrack;
    private final TidalServiceImplementation tidalServiceImplementation;
    private final UserServiceImpl userService;

    @GetMapping("/toptracks/{genre}/{beatportId}")
    String topTracksByGenre(@PathVariable String genre,
                            @PathVariable String beatportId,
                            Model model,
                            @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = topTracksService.findTracksByGenre(genre, beatportId);
        topTrack.setTitles(titles);

        List<String> artists = topTracksService.findArtistsByGenre(genre, beatportId);
        topTrack.setArtists(artists);

        List<String> searchQuery = topTracksService.prepareSearchQuery(titles, artists);

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);

        topTrack.setTidalTrackId(tidalServiceImplementation.prepareTidalTracksId(searchQuery));
        topTrack.setGenre(genre);
        topTrack.setBeatportId(beatportId);

        model.addAttribute("toptracks", topTrack);

        return "forward:/dashboard";

    }

    @GetMapping("/toprocktracks/")
    String topTracksByGenre(Model model,
                            @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = topTracksService.findRockTracksByGenre();
        topTrack.setTitles(titles);

        List<String> artists = topTracksService.findRockArtistsByGenre();
        topTrack.setArtists(artists);

        List<String> searchQuery = topTracksService.prepareRockSearchQuery(titles , artists);

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);

        topTrack.setTidalTrackId(tidalServiceImplementation.prepareTidalTracksId(searchQuery));
        model.addAttribute("toptracks", topTrack);

        return "forward:/dashboard";

    }

    @Transactional
    @GetMapping("/createrocktopplaylist/")
    String createPlaylist(@AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = topTracksService.findRockTracksByGenre();
        topTrack.setTitles(titles);

        List<String> artists = topTracksService.findRockArtistsByGenre();
        topTrack.setArtists(artists);

        List<String> searchQuery = topTracksService.prepareRockSearchQuery(titles, artists);

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);

        topTracksService.createPlaylistIfNotExist("Rock - ", searchQuery);

        return "forward:/dashboard";

    }

}
