package stepDefinitions;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.Communicator;

/**
 * Step definitions for tests
 */
public class StepDefinition {
    private Response response;
    private String securityToken = "";
    private String singlePullRequestLink = "https://github.com/helenna1009/KeyPR_testing_task/pull/1";

    @Given("user is logged in")
    public void loggingIn(){
        securityToken = Communicator.autorize();
    }

    @When("user retrieves single pull request")
    public void retrievingSinglePullRequest(){
        response = Communicator.makePullRequest(singlePullRequestLink, securityToken);
    }

    @Then("the status code is (\\d{3})")
    public void verifyStatusCode(int statusCode){
        assertEquals(statusCode, response.getStatusCode());
    }
}
