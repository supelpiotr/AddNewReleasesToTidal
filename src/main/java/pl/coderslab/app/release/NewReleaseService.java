package pl.coderslab.app.release;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface NewReleaseService {

    List<String> findTracksByGenre(String genre);
    List<String> findArtistsByGenre(String genre);

    List<String> prepareSearchQuery(List<String> titles, List<String> artists);

    void createPlaylistIfNotExist(@PathVariable String genre, List<String> searchQuery);

}