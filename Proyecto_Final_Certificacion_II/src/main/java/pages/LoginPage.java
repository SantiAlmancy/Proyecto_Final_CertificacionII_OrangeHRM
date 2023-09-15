package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    @FindBy(name = "username")
    WebElement userNameTextBox;
    @FindBy(name = "password")
    WebElement passwordTextBox;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginButton;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTextBox(String userName)
    {
        userNameTextBox.sendKeys(userName);
    }
    public void setPasswordTextBox(String password)
    {
        passwordTextBox.sendKeys(password);
    }
    public void clickOnLoginButton()
    {
        loginButton.click();
    }
    public boolean isLoginPageDisplayed()
    {
        return (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }
}
