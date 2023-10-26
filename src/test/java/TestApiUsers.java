import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.RequestModel.AutorizationUserRequest;
import models.ResponseModel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseTests;

import java.util.ArrayList;
import java.util.List;

@Epic("Гр.3 api tests")
@Feature("Тесты апи действия с user & userList")
public class TestApiUsers extends BaseTests {

    @Test(description = "get list user")
    public void testUserList()
    {
        apiSteps.getUserList();
    }

    @Test(description = "get single user")
    public void testGetSingleUser()
    {
        UserResponse returnUser = apiSteps.getSingleUserById(2, 200);
        UserResponse checkUser = new UserResponse();
        DataResponse tmpData = new DataResponse();
        SupportResponse tmpSupport = new SupportResponse();
        tmpData.setId(2);
        tmpData.setEmail("janet.weaver@reqres.in");
        tmpData.setFirstName("Janet");
        tmpData.setLastName("Weaver");
        tmpSupport.setText("To keep ReqRes free, contributions towards server costs are appreciated!");
        tmpSupport.setUrl("https://reqres.in/#support-heading");
        tmpData.setAvatar("https://reqres.in/img/faces/2-image.jpg");
        checkUser.setData(tmpData);
        checkUser.setSupport(tmpSupport);

        Assert.assertEquals(returnUser, checkUser);
    }
    @Test(description = "single user not found")
    public void testUserNotFound()
    {
        apiSteps.getSingleUserById(23, 404);
    }

    @Test(description = "проверяем создание sinngle user")
    public void testCheckCreatedUser()
    {
        UserCreatedResponce returnUser = apiSteps.createdUser();
        UserResponse checkUser = apiSteps.getSingleUserById(returnUser.getId(), 404);
    }

    @Test(description = "update single user bu put")
    public void testPutSingleUserPut()
    {
        UserResponceWithUpdate returnUser = apiSteps.getUpdateSingleUserAfterPut();
        Assert.assertEquals(returnUser.getName(), "morpheus");
        Assert.assertEquals(returnUser.getJob(), "zion resident");
    }
    @Test(description = "update single user by patch")
    public void testPutSingleUserPatch()
    {
        UserResponceWithUpdate returnUser = apiSteps.getUpdateSingleUserAfterPatch();
        Assert.assertEquals(returnUser.getName(), "morpheus");
        Assert.assertEquals(returnUser.getJob(), "zion resident");
    }

    @Test(description = "delete user")
    public void testDeleteUser()
    {
        apiSteps.deleteUserById(2);
    }

    @Test(description = "post register user successful")
    public void testRegisterUserSuccess()
    {
        AutorizationUserRequest user = new AutorizationUserRequest("eve.holt@reqres.in", "pistol");
        AutorizationUserResponse returnUser =  apiSteps.registrationUser(200, user);
        AutorizationUserResponse checkUser = new AutorizationUserResponse(4, "QpwL5tke4Pnpja7X4");
        Assert.assertEquals(checkUser, returnUser);
    }

    @Test(description = "get dalayed response list")
    public void testDelayedResponseList()
    {
        List<DataResponse> dataResponse = apiSteps.getDelayedList(200).getData();
        ArrayList<DataResponse> checkDataResponse = new ArrayList<>();
        DataResponse data1 = new DataResponse(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg");
        DataResponse data2 = new DataResponse(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        DataResponse data3 = new DataResponse(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg");
        DataResponse data4 = new DataResponse(4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg");
        DataResponse data5 = new DataResponse(5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg");
        DataResponse data6 = new DataResponse(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg");
        checkDataResponse.add(data1);
        checkDataResponse.add(data2);
        checkDataResponse.add(data3);
        checkDataResponse.add(data4);
        checkDataResponse.add(data5);
        checkDataResponse.add(data6);
        Assert.assertEquals(checkDataResponse, dataResponse);
    }
}



