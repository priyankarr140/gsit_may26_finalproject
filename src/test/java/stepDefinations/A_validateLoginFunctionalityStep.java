package stepDefinations;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import io.cucumber.java.en.*;
public class A_validateLoginFunctionalityStep {
	WebDriver driver;
	@Given("user is home page")
	public void user_is_home_page() throws Exception {
		driver=new ChromeDriver();
		Thread.sleep(5000);		
		driver.get("https://www.engineerdiaries.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);   
	}
	@When("clicks login")
	public void clicks_login() throws Exception {		
		 Thread.sleep(3000); 
		 driver.findElement(By.xpath("//*[text()='Sign In / Sign Up']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[text()='Login']")).click();		  
		  Thread.sleep(3000);		
	}
	@When("user enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) 
	throws Exception
	{
		driver.findElement(By.id("input-Email")).sendKeys(email);
		Thread.sleep(3000);
		 driver.findElement(By.id("input-Password")).sendKeys(password);
		 Thread.sleep(3000);
		 
	   
	}
	@Then("user is sucessfully logged in")
	public void user_is_sucessfully_logged_in() throws Exception {
		
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@type='submit']")).click();		
	    Thread.sleep(2000);
	    String loginText=
	    		driver.findElement(By.xpath("(//div[@class='relative'])[3]"))
	    		.getText();
		  Assert.assertTrue(loginText.contains("Hi"),"Login failure"); 
		  Thread.sleep(3000);
		 
	   
	}
	

}
