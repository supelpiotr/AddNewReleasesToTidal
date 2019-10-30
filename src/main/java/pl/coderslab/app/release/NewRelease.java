package pl.coderslab.app.release;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class NewRelease {

    private List<String> titles;
    private List<String> artists;

}
