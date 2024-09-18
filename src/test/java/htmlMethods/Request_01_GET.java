package htmlMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Request_01_GET 
{
  @Test
  public void getRequest_SingleUser()
  {
	 Response res= RestAssured.get("https://reqres.in/api/users/2");
   int statuscode=res.getStatusCode();
  System.out.println("Response status code is"+statuscode);
  
  Assert.assertEquals(200,statuscode,"Fail:status code not matched");
  System.out.println("Pass:statuscode is matched");
  
  System.out.println("Session id is :"+res.sessionId());
  System.out.println("status lin:"+res.statusLine());
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
}
