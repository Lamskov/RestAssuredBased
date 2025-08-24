import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class RestTestInsappPractice {
      private static final String BASE_URL = "https://test-api.insapp.pro";
      private static final String API_KEY = "cd736677c3b1b0c7baf04f25d94623ca";



    @BeforeAll
    public static void setUpBeforeClass() {
        RestAssured.baseURI = BASE_URL;

    }

    @Test
    public void test() {


        given()
                .contentType("application/json")
                .body("{ \"apiKey\": \"" + API_KEY + "\" }")
        .when().post("/dictionaries/GetAllBrands")
        .then()
                .statusCode(200)
                .body("value.brands", not(empty()))
                .log().all()
                .body("value.brands.brandName", hasItems("Toyota","BMW"))
                .body("value.brands.find { it.brandName == 'Toyota' }.models", not(empty()))
                .body("value.brands.find { it.brandName == 'BMW' }.models", not(empty()));




    }


}
