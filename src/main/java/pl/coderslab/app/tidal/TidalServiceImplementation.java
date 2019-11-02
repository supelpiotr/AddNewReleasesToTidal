package pl.coderslab.app.tidal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.app.utils.RestHelper;

import javax.naming.directory.SearchResult;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TidalServiceImplementation implements TidalService {

    private TidalSession currentSession;
    private RestHelper restHelper;

    @Override
    public void login(String username, String password) {
        TidalSession currentSession = TidalSession.login(username, password);
    }

    @Override
    public void addTrackToPlaylist(List<String> trackId, String playlistId) {
        HttpResponse<JsonNode> jsonResponseETag = restHelper.executeRequest(currentSession.post("playlists/" + playlistId));
        restHelper.checkResponseStatus(jsonResponseETag);
        String etag = jsonResponseETag.getHeaders().get("ETag").get(0);
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(
                currentSession.post("playlists/" + playlistId + "/items")
                        .header("If-None-Match", etag)
                        .field("trackIds", String.join(",", trackId))
                        .field("toIndex", "0"));
        restHelper.checkResponseStatus(jsonResponse);
    }

    @Override
    public TidalPlaylist createPlaylist(String title, String description) {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(
                currentSession.post("users/" + currentSession.getUserId() + "/playlists")
                        .field("title", title)
                        .field("description", description));
        return restHelper.checkAndDeserialize(jsonResponse, TidalPlaylist.class);
    }

    @Override
    public TidalTrack searchTrack(String query) {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(currentSession.get("search")
                .queryString("query", query)
                .queryString("limit", "100")
                .queryString("offset", 0)
                .queryString("types", "TRACK"));
        return restHelper.checkAndDeserialize(jsonResponse, TidalTrack.class);
    }
}
