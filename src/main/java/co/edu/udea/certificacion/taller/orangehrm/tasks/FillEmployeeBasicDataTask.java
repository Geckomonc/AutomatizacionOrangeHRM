package co.edu.udea.certificacion.taller.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.EMPLOTEE_FIRSTNAME;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.EMPLOTEE_LASTNAME;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.EMPLOTEE_MIDDLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillEmployeeBasicDataTask implements Task {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public FillEmployeeBasicDataTask(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EMPLOTEE_FIRSTNAME, isVisible()).forNoMoreThan(15).seconds()
        );

        if (!isEmptyValue(firstName)) {
            actor.attemptsTo(Enter.theValue(firstName).into(EMPLOTEE_FIRSTNAME));
        }

        if (!isEmptyValue(middleName)) {
            actor.attemptsTo(Enter.theValue(middleName).into(EMPLOTEE_MIDDLE));
        }

        if (!isEmptyValue(lastName)) {
            actor.attemptsTo(Enter.theValue(lastName).into(EMPLOTEE_LASTNAME));
        }
    }

    public static FillEmployeeBasicDataTask with(String firstName, String middleName, String lastName) {
        return Tasks.instrumented(FillEmployeeBasicDataTask.class, firstName, middleName, lastName);
    }

    private boolean isEmptyValue(String value) {
        return value == null || value.trim().isEmpty() || "EMPTY".equalsIgnoreCase(value.trim());
    }
}