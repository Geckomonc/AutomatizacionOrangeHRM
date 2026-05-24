package co.edu.udea.certificacion.taller.orangehrm.stepdefinitions;

import co.edu.udea.certificacion.taller.orangehrm.models.UserModel;
import co.edu.udea.certificacion.taller.orangehrm.questions.IsEmployeeFoundById;
import co.edu.udea.certificacion.taller.orangehrm.tasks.GoToEmployeeListTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.LoginOrangePageTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.OpenWebOrangeTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.SearchEmployeeByIdTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class SearchEmployeeStepDefinition {

    private final Actor user = Actor.named("Orange User");

    @Managed(driver = "chrome")
    private WebDriver driver;

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("The admin is authenticated in OrangeHRM for employee search")
    public void theAdminIsAuthenticatedInOrangeHRMForEmployeeSearch() {
        user.attemptsTo(OpenWebOrangeTask.homePage());
        user.attemptsTo(LoginOrangePageTask.with(new UserModel("Admin", "admin123")));
    }

    @Given("The admin is on the employee list page")
    public void theAdminIsOnTheEmployeeListPage() {
        user.attemptsTo(GoToEmployeeListTask.go());
    }

    @When("The admin searches employee by id {string}")
    public void theAdminSearchesEmployeeById(String employeeId) {
        user.attemptsTo(SearchEmployeeByIdTask.with(employeeId));
    }

    @Then("The employee with id {string} should be displayed in the results")
    public void theEmployeeWithIdShouldBeDisplayedInTheResults(String employeeId) {
        user.should(seeThat(IsEmployeeFoundById.with(employeeId), is(true)));
    }
}