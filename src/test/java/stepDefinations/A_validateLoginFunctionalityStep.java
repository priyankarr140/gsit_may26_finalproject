package stepDefinations;
import org.testng.Assert;
import base.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import io.cucumber.java.en.*;
public class A_validateLoginFunctionalityStep extends Base {
	//WebDriver driver;
	private static final Logger log =
			LogManager.getLogger(A_validateLoginFunctionalityStep.class);

	@Given("user is home page")
	public void user_is_home_page()  {
		try {
			
			Thread.sleep(5000);		
			getDriver().get("https://www.engineerdiaries.com/");
			log.debug("url launched");
			Thread.sleep(3000);
			getDriver().manage().window().maximize();
			log.debug("browser got maximized");
			Thread.sleep(3000);  
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());
		}
		//driver=new ChromeDriver();
		 
	}
	@When("clicks login")
	public void clicks_login()  {	
		try {
		 Thread.sleep(3000); 
		 getDriver().findElement(By.xpath("//*[text()='Sign In / Sign Up']")).click();
			log.debug("Signup button got clicked");
		 
		  Thread.sleep(3000);
		  getDriver().findElement(By.xpath("//*[text()='Login']")).click();	
			log.debug("login tab got clicked");
		  Thread.sleep(3000);	
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());
		}
	}
	@When("user enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) 
	
	{
		try {
		getDriver().findElement(By.id("input-Email")).sendKeys(email);
		log.debug("Email entered:"+email);

		Thread.sleep(3000);
		getDriver().findElement(By.id("input-Password")).sendKeys(password);
		log.debug("Password entered:"+password);

		 Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());

		}
		 
	   
	}
	@Then("user is sucessfully logged in")
	public void user_is_sucessfully_logged_in() {
		try {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//*[@type='submit']")).click();		
		log.debug("Submit button got clicked");

	    Thread.sleep(2000);
	    String loginText=
	    		getDriver().findElement(By.xpath("(//div[@class='relative'])[3]"))
	    		.getText();
		  Assert.assertTrue(loginText.contains("Hi"),"Login failure"); 
			log.debug("User is logged in successfully");

		  Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());

		}
	   
	}
	

}
