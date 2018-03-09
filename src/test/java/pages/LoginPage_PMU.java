package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_PMU
{
    WebDriver dr;
    //locators
    By email = By.xpath("//div/input[@name='email']");
    By password = By.name("password");
    By forgotPassword = By.xpath("//div/a[@class='text-muted']");
    By loginButton = By.id("login");
    By registerNowButton = By.className("btn btn-block btn-default");

    public LoginPage_PMU (WebDriver dr)
    {
        this.dr = dr;
    }

    public void typeEmail ()
    {
        dr.findElement(email).sendKeys("auto.qauber@mailinator.com");
    }
    public void typePassword ()
    {
        dr.findElement(password).sendKeys("qwe123");
    }
    public void clickOnLoginButton ()
    {
        dr.findElement(loginButton).submit();
    }
}

