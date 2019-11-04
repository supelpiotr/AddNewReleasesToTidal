package pl.coderslab.app.tidal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class TidalResult<T> {

    private List<T> items;

}
