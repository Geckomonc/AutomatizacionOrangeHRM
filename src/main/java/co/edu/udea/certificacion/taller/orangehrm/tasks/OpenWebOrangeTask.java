package co.edu.udea.certificacion.taller.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenWebOrangeTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.orangeUrl"));
    }

    public static OpenWebOrangeTask homePage() {
        return Tasks.instrumented(OpenWebOrangeTask.class);
    }

}
