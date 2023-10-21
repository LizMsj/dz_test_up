package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.RequestModel.UserRequest;
import models.ResponseModel.UserCreatedResponce;
import models.ResponseModel.UserResponse;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    @Step
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
    }

    @Step("Получить пользователя по ай ди")
    public UserResponse getSingleUserById(int id)
    {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users/" + id)
                .then()
                .statusCode(200)
                .extract().response().body().as(UserResponse.class);
    }

    @Step("создать пользователя")
    public UserCreatedResponce createdUser()
    {
        UserRequest user = new UserRequest();
        user.setJob("leader");
        user.setName("morpheus");
        return given()
                .baseUri("https://reqres.in/")
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().response().body().as(UserCreatedResponce.class);
    }
}


