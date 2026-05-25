package co.edu.udea.certificacion.taller.orangehrm.questions;

import co.edu.udea.certificacion.taller.orangehrm.userinterfaces.SearchEmployeePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class IsSearchResultMessageDisplayed implements Question<Boolean> {

    private final String message;

    public IsSearchResultMessageDisplayed(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(SearchEmployeePageUI.SEARCH_RESULT_MESSAGE.of(message)).answeredBy(actor);
    }

    public static Question<Boolean> withMessage(String message) {
        return new IsSearchResultMessageDisplayed(message);
    }
}
