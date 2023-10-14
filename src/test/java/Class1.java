import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

public class Class1 {

    String path = null;
    @BeforeClass
    public void formedFile()
    {
        try {
            File file = new File("test.txt");
            String path = file.getPath();
            PrintWriter writer = null;
            writer = new PrintWriter("test.txt", "UTF-8");
            writer.println("The first line");
            writer.println("ret second line");
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testotest()
    {
        System.out.println("1");
    }

}
