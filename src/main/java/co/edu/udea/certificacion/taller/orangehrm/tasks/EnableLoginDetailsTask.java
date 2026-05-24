package co.edu.udea.certificacion.taller.orangehrm.tasks;

import co.edu.udea.certificacion.taller.orangehrm.interactions.EnableLoginDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EnableLoginDetailsTask implements Task {

    private final String value;

    public EnableLoginDetailsTask(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if ("yes".equalsIgnoreCase(value)) {
            actor.attemptsTo(EnableLoginDetails.now());
        }
    }

    public static EnableLoginDetailsTask ifEnabled(String value) {
        return Tasks.instrumented(EnableLoginDetailsTask.class, value);
    }

}
