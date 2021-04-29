package BackendAPI.Controller;

import java.util.Date;

public class SongController {
    public String songName;
    public String artist;
    public Date listenedDate;

    public SongController() {

    }

    public SongController(String songName, String artist, Date listenedDate) {
        this.songName = songName;
        this.artist = artist;
        this.listenedDate = listenedDate;
    }
}
