package co.edu.udea.certificacion.taller.orangehrm.questions;

import co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class IsTheUsernameVisible implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomeOrangePageUI.USER_TITTLE).answeredBy(actor);
    }

    public static Question<String> value() {
        return new IsTheUsernameVisible();
    }
}
