import io.qameta.allure.Epic;
import models.RequestModel.AutorizationUserRequest;
import models.ResponseModel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseTests;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Epic("Гр.3 api tests")
public class TestApi extends BaseTests {
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

    @Test(description = "get list <resource>")
    public void testGetListResources() {
        List<DatumResponse> listResponseData  = apiSteps.getResourcesListUnknown().getData();
        ArrayList<DatumResponse> listDatum = new ArrayList<>();
        DatumResponse datumResponse1 = new DatumResponse(1, "cerulean", 2000, "#98B2D1", "15-4020");
        DatumResponse datumResponse2 = new DatumResponse(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        DatumResponse datumResponse3 = new DatumResponse(3, "true red", 2002, "#BF1932", "19-1664");
        DatumResponse datumResponse4 = new DatumResponse(4, "aqua sky", 2003, "#7BC4C4", "14-4811");
        DatumResponse datumResponse5 = new DatumResponse(5, "tigerlily", 2004, "#E2583E", "17-1456");
        DatumResponse datumResponse6 = new DatumResponse(6, "blue turquoise", 2005, "#53B0AE", "15-5217");
        listDatum.add(datumResponse1);
        listDatum.add(datumResponse2);
        listDatum.add(datumResponse3);
        listDatum.add(datumResponse4);
        listDatum.add(datumResponse5);
        listDatum.add(datumResponse6);

        Assert.assertEquals(listResponseData, listDatum);
    }

    @Test(description = "проверяем создание sinngle user")
    public void testCheckCreatedUser()
    {
        UserCreatedResponce returnUser = apiSteps.createdUser();
        UserResponse checkUser = apiSteps.getSingleUserById(returnUser.getId(), 404);
    }

    @Test(description = "get single <resources>")
    public void testGetSingleresponceListSuccess()
    {
        ResourcesDatumSupportResponce returnResponce = apiSteps.getResourcesListById(2, 200);
        DatumResponse data = new DatumResponse(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        SupportResponse support = new SupportResponse("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
        ResourcesDatumSupportResponce checkResponce = new ResourcesDatumSupportResponce(data, support);
        Assert.assertEquals(checkResponce, returnResponce);
    }

    @Test(description = "get single <resources> not found")
    public void testSingleResoucesListNotFound()
    {
        apiSteps.getSingleUserById(23, 404);
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
    public void testRegistrUserSuccess()
    {
        AutorizationUserRequest user = new AutorizationUserRequest("eve.holt@reqres.in", "pistol");
        AutorizationUserResponse returnUser =  apiSteps.registrationUser(200, user);
        AutorizationUserResponse checkUser = new AutorizationUserResponse(4, "QpwL5tke4Pnpja7X4");
        Assert.assertEquals(checkUser, returnUser);
    }

    @Test(description = "post register user unsuccessful")
    public void testRegistrUserUnsuccess()
    {
        AutorizationUserRequest user = new AutorizationUserRequest("sydney@fife");
        apiSteps.registrationUser(400, user);
    }

    @Test(description = "login successful post")
    public void testLogInSuccessful()
    {
        AutorizationUserRequest user = new AutorizationUserRequest("eve.holt@reqres.in", "cityslicka");
        AutorizationUserResponse returnUser =  apiSteps.autorizationUser(200, user);
        AutorizationUserResponse checkUser = new AutorizationUserResponse(null, "QpwL5tke4Pnpja7X4");
        Assert.assertEquals(checkUser, returnUser);
    }

    @Test(description = "login successful post")
    public void testLogInUnsuccessful()
    {
        AutorizationUserRequest user = new AutorizationUserRequest("eve.holt@reqres.in");
        AutorizationUserResponse returnUser =  apiSteps.autorizationUser(400, user);
        AutorizationUserResponse checkUser = new AutorizationUserResponse(null, null, "Missing password");
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



