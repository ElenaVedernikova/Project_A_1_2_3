package ru.netology.rest;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

class MobileBankApiTestV1 {

    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("https://postman-echo.com")

                .body("{name: Dorothy Zborna, type: Individual}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("{name: Dorothy Zborna, type: Individual}"))
                .body("headers", hasKey("user-agent"))
                .header("Content-Type", "application/json; charset=utf-8")
                .contentType(ContentType.JSON)

        ;
    }


}
