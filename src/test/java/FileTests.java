import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.BaseTests;


@Epic("Гр.1 test.txt")
@Feature("Подгр. 1 вхождение подстроки")
public class FileTests extends BaseTests {


    @Test(description = "Вхождение в файл подстроки code")
    public void testCreateDeleteFile()
    {
        fileAndListSteps.formedFile();
        fileAndListSteps.createFile();
        fileAndListSteps.deleteFile();
        fileAndListSteps.createFile();

    }
    @Test(description = "Не вхождение в файл подстроки yes")
    public void testWorkWithFiles()
    {
        fileAndListSteps.formedFile();
        fileAndListSteps.createFile();
        fileAndListSteps.readLineFile();
        fileAndListSteps.detectedFile("code");
        fileAndListSteps.deleteFile();
    }
}
