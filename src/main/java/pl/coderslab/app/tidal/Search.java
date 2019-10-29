package pl.coderslab.app.tidal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.app.utils.RestHelper;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Search {

    private Session session;
    private RestHelper restHelper;

    public List<Track> searchTrack(String query) {
        return search(query, "TRACK").getTracks();
    }

    public SearchResult search(String query, String types) {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(session.get("search")
                .queryString("query", query)
                .queryString("limit", "100")
                .queryString("offset", 0)
                .queryString("types", types));
        return restHelper.checkAndDeserialize(jsonResponse, SearchResult.class);
    }

}
