package htmlMethods;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class SameUserGETPOSTPUTDELEETE 
{
	String id;
  @Test(priority=1)
  public void creatUser() 
  {
	//creat a data
	  PojoDemo pojo=new PojoDemo();
	  pojo.setJob("vali");
	  pojo.setName("tester");
	  
	  //save response in variable
	  id=given()
	  .contentType("application/json")//header
	  .body(pojo)
	  
	  .when()
	  .post("https://reqres.in/api/users")
	 .jsonPath().get("id");
	  
	  System.out.println("User created with id:"+id);
  }
  
  @Test(priority=2)
  public void getUser() 
  {
	  given()
	  .when().get("https://reqres.in/api/users/"+id)
	  .then().log().body();
	  
	  System.out.println("User display with same id:"+id);
  }
  
 
@Test(priority=3)
  public void putupdateUser() 
  {
	 PojoDemo p1=new PojoDemo();
	  p1.setName("Rahim");
	  p1.setJob("Engg");
	  
	  given()
	  .contentType("application/json")
	  .body(p1)
	  
	  
	  .when()
	  .put("https://reqres.in/api/users/"+id)
	  .then()
	  .statusCode(200)
	  .log().all();
	  
	  System.out.println("Data is  updated with same id:"+id);
  }
  
  @Test(priority=4)
  public void DeleteUser() 
  {
	  
	  given()
	  .when()
	  .delete("https://reqres.in/api/users/")
	  .then()
	  .statusCode(204)
	  .log().body();
	  
	  System.out.println("User is  Delete with same id:"+id);
  }
  
}
