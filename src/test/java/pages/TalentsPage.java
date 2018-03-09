package pages;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TalentsPage
{
    private WebDriver driver;

    By userIcon = By.xpath("/html/body/app/ui-view/public-area/div/header/nav/div[2]/ul[2]/li[2]/a/em");
    By myProfile = By.xpath("/html/body/app/ui-view/public-area/div/header/nav/div[2]/ul[2]/li[2]/ul/li/div/a[1]/div/div[2]/p");
    By appLogo = By.className("img-responsive");

    public TalentsPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void verifyTitle()
    {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Sign In"), "The title of the home page did'not match.");
        //Verify
    }

    public void getToHomePageFromMyProfile() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(userIcon).click();
        Thread.sleep(2000);
        driver.findElement(myProfile).click();
        Thread.sleep(2000);
        driver.findElement(appLogo).click();
    }
}
