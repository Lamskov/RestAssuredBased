/*
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestTest2 {
    public static String API_KEY = "reqres-free-v1";

    @Test
    public void getUsers() {
        List<String> responseString = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users?page=2")
                .header("x-api-key", API_KEY)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
               .extract().jsonPath().getJsonObject("data");



    }
}
*/
