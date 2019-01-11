package apiTests;

import apiTests.model.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class WhetherStepDefs {

    private String city;
    private WhetherRequester requester = new WhetherRequester();
    private Response response = new Response();

    @Given("city name: (.*)")
    public void set_city(String city) {
        this.city = city;
    }

    @When("we are requesting whether info")
    public void request_whether() throws IOException {
        response = requester.get_weather(city);
    }

    @Then("lon is: (.*)")
    public void check_lon(double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon());
    }

    @Then("lat is: (.*)")
    public void check_lat(double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat());
    }

    @Then("pressure is: (.*)")
    public void check_pressure(double pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure());

    }

    @Then("temperature is: (.*)")
    public void check_temperature(double temperature) {
        Assertions.assertEquals(temperature, response.getMain().getTemp());
    }

    @Then("humidity is: (.*)")
    public void check_humidity(double humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity());
    }

    @Then("temp_min: (.*)")
    public void check_temp_min(double temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min());
    }

    @Then("temp_max: (.*)")
    public void check_temp_max(double temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max());
    }
}