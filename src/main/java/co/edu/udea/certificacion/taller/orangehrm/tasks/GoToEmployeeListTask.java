package co.edu.udea.certificacion.taller.orangehrm.tasks;

import co.edu.udea.certificacion.taller.orangehrm.interactions.ClickPIMSection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.PIM_BUTTON;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.SearchEmployeePageUI.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToEmployeeListTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickPIMSection.now(),
                WaitUntil.the(SEARCH_BUTTON, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static GoToEmployeeListTask go() {
        return Tasks.instrumented(GoToEmployeeListTask.class);
    }
}
