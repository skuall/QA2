package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomeworkThird;
import java.util.concurrent.TimeUnit;

public class HomeworkThirdTest {

    public static WebDriver driver;
    public static HomeworkThird tab;
    private static String url = "http://automationpractice.com/index.php";

    @BeforeAll
    public static void setUpDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        tab = new HomeworkThird(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void checkProduct() throws InterruptedException {
        tab.listFirstTab();
        tab.checkCattegory();
        tab.chooseColor();
        tab.checkColorMatch();
        tab.selectDres();
        tab.addToCart();
        driver.navigate().back();
        tab.priceCollect();
        tab.addToSecCart();
        tab.sumPrices();

    }

    @AfterAll
    public static void closeDriver(){
        driver.quit();
    }
}

