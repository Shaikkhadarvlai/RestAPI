package htmlMethods;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * This is following BDD, Behavior Driven Developing
 * given()-pre-requisite
 * header,request payload,cookies,Authentication
 * 
 * when()-request   
 * GET,POST,PUT,DELETE
 * 
 * then()-Validation response
 * status code,payload,body
 */
public class RequestLatestWay_GET 
{
  @Test(enabled=false)
  public void getRequest01() 
  {
	  //endpoint=https://reqres.in/api/users/2
	  
	  System.out.println("Single user respose");
	  
	  given()
	  
	 .when().get("https://reqres.in/api/users/2")
	  
	 .then()
	 .assertThat()
     .statusCode(200)
     .body("data.id",equalTo(2))
     .body("data.first_name",equalTo("Janet"))
     .log().body();
          
  }
  
  @Test(enabled=false)
  public void getListOfUsers()
  {
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  .body("page",equalTo(2))
	  .body("data.id[2]",equalTo(9))
	  .body("data.first_name[5]",equalTo("Rachel"))
	  .log().body();
  }
  
   @Test(enabled=false)//this my own creation
   public void getsingleUser()
   {
	   given()
	   
	   
	   .when()
	   .get("https://reqres.in/api/unknown/2")
	   .then()
	   .statusCode(200)
	   .body("page",equalTo(1))
	   .body("data.id",equalTo(2))
	   .body("data.name",equalTo("fuchsia rose"))
	   .log().body();
	   
   }
   @Test(enabled=false)//this my own creation
  public void getresouresingle()
  {
	  given()
	  .when()
	  .get("https://reqres.in/api/unknown")
	  .then()
	  .statusCode(200)
	  .body("page",equalTo(1))
	  .body("data.name[1]",equalTo("fuchsia rose"))
	  .log().body();
	  
  }
  
  //hasItest() contains()
 //hasItems() ->check all elements are in a collection
 // contains() ->check all elements are in a collection and in a  
  
  @Test
  public void getTestMethods()
  {
	  given ()
	  .when()
	  .get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  .body("data.id",hasItems(7,11,12))
	  //.body("data.id",contains(7,11,12))//fail
	  .body("data.id",contains(7,8,9,10,11,12))//pass 
	  .body("data.first_name[3]",equalTo("Byron"))
	  .log().body();
  }


}
  


