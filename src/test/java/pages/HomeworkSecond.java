package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomeworkSecond {

    public HomeworkSecond(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    // rus.delfi.lv titles

    @FindBy(xpath = "//div[@class='top2012-big'][1]/h3[@class='top2012-title']/a[@class='top2012-title']")
    public WebElement articleTitleFirst;

    @FindBy(xpath = "//div[@class='top2012-big'][2]/h3[@class='top2012-title']/a[@class='top2012-title']")
    public WebElement articleTitleSecond;

    @FindBy(xpath = "//div[@class='top2012-small'][1]/h3[@class='top2012-title']/a[@class='top2012-title']")
    public WebElement getArticleTitleThird;

    @FindBy(xpath = "//div[@class='top2012-small'][2]/h3[@class='top2012-title']/a[@class='top2012-title']")
    public WebElement getGetArticleTitleFourth;

    @FindBy(xpath = "//div[@class='top2012-small'][3]/h3[@class='top2012-title']/a[@class='top2012-title']")
    public WebElement getGetGetArticleTitleFifth;

    // m.rus.delfi.lv titles

    @FindBy(xpath = "//*[@id='wrapper']/div[3]/div/div[2]/div/a[1]")
    public WebElement mobileTitleFirst;

    @FindBy(xpath = "//*[@id='wrapper']/div[3]/div/div[3]/div/a[1]")
    public WebElement mobileTitleSecond;

    @FindBy(xpath = "//*[@id='wrapper']/div[3]/div/div[4]/div/a[1]")
    public WebElement mobileTitleThird;

    @FindBy(xpath = "//*[@id='wrapper']/div[3]/div/div[6]/div/a[1]")
    public WebElement mobileTitleFourth;

    @FindBy(xpath = "//*[@id='wrapper']/div[3]/div/div[7]/div/a[1]")
    public WebElement mobileTitleFifth;

    public List<String> mainList = new ArrayList();

    public void grabTitles() {
        mainList.add(articleTitleFirst.getText());
        mainList.add(articleTitleSecond.getText());
        mainList.add(getArticleTitleThird.getText());
        mainList.add(getGetArticleTitleFourth.getText());
        mainList.add(getGetGetArticleTitleFifth.getText());

    }

    public List<String> mobList = new ArrayList();

    public void grabMobileTitle() {
        mobList.add(mobileTitleFirst.getText());
        mobList.add(mobileTitleSecond.getText());
        mobList.add(mobileTitleThird.getText());
        mobList.add(mobileTitleFourth.getText());
        mobList.add(mobileTitleFifth.getText());

    }


}

