package pl.coderslab.app.tidal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class TidalSearchResult {

    TidalResult<TidalTrack> tracks;

}
