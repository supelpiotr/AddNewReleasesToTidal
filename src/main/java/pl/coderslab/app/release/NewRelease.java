package pl.coderslab.app.release;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class NewRelease {

    private List<String> titles;
    private List<String> artists;
    private List<String> tidalURL;
    private String genre;
    private List<String> tidalTrackId;

}
