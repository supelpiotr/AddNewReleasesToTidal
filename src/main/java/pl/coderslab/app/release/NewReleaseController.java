package pl.coderslab.app.release;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewReleaseController {

    private final NewReleaseServiceImpl newReleaseService;
    private final NewRelease newRelease;

    @GetMapping("/newreleases/{genre}")
    String newTracksByGenre(@PathVariable String genre, Model model) {

        List<String> titles = newReleaseService.findTracksByGenre(genre);
        newRelease.setTitles(titles);

        List<String> artists = newReleaseService.findArtistsByGenre(genre);
        newRelease.setArtists(artists);
        model.addAttribute("releases", newRelease);
        return "forward:../../index";

    }
}
