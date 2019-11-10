package pl.coderslab.app.release;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.tidal.TidalPlaylist;
import pl.coderslab.app.tidal.TidalServiceImplementation;
import java.time.LocalDate;
import pl.coderslab.app.user.UserServiceImpl;
import java.util.ArrayList;
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

        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add(titles.get(i).split("\\(")[0] + " " + artists.get(i));
        }

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();

        tidalServiceImplementation.login(username,tidalPassword);
        List<String> tidalUrl = new ArrayList<>();
        for (String s : searchQuery) {
                tidalUrl.add(tidalServiceImplementation.searchTrack(s).get(0).getUrl());
        }
        newRelease.setTidalURL(tidalUrl);
        newRelease.setGenre(genre);

        model.addAttribute("releases", newRelease);

        return "dashboard/newreleases";

    }

    @GetMapping("/createplaylist/{genre}")
    String createPlaylist(@PathVariable String genre, Model model, @AuthenticationPrincipal UserDetails userDetails) {

        List<String> titles = newReleaseService.findTracksByGenre(genre);
        newRelease.setTitles(titles);

        List<String> artists = newReleaseService.findArtistsByGenre(genre);
        newRelease.setArtists(artists);

        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add(titles.get(i).split("\\(")[0] + " " + artists.get(i));
        }

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();

        tidalServiceImplementation.login(username,tidalPassword);
        List<String> tidalUrl = new ArrayList<>();
        for (String s : searchQuery) {
            tidalUrl.add(tidalServiceImplementation.searchTrack(s).get(0).getUrl());
        }

        if (tidalServiceImplementation.findPlaylistByName(genre) == null) {
            tidalServiceImplementation.createPlaylist(genre.toUpperCase() ,
                    genre.toUpperCase() + " - New Releases (from junodownload.com) " +
                            "created on: " + LocalDate.now());
            String playlistId = tidalServiceImplementation.findPlaylistByName(genre.toUpperCase()).getUuid();
            List<String> tidalTrackId = new ArrayList<>();
            for (int i = 0; i < searchQuery.size(); i++) {
                tidalTrackId.add(tidalServiceImplementation
                        .searchTrack(searchQuery.get(i))
                        .get(0)
                        .getId().toString());
            }
                tidalServiceImplementation.addTrackToPlaylist(tidalTrackId , playlistId);

            } else {

            String playlistId = tidalServiceImplementation.findPlaylistByName(genre).getUuid();
            List<String> tidalTrackId = new ArrayList<>();
            for (int i = 0; i < searchQuery.size(); i++) {
                tidalTrackId.add(tidalServiceImplementation
                        .searchTrack(searchQuery.get(i))
                        .get(0)
                        .getId()
                        .toString());
            }
            tidalServiceImplementation.addTrackToPlaylist(tidalTrackId , playlistId);

            }


        return "/dashboard/newreleases";

    }
}