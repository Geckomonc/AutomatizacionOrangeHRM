package co.edu.udea.certificacion.taller.orangehrm.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_employee.feature",
        glue = "co.edu.udea.certificacion.taller.orangehrm.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class CreateEmployeeRunner {
}
