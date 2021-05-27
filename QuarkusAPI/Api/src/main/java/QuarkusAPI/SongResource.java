package QuarkusAPI;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Songs")
public class TestSongResource {

    private Set<Song> Songs = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public SongResource() {
        Songs.add(new Song("Because Your Here", "Hatsune Miku"));
        Songs.add(new Song("Im glad i met You", "Hatsune Miku and Justin"));
        Songs.add(new Song("Calc.", "Hatsune Miku"));
    }

    @GET
    @Path("/GetAllSongs")
    public Set<Song> list() {
        return Songs;
    }

    @Post
    @Path("/AddSong")
    public Set<Song> AddSong(Song song) {
        Songs.add(new Song(song));
        return Songs;
    }

    @DELETE
    @Path("/DeleteSong")
    public Set<Song> DeleteSong(Song song) {
        Songs.remove(exsitingSong -> exsitingSong.Name.contentEquals(song.name));
        return Songs;
    }
}