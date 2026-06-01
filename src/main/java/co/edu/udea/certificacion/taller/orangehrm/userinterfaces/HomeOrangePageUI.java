package co.edu.udea.certificacion.taller.orangehrm.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeOrangePageUI {

    public static final Target DASHBOARD_TITLE = Target.the("dashboard title")
            .located(By.xpath("//h6[normalize-space()='Dashboard']"));

    public static final Target PIM_BUTTON = Target.the("PIM button")
            .located(By.xpath("//span[normalize-space()='PIM']"));

    public static final Target ADD_EMPLOYEE_BUTTON = Target.the("add employee button")
            .located(By.xpath("//button[normalize-space()='Add']"));

    public static final Target EMPLOTEE_FIRSTNAME = Target.the("employee firstname")
            .located(By.name("firstName"));

    public static final Target EMPLOTEE_MIDDLE = Target.the("employee middlename")
            .located(By.name("middleName"));

    public static final Target EMPLOTEE_LASTNAME = Target.the("employee lastname")
            .located(By.name("lastName"));

    public static final Target EMPLOYEE_ID = Target.the("employee id")
            .located(By.xpath("//label[normalize-space()='Employee Id']/following::input[1]"));

    public static final Target LOGIN_DETAILS_BUTTON = Target.the("login details button")
            .located(By.xpath("//p[normalize-space()='Create Login Details']/following::span[contains(@class,'oxd-switch-input')][1]"));

    public static final Target USERNAME_EMPLOYEE = Target.the("username employee")
            .located(By.xpath("//label[normalize-space()='Username']/following::input[1]"));

    public static final Target STATUS_EMPLOYEE_ENABLED = Target.the("enabled status employee")
            .located(By.xpath("//label[normalize-space()='Enabled']"));

    public static final Target STATUS_EMPLOYEE_DISABLED = Target.the("disabled status employee")
            .located(By.xpath("//label[normalize-space()='Disabled']"));

    public static final Target PASSWORD_EMPLOYEE = Target.the("password employee")
            .located(By.xpath("//label[normalize-space()='Password']/following::input[1]"));

    public static final Target CONFIRM_PASSWORD_EMPLOYEE = Target.the("confirm password employee")
            .located(By.xpath("//label[normalize-space()='Confirm Password']/following::input[1]"));

    public static final Target SAVE_BUTTON = Target.the("save button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target EMPLOYEE_IMG = Target.the("employee profile picture")
            .located(By.xpath("//img[contains(@class,'employee-image')]"));

    public static final Target VALIDATION_MESSAGE = Target.the("validation message")
            .locatedBy("//*[contains(@class,'oxd-input-field-error-message') and contains(normalize-space(),'{0}')]");
}
