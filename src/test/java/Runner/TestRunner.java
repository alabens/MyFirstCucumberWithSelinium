package Runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.formatter.Formatter;
import io.cucumber.core.options.RuntimeOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = ("src/test/java/Features"),
        plugin = {"json:target/cucumber.json",
                "html:target/site/cucumber-pretty",
                //"com.cucumber.listener.ExtentCucumberFormatter:target/Extent/ExtentReport.html"
        },
        glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests {


    }
//}