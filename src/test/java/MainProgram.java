import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.className;


public class MainProgram {

    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public static void beforeClass() throws Exception {

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("BuyMe Automation Project", "Sanity Test for BuyMe Web site");
        // add custom system info
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Raz");
        // log results
        test.log(Status.INFO, "@Before class");

        boolean driverEstablish = false;

        try {
            driver = DriverSingleton.getDriverInstance();
            driver.get(GeneralParameters.BaseUrl);
            driver.manage().window().maximize();

            driverEstablish = true;

            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "BuyMe website was not found " + e.getMessage());
            driverEstablish = false;

        } finally {
            if (driverEstablish) {
                test.log(Status.PASS, "BuyMe " + "Webpage opened successfully");
            }
        }


    }


//Registration page
    @Test (priority = 1)
    public void registrationPage_01 () {
       boolean Registration = false;
        try {
            driver.findElement(className("seperator-link")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(RegistrationParam.Registration).click();
            driver.findElement(RegistrationParam.Name).sendKeys(RegistrationParam.NameToSend);
            driver.findElement(RegistrationParam.Email).sendKeys(RegistrationParam.EmailToSend);
            driver.findElement(RegistrationParam.Password).sendKeys(RegistrationParam.PasswordToSend);
            driver.findElement(RegistrationParam.RepeatPassword).sendKeys(RegistrationParam.PasswordToSend);
            driver.findElement(RegistrationParam.Submit).click();
           Registration = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Registration process fail " + e.getMessage());
        } finally {
            if (Registration)
                test.log(Status.PASS, "Registration process completed successfully");
            }
        }




//Home Page
        @Test (priority = 2)
                public void homePage_02 () {

        boolean homePage = false;
                try {
                    driver.findElement(HomePage.Price).click();
                    driver.findElement(HomePage.Choose_Price).click();
                    driver.findElement(HomePage.Area).click();
                    driver.findElement(HomePage.Choose_Area).click();
                    driver.findElement(HomePage.Category).click();
                    driver.findElement(HomePage.Choose_Category).click();
                    driver.findElement(HomePage.Find).click();

                    homePage = true;

                } catch (Exception e) {
                    e.printStackTrace();
                    test.log(Status.FAIL, "homePage process was fail " + e.getMessage());
                } finally {
                    if (homePage) {
                        test.log(Status.PASS, "homePage process completed successfully");
                    }
                }
    }
//Pick Business page
    @Test (priority = 3)
        public void businessPage_03 () {

        try {

            boolean busi = false;

            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, Pick_Business.url);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(Pick_Business.Choose_Gift));
            driver.findElement(Pick_Business.Choose_Gift).click();

            busi = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Business was fail " + e.getMessage());
        }
    }

//Sender & reciever information screen page

    @Test (priority = 4)
            public void infoScreen_04 () {
        boolean info = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);

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

//how to send page

            driver.findElement(HowToSend.SendWay).click();
            driver.findElement(HowToSend.PhoneArea).sendKeys(HowToSend.PhoneReceiver);
            wait.until(ExpectedConditions.elementToBeClickable(HowToSend.FromWhomArea));


            driver.findElement(HowToSend.FromWhomArea).clear();
            driver.findElement(HowToSend.FromWhomArea).sendKeys(HowToSend.FromWhomName);
            wait.until(ExpectedConditions.elementToBeClickable(HowToSend.ToWhomArea));
            driver.findElement(HowToSend.ToWhomArea).sendKeys(HowToSend.PhoneSender);
            driver.findElement(HowToSend.ProceedToPayment).click();
            info = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Information process was fail " + e.getMessage());
        } finally {
            if (info) {
                test.log(Status.PASS, "Information process completed successfully");
            }
        }
    }

    @Test (priority = 5)
            public void assertTest_05 () {

        Assert.assertEquals(HowToSend.FromWhomName, "צוות אוטומציה");
        Assert.assertEquals(GiftSendPage.HappyPerson, "עובדיה");
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();
    }


            private static String takeScreenShot (String ImagesPath){
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                File destinationFile = new File(ImagesPath + ".png");
                try {
                    FileUtils.copyFile(screenShotFile, destinationFile);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                return ImagesPath + ".png";
            }
        }
