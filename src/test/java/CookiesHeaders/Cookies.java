package CookiesHeaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Cookies {

	@Test
	public void cookiesTest(){
		Response res = given()
			.when().get("https://google.com");
		
//		System.out.println(res.getCookies());
		Map<String, String> cookies = res.getCookies();
		
		for(String lv : cookies.keySet()) {			
			System.out.println(lv+" -------> "+res.getCookie(lv));			
		}
	}
	
}
