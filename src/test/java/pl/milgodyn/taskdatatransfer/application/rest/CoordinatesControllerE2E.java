package pl.milgodyn.taskdatatransfer.application.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import static org.hamcrest.Matchers.is;

@SpringBootTest
class CoordinatesControllerE2E {

    @Test
    void testGetEndpoint() {
        RestAssured.baseURI = "http://localhost:8080/v1";

        Response response = RestAssured.given()
                .header(HttpHeaders.AUTHORIZATION, "Basic dXNlcjpwYXNzd29yZA==")
                .when()
                .get("/coordinates/DE");

        response.then()
                .assertThat().statusCode(200)
                .assertThat().body("capital", is("Berlin"))
                .assertThat().body("latitude", is((float) 52.5170365))
                .assertThat().body("longitude", is((float) 13.3888599))
                .assertThat().body("country", is("Deutschland"))
                .assertThat().body("display_name", is("Berlin, Deutschland"));
    }
}
