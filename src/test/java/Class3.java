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
@Feature("Подгр. 2 замена элемента")
public class Class3 {

    List<Integer> list = new ArrayList<>();

    @BeforeClass
    public void createList() {
        for (int i = 0; i < 20; i++)
            list.add(i * i);

    }

    @AfterClass
    public void deleteList() {
        list.clear();
    }

    @Test(description = "Тест замена элементов 1")
    public void testZamList1()
    {
        checkElemList(25);
        zamElemList(4, 123);
        checkElemList(123);
    }

    @Test(description = "Тест замена элементов 2")
    public void testZamList2()
    {
        checkElemList(123);
        zamElemList(123, 20000);
        checkElemList(20000);
        checkElemList(123);
    }

    @Step("Проверить элемент")
    public void checkElemList(Integer a)
    {
        if (list.contains(a))
            Assert.assertTrue(list.contains(a));
        else
            System.out.println("Элемента не существует в списке");
    }

    @Step("Заменить элемент")
    public void zamElemList(Integer a, Integer b)
    {
        Integer tmp = list.indexOf(a);
        list.remove(tmp);
        list.add(tmp, b);
    }
}