package RestAssuredDay1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class ValidateResponseBody {
	
	@Test
	public void validateResponse() {
		
		HashMap map = new HashMap<>();
		map.put("name", "monja");
		map.put("job", "Doctor");
		
		given().header("x-api-key", "reqres-free-v1").contentType("Application/json").body(map)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201).body("name", equalTo("monja")).body("job", equalTo("Doctor"))
		.log().all();
	}

}
