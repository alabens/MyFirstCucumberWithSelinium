package Steps;

import Base.BaseUtil;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario){
        scenariodef =base.features.createNode(scenario.getName());

        System.out.println("opening the browser : chrome");
        System.setProperty("webdriver.chrome.driver","chromedriver");

        base.driver=new ChromeDriver();
    }

    @After
    public void TearDownTest(Scenario scenario){
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("closing the browser : chrome");
    }}
