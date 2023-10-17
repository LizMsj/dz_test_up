package steps;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    public void getUserList()
    {
        Response response = (Response) given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println();
    }

}
