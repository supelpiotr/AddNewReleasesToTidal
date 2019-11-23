package pl.coderslab.app.toptracks;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TopTracksService {

    List<String> findTracksByGenre(String genre, String beatportId);
    List<String> findArtistsByGenre(String genre, String beatportId);
    List<String> findRockArtistsByGenre();
    List<String> findRockTracksByGenre();

    List<String> prepareSearchQuery(List<String> titles, List<String> artists);
    List<String> prepareRockSearchQuery(List<String> titles, List<String> artists);

    void createPlaylistIfNotExist(@PathVariable String genre, List<String> searchQuery);

}
