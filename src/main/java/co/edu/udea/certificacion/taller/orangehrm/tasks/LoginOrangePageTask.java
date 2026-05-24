package co.edu.udea.certificacion.taller.orangehrm.tasks;

import co.edu.udea.certificacion.taller.orangehrm.interactions.CompleteLoginFormOrangePage;
import co.edu.udea.certificacion.taller.orangehrm.models.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LoginOrangePageTask implements Task {

    private final UserModel user;

    public LoginOrangePageTask(UserModel user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CompleteLoginFormOrangePage.with(user)
        );
    }

    public static CompleteLoginFormOrangePage with(UserModel user) {
        return Tasks.instrumented(CompleteLoginFormOrangePage.class, user);
    }

}
