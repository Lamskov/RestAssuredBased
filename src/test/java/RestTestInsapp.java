import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;


public class RestTestInsapp {

    private static final String BASE = "https://test-api.insapp.pro";
    private static final String DICT_API_KEY = "cd736677c3b1b0c7baf04f25d94623ca";


    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE;
        // На тестовых контурах TLS может быть "шумным" — это спасает от SSL-варнингов.
        RestAssured.useRelaxedHTTPSValidation();

        // Для наглядности логи можно включить так:
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test
    public void getAllModels() {
        Map<String, String> body = Map.of("ApiKey", DICT_API_KEY);

        Response resp =
                given()
                        .contentType(ContentType.JSON)
                .when()
                        .post("/dictionaries/GetAllBrands")
                .then()
                        .statusCode(200)
                        .body("value.brands", notNullValue())
                        .body("value.brands.size()", greaterThan(0))
                        .extract().response();

        List<String> brandNames = resp.path("value.brands.brandName");
        System.out.println("Всего брендов: " + brandNames.size());
        System.out.println("Первые 10: " + brandNames.stream().limit(10).toList());

        // 2. Делаем запрос к словарю брендов
/*        given()
                .contentType("application/json")
                .header("Authorization", apiKey) // если ключ идет в header
                .when()
                .post("https://api.insapp.pro/dictionaries/GetAllBrands")
                .then()
                .statusCode(200)
                .body("value.brands[0].brandName", notNullValue()); // проверим, что бренды есть
    }*/
}

}

