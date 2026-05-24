package co.edu.udea.certificacion.taller.orangehrm.interactions;

import co.edu.udea.certificacion.taller.orangehrm.models.UserModel;
import co.edu.udea.certificacion.taller.orangehrm.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.LoginOrangePageUI.*;

public class CompleteLoginFormOrangePage implements Interaction {

    private final UserModel user;

    public CompleteLoginFormOrangePage(UserModel user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME),
                Enter.theValue(user.getPassword()).into(PASSWORD),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static CompleteLoginFormOrangePage with(UserModel user) {
        return Tasks.instrumented(CompleteLoginFormOrangePage.class, user);
    }
}
