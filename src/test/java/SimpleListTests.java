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
@Feature("Подгр. 1 создание/удаление/изменение")
public class SimpleListTests extends BaseTests {

    @Test(description = "Тест 1 работоспособный список")
    public void testList1()
    {
        fileAndListSteps.createList();
        fileAndListSteps.addElemList(123);
        fileAndListSteps.checkElemList(123);
        fileAndListSteps.checkElemList(81);
        fileAndListSteps.deleteList();
    }

    @Test(description = "Тест 2 работоспособный список")
    public void testList2()
    {
        fileAndListSteps.createList();
        fileAndListSteps.delElemList(4);
        fileAndListSteps.delElemList(16);
        fileAndListSteps.checkElemList(16);
        fileAndListSteps.delElemList(9);
        fileAndListSteps.checkElemList(49);
        fileAndListSteps.deleteList();
    }

}
