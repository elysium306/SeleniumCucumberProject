package api_stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class PetStore {
	
	String url;
	Response response;
	
	
	@Given("valid endpoint exist")
	public void valid_endpoint_exist() {
	    url = "https://petstore.swagger.io/v2/pet/findByStatus";
	}
	@When("I send a GET request by status {string} to valid endpoint")
	public void i_send_a_get_request_by_status_to_valid_endpoint(String string) {
	   response = given().accept(ContentType.JSON)
	    .queryParam("status", "available")
	    .when().get(url);
	}
	@Then("Response status code should be {int}")
	public void response_status_code_should_be(Integer int1) {

		// validing the response using RestAssured build it validation
		response.then().statusCode(200);
	}
	@Then("Content type should be {string}")
	public void content_type_should_be(String string) {
		response.then().contentType("application/json");
	}

}
