package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager instance;
    public WebDriver driver;

    private DriverManager()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();

    }

    public static DriverManager getDriver()
    {
        if(instance==null)
        {
            instance = new DriverManager();
        }
        return instance;
    }
    public static void switchToNextWindow()
    {
        Set<String> windowHandles = DriverManager.getDriver().driver.getWindowHandles();
        for (String handle : windowHandles)
        {
            if (!handle.equals(DriverManager.getDriver().driver.getWindowHandle()))
            {
                DriverManager.getDriver().driver.switchTo().window(handle);
                break;
            }
        }
    }
    public static void closeAndSwitchToPreviousWindow() {
        WebDriver driver = DriverManager.getDriver().driver;
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
                driver.switchTo().window(currentWindowHandle);
                break;
            }
        }
    }
    public static String getCurrentURL()
    {
        return DriverManager.getDriver().driver.getCurrentUrl();
    }
    public static void closeAllWindows()
    {
        for (String handle : DriverManager.getDriver().driver.getWindowHandles())
        {
            DriverManager.getDriver().driver.switchTo().window(handle);
            DriverManager.getDriver().driver.close();
        }
    }
}
