import io.qameta.allure.Epic;
import io.restassured.response.ResponseBody;
import models.RequestModel.UserRequest;
import models.ResponseModel.DataResponse;
import models.ResponseModel.SupportResponse;
import models.ResponseModel.UserCreatedResponce;
import models.ResponseModel.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseTests;

import javax.xml.ws.Response;

@Epic("Гр.3 api tests")
public class TestApi extends BaseTests {
    @Test(description = "проверка апи юзер лист")
    public void testUserList()
    {
        apiSteps.getUserList();
    }

    @Test(description = "проверяем апи сингле юзер")
    public void testSingleUser()
    {
        UserResponse returnUser = apiSteps.getSingleUserById(2);
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

    @Test(description = "проверяем создание юзера")
    public void testCreatedUser()
    {
        UserCreatedResponce returnUser = apiSteps.createdUser();
        UserResponse checkUser = apiSteps.getSingleUserById(returnUser.getId());
    }
}
