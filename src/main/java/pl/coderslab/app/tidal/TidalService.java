package pl.coderslab.app.tidal;

import javax.naming.directory.SearchResult;
import java.util.List;

public interface TidalService {

    void login(String username, String password);
    void addTrackToPlaylist(List<String> trackId, String playlistId);
    TidalPlaylist createPlaylist(String title, String description);
    TidalTrack searchTrack(String query);

}