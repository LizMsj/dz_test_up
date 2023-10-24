import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.BaseTests;

import java.util.ArrayList;
import java.util.List;

@Epic("Гр. 2 ArrayList")
@Feature("Подгр. 2 замена элемента")
public class HardListTests extends BaseTests {

    @Test(description = "Тест замена элементов 1")
    public void testZamList1()
    {
        fileAndListSteps.createList();
        fileAndListSteps.checkElemList(25, true);
        fileAndListSteps.zamElemList(4, 123);
        fileAndListSteps.checkElemList(123, true);
        fileAndListSteps.deleteList();
    }

    @Test(description = "Тест замена элементов 2")
    public void testZamList2()
    {
        fileAndListSteps.createList();
        fileAndListSteps.checkElemList(9, true);
        fileAndListSteps.zamElemList(9, 20000);
        fileAndListSteps.checkElemList(20000, true);
        fileAndListSteps.checkElemList(9, true);
        fileAndListSteps.deleteList();
    }
}