import org.openqa.selenium.By;

public class HowToSend {

    public static final By SendWay = By.cssSelector("svg[gtm=method-sms]");

    public static final By PhoneArea = By.id("sms");
    public static final String PhoneReceiver= "0555555555";

    public static final By FromWhomArea = By.id("ember1992");
    public static final String FromWhomName = "צוות אוטומציה";

    public static final By ToWhomArea = By.id("ember2001");
    public static final String PhoneSender = "0524677889";
//
   public static final By ProceedToPayment = By.id("ember1993");
}
