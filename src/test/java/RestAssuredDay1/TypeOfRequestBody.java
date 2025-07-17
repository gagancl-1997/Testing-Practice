package RestAssuredDay1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*; 

import java.util.HashMap;

import org.testng.annotations.Test;

public class TypeOfRequestBody {
	
	@Test(priority = 1, enabled = false)
	public void UsingHashMap() {
		
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Monja");
		data.put("job", "Teacher");
		
		given()
			.contentType("Application/json").body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then().log().body();
		
	}
	
	@Test(priority = 2)
	public void UsingJson() {
		
		HashMap data = new HashMap<>();
		data.put("name", "Raju");
		data.put("location", "Italy");
		data.put("phone", "1234567890");
		
		String coursesArr[] = {"Perl", "Ruby"};
		data.put("courses", coursesArr);
		
		given()
			.contentType("Application/json").body(data)
		.when()
			.post("http://localhost:3000/students")
		.then().statusCode(equalTo(201)).log().body();
	}

}
