package pl.coderslab.app.toptracks;

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
public class TopTracksServiceImpl implements TopTracksService {

    private final TidalServiceImplementation tidalServiceImplementation;

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

    @Override
    public List<String> findRockArtistsByGenre() {

        try {

            ArrayList<String> artistsParsed = new ArrayList<>();
            for (int i = 1; i < 5; i++) {
                Document docArtist = Jsoup.connect("https://www.last.fm/tag/rock/tracks?page=" + i).get();
                Elements artists = docArtist.getElementsByClass("chartlist-artist");
                for (Element artist : artists) {
                    if (artist.hasText()) {
                        artistsParsed.add(artist.text());
                    }
                }
            }
            return artistsParsed;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> findRockTracksByGenre() {

        try {

            ArrayList<String> titlesParsed = new ArrayList<>();
            for (int i = 1; i < 5; i++) {
                Document docTitles = Jsoup.connect("https://www.last.fm/tag/rock/tracks?page=" + i).get();
                Elements titles = docTitles.getElementsByClass("chartlist-name");
                for (Element title : titles) {
                    if (title.hasText()) {
                        titlesParsed.add(title.text().split("\\(")[0]);
                    }
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
            searchQuery.add
                    (titles.get(i)
                            .replace("Original Mix", "")
                            .replace("feat.", "")
                            + " " + artists.get(i).split(",")[0]);
        }
        return searchQuery;
    }

    @Override
    public List<String> prepareRockSearchQuery(List<String> titles, List<String> artists) {
        List<String> searchQuery = new ArrayList<>(titles.size());
        for (int i = 0; i < titles.size(); i++) {
            searchQuery.add(titles.get(i) + " " + artists.get(i));
        }
        return searchQuery;
    }

    @Override
    public void createPlaylistIfNotExist(@PathVariable String genre, List<String> searchQuery) {
        if (tidalServiceImplementation.findPlaylistByName
                (genre.toUpperCase() + "TOP") == null) {
            tidalServiceImplementation.createPlaylist(genre.toUpperCase() + "TOP",
                    genre.toUpperCase() + " - Top (Beatport) " +
                            "created on: " + LocalDate.now());
            String playlistId = tidalServiceImplementation.findPlaylistByName
                    (genre.toUpperCase() + "TOP").getUuid();
            List<String> tidalTrackId = new ArrayList<>();
            for (int i = 0; i < searchQuery.size(); i++) {
                tidalTrackId.add(tidalServiceImplementation
                        .searchTrack(searchQuery.get(i))
                        .get(0)
                        .getId().toString());
            }
            tidalServiceImplementation.addTrackToPlaylist(tidalTrackId, playlistId);

        } else {

            String playlistId = tidalServiceImplementation.findPlaylistByName
                    (genre.toUpperCase() + "TOP").getUuid();
            List<String> tidalTrackId = new ArrayList<>();
            for (int i = 0; i < searchQuery.size(); i++) {
                tidalTrackId.add(tidalServiceImplementation
                        .searchTrack(searchQuery.get(i))
                        .get(0)
                        .getId()
                        .toString());
            }
            tidalServiceImplementation.addTrackToPlaylist(tidalTrackId, playlistId);
        }
    }
}
