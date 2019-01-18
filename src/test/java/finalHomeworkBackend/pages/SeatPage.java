package finalHomeworkBackend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeatPage {

    BaseBackendFunction baseBackendFunction;
    private final By SEAT_BUTTON = By.xpath("//div[@class='seat']");
    private final By BOOK_BUTTON = By.xpath("//*[@id=\"book2\"]");



    public void selectSeatNumber() {
        List<WebElement> seatNumbers = baseBackendFunction.getElements(SEAT_BUTTON);
        seatNumbers.get(7).click();

    }

    public void clickOnBookButton(){
        baseBackendFunction.getElement(BOOK_BUTTON).click();
    }
}
