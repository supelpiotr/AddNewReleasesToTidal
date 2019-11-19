package pl.coderslab.app.toptracks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopTracksServiceImpl implements TopTracksService{

    @Override
    public List<String> findTracksByGenre(String genre, String beatportId) {
        try {
            Document docTitles = Jsoup.connect("https://www.beatport.com/genre/"
                    + genre + "/" + beatportId + "/hype-100").get();
            Elements titles = docTitles.getElementsByClass("buk-track-title");
            ArrayList<String> titlesParsed = new ArrayList<>();
            for (Element title : titles) {
                if (title.hasText()) {
                    titlesParsed.add(title.text().split("\\(")[0]);
                }
            }
            return titlesParsed;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> findArtistsByGenre(String genre, String beatportId) {
        try {
            Document docArtists = Jsoup.connect("https://www.beatport.com/genre/"
                    + genre + "/" + beatportId + "/hype-100").get();
            Elements artists = docArtists.getElementsByClass("buk-track-artists");
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

}
