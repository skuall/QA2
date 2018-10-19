package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomeworkSecond;

import java.util.concurrent.TimeUnit;

public class HomeworkSecondTest {

    public static WebDriver driver;
    public static HomeworkSecond title;
    private static String url = "https://rus.delfi.lv";
    private static String mobileUrl = "https://m.rus.delfi.lv/";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        title = new HomeworkSecond(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
    }


    @Test
    public void grabArticleTitles() {
        title.grabTitles();
        driver.get(mobileUrl);
        title.grabMobileTitle();
        Assertions.assertEquals(title.mainList, title.mobList);


    }

    @AfterAll
    public static void shutDown() {
        driver.quit();
    }
}
