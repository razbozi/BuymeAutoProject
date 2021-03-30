import org.openqa.selenium.By;

public class RegistrationParam {

    public static final By Registration = By.xpath("//*[@id=\"ember832\"]/div/div[1]/div/div/div[3]/div[1]/span");
    public static final By Name = By.xpath("//*[@id=\"ember1376\"]");
    public static final String NameToSend = "David";

    public static final By Email = By.xpath("//*[@id=\"ember1379\"]");
    public static final String EmailToSend = "l77599@gmail.com";

    public static final By Password = By.xpath("//*[@id=\"ember1382\"]");
    public static final String  PasswordToSend = "Vrtkua2010";

    public static final By RepeatPassword = By.xpath("//*[@id=\"ember1385\"]");

    public static final By Submit = By.id("ember1387");
}