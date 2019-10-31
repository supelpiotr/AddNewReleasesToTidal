package pl.coderslab.app.release;

import java.util.List;

public interface NewReleaseService {

    List<String> findTracksByGenre(String genre);
    List<String> findArtistsByGenre(String genre);

}
