package pl.coderslab.app.toptracks;

import java.util.List;

public interface TopTracksService {

    List<String> findTracksByGenre(String genre, String beatportId);
    List<String> findArtistsByGenre(String genre, String beatportId);

}
