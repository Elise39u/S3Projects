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
public class SongResource {

    private Set<Song> Songs = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public SongResource() {
        Songs.add(new Song("Because Your Here", "Hatsune Miku"));
        Songs.add(new Song("Im glad i met You", "Hatsune Miku and Justin"));
        Songs.add(new Song("Calc.", "Hatsune Miku"));
    }

    @GET
    @Path("/GetAllSongs")
    public Set<Song> list() {
        int songsCount = Songs.size();

        if(songsCount > 0) {
            return Songs;
        } else {
            throw new NotFoundException("Me and Miku looked really hard but we found: " + songsCount + " amount of songs");
        }

    }

    @POST
    @Path("/AddSong")
    public Set<Song> AddSong(Song song) {
        if(song.Name == "" || song.Name == null || song.Artist == null || song.Artist == "") {
           // send a 400
           throw new BadRequestException("Sorry but we looked across your data and its seems to be invalid");
        }
        else {
            Songs.add(new Song(song.Name, song.Artist));
            return Songs;
        }
    }

    @DELETE
    @Path("/DeleteSong")
    public Set<Song> DeleteSong(Song song) {
        if(Songs.containsKey(song.Name)) {
            Songs.removeIf(exsitingSong -> exsitingSong.Name.contentEquals(song.Name));
            return Songs;
        } else {
            throw new NotFoundException("Well i looked but couldnt find your song? are you sure the data is correct");
        }
    }
}