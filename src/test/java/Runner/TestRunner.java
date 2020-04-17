package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features=("src/test/java/Features"),
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty" },
        glue="Steps")

public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider
    //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}