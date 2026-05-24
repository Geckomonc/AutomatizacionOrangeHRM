package co.edu.udea.certificacion.taller.orangehrm.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchEmployeePageUI {

    public static final Target EMPLOYEE_ID_INPUT = Target.the("employee id search input")
            .located(By.xpath("//label[normalize-space()='Employee Id']/following::input[1]"));

    public static final Target SEARCH_BUTTON = Target.the("search button")
            .located(By.xpath("//button[normalize-space()='Search']"));

    public static final Target EMPLOYEE_RESULT_BY_ID = Target.the("employee result by id")
            .locatedBy("//div[contains(@class,'oxd-table-card')]//*[normalize-space()='{0}']");
}
