package finalHomeworkBackend;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import finalHomeworkBackend.model.UserData;
import finalHomeworkBackend.pages.*;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.Map;

public class ReservationStepDefs {

    private String departure_name;
    private String destination_name;
    private Integer seatNumber;
    private Map params;
    private UserData userData = new UserData();
    private BaseBackendFunction baseBackendFunction = new BaseBackendFunction();
    private final String HOME_PAGE = "http://www.qaguru.lv:8090/tickets";
    private final String DELETE_PAGE = "https://www.qaguru.lv:8090/tickets/delete.php?id=";
    private HomePage homePage;

    public ReservationStepDefs() {
    }

    @Given("departure airport: (.*)")
    public void set_departure_airport(String departure_name) {
        this.departure_name = departure_name;
    }

    @Given("destination airport: (.*)")
    public void set_destination_airport(String destination_name) {
        this.destination_name = destination_name;
    }

    @Given("user data is:")
    public void set_user_data(Map<String, String> params) {
        userData.setName(params.get("name"));
        userData.setSurname(params.get("surname"));
        userData.setDiscountcode(params.get("discountCode"));
        userData.setPersonCount(Integer.valueOf(params.get("personCount")));
        userData.setChildrenCount(Integer.valueOf(params.get("childrenCount")));
        userData.setLuggageCount(Integer.valueOf(params.get("luggageCount")));
        userData.setNextFlightDate(params.get("nextFlightDate"));
    }

    @Given("place is (.*)")
    public void set_seat_number(Integer seatNumber) {
        this.seatNumber = seatNumber;

    }

    @Given("we are on the home page")
    public void homepage() {
        baseBackendFunction.getUrl(HOME_PAGE);


    }

    @When("we are selectiing airports")
    public void select_airports() {
        homePage.chooseDepartureAirport(departure_name);
        homePage.chooseDestinationAirport(destination_name);


    }

    @When("we are presssing Gogogo button")
    public void press_button() {
        homePage.clickOnGoButton();

    }

    @Then("registration page appears")
    public void check_registration_page() {
        RegistrationPage registrationPage = new RegistrationPage(baseBackendFunction);

    }

    @When("we fill registration form")
    public void fill_form() {
        RegistrationPage registrationPage = new RegistrationPage(baseBackendFunction);
        registrationPage.fillRegistrationName((String) params.get(userData.getName()));
        registrationPage.fillRegistrationSurname((String) params.get(userData.getSurname()));
        registrationPage.fillRegistrationDiscountCode((String) params.get(userData.getDiscountcode()));
        registrationPage.fillRegistrationPeopleCount((String) params.get(userData.getPersonCount()));
        registrationPage.fillRegistrationChildrenCount((String) params.get(userData.getChildrenCount()));
        registrationPage.fillRegistrationLuggageCount((String) params.get(userData.getLuggageCount()));
        registrationPage.fillRegistrationNextFlight((String) params.get(userData.getNextFlightDate()));

    }

    @When("we are pressing Get price button")
    public void press_procceed_button() {
        RegistrationPage registrationPage = new RegistrationPage(baseBackendFunction);
        registrationPage.clickOnGetPriceButton();


    }

    @Then("our price will be (.*) euro")
    public void price_check(Integer price) {
        RegistrationPage registrationPage = new RegistrationPage(baseBackendFunction);
        String priceResult = registrationPage.checkPrice();
        String priceConv = String.valueOf(price);
        Assertions.assertEquals(priceResult, priceConv);

    }

    @When("we are pressing Book button")
    public void press_book_button() {
        RegistrationPage registrationPage = new RegistrationPage(baseBackendFunction);
        registrationPage.clickOnRegisterButton();


    }

    @Then("we are redirected on select seat page")
    public void check_seat_page() {
        SeatPage seatPage = new SeatPage();


    }

    @When("we are selecting our seat number")
    public void select_seat() {
        SeatPage seatPage = new SeatPage();
        seatPage.selectSeatNumber();

    }

    @When("we are clicking Book button")
    public void click_book_button() {
        SeatPage seatPage = new SeatPage();
        seatPage.clickOnBookButton();

    }

    @Then("successfull registration page appears with message: (.*)")
    public void check_success_page(String message) {
        SuccessPage successPage = new SuccessPage();
        String noticeMessage = successPage.getSuccessText();
        Assertions.assertEquals(noticeMessage, message);


    }

    @When("we are requesting reservation list")
    public void request_list() throws IOException {
        ReservationRequester reservationRequester = new ReservationRequester();
        reservationRequester.getTicketResponeData();


    }

    @Then("we can see our rservation in the list")
    public void check_reservation() throws IOException {
        ReservationRequester reservationRequester = new ReservationRequester();
        reservationRequester.dataResult();

    }

    @When("we are deleting our reservation ticket")
    public void delete_reservation() throws IOException {
        ReservationRequester reservationRequester = new ReservationRequester();
        String idToDelete = reservationRequester.deleteResponse();
        baseBackendFunction.getUrl(DELETE_PAGE + idToDelete);

    }

    @When("we are requesting reservation list again")
    public void request_modified_list() {
        baseBackendFunction.getUrl(HOME_PAGE);

    }

    @Then("we can see our reservation is deleted")
    public void check_deleted_reservation() throws IOException {
        ReservationRequester reservationRequester = new ReservationRequester();
        String idToDelete = reservationRequester.deleteResponse();
        String deletedId = reservationRequester.dataResult().getId();
        Assertions.assertNotEquals(deletedId, idToDelete);


    }


}
