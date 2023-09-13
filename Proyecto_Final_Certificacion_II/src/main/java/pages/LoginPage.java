package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;

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

        //WebElement userNameTextBox = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
          //      .until(ExpectedConditions.elementToBeClickable(By.name("username")));
        userNameTextBox.sendKeys(userName);
    }
    public void setPasswordTextBox(String password)
    {
        //WebElement passwordTextBox = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
          //      .until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passwordTextBox.sendKeys(password);
    }
    public void clickOnLoginButton()
    {
        //WebElement loginButton = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
          //      .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")));
        loginButton.click();
    }

}
