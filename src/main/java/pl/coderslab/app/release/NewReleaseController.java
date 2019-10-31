package pl.coderslab.app.release;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NewReleaseController {

    private final NewReleaseServiceImpl newReleaseService;
    private final NewRelease newRelease;

    public NewReleaseController(NewReleaseServiceImpl newReleaseService, NewRelease newRelease) {
        this.newReleaseService = newReleaseService;
        this.newRelease = newRelease;
    }

    @GetMapping("/newreleases/{genre}")
    String newTracksByGenre(@PathVariable String genre, Model model) {

        newRelease.setTitles(
                newReleaseService.findTracksByGenre(genre));
        newRelease.setArtists(
                newReleaseService.findArtistsByGenre(genre));
        model.addAttribute("releases", newRelease);
        return "forward:../../index";

    }
}
