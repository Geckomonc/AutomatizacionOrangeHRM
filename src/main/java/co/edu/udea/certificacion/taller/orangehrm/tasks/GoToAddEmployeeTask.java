package co.edu.udea.certificacion.taller.orangehrm.tasks;

import co.edu.udea.certificacion.taller.orangehrm.interactions.ClickPIMSection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.ADD_EMPLOYEE_BUTTON;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.PIM_BUTTON;

public class GoToAddEmployeeTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickPIMSection.now(),
                Click.on(ADD_EMPLOYEE_BUTTON)
        );
    }

    public static GoToAddEmployeeTask go() {
        return Tasks.instrumented(GoToAddEmployeeTask.class);
    }
}
