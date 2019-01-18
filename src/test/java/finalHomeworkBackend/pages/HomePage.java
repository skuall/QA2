package finalHomeworkBackend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private BaseBackendFunction baseBackendFunction;

    private final By DEPARTURE_AIRPORT = By.xpath("//*[@id=\"afrom\"]");
    private final By DESTINATION_AIRPORT = By.xpath("//*[@id=\"bfrom\"]");
    private final By DEPARTURE_AIRPORTS_CODES = By.xpath("//*[@id=\"afrom\"]/option");
    private final By GOGOGO_BUTTON = By.xpath("//span[contains(@class, 'gogogo')]");

    public HomePage(BaseBackendFunction baseBackendFunction) {
        this.baseBackendFunction = baseBackendFunction;
    }

    public WebElement chooseDepartureAirport(String departureName) {
        List<WebElement> departureCodes = baseBackendFunction.getElements(DEPARTURE_AIRPORT);
        for (WebElement fromCodes : departureCodes) {
            if (fromCodes.findElement(DEPARTURE_AIRPORTS_CODES).getText().contains(departureName)) {
                return fromCodes;
            }

        }

        return null;

    }

    public WebElement chooseDestinationAirport(String destinationName) {
        List<WebElement> destinationCodes = baseBackendFunction.getElements(DESTINATION_AIRPORT);
        for (WebElement toCodes : destinationCodes) {
            if (toCodes.findElement(DESTINATION_AIRPORT).getText().contains(destinationName)) {
                return toCodes;
            }

        }

        return null;

    }

    public RegistrationPage clickOnGoButton() {
        baseBackendFunction.getElement(GOGOGO_BUTTON).click();
        return new RegistrationPage(baseBackendFunction);
    }


}
