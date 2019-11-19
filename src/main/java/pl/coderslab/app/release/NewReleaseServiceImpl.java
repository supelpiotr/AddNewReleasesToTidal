package pl.coderslab.app.release;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.tidal.TidalServiceImplementation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewReleaseServiceImpl implements NewReleaseService {

    private final TidalServiceImplementation tidalServiceImplementation;

    @Override
    public List<String> findArtistsByGenre(String genre) {

        try {
            Document docArtists = Jsoup.connect("https://www.junodownload.com/" +
                    genre + "/charts/bestsellers/eight-weeks/tracks/").get();
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
                    genre + "/charts/bestsellers/eight-weeks/tracks/").get();
            Elements titles = docTitles.getElementsByClass("juno-title");
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
    public List<String> prepareSearchQuery(List<String> titles, List<String> artists) {
        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add(titles.get(i).split("\\(")[0] + " " + artists.get(i));
        }
        return searchQuery;
    }

    @Override
    public void createPlaylistIfNotExist(@PathVariable String genre, List<String> searchQuery) {
        if (tidalServiceImplementation.findPlaylistByName(genre) == null) {
            tidalServiceImplementation.createPlaylist(genre.toUpperCase() ,
                    genre.toUpperCase() + " - New Releases (from junodownload.com) " +
                            "created on: " + LocalDate.now());
            String playlistId = tidalServiceImplementation.findPlaylistByName(genre.toUpperCase()).getUuid();
            List<String> tidalTrackId = tidalServiceImplementation.prepareTidalTracksId(searchQuery);
            tidalServiceImplementation.addTrackToPlaylist(tidalTrackId , playlistId);

        } else {

            String playlistId = tidalServiceImplementation.findPlaylistByName(genre).getUuid();
            List<String> tidalTrackId = tidalServiceImplementation.prepareTidalTracksId(searchQuery);
            tidalServiceImplementation.addTrackToPlaylist(tidalTrackId , playlistId);

        }
    }

}
