import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestDisk {

    @BeforeSuite
    public void previewTest() {
        System.out.println("Start test classes / point in");
    }

    @AfterSuite
    public void endingTest() {
        System.out.println("End test classes / point exit");
    }

    @Test(testName = "test1")
    public void TestOne() {
        Integer funcCheck = Yravnenie.yravnenueDisk(12, 1, 5);
        Integer prov = 1 - 4 * 12 * 5;
        Assert.assertEquals(funcCheck, prov);
    }

    @Test(testName = "test2", expectedExceptions = AssertionError.class)
    public void TestTwo() {
        Integer funcCheck = Yravnenie.yravnenueDisk(11, 1, 5);
        Integer prov = 11 - 4 * 12 * 5;
        Assert.assertEquals(funcCheck, prov, "значения не совпадают");
    }

}
