package api_tests;

import static org.testng.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetStoreTest {

	/*
	 * Scenario: Find a pet by status available Given valid endpoint exist When I
	 * send a GET request by status "available" to valid endpoint Then Response
	 * status code should be 200 And Content type should be "application/json"
	 */

	String url;
	Response response;

	@Test(priority = 1)
	public void findByStatus() {

		url = "https://petstore.swagger.io/v2/pet/findByStatus";
		// structure request url with parameters
		response = given().queryParam("status", "available").accept(ContentType.JSON).when().get(url);

		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());

		System.out.println(response.asPrettyString());
		// response.prettyPrint();

		// validing the response using RestAssured build it validation
		response.then().statusCode(200).and().contentType("application/json");

		// validating the response using testng assertion
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.contentType(), "application/json");
		

	}

	/*
	 * Scenario: Find a pet by invalid url using status available Given invalid
	 * endpoint exist When I send a GET request by "available" to valid endpoint
	 * Then Response status code should be 404 And Content type should be
	 * "application/json"
	 */

	@Test(priority = 2)
	public void findByWithInvalidUrl() {
		url = "https://petstore.swagger.io/v2/pet/findBy";

		response = given().queryParam("status", "available").accept(ContentType.JSON).when().get(url);

		response.prettyPrint();

		response.then().assertThat().statusCode(404).and().assertThat().contentType("application/json");

		assertEquals(response.getStatusCode(), 404);
		assertEquals(response.getContentType(), "application/json");

	}

	/*
	 * Scenario: As a user, I should be able to perform GET request to find a pet by
	 * id Given I have the GET request URL When I perform GET request to URL with
	 * pet id 227007 Then Response status code should be 200 And content type should
	 * be "application/json" And pet id is 227007, pet name is "booboo" status is
	 * "available" And validate category id is 5, category name is dog And validate
	 * tags id is 1234, and tags name is booboodc
	 */

	@Test(priority = 4)
	public void findByID() {
		int id = 227099;
		url = "https://petstore.swagger.io/v2/pet/";

		response = given().accept(ContentType.JSON).when().get(url + id);

		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.contentType(), "application/json");

		int actualID = response.path("id");
		System.out.println("actualID is : " + actualID);
		String actualName = response.path("name");
		System.out.println("actualName is : " + actualName);
		String actualStatus = response.path("status");
		System.out.println("actualStatus is : " + actualStatus);

		assertEquals(actualID, id);
		assertEquals(actualName, "booboo");
		assertEquals(actualStatus, "available");

		int categoryID = response.path("category.id");
		String categoryName = response.path("category.name");

		System.out.println(categoryID);
		System.out.println(categoryName);

		assertEquals(categoryID, 5);
		assertEquals(categoryName, "dog");

		int tagsID = response.path("tags[0].id");
		String tagsName = response.path("tags[0].name");

		System.out.println(tagsID);
		System.out.println(tagsName);

		assertEquals(tagsID, 1234);
		assertEquals(tagsName, "booboodc");

	}

	
	/*
	 * Scenario: As a user, I should be able to perform GET request to find a pet by
	 * invalid id Given I have the GET request URL When I perform GET request to URL
	 * with invalid id 2792200 Then Response status code should be 404 And content
	 * type is application/json And the message is "Pet not found"
	 */

	@Test (priority = 5)
	public void findByInvalidID() {
		url = "https://petstore.swagger.io/v2/pet/";
		int invalidId = 2792200;

		response = given().accept(ContentType.JSON).when().get(url + invalidId);

		assertEquals(response.statusCode(), 404);
		assertEquals(response.contentType(), "application/json");
		assertEquals(response.path("message"), "Pet not found");
	}

	/*
	 * Scenario: As a user, I should be able to perform POST request to add new pet to store 
	 * Given I have the POST request URL and valid request body 
	 * When I perform POST request to URL with request body 
	 * Then Response status code should be 200 
	 * And content type is application.json 
	 * And response body match the request body
	 */

	@Test(priority = 3)
	public void addNewPet() {
		url = "https://petstore.swagger.io/v2/pet";
		String requestBody = "{\n"
				+ "  \"id\": 227099,\n"
				+ "  \"category\": {\n"
				+ "    \"id\": 2,\n"
				+ "    \"name\": \"cat\"\n"
				+ "  },\n"
				+ "  \"name\": \"meow\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \"string\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": 12,\n"
				+ "      \"name\": \"meow\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \"available\"\n"
				+ "}";

		response = given().contentType("application/json").accept(ContentType.JSON)
				.body(requestBody)
				.when().post(url);

		assertEquals(response.statusCode(), 200);
		assertEquals(response.contentType(), "application/json");

		response.body().prettyPrint();
	}
	
	
	/*
	 * Scenario: As a user, I should be able to perform POST request to add new pet to store 
	 * Given I have the POST request URL and valid request body 
	 * When I perform POST request to URL with request body 
	 * Then Response status code should be 200 
	 * And content type is application.json 
	 * And response body match the request body
	 */
	
	
	@Test (priority = 6)
	public void addNewPetWithJSONFile() throws IOException {
		
		url = "https://petstore.swagger.io/v2/pet";
		
		File requestBody = new File("./src/test/resources/jsonFiles/addNewPet.json");
		
		String content = 
				new String(Files.readAllBytes(Paths.get("./src/test/resources/jsonFiles/addNewPet.json")));

		// chain validation with storing the response in to Response object
		response = given().contentType("application/json").accept(ContentType.JSON)
				.body(requestBody)
				.when().post(url);
		
		response.then().assertThat().statusCode(200)
		.and().assertThat().contentType("application/json")
		.and().assertThat().body("id", equalTo(330070))
		.and().assertThat().body("category.id", equalTo(2))
		.and().assertThat().body("category.name", equalTo("doggie"))
		.and().assertThat().body("name", equalTo("booboo"));

		assertEquals(response.statusCode(), 200);
		assertEquals(response.contentType(), "application/json");
		String responseBody = response.body().asPrettyString();
		response.body().prettyPrint();
		assertEquals(responseBody, content);
	}
	
	/*
	 * Scenario: As a user, I should be able to perform POST request to add new pet to store 
	 * Given I have the POST request URL and valid request body 
	 * When I perform POST request to URL with request body 
	 * Then Response status code should be 200 
	 * And content type is application.json 
	 * And response body match the request body
	 */
	
	@Test (priority = 7)
	public void addNewPetWithChainValidation() throws IOException {
		
		url = "https://petstore.swagger.io/v2/pet";
		
		File requestBody = new File("./src/test/resources/jsonFiles/addNewPetChainValidation.json");

		// chain validation without storing the response in to Response object
		given().contentType("application/json").accept(ContentType.JSON)
				.body(requestBody)
				.when().post(url)
				.then().assertThat().statusCode(200)
				.and().assertThat().contentType("application/json")
				.and().assertThat().body("id", equalTo(330000))
				.and().assertThat().body("category.id", equalTo(2))
				.and().assertThat().body("category.name", equalTo("doggie"))
				.and().assertThat().body("name", equalTo("booboo"))
				.and().assertThat().body("tags[0].id", equalTo(12))
				.and().assertThat().body("tags[0].name", equalTo("bobo"))
				.and().assertThat().body("tags[1].id", equalTo(4))
				.and().assertThat().body("tags[1].name", equalTo("DMV"))
				.and().assertThat().body("status", equalTo("available"))
				.log().all();
		
	}
	
	
	/*
	 * Scenario: As a user, I should not be able to perform POST request to invalid data structure
	 * Given I have the POST request URL and invalid request body 
	 * When I perform POST request to URL with request body 
	 * Then Response status code should be 500 invalid input 
	 * And content type is application.json
	 * And message should be "bad input"
	 * 
	 */
	
	
	@Test (priority = 8)
	public void addNewPetWithInvalidData() throws IOException {
		
		url = "https://petstore.swagger.io/v2/pet";
		
		File requestBody = new File("./src/test/resources/jsonFiles/invalidPostJsonData.json");

		// chain validation with storing the response in to Response object
		response = given().contentType("application/json").accept(ContentType.JSON)
				.body(requestBody)
				.when().post(url).andReturn();
		
		response.body().prettyPrint();
		
		response.then().assertThat().statusCode(500)
		.and().assertThat().contentType("application/json")
		.and().assertThat().body("message", equalTo("something bad happened"));
		
	}
	
	// Put request
	
	@Test (priority = 9)
	public void updatePet() {
		
    url = "https://petstore.swagger.io/v2/pet";
		
	File requestBody = new File("./src/test/resources/jsonFiles/putRequestBody.json");
	
	response = given().accept(ContentType.JSON).contentType("application/json")
	.body(requestBody)
	.when().put(url).thenReturn();
	
	//andReturn() = sugar coating, doesn't do anything,  simply returns the same response object that the Method got
	//thenReturn() = sugar coating, doesn't do anything,  simply returns the same response object that the Method got
	//then() = actually does something,  returns ValidatableResponse object which allows you to use those validation methods
		
	response.prettyPrint();
	
	response.then().assertThat().statusCode(200)
	.and().assertThat().contentType("application/json")
	.and().assertThat().body("id", equalTo(330000))
	.and().assertThat().body("photoUrls[0]", equalTo("https://www.thesprucepets.com/siberian-husky-dog-breed-profile-1118000"));
	
	}
	
	// Delete request
	
	@Test(priority = 10)
	public void deletePet() {
		url = "https://petstore.swagger.io/v2/pet/";
		
		response = given().header("api_key", "huskydelete").accept(ContentType.JSON)
		.when()
		.delete(url + 330000);
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200)
		.and().assertThat().contentType("application/json")
		.and().assertThat().body("message", equalTo("330000"));
		
	}
	
	
	// oauth with string token in the header
	
	@Test(priority = 11)
	public void deleteWithAuthToken() {
		url = "https://petstore.swagger.io/v2/pet/";
		
		response = given().accept(ContentType.JSON).auth().oauth2("helil_primetech")
		.when().delete(url + 330070);
		
		response.prettyPrint();
	}
	
	
	// basic authentication in the header
	
	@Test(priority = 12)
	public void deleteWithAuthUsernamePassword() {
		url = "https://petstore.swagger.io/v2/pet/";
		
		response = given().accept(ContentType.JSON).auth().basic("test", "abc123")
		.when().delete(url + 227099);
		
		response.prettyPrint();
	}
	
	
	

}
