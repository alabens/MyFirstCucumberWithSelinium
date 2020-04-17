package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(how = How.NAME, using="UserName")
    public WebElement textUserName;

    @FindBy(how = How.NAME, using="Password")
    public WebElement textPassword;

    @FindBy(how = How.NAME, using="Login")
    public WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void Login (String userName, String password){
        textUserName.sendKeys(userName);
        textUserName.sendKeys(password);
    }

    public void ClickLogin(){
        btnLogin.submit();
    }

}
