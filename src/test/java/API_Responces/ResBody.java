package API_Responces;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class ResBody {
	
	@Test
	public void checkResponseBodyValues() {
		Response response = given()
			.when().get("http://localhost:3000/testing");
		
		String resValue = response.jsonPath().getString("batters.batter[0].type");
		System.out.println(resValue);
		Assert.assertEquals(resValue, "Regular");
		
		List<Object> resValue1 = response.jsonPath().getList("batters.batter");
		System.out.println(resValue1);
		
		for(int i=0; i<resValue1.size(); i++) {
			String value = response.jsonPath().getString("batters.batter["+i+"].type");
			System.out.println(value);
		}
		
	}

}
