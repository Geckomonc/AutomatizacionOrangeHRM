package co.edu.udea.certificacion.taller.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.CONFIRM_PASSWORD_EMPLOYEE;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.PASSWORD_EMPLOYEE;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.STATUS_EMPLOYEE_DISABLED;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.STATUS_EMPLOYEE_ENABLED;
import static co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI.USERNAME_EMPLOYEE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillDetailsEmployeeTask implements Task {

    private final String createLogin;
    private final String username;
    private final String password;
    private final String confirmPassword;
    private final String status;

    public FillDetailsEmployeeTask(String createLogin, String username, String password, String confirmPassword, String status) {
        this.createLogin = createLogin;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.status = status;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!"yes".equalsIgnoreCase(createLogin)) {
            return;
        }

        actor.attemptsTo(
                WaitUntil.the(USERNAME_EMPLOYEE, isVisible()).forNoMoreThan(15).seconds()
        );

        if (!isEmptyValue(username)) {
            actor.attemptsTo(Enter.theValue(username).into(USERNAME_EMPLOYEE));
        }

        if ("Enabled".equalsIgnoreCase(status)) {
            actor.attemptsTo(Click.on(STATUS_EMPLOYEE_ENABLED));
        }

        if ("Disabled".equalsIgnoreCase(status)) {
            actor.attemptsTo(Click.on(STATUS_EMPLOYEE_DISABLED));
        }

        if (!isEmptyValue(password)) {
            actor.attemptsTo(Enter.theValue(password).into(PASSWORD_EMPLOYEE));
        }

        if (!isEmptyValue(confirmPassword)) {
            actor.attemptsTo(Enter.theValue(confirmPassword).into(CONFIRM_PASSWORD_EMPLOYEE));
        }
    }

    public static FillDetailsEmployeeTask with(String createLogin, String username, String password, String confirmPassword, String status) {
        return Tasks.instrumented(FillDetailsEmployeeTask.class, createLogin, username, password, confirmPassword, status);
    }

    private boolean isEmptyValue(String value) {
        return value == null || value.trim().isEmpty() || "EMPTY".equalsIgnoreCase(value.trim());
    }
}
