import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@SuppressWarnings("ALL")
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"com.ui.stepdefinitions"},
        tags = {"@addtocart"},
        strict = true
        )
public class Cukes1Runner extends AbstractTestNGCucumberTests {

}
