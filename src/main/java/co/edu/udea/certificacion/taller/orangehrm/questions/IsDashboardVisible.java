package co.edu.udea.certificacion.taller.orangehrm.questions;

import co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class IsDashboardVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(HomeOrangePageUI.DASHBOARD_TITLE).answeredBy(actor);
    }

    public static Question<Boolean> value() {
        return new IsDashboardVisible();
    }
}