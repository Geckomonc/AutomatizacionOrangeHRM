package co.edu.udea.certificacion.taller.orangehrm.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.SearchEmployeePageUI.EMPLOYEE_ID_INPUT;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.SearchEmployeePageUI.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchEmployeeByIdTask implements Task {

    private final String employeeId;

    public SearchEmployeeByIdTask(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EMPLOYEE_ID_INPUT, isVisible()).forNoMoreThan(15).seconds()
        );

        WebElementFacade employeeIdField = EMPLOYEE_ID_INPUT.resolveFor(actor);

        employeeIdField.click();
        employeeIdField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        employeeIdField.sendKeys(Keys.BACK_SPACE);
        employeeIdField.sendKeys(employeeId);

        actor.attemptsTo(
                Click.on(SEARCH_BUTTON)
        );
    }

    public static SearchEmployeeByIdTask with(String employeeId) {
        return Tasks.instrumented(SearchEmployeeByIdTask.class, employeeId);
    }
}
