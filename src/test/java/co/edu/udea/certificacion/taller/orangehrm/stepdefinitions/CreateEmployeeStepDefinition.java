package co.edu.udea.certificacion.taller.orangehrm.stepdefinitions;

import co.edu.udea.certificacion.taller.orangehrm.interactions.ClickSaveEmployee;
import co.edu.udea.certificacion.taller.orangehrm.models.UserModel;
import co.edu.udea.certificacion.taller.orangehrm.questions.IsEmployeeProfilePictureVisible;
import co.edu.udea.certificacion.taller.orangehrm.questions.IsEmployeeValidationMessageVisible;
import co.edu.udea.certificacion.taller.orangehrm.tasks.EnableLoginDetailsTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.FillDetailsEmployeeTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.FillEmployeeBasicDataTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.GoToAddEmployeeTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.LoginOrangePageTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.OpenWebOrangeTask;
import co.edu.udea.certificacion.taller.orangehrm.tasks.SetEmployeeIdTask;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import co.edu.udea.certificacion.taller.orangehrm.userinterfaces.HomeOrangePageUI;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CreateEmployeeStepDefinition {

    private final Actor user = Actor.named("Orange User");

    @Managed(driver = "chrome")
    private WebDriver driver;

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("The user is authenticated in OrangeHRM")
    public void theUserIsAuthenticatedInOrangeHRM() {
        user.attemptsTo(OpenWebOrangeTask.homePage());
        user.attemptsTo(LoginOrangePageTask.with(new UserModel("Admin", "admin123")));
    }

    @Given("The user is on the Add Employee page")
    public void theUserIsOnTheAddEmployeePage() {
        user.attemptsTo(GoToAddEmployeeTask.go());
    }

    @When("The admin completes employee data: {string}, {string}, {string}")
    public void theAdminCompletesEmployeeData(String first, String middle, String last) {
        user.attemptsTo(FillEmployeeBasicDataTask.with(first, middle, last));
    }

    @When("The admin sets employee id {string}")
    public void theAdminSetsEmployeeId(String employeeId) {
        user.attemptsTo(SetEmployeeIdTask.with(employeeId));
    }

    @And("The admin enables login details if {string}")
    public void theAdminEnablesLoginDetailsIf(String value) {
        user.attemptsTo(EnableLoginDetailsTask.ifEnabled(value));
    }

    @And("If CreateLogin is {string}, the admin sets login details {string}, {string}, {string}, {string}")
    public void ifCreateLoginIsTheAdminSetsLoginDetails(String createLogin, String username, String password, String confirmPassword, String status) {
        user.attemptsTo(FillDetailsEmployeeTask.with(createLogin, username, password, confirmPassword, status));
    }

    @When("The admin saves the employee")
    public void theAdminSavesTheEmployee() {
        user.attemptsTo(ClickSaveEmployee.now());
    }

    @Then("The user should see the employee profile picture")
    public void theUserShouldSeeTheEmployeeProfilePicture() {
        user.should(seeThat(IsEmployeeProfilePictureVisible.value(), is(true)));
    }

    @When("The admin tries to create an employee with data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theAdminTriesToCreateAnEmployeeWithData(
            String firstName,
            String middleName,
            String lastName,
            String employeeId,
            String createLogin,
            String username,
            String password,
            String confirmPassword,
            String status
    ) {
        user.attemptsTo(
                FillEmployeeBasicDataTask.with(firstName, middleName, lastName),
                SetEmployeeIdTask.with(employeeId),
                EnableLoginDetailsTask.ifEnabled(createLogin),
                FillDetailsEmployeeTask.with(createLogin, username, password, confirmPassword, status)
        );
    }

    @Then("The employee creation validation message {string} should be displayed")
    public void theEmployeeCreationValidationMessageShouldBeDisplayed(String expectedMessage) {
        user.attemptsTo(
                WaitUntil.the(HomeOrangePageUI.VALIDATION_MESSAGE.of(expectedMessage), isVisible())
                        .forNoMoreThan(15).seconds()
        );

        user.should(seeThat(IsEmployeeValidationMessageVisible.withMessage(expectedMessage), is(true)));
    }

    @After
    void closeBrowser() {
        driver.
    }
}