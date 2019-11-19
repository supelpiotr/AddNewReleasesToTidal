package pl.coderslab.app.release;

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
public class NewReleaseController {

    private final NewReleaseServiceImpl newReleaseService;
    private final NewRelease newRelease;
    private final TidalServiceImplementation tidalServiceImplementation;
    private final UserServiceImpl userService;

    @GetMapping("/newreleases/{genre}")
    String newTracksByGenre(@PathVariable String genre, Model model, @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = newReleaseService.findTracksByGenre(genre);
        newRelease.setTitles(titles);

        List<String> artists = newReleaseService.findArtistsByGenre(genre);
        newRelease.setArtists(artists);

        List<String> searchQuery = newReleaseService.prepareSearchQuery(titles, artists);

        userLogin(userDetails);

        newRelease.setTidalURL(tidalServiceImplementation.prepareTidalUrl(searchQuery));
        newRelease.setGenre(genre);

        model.addAttribute("releases", newRelease);

        return "forward:/dashboard";

    }

    @Transactional
    @GetMapping("/createplaylist/{genre}")
    String createPlaylist(@PathVariable String genre, Model model, @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = newReleaseService.findTracksByGenre(genre);
        newRelease.setTitles(titles);

        List<String> artists = newReleaseService.findArtistsByGenre(genre);
        newRelease.setArtists(artists);

        List<String> searchQuery = newReleaseService.prepareSearchQuery(titles, artists);

        userLogin(userDetails);

        newReleaseService.createPlaylistIfNotExist(genre, searchQuery);

        return "forward:/dashboard";

    }

    public void userLogin(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username, tidalPassword);
    }

}