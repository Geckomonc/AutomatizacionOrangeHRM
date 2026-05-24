package co.edu.udea.certificacion.taller.orangehrm.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginOrangePageUI {

    public static final Target USERNAME = Target.the("username")
            .located(By.name("username"));

    public static final Target PASSWORD = Target.the("password")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//button[@type='submit']"));
}
