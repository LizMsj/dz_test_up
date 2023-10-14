import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Тест дискриминанта")
public class TestRad {
    @BeforeClass
    public void previewTest() {
        System.out.println("Start test classes TestRad");
    }

    @AfterClass
    public void endingTest() {
        System.out.println("Ending test classes TestRad");
    }

    @Test(testName = "test1", description = "первый тест")
    public void TestOne() {
        countNum(testNum(1, 6, 9));
        countNum(testNum(-1, 6, 0));
        countNum(testNum(1, -6, 5));

    }

    @Step("Вычисление дискриминанта")
    public Integer testNum(Integer a, Integer b, Integer c)
    {
        Integer d = b * b - 4 * a * c;
        return d;
    }

    @Step("Проверка количества корней")
    public void countNum(Integer d)
    {
        Integer tmp = (d == 0) ? 1 : (d < 0) ? 0 : 2;
        Assert.assertEquals(tmp, Yravnenie.yravnenieRad(d));
    }
}
