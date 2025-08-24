import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestTest {
    private final static String API_KEY = "reqres-free-v1";


    @Test
    public void getUsers() {

            given()
                .baseUri("https://reqres.in/api")
                .basePath("/users?page=2")
                .header("x-api-key", API_KEY)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("data.find { it.email == 'george.edwards@reqres.in' }.first_name",
                        equalTo("George"));


    }
}
