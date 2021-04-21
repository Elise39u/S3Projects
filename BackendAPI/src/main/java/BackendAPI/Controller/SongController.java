package BackendAPI.Controller;

import java.util.Date;

public class SongController {
    public String songName;
    public String artist;
    public Date listendDate;

    public SongController() {

    }

    public SongController(String songName, String artist, Date listendDate) {
        this.songName = songName;
        this.artist = artist;
        this.listendDate = listendDate;
    }
}
