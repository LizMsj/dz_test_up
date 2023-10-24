package steps;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileAndListSteps {

    File file;
    String path = "";
    String fileText;
    ArrayList<Integer> list = new ArrayList<>();

    @Step("Создание файла")
    public void formedFile() {
        try {
            file = new File("test.txt");
            path = file.getPath();
            PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
            writer.println("no no yes code");
            writer.println("get code console");
            writer.println("i live in codetown");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing file " + e.getMessage());
        }
    }

    @Step("Удаление файла")
    public void deleteFile()
    {
        try {
            file.delete();
        } catch (Exception e) {
            System.out.println("Error delete file " + e.getMessage());
        }
    }

    @Step("Чтение файла")
    public void readLineFile()
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                fileText = fileText + " " + line;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error read file " + e.getMessage());
        }
    }
    @Step("Вхождение подстроки")
    public void detectedFile(String a)
    {
        Integer tmp = fileText.indexOf(a);
        Assert.assertNotEquals(tmp, -1);
    }

    @Step("Существование файла")
    public void createFile(Boolean have)
    {
        if (have)
            Assert.assertTrue(file.exists());
        else
            Assert.assertFalse(file.exists());

    }

    @Step("Создаем лист")
    public void createList() {
        for (int i = 0; i < 20; i++)
            list.add(i * i);

    }

    @Step("Очищаем лист")
    public void deleteList() {
        list.clear();
    }

    @Step("Заменить элемент")
    public void zamElemList(Integer a, Integer b)
    {
        Integer tmp = list.indexOf(a);
        list.remove(tmp);
        list.add(tmp, b);
    }
    @Step("Проверить элемент")
    public void checkElemList(Integer a,  Boolean have)
    {
        if(have) {
            Assert.assertTrue(list.contains(a));
        }else {
            Assert.assertTrue(!list.contains(a));
        }
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
