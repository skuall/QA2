package finalHomeworkBackend.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseBackendFunction {

    private WebDriver driver;

    public BaseBackendFunction() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void getUrl(String url) {
        if (!url.contains("https://") && !url.contains("https://")) {
            url = "https://" + url;
        }
        driver.get(url);

    }

    public List<WebElement> getElements(By locator) {
        Assertions.assertFalse(driver.findElements(locator).isEmpty(), "Not found");
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void selectFromDropDown(By locator, String text) {
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByVisibleText(text);

    }
}
