package pl.coderslab.app.release;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.tidal.TidalServiceImplementation;
import pl.coderslab.app.tidal.TidalSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewReleaseController {

//    private final TidalSession tidalSession;
    private final NewReleaseServiceImpl newReleaseService;
    private final NewRelease newRelease;
    private final TidalServiceImplementation tidalServiceImplementation;

    @GetMapping("/newreleases/{genre}")
    String newTracksByGenre(@PathVariable String genre, Model model, @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = newReleaseService.findTracksByGenre(genre);
        newRelease.setTitles(titles);

        List<String> artists = newReleaseService.findArtistsByGenre(genre);
        newRelease.setArtists(artists);

        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add(titles.get(i).split("\\(")[0] + " " + artists.get(i));
        }

        String password = userDetails.getPassword();
        String username = userDetails.getUsername();

        tidalServiceImplementation.login(username,password);
//        tidalServiceImplementation.login("kinga.wieczorek8@wp.pl","kinga56");
        List<String> tidalUrl = new ArrayList<>();
        for (String s : searchQuery) {
            if (tidalServiceImplementation.searchTrack(s) != null) {
                tidalUrl.add(tidalServiceImplementation.searchTrack(s).get(0).getUrl());
            } else {
                tidalUrl.add("Track not found on Tidal");
            }
        }
        newRelease.setTidalURL(tidalUrl);

        model.addAttribute("releases", newRelease);

        return "/dashboard/newreleases";

    }
}