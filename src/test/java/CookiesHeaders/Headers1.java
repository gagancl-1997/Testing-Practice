package CookiesHeaders;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Headers1 {
	@Test
	public void headers() {
		given()
				.when().get("https://www.google.com/")
				.then().header("Server", "gws").statusCode(200);
		System.out.println("<------------------------------------------------>");
		Response res = given()
			.when().get("https://www.google.com/");
		  
		Headers head = res.getHeaders();
		
		for(Header lv : head) {
			System.out.println(lv.getName()+" ----> "+lv.getValue());
		}

	}

}
