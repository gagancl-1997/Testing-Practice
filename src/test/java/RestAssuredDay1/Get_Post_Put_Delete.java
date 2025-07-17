package RestAssuredDay1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Get_Post_Put_Delete {
	
	int id;

	@Test(priority = 1, enabled = true)
	public void getRequest() {
		given().header("x-api-key", "reqres-free-v1")
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).log().body();
	}

	@Test(priority = 2, enabled = true)
	public void postRequest() {

		HashMap<String, String> map = new HashMap<>();
		map.put("name", "Monja");
		map.put("job", "Engineer");

		id = given().header("x-api-key", "reqres-free-v1").contentType("Application/json").body(map)
				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		System.out.println(id);
	}
	
	@Test(priority = 3, dependsOnMethods = "postRequest")
	public void putRequest() {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "Nanja");
		map.put("job", "Teacher");
		
		given().header("x-api-key", "reqres-free-v1").contentType("Application/json").body(map)
		.when().put("https://reqres.in/api/users/"+id)
		.then().log().body();
	}
	
	@Test(priority = 4, dependsOnMethods = "postRequest")
	public void deleteRequest() {
		when().delete("https://reqres.in/api/users/"+id)
		.then().log().ifStatusCodeIsEqualTo(204);
	}
	
	@Test(priority = 5, enabled = true)
	public void getRequest1() {
		given().header("x-api-key", "reqres-free-v1")
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).log().body();
	}

}
