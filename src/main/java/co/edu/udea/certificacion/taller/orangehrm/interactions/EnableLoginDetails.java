package co.edu.udea.certificacion.taller.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.LOGIN_DETAILS_BUTTON;

public class EnableLoginDetails implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_DETAILS_BUTTON));
    }

    public static EnableLoginDetails now() {
        return Tasks.instrumented(EnableLoginDetails.class);
    }
}
