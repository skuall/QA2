package finalHomeworkBackend.pages;


import org.openqa.selenium.By;


public class RegistrationPage {

    private BaseBackendFunction baseBackendFunction;
    private final By NAME_FIELD = By.xpath("//*[@id=\"name\"]");
    private final By SURNAME_FIELD = By.xpath("//*[@id=\"surname\"]");
    private final By DISCOUNT_FIELD = By.xpath("//*[@id=\"discount\"]");
    private final By PEOPLE_FIELD = By.xpath("//*[@id=\"adults\"]");
    private final By CHILDREN_FIELD = By.xpath("//*[@id=\"children\"]");
    private final By LUGGAGE_FIELD = By.xpath("//*[@id=\"bugs\"]");
    private final By NEXTFLIGHT_FIELD = By.xpath("//*[@id=\"flight\"]");
    private final By GET_PRICE_BUTTON = By.xpath("//span[@onclick='setLang();']");
    private final By PRICE_RESPONSE = By.xpath("//*[@id=\"response\"]");
    private final By BOOK_BUTTON_REGISTRATION = By.xpath("//*[@id=\"book2\"]");



    public RegistrationPage(BaseBackendFunction baseBackendFunction) {
        this.baseBackendFunction = baseBackendFunction;

    }

    public void fillRegistrationName(String name) {
        baseBackendFunction.getElement(NAME_FIELD).sendKeys(name);

    }

    public void fillRegistrationSurname(String surname) {
        baseBackendFunction.getElement(SURNAME_FIELD).sendKeys(surname);

    }

    public void fillRegistrationDiscountCode(String code) {
        baseBackendFunction.getElement(DISCOUNT_FIELD).sendKeys(code);
    }

    public void fillRegistrationPeopleCount(String peopleCount) {
        baseBackendFunction.getElement(PEOPLE_FIELD).sendKeys(peopleCount);
    }

    public void fillRegistrationChildrenCount(String childrenCount) {
        baseBackendFunction.getElement(CHILDREN_FIELD).sendKeys(childrenCount);
    }

    public void fillRegistrationLuggageCount(String LuggageCount) {
        baseBackendFunction.getElement(LUGGAGE_FIELD).sendKeys(LuggageCount);
    }

    public void fillRegistrationNextFlight(String nextFlight) {
        baseBackendFunction.selectFromDropDown(NEXTFLIGHT_FIELD, nextFlight);
    }

    public void clickOnGetPriceButton() {
        baseBackendFunction.getElement(GET_PRICE_BUTTON);
    }

    public String checkPrice() {
        String price = baseBackendFunction.getElement(PRICE_RESPONSE).getText();
        price = price.substring(49, price.length() - 40);
        return price;

    }

    public void clickOnRegisterButton(){
        baseBackendFunction.getElement(BOOK_BUTTON_REGISTRATION).click();
    }





}
