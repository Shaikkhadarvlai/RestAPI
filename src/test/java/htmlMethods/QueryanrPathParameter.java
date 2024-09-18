package htmlMethods;

import org.testng.annotations.Test;


import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryanrPathParameter
{
	/*
	 * https://reqres.in/api/user?page=2
	 * resource: https://reqres.in/api
	 * path param:/users
	 * qurey param: page=2
	 * 
	 */
	
  @Test
  public void testParam() 
  {
	  given()
	  .pathParam("path","users")
	  .queryParam("page",2)
	  .when()
	  //.get("https://reqres.in/api/user?page=2")
	  .get("https://reqres.in/api/{path}")
	  .then().log().body();
  }
}
