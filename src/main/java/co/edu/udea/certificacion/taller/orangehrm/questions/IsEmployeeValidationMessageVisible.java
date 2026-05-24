package co.edu.udea.certificacion.taller.orangehrm.questions;

import co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class IsEmployeeValidationMessageVisible implements Question<Boolean> {

    private final String message;

    public IsEmployeeValidationMessageVisible(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(HomeOrangePageUI.VALIDATION_MESSAGE.of(message)).answeredBy(actor);
    }

    public static Question<Boolean> withMessage(String message) {
        return new IsEmployeeValidationMessageVisible(message);
    }
}
