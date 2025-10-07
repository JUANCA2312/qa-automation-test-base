import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/login",
    glue = "com.automatizacion.login.stepdefinitions",
    plugin = {"pretty"},
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoginTestRunner {
}

