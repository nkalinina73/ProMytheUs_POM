package pages;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.bcel.internal.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
    public void getToHomePageFromMyProfile() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(userIcon).click();
        Thread.sleep(2000);
        driver.findElement(myProfile).click();
        Thread.sleep(2000);
        driver.findElement(appLogo).click();
        Thread.sleep(2000);
    }


    By buttonNew = By.xpath("/html/body/app/ui-view/public-area/div/ui-view/talents-section/div/section/div/div/spinner-container/div[1]/div/div[1]/div/div/div/a");
    By dropDownArrow = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[1]/div[1]/div/div[1]/div[1]/span/i");
    By entrepreneur = By.xpath("//*[@id=\"ui-select-choices-row-1-1\"]/span");
    By dropdownField = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[1]/div[1]/div/div[1]/input[1]");
    By talentFirstName = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[1]/div[1]/input");
    By talentLastName = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[1]/div[3]/input");
    By buttonChooseFile = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[2]/div[1]/div[1]/div/span/button");
    By radioButtonFemale = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[3]/div/label[2]/span");
    //By dropDownCountry = By.xpath("<i class=\"caret pull-right\" ng-click=\"$select.toggle($event)\"></i>");
    By dropDownCountry = By.xpath("//*[@id=\"signUpCountry\"]/span/span[2]");
    By chooseCountryTField = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[5]/div/div/input[1]");
    By textfieldAddress = By.xpath("//*[@id=\"address\"]");
    By textfieldCity = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[7]/div/input");
    By textfieldState = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[8]/div/input");
    By textfieldPostalCode = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[2]/div/div/div[9]/div/input");
    By buttonNext =  By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[2]/button[2]");

    public void createNewTalent() throws InterruptedException, AWTException {

        Thread.sleep(2000);
        driver.findElement(buttonNew).click();
        Thread.sleep(4000);
        driver.findElement(dropDownArrow).click();
        Thread.sleep(2000);
        /*Select dropDown = new Select(drobDownErrow);
        dropDown.selectByVisibleText("Comedy");*/
//        driver.findElement(entrepreneur);

        driver.findElement(By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/div[1]/div[1]/fieldset[1]/div[1]/div/div[1]/input[1]")).sendKeys("entrepreneur");
        driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-0-0\"]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/button[@ng-click='$ctrl.next()']")).click();
        Thread.sleep(2000);
        driver.findElement(talentFirstName).sendKeys(new Faker().name().firstName());
        driver.findElement(talentLastName).sendKeys(new Faker().name().lastName());
        //clickin on the Choose fille button
        driver.findElement(buttonChooseFile).click();
        //path to the image
        //String filePath = "C:\\Users\\Natalia\\Pictures\\cat.jpg";
        //clickin on the Choose fille button
        //driver.findElement(buttonChooseFile).sendKeys(filePath);

        //creating object of the Robot class
        Robot robot = new Robot();
        robot.setAutoDelay(2000);

        StringSelection stSelection = new StringSelection("C:\\Users\\Natalia\\Pictures\\cat.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stSelection, null);
        robot.setAutoDelay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(radioButtonFemale).click();
        Thread.sleep(3000);
        driver.findElement(dropDownCountry).click();
        driver.findElement(chooseCountryTField).sendKeys("Japan");
        driver.findElement(chooseCountryTField).submit();
        driver.findElement(textfieldAddress).sendKeys(new Faker().address().streetAddress());
        driver.findElement(textfieldCity).sendKeys("sf");
        driver.findElement(textfieldState).sendKeys("CA");
        driver.findElement(textfieldPostalCode).sendKeys("65874");
        driver.findElement(buttonNext).click();
        driver.findElement(appLogo).click();


    }
   /* By buttonEdit = By.className("icon-pencil");
    public void editTalent () throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(buttonEdit).click();
    }*/
}
