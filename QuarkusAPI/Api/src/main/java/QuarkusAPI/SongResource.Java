package QuarkusAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Models;

@Path("/Song")
public class SongResource {
    private Set<Song> Songs = Collections.newSetFromMap(Collection.synchronizedMap(new LinkedHasMap<>()));

    public SongResource() {
        Songs.add(new Song("Because Your Here", "Hatsune Miku"));
        Songs.add(new SOng("Im glad i met You", "Hatsune Miku and Justin"))
    }
}
