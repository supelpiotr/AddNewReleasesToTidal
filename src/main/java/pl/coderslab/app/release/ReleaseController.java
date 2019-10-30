package pl.coderslab.app.release;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReleaseController {

    private final NewRelease newRelease;

    @GetMapping("/newreleases/{genre}")
    String newreleases(@PathVariable String genre, Model model) {
        try {
            Document doc = Jsoup.connect("https://www.junodownload.com/" +
                    genre +"/two-weeks/releases/?order=bestseller/").get();
            Elements titles = doc.getElementsByClass("juno-title");
            Elements artists = doc.getElementsByClass("col juno-artist");
            ArrayList<String> artistsParsed = new ArrayList<>();
            ArrayList<String> titlesParsed = new ArrayList<>();
            for (Element artist : artists) {
                if (artist.hasText()){
                    artistsParsed.add(artist.text());
                }
            }
            for (Element title : titles) {
                if (title.hasText()) {
                    titlesParsed.add(title.text());
                }
            }
            newRelease.setArtists(artistsParsed);
            newRelease.setTitles(titlesParsed);
            model.addAttribute("releases", newRelease);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "forward:../../index";
    }
}
