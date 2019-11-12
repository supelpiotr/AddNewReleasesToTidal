package pl.coderslab.app.tidal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.app.utils.RestHelper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TidalServiceImplementation implements TidalService {

    private TidalSession currentSession;
    private RestHelper restHelper;
    private TidalTrack tidalTrack;
    private TidalSearch tidalSearch;
    private TidalUserPlaylists tidalUserPlaylist;

    @Override
    public TidalPlaylist findPlaylistByName(String playlistTitle) {
        return tidalUserPlaylist.findPlaylistByName(playlistTitle);
    }

    @Override
    public void login(String username, String password) {
        TidalSession currentSession = TidalSession.login(username, password);
        tidalSearch = new TidalSearch(currentSession);
        tidalUserPlaylist = new TidalUserPlaylists(currentSession);
    }

    @Override
    public void addTrackToPlaylist(List<String> trackId, String playlistId) {
        tidalUserPlaylist.addTrackToPlaylist(trackId , playlistId);
    }

    @Override
    public TidalPlaylist createPlaylist(String title, String description) {
        return tidalUserPlaylist.createPlaylist(title, description);
    }

    @Override
    public List<TidalTrack> searchTrack(String query){
        return tidalSearch.searchTrack(query);
    }

    @Override
    public List<TidalPlaylist> getUserPlaylists() {
        return tidalUserPlaylist.getUserPlaylists();
    }

}
