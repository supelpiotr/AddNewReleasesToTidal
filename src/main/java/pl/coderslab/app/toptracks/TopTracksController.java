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

import java.time.LocalDate;
import java.util.ArrayList;
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

        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add
                    (titles.get(i)
                            .replace("Original Mix","")
                            .replace("feat.","")
                            + " " + artists.get(i).split(",")[0]);
        }

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();

        tidalServiceImplementation.login(username,tidalPassword);
        List<String> tidalUrl = new ArrayList<>();
        for (String s : searchQuery) {
            tidalUrl.add(tidalServiceImplementation.searchTrack(s).get(0).getUrl());
        }
        topTrack.setTidalURL(tidalUrl);
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

        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add
                    (titles.get(i)
                            .replace("Original Mix", "")
                            .replace("feat.", "")
                            + " " + artists.get(i).split(",")[0]);
        }

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();

        tidalServiceImplementation.login(username,tidalPassword);

        if (tidalServiceImplementation.findPlaylistByName
                (genre.toUpperCase() + "TOP") == null) {
            tidalServiceImplementation.createPlaylist(genre.toUpperCase() + "TOP" ,
                    genre.toUpperCase() + " - Top (Beatport) " +
                            "created on: " + LocalDate.now());
            String playlistId = tidalServiceImplementation.findPlaylistByName
                    (genre.toUpperCase() + "TOP").getUuid();
            List<String> tidalTrackId = new ArrayList<>();
            for (int i = 0; i < searchQuery.size(); i++) {
                tidalTrackId.add(tidalServiceImplementation
                        .searchTrack(searchQuery.get(i))
                        .get(0)
                        .getId().toString());
            }
            tidalServiceImplementation.addTrackToPlaylist(tidalTrackId , playlistId);

        } else {

            String playlistId = tidalServiceImplementation.findPlaylistByName
                    (genre.toUpperCase() + "TOP").getUuid();
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


        return "forward:/dashboard";

    }

}
