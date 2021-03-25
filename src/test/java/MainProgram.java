import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class MainProgram {
    private static ChromeDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation Course\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(GeneralParameters.BaseUrl);

        //Registration page
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.findElement(className("seperator-link")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            driver.findElement(RegistrationParam.Registration).click();
            driver.findElement(RegistrationParam.Name).sendKeys(RegistrationParam.NameToSend);
            driver.findElement(RegistrationParam.Email).sendKeys(RegistrationParam.EmailToSend);
            driver.findElement(RegistrationParam.Password).sendKeys(RegistrationParam.PasswordToSend);
            driver.findElement(RegistrationParam.RepeatPassword).sendKeys(RegistrationParam.PasswordToSend);
            driver.findElement(RegistrationParam.Submit).click();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
        }

//Home Page
        try {
            driver.findElement(HomePage.Price).click();
            driver.findElement(HomePage.Choose_Price).click();

            driver.findElement(HomePage.Area).click();
            driver.findElement(HomePage.Choose_Area).click();

            driver.findElement(HomePage.Category).click();
            driver.findElement(HomePage.Choose_Category).click();

            driver.findElement(HomePage.Find).click();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
//Pick Business

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Pick_Business.url);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(Pick_Business.Choose_Gift));
        driver.findElement(Pick_Business.Choose_Gift).click();

//Sender & reciever information screen
        wait.until(ExpectedConditions.elementToBeClickable(GiftSendPage.SendGiftTo));
        driver.findElement(GiftSendPage.SendGiftTo).sendKeys(GiftSendPage.HappyPerson);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(GiftSendPage.EventType).click();
        wait.until(ExpectedConditions.elementToBeClickable(GiftSendPage.ChooseEvent));
        driver.findElement(GiftSendPage.ChooseEvent).click();
        driver.findElement(GiftSendPage.BlessingArea).clear();
        driver.findElement(GiftSendPage.BlessingArea).sendKeys(GiftSendPage.MyBlessing);
        driver.findElement(GiftSendPage.Proceed).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //how to send
        driver.findElement(HowToSend.SendWay).click();
        driver.findElement(HowToSend.PhoneArea).sendKeys(HowToSend.PhoneReceiver);
      //  wait.until(ExpectedConditions.elementToBeClickable(HowToSend.FromWhomArea));

        WebElement element = driver.findElement((HowToSend.FromWhomArea));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(HowToSend.FromWhomArea).clear();
        driver.findElement(HowToSend.FromWhomArea).sendKeys(HowToSend.FromWhomName);
 //       wait.until(ExpectedConditions.elementToBeClickable(HowToSend.ToWhomArea));
//        driver.findElement(HowToSend.ToWhomArea).sendKeys(HowToSend.PhoneSender);
//        driver.findElement(HowToSend.ProceedToPayment).click();

        Assert.assertEquals(HowToSend.FromWhomName, "צוות אוטומציה");
        Assert.assertEquals(GiftSendPage.HappyPerson, "עובדיה");






    }






}