package co.edu.udea.certificacion.taller.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

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
                WaitUntil.the(EMPLOYEE_ID_INPUT, isVisible()).forNoMoreThan(15).seconds(),
                Clear.field(EMPLOYEE_ID_INPUT),
                Enter.theValue(employeeId).into(EMPLOYEE_ID_INPUT),
                Click.on(SEARCH_BUTTON)
        );
    }

    public static SearchEmployeeByIdTask with(String employeeId) {
        return Tasks.instrumented(SearchEmployeeByIdTask.class, employeeId);
    }
}
