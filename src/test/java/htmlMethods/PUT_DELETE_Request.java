package htmlMethods;

import org.testng.annotations.Test;


import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PUT_DELETE_Request 
{
  @Test(priority=1)
  public void PutRequest_Update() 
  {
	  System.out.println("Put Request is Executing!");
	  //https://reqres.in/api/users/2
	 
	  PojoDemo p1=new PojoDemo();
	  p1.setName("Rahim");
	  p1.setJob("Engg");
	  
	  given()
	  .contentType("application/json")
	  .body(p1)
	  
	  
	  .when()
	  .put("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log().all();
	  
  }
  
  
  @Test(priority=2)
  public void patchRequest_Update() 
  {
	  System.out.println("Patch Request is Executing!");
	  //https://reqres.in/api/users/2
	  PojoDemo p2=new PojoDemo();
	  p2.setName("Kumsr");
	  
	  
	  given()
	  .contentType("application/json")
	  .body(p2)
	  
	  
	  .when()
	  .patch("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log().all();
	  
  }
  
  @Test(priority=3)
  public void deleteRequest()
  {
	  given()
	  
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(204)
	  .log().body();
	  
  }
  
  
  
}
