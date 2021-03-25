import org.openqa.selenium.By;

import java.security.PublicKey;

public class GiftSendPage {

    public static final By SendGiftTo = By.xpath("//input[@data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']");
    public static final String HappyPerson = "עובדיה";

    public static final By EventType = By.xpath("//*[@id=\"ember1890\"]/div/div[1]/span");
    public static final By ChooseEvent = By.xpath("//*[@id=\"ember1930\"]/span");

    public static final By BlessingArea = By.xpath("//*[@id=\"ember1825\"]/textarea");
    public static final String MyBlessing = "שתהיה מאושר לעד. צוות אוטומציה";

    public static final By Proceed = By.id("ember1835");




}
