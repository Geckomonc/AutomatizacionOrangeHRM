package co.edu.udea.certificacion.taller.orangehrm.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.EMPLOYEE_ID;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SetEmployeeIdTask implements Task {

    private final String employeeId;

    public SetEmployeeIdTask(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (isEmptyValue(employeeId)) {
            return;
        }

        actor.attemptsTo(
                WaitUntil.the(EMPLOYEE_ID, isVisible()).forNoMoreThan(15).seconds()
        );

        WebElementFacade employeeIdField = EMPLOYEE_ID.resolveFor(actor);

        employeeIdField.click();
        employeeIdField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        employeeIdField.sendKeys(Keys.BACK_SPACE);
        employeeIdField.sendKeys(employeeId);
        employeeIdField.sendKeys(Keys.TAB);
    }

    public static SetEmployeeIdTask with(String employeeId) {
        return Tasks.instrumented(SetEmployeeIdTask.class, employeeId);
    }

    private boolean isEmptyValue(String value) {
        return value == null || value.trim().isEmpty() || "EMPTY".equalsIgnoreCase(value.trim());
    }
}
