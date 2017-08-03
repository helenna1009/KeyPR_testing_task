package stepDefinitions;

import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

/**
 * Step definitions for tests
 */
public class StepDefinition {
    private Response response;

    @When("user retrieves start page")
    public void getLoginPage() {
        response = when().get("http://github.com");
    }

    @Then("the status code is (\\d{3})")
    public void verifyStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("header contains (.*) with (.*)")
    public void verifyParams(Map<String, String> paramsValues) {
        assertEquals(paramsValues, response.getHeaders());
    }

}