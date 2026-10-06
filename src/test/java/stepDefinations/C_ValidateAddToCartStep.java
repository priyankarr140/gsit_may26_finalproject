package stepDefinations;
import org.testng.Assert;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class C_ValidateAddToCartStep {
	WebDriver driver;
	String userFlower;
	String userQuantity;
	@Given("clear filter is applied")
	public void user_is_on_the_search_page_and_clear_filter_is_applied() throws Exception{
	  
	    		Thread.sleep(3000);
	    		driver=new ChromeDriver();
	    		//driver.manage().window().maximize();
	    	        driver.get("https://www.engineerdiaries.com/ui-framework");
	    	        //Thread.sleep(5000);
	    	        System.out.println("REACHED CART");
	    	        //System.out.println(driver.getCurrentUrl());
	    	 		Thread.sleep(3000);
	    	 		driver.findElement(By.xpath("//*[text()='Clear Filters']")).click();
			   // Thread.sleep(3000);
			    System.out.println("CLEAR FILTER is clicked");
	    	
	   
	}
	@When("user search flower {string} and quantity {string}")
	public void user_search_flower_and_quantity(String flower, String quantity)
	throws Exception{
		
			userFlower=flower;
			userQuantity=quantity;
			//   System.out.println("REACHED METHOD2"+flower);
			driver.findElement(By.xpath("//input[@data-testid='search-input']"))
		    .sendKeys(flower);
		   Thread.sleep(3000);
		    for(int i=1;i<=Integer.parseInt(quantity);i++)
		    {
		    	driver.findElement(By.xpath("//*[text()='Add to Cart']")).click();
		    		Thread.sleep(3000);
		    }		    		
		 Thread.sleep(3000);
	
	   
	}
	@Then("validate correct item is added")
	public void validate_correct_item_is_added() throws Exception{
		driver.findElement(By.xpath("//*[@data-testid='toggle-cart']")).click();
			    Thread.sleep(3000);
			   String flower= driver.findElement(By.xpath("//p[@class='font-semibold']")).getText();
			    System.out.println("FLOWER:"+flower);
			    Assert.assertTrue(flower.equals(userFlower));
   
	}
	@Then("validate correct item quantity")
	public void validate_correct_item_quantity() throws Exception{
		
			Thread.sleep(3000);
			 String quantity= driver.findElement
					 (By.className("text-gray-600")).getText();

			    quantity=quantity.replaceAll("x","");
			    System.out.println(quantity);
			    Assert.assertTrue(quantity.equals(userQuantity));
			  
		
	 
	}

}
