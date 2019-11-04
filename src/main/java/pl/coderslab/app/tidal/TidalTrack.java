package pl.coderslab.app.tidal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@RequiredArgsConstructor
public class TidalTrack {
    private String copyright;
    private Map<String, Object> album;
    private String title;
    private String url;
    private int duration;
    private int popularity;
    private List<Object> artists;
    private Long id;

    @Override
    public String toString() {
        return "Track{" +
                "copyright='" + copyright + '\'' +
                ", album=" + album +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", popularity=" + popularity +
                ", artists=" + artists +
                ", id=" + id +
                '}';
    }

}