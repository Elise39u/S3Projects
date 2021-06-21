package QuarkusAPI;

public class Song {
    public int Id;
    public String Name;
    public String Artist;

    public Song() {

    }

    public Song(int id, String name, String artist) {
        this.Id = id;
        this.Name = name;
        this.Artist = artist;
    }
}