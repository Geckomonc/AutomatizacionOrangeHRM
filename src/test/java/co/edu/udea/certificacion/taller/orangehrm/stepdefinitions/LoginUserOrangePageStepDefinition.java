package co.edu.udea.certificacion.taller.orangehrm.stepdefinitions;

import co.edu.udea.certificacion.taller.orangehrm.models.UserModel;
import co.edu.udea.certificacion.taller.orangehrm.questions.IsDashboardVisible;
import co.edu.udea.certificacion.taller.orangehrm.tasks.LoginOrangePageTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.OpenWebOrangeTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.is;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginUserOrangePageStepDefinition {

    private final Actor user = Actor.named("Orange User");

    @Managed(driver = "chrome", uniqueSession = true)
    private WebDriver driver;

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("The user is on the OrangeHRM login page")
    public void theUserIsOnTheOrangeHRMLoginPage() {
        user.attemptsTo(OpenWebOrangeTask.homePage());
    }

    @When("The user fill username {string}, password {string} and click the login button")
    public void theUserFillUsernamePasswordAndClickTheLoginButton(String username, String password) {
        user.attemptsTo(LoginOrangePageTask.with(new UserModel(username, password)));
    }

    @Then("The user should see the dashboard page")
    public void theUserShouldSeeTheDashboardPage() {
        user.should(seeThat(IsDashboardVisible.value(), is(true)));
    }
}
