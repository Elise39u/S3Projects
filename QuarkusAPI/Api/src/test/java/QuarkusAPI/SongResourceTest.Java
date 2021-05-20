package QuarkusAPI;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class SongResourceTest {

    @Test
    public void giveTestList() {
        given()
                .when().get("/Songs")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "name", containsInAnyOrder("Because Your Here", "Im glad i met You", "Calc."),
                        "Artist", containsInAnyOrder("Hatsune Miku", "Hatsune Miku and Justin", "Hatsune Miku"));
    }

    @Test
    public void testAdd() {
        given()
                .body("{\"name\": \"Melt\", \"Artist\": \"Hatsune Miku\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/AddSong")
                .then()
                .statusCode(200)
                .body("$.size()", is(4),
                        "name", containsInAnyOrder("Because Your Here", "Im glad i met You", "Calc.", "Melt"),
                        "Artist", containsInAnyOrder("Hatsune Miku", "Hatsune Miku and Justin", "Hatsune Miku", "Hatsune Miku"));

        given()
                .body("{\"name\": \"Melt\", \"Artist\": \"Hatsune Miku\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/DeleteSong")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "name", containsInAnyOrder("Because Your Here", "Im glad i met You", "Calc."),
                        "Artist", containsInAnyOrder("Hatsune Miku", "Hatsune Miku and Justin", "Hatsune Miku"));
    }
}