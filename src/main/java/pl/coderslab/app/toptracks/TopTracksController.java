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

        topTrack.setTidalURL(tidalServiceImplementation.prepareTidalUrl(searchQuery));
        topTrack.setGenre(genre);
        topTrack.setBeatportId(beatportId);

        model.addAttribute("toptracks", topTrack);

        return "forward:/dashboard";

    }

    @Transactional
    @GetMapping("/createtopplaylist/{genre}/{beatportId}")
    String createPlaylist(@PathVariable String genre,
                          @PathVariable String beatportId,
                          @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = topTracksService.findTracksByGenre(genre, beatportId);
        topTrack.setTitles(titles);

        List<String> artists = topTracksService.findArtistsByGenre(genre, beatportId);
        topTrack.setArtists(artists);

        List<String> searchQuery = topTracksService.prepareSearchQuery(titles, artists);

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);

        topTracksService.createPlaylistIfNotExist(genre, searchQuery);

        return "forward:/dashboard";

    }

}
