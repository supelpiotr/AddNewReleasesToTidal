package pl.coderslab.app.release;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewReleaseServiceImpl implements NewReleaseService {

    @Override
    public List<String> findArtistsByGenre(String genre) {

        try {
            Document docArtists = Jsoup.connect("https://www.junodownload.com/" +
                    genre + "/two-weeks/tracks/?torder=bestseller").get();
            Elements artists = docArtists.getElementsByClass("col juno-artist");
            ArrayList<String> artistsParsed = new ArrayList<>();
            for (Element artist : artists) {
                if (artist.hasText()) {
                    artistsParsed.add(artist.text());
                }
            }
            return artistsParsed;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> findTracksByGenre(String genre) {

        try {
            Document docTitles = Jsoup.connect("https://www.junodownload.com/" +
                    genre + "/two-weeks/tracks/?order=bestseller/").get();
            Elements titles = docTitles.getElementsByClass("juno-title");
            ArrayList<String> titlesParsed = new ArrayList<>();
            for (Element title : titles) {
                if (title.hasText()) {
                    titlesParsed.add(title.text());
                }
            }
            return titlesParsed;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
