package pl.coderslab.app.tidal;

import lombok.Data;

import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class SearchResult {

    private List<Track> tracks;

}
