package Steps;

//import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
import Base.BaseUtil;
import Pages.LoginPage;
//import cucumber.api.DataTable;
import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class LoginStep extends BaseUtil {

    //WebDriver driver;
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        scenariodef.createNode(new GherkinKeyword("Given"),"I navigate to the login page");
        System.out.println("Navigate login page");
        //System.setProperty("webdriver.chrome.driver","chromedriver");
        //driver=new ChromeDriver();

        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");

    }


    @And("I enter the username as admin and password as admin")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable{
        scenariodef.createNode(new GherkinKeyword("And"),"I enter the username as admin and password ");

        System.out.println("Enter username and password");
        //throw  new PendingException();

    }

    @And("I click login button")
    public void iClickLoginButton() throws Throwable {
        scenariodef.createNode(new GherkinKeyword("And"),"I click login button");

        System.out.println("Click login button");

        LoginPage page = new LoginPage(base.driver);

        page.ClickLogin();

        // driver.findElement(By.name("Login")).submit(); ;

    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() throws Throwable {
        scenariodef.createNode(new GherkinKeyword("Then"),"I should see the userform page");

        System.out.println("I should see userform");
        Assert.assertEquals("its not displayed",base.driver.findElement(By.id("Initial")).isDisplayed(),true );

        base.driver.findElement(By.name("FirstName")).sendKeys("Ala");
        base.driver.findElement(By.name("MiddleName")).sendKeys("Ben Salah");

        //driver.findElement(By.name("generate")).click() ;


    }

   /* @And("I enter the username as {string} and password as {string}")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) {
        System.out.println("Username is " + username + " and password is " + password);

    }*/

    @And("I enter the following details for login")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) throws Throwable {
        scenariodef.createNode(new GherkinKeyword("And"),"I enter the following details for login");

        List<List<String>> data = table.cells();

        List<User> users = table.asList(User.class);
        for (User user : users) {
            System.out.println("The username is " + user.getUsername());
            System.out.println("The password is " + user.getPassword());
            LoginPage page = new LoginPage(base.driver);
            page.Login(user.username,user.password);

        }

      /*  Map<String, String> users = table.asMap(String.class, String.class);
        for (Map.Entry mapentry : users.entrySet()) {
            System.out.println("The UserName is : "+mapentry.getKey()
                    + " | The password is: " + mapentry.getValue());/*
        }*/
   }


    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        scenariodef.createNode(new GherkinKeyword("And"),"I enter username and password");

        //driver.findElement(By.name("UserName")).sendKeys(username);
        //driver.findElement(By.name("Password")).sendKeys(password);
        LoginPage page = new LoginPage(base.driver);
        page.Login(username,password);
        Thread.sleep(1000);

        //System.out.println("Username is : " + username);
        //System.out.println("Password is : " + password);
    }

    @Then("Close browser")
    public void closeBrowser() throws Throwable{
        scenariodef.createNode(new GherkinKeyword("Then"),"Close browser");

        Thread.sleep(3000);
        base.driver.quit();
        base.driver=null ;
    }


    public class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }


}