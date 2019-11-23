package pl.coderslab.app.toptracks;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class TopTrack {

    private List<String> titles;
    private List<String> artists;
    private List<String> tidalURL;
    private String genre;
    private List<String> tidalTrackId;
    private String beatportId;

}
