import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.linkText;

public class HomePage {

    public static final By Price = By.linkText("סכום");
    public static final By Choose_Price = By.xpath("//li[@data-option-array-index='3']");

    public static final By Area = By.linkText("אזור");
    public static final By Choose_Area = By.xpath("//li[@data-option-array-index='2']");

    public static final By Category = By.linkText("קטגוריה");
    public static final By Choose_Category = By.xpath("//li[@data-option-array-index='4']");

    public static final By Find = By.id("ember987");





















//    public static ChromeDriver driver;
//
//
//    //decalration of price point
//    public static void Price() {
//        driver.findElement(linkText("סכום")).click();
//        driver.findElement(By.xpath("//li[@data-option-array-index='3']")).click();
//    }
//
//    static void Region() {
//        Select region = new Select(driver.findElement(By.xpath("//*[@id=\"ember942_chosen\"]/a")));
//        region.getFirstSelectedOption().click();
//    }
//
//    static void Category() {
//        Select category = new Select(driver.findElement(By.xpath("//*[@id=\"ember952_chosen\"]/a")));
//        category.getFirstSelectedOption().click();
//    }


}




