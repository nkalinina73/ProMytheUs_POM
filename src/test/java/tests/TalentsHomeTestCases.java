package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage_PMU;
import pages.TalentsPage;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TalentsHomeTestCases
{
    private WebDriver driver;

    @BeforeClass
    public void settingUp() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\selenium-java-3.8.1\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        LoginPage_PMU login = new LoginPage_PMU(driver);
        login.typeEmail();
        login.typePassword();
        Thread.sleep(3000);
        login.clickOnLoginButton();
    }
        //verify Talents (home page)

        @AfterClass
        public void cleaningUp () throws InterruptedException
        {
            Thread.sleep(4000);
           // driver.close();
        }

        @Test
        public void talentsHome () throws InterruptedException, AWTException {
            TalentsPage testTalents = new TalentsPage(driver);
            //testTalents.verifyTitle();
            //testTalents.getToHomePageFromMyProfile();
            testTalents.createNewTalent();
            //testTalents.editTalent();

        }

}
