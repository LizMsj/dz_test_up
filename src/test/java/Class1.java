import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.*;



@Epic("Гр.1 test.txt")
@Feature("Подгр. 1 вхождение подстроки")
public class Class1 {

    String path = null;
    String fileText = null;
    File file;
    @BeforeClass
    public void formedFile()
    {
        try {
            file = new File("test.txt");
            String path = file.getPath();
            PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
            writer.println("no no yes code");
            writer.println("get code console");
            writer.println("i live in codetown");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing file " + e.getMessage());
        }
    }

    @AfterClass
    public void deleteFile()
    {
        try {
            file.delete();
        } catch (Exception e) {
            System.out.println("Error delete file " + e.getMessage());
        }
    }

    @Test(description = "Вхождение в файл подстроки code")
    public void testotest1()
    {
        createFile();
        readLineFile();
        detectedFile("code");

    }
    @Test(description = "Не вхождение в файл подстроки yes")
    public void testotest2()
    {
        createFile();
        readLineFile();
        detectedFile("yes");

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
    public void createFile()
    {
        Assert.assertTrue(file.exists());
    }
}
