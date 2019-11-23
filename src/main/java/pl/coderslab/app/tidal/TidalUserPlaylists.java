package pl.coderslab.app.tidal;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.owlike.genson.GenericType;
import pl.coderslab.app.utils.RestHelper;

import java.util.List;
import java.util.stream.Collectors;

public class TidalUserPlaylists {

    private static final String ETAG = "ETag";

    private TidalSession currentSession;
    private RestHelper restHelper;

    public TidalUserPlaylists(TidalSession currentSession) {
        this(currentSession, new RestHelper());
    }

    public TidalUserPlaylists(TidalSession currentSession, RestHelper restHelper) {
        this.currentSession = currentSession;
        this.restHelper = restHelper;
    }

    public List<TidalPlaylist> getUserPlaylists() {
        HttpResponse<JsonNode> jsonResponse =
                restHelper.executeRequest(currentSession.get("users/" + currentSession.getUserId() + "/playlists"));
        return restHelper.checkAndDeserialize(jsonResponse, new GenericType<TidalResult<TidalPlaylist>>(){}).getItems();
    }

    public TidalPlaylist createPlaylist(String title, String description) {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(
                currentSession.post("users/" + currentSession.getUserId() + "/playlists")
                        .field("title", title)
                        .field("description", description));
        return restHelper.checkAndDeserialize(jsonResponse, TidalPlaylist.class);
    }

    public void addTrackToPlaylist(List<String> trackId, String playlistId) {
        List<String> trackIdWithoutNull = trackId.stream()
                .filter(c -> !c.equals("0"))
                .collect(Collectors.toList());
        HttpResponse<JsonNode> jsonResponseETag = restHelper.executeRequest(currentSession.post("playlists/" + playlistId));
        restHelper.checkResponseStatus(jsonResponseETag);
        String etag = jsonResponseETag.getHeaders().get("ETag").get(0);
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(
                currentSession.post("playlists/" + playlistId + "/items")
                        .header("If-None-Match", etag)
                        .field("trackIds", String.join(",", trackIdWithoutNull))
                        .field("toIndex", "0"));
        restHelper.checkResponseStatus(jsonResponse);

    }


    public TidalPlaylist findPlaylistByName(String playlistTitle) {
    List<TidalPlaylist> userPlaylist =  getUserPlaylists();
        for (int i = 0; i < userPlaylist.size(); i++) {
            if (userPlaylist.get(i).getTitle().contains(playlistTitle)) {
                return userPlaylist.get(i);
            }
        }
        return null;
    }

    public void deletePlaylist(String playlistId) {
        HttpResponse<JsonNode> jsonResponse =
                restHelper.executeRequest(currentSession.delete("playlists/" + playlistId));
        restHelper.checkResponseStatus(jsonResponse);
    }

    public void deleteTrackFromPlaylist(String playlistId, int index) {
        String etag = getPlaylistEtag(playlistId);
        HttpResponse<JsonNode> jsonResponse =
                restHelper.executeRequest(currentSession.delete("playlists/" + playlistId + "/items/" + index)
                        .header("If-None-Match", etag));
        restHelper.checkResponseStatus(jsonResponse);
    }

    private String getPlaylistEtag(String playlistId)  {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(currentSession.post("playlists/" + playlistId));
        restHelper.checkResponseStatus(jsonResponse);
        return jsonResponse.getHeaders().get(ETAG).get(0);
    }
}
