import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Тест кол-ва корней")
public class TestDisk {

    @BeforeClass
    public void previewTest() {
        System.out.println("Start test classes TestDisk");
    }

    @AfterClass
    public void endingTest() {
        System.out.println("End test classes TestDisk");
    }

    @Test(testName = "test1", description = "первый тест")
    public void TestOne() {
        testNum(1, 7, 6);
        testNum(4, -7, -6);
        testNum(1, 0, -6);

    }

    @Test(testName = "test2", description = "второй тест")
    public void TestTwo() {
        testNum(-5, -9, -0);
    }

    @Step("Проверка числа")
    public void testNum(Integer a, Integer b, Integer c)
    {
        Integer d = b * b - 4 * a * c;
       Assert.assertEquals(d, Yravnenie.yravnenueDisk(a, b, c));
    }
}

