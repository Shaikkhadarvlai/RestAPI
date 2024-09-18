package htmlMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Header_CookiesTest
{
  @Test(priority=1)
  public void testAllHeader() 
  {
	  given()
	  
	  .when().get("https://www.google.com")
	  .then().log().headers();
  
  
  
  }
  @Test(priority=2)
  public void testHeaders()
  {
	 Response res= given()
	              .when().get("https://www.google.com");
	
  
      String actHeader= res.getHeader("Content-Type");
      Assert.assertEquals(actHeader,"text/html; charset=ISO-8859-1");
      System.out.println("Header is validated!");
      
  }
  @Test(priority=3)
  public void cookiesTest()
  {
	  Response res= given()
	         .when().get("https://www.google.com");
	  
	Map<String,String> all= res.getCookies();
	
	System.out.println(all);
	String actcookie=res .getCookie("AEC");
	//cookie are always dynamic
	//cookies should not match
	
	Assert.assertFalse(actcookie.contains("AVYB7cp2vcvlj"));
	System.out.println("Pass: cookies are not matched");
	
	
  }
  
  
  
  
}
