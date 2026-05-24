package co.edu.udea.certificacion.taller.orangehrm.questions;

import co.edu.udea.certificacion.taller.orangehrm.userinterfaces.SearchEmployeePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class IsEmployeeFoundById implements Question<Boolean> {

    private final String employeeId;

    public IsEmployeeFoundById(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(SearchEmployeePageUI.EMPLOYEE_RESULT_BY_ID.of(employeeId)).answeredBy(actor);
    }

    public static Question<Boolean> with(String employeeId) {
        return new IsEmployeeFoundById(employeeId);
    }
}
