package steps;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTests implements Steps{

    @BeforeSuite
    public void startTests(){
        System.out.println("Test started... wait...");
    }

    @AfterSuite
    public void endTests(){
        System.out.println("Tests ending");
    }
}
