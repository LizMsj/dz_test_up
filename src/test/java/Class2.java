import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


@Epic("Гр. 2 ArrayList")
@Feature("Подгр. 1 создание/удаление/изменение")
public class Class2 {

    List<Integer> list = new ArrayList<>();

    @BeforeClass
    public void createList()
    {
        for (int i = 0; i < 20; i++)
            list.add(i * i);

    }

    @AfterClass
    public void deleteList()
    {
            list.clear();
    }

    @Test(description = "Тест 1 работоспособный список")
    public void testList1()
    {
        addElemList(123);
        checkElemList(123);
        delElemList(25);
        checkElemList(81);
    }

    @Test(description = "Тест 2 работоспособный список")
    public void testList2()
    {
        delElemList(4);
        delElemList(16);
        checkElemList(16);
        delElemList(9);
        checkElemList(49);
    }

    @Step("Проверить элемент")
    public void checkElemList(Integer a)
    {
        Assert.assertTrue(list.contains(a));
    }
    @Step("Удалить элемент")
    public void delElemList(Integer a)
    {
        list.remove(list.indexOf(a));
        Assert.assertFalse(list.contains(a));
    }
    @Step("Добавить элемент")
    public void addElemList(Integer a)
    {
        list.add(a);
        Assert.assertFalse(list.contains(list.indexOf(a)));
    }
}
