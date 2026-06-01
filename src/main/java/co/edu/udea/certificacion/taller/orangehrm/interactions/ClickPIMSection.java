package co.edu.udea.certificacion.taller.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.PIM_BUTTON;

public class ClickPIMSection implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PIM_BUTTON));
    }

    public static ClickPIMSection now() {
        return Tasks.instrumented(ClickPIMSection.class);
    }

}
