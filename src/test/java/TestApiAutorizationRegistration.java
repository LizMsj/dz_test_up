import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.RequestModel.AutorizationUserRequest;
import models.ResponseModel.AutorizationUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseTests;

@Epic("Гр.3 api tests")
@Feature("Тесты по авторизации и регистрации пользователей")
public class TestApiAutorizationRegistration extends BaseTests {
    @Test(description = "post register user unsuccessful")
    public void testRegisterUserUnsuccess()
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
}
