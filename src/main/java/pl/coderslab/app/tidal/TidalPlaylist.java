package pl.coderslab.app.tidal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class TidalPlaylist {

    private String description;
    private String title;
    private String type;
    private String uuid;
    private String url;
    private Long duration;
    private Long popularity;
    private Long numberOfVideos;
    private Long numberOfTracks;

    @Override
    public String toString() {
        return "TidalPlaylist{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", uuid='" + uuid + '\'' +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", popularity=" + popularity +
                ", numberOfVideos=" + numberOfVideos +
                ", numberOfTracks=" + numberOfTracks +
                '}';
    }

}