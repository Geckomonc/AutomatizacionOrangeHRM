package co.edu.udea.certificacion.taller.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.SAVE_BUTTON;

public class ClickSaveEmployee implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SAVE_BUTTON));
    }

    public static ClickSaveEmployee now() {
        return Tasks.instrumented(ClickSaveEmployee.class);
    }
}
