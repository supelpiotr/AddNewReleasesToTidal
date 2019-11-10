package pl.coderslab.app.tidal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.app.utils.RestHelper;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class TidalSearch {

    private TidalSession currentSession;
    private RestHelper restHelper;

    public TidalSearch(TidalSession currentSession) {
        this(currentSession, new RestHelper());
    }

    public TidalSearch(TidalSession currentSession, RestHelper restHelper) {
        this.currentSession = currentSession;
        this.restHelper = restHelper;
    }

    public List<TidalTrack> searchTrack(String query) {
        return searchTrack(query, "TRACKS").getTracks().getItems();
    }

    public TidalSearchResult searchTrack(String query, String types) {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(currentSession.get("search")
                .queryString("query", query)
                .queryString("limit", "100")
                .queryString("offset", 0)
                .queryString("types", types));

        if (!jsonResponse.getBody().getArray()
                .getJSONObject(0).getJSONObject("tracks")
                .getJSONArray("items").isNull(0)) {
            return restHelper.checkAndDeserialize(jsonResponse, TidalSearchResult.class);
        } else {
            TidalTrack tidalTrack = new TidalTrack();
            tidalTrack.setUrl("TRACK NOT FOUND");
            tidalTrack.setId(0L);
            List<TidalTrack> tidalTrackList= new ArrayList<>();
            tidalTrackList.add(tidalTrack);
            TidalResult<TidalTrack> tidalTrackTidalResult = new TidalResult<>();
            tidalTrackTidalResult.setItems(tidalTrackList);
            TidalSearchResult tidalSearchResult = new TidalSearchResult();
            tidalSearchResult.setTracks(tidalTrackTidalResult);
            return tidalSearchResult;
        }
    }

}