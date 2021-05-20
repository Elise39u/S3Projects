package QuarkusAPI;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Song")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SongResource {
    private Set<Song> Songs = Collections.newSetFromMap(Collection.synchronizedMap(new LinkedHasMap<>()));

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
