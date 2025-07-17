package Paams;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueyPaamsr {

	@Test
	public void parameters() {
//		 x-api-key: reqres-free-v1
		String url = "https://reqres.in/api/";
		given().header("x-api-key", "reqres-free-v1")
			.pathParam("value1", "users")
			.queryParam("page", "2")
			.queryParam("id", "8")
		.when().get(url+"{value1}")
		.then().statusCode(200).log().all();
		
	}
	
}
