package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.List;

public class HomeworkThird {

    public WebDriver driver;

    public HomeworkThird(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li")
    public List<WebElement> list;

    public void listFirstTab() {

        WebElement tabList = list.get(0);
        tabList.click();
    }

    @FindBy(xpath = "//*[@id='subcategories']/ul/li/h5/a")
    public List<WebElement> subCattegory;

    public void checkCattegory() {
        WebElement cattegory = subCattegory.get(1);
        cattegory.click();

    }

    //Тут есть проблема с сайтом, что фильтр не всегда срабатывет, пытался сделать костыль, но передумал.
    @FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_3']/li")
    public List<WebElement> colors;


    public void chooseColor() {
        WebElement colorOrange = colors.get(3);
        colorOrange.click();

    }


    @FindBy(xpath = "//*[@id='enabled_filters']/ul/li")
    public WebElement trueColor;

    public void checkColorMatch() {
        String orangeColorMatch = trueColor.getText();
        Assertions.assertTrue("Color: Orange".contains(orangeColorMatch), "Color match");

    }

    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    public List<WebElement> dreses;

    public void selectDres() throws InterruptedException {
        WebElement firstDres = dreses.get(0);
        firstDres.click();
    }

    @FindBy(xpath = "//*[@id='color_13']")
    public WebElement dressColor;

    public void checkDressColor() {
        String colorName = dressColor.getText();
        Assertions.assertTrue(colorName.contains("Orange"), "Color match selected");

    }

    @FindBy(xpath = "//button[contains(@class, 'exclusive')]/span")
    public WebElement cartButton;

    @FindBy(xpath = "//span[contains(@class, 'continue btn btn-default button exclusive-medium')]")
    public WebElement continiue;

    public void addToCart() throws InterruptedException {
        cartButton.click();
        Thread.sleep(3000);
        continiue.click();

    }

    @FindBy(xpath = "//span[contains(@class, 'price product-price')]")
    public List<WebElement> prices;

    public BigDecimal priceCollect() {
        WebElement firstPrice = prices.get(0);
        String firstPriceString = firstPrice.getText();
        firstPriceString = firstPriceString.replaceAll("\\$", "");
        BigDecimal firstPriceValue = new BigDecimal(firstPriceString);
        WebElement secondPrice = prices.get(1);
        String secondPriceString = secondPrice.getText();
        secondPriceString = secondPriceString.replaceAll("\\$", "");
        BigDecimal secondPriceValue = new BigDecimal(secondPriceString);
        BigDecimal sum = firstPriceValue.multiply(secondPriceValue);
        return sum;

    }


    @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']/span")
    public List<WebElement> secondCart;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']/span")
    public WebElement checkout;

    public void addToSecCart() throws InterruptedException {
        WebElement addToCar = secondCart.get(1);
        addToCar.click();
        Thread.sleep(3000);
        checkout.click();

    }

    @FindBy(xpath = "//*[@id='total_price']")
    public WebElement sumPrice;

    public void sumPrices() {
        String sumPriceString = sumPrice.getText();
        sumPriceString = sumPriceString.replaceAll("\\$", "");
        BigDecimal sumPriceValue = new BigDecimal(sumPriceString);
        Assertions.assertEquals(sumPriceValue, priceCollect());

    }

}
