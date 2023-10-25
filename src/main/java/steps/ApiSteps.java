package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.RequestModel.AutorizationUserRequest;
import models.RequestModel.UserRequest;
import models.ResponseModel.UserResponceWithUpdate;
import models.ResponseModel.*;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    @Step("gполучить user лист")
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
    public UserResponse  getSingleUserById(int id, Integer stCode)
    {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users/" + id)
                .then()
                .statusCode(stCode)
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

    @Step("полуить responce лист")
    public ResourcesResponse getResourcesListUnknown()
    {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .extract().response().body().as(ResourcesResponse.class);
    }

    @Step("получить responce лист по id")
    public ResourcesDatumSupportResponce getResourcesListById(Integer id, Integer stCode)
    {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/unknown/" + id)
                .then()
                .statusCode(stCode)
                .extract().response().body().as(ResourcesDatumSupportResponce.class);
    }

    @Step("обновить данные о пользователе")
    public UserResponceWithUpdate getUpdateSingleUserAfterPut()
    {
        UserRequest user = new UserRequest("morpheus", "zion resident");
        return given()
                .baseUri("https://reqres.in/")
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .extract().response().body().as(UserResponceWithUpdate.class);
    }

    @Step("обновить данные о пользователе")
    public UserResponceWithUpdate getUpdateSingleUserAfterPatch()
    {
        UserRequest user = new UserRequest("morpheus", "zion resident");
        return given()
                .baseUri("https://reqres.in/")
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .extract().response().body().as(UserResponceWithUpdate.class);
    }
    @Step("delete user by id")
    public void deleteUserById(Integer id)
    {
        Response response = (Response) given()
                .baseUri("https://reqres.in/")
                .when()
                .delete("/api/users/" + id)
                .then()
                .assertThat()
                .statusCode(204)
                .extract().response();
    }

    @Step("регистрция пользователя")
    public AutorizationUserResponse registrationUser(Integer stCode, AutorizationUserRequest user)
    {
        return given()
                .baseUri("https://reqres.in/")
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then()
                .statusCode(stCode)
                .extract().response().body().as(AutorizationUserResponse.class);
    }

    @Step("авторизация пользователя")
    public AutorizationUserResponse autorizationUser(Integer stCode, AutorizationUserRequest user)
    {
        return given()
                .baseUri("https://reqres.in/")
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .post("/api/login")
                .then()
                .statusCode(stCode)
                .extract().response().body().as(AutorizationUserResponse.class);
    }

    @Step("Получить список пользователей delayed")
    public DelayedResponse  getDelayedList(Integer stCode)
    {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users?delay=3")
                .then()
                .statusCode(stCode)
                .extract().response().body().as(DelayedResponse.class);
    }
}


