package pl.coderslab.app.tidal;

import java.util.List;

public interface TidalService {

    void login(String username, String password);
    void addTrackToPlaylist(List<String> trackId, String playlistId);
    TidalPlaylist createPlaylist(String title, String description);
    List<TidalTrack> searchTrack(String query);
    List<TidalPlaylist> getUserPlaylists();
    List<String> prepareTidalUrl(List<String> searchQuery);
    TidalPlaylist findPlaylistByName(String playlistTitle);
    List<String> prepareTidalTracksId(List<String> searchQuery);

}