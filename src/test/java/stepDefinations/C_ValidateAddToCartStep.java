package stepDefinations;
import pageObjects.CartPage;
import org.testng.Assert;

import io.cucumber.java.en.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import base.*;
public class C_ValidateAddToCartStep extends Base {
	CartPage cartPage;
	private static final Logger log =
			LogManager.getLogger(C_ValidateAddToCartStep.class);
//	WebDriver driver;
	String userFlower;
	String userQuantity;
	@Given("clear filter is applied")
	public void user_is_on_the_search_page_and_clear_filter_is_applied() {
	  
		try {
			Thread.sleep(3000);
    		//driver=new ChromeDriver();
    		//driver.manage().window().maximize();
			log.debug("framework url launched");
			getDriver().get(this.getData("frameworkUrl"));
    			log.debug("framework url launched");
    	        //Thread.sleep(5000);
    	        System.out.println("REACHED CART");
    	        //System.out.println(driver.getCurrentUrl());
    	 		Thread.sleep(3000);
    	 		cartPage=new CartPage(getDriver());
    	 		cartPage.getClearFilter().click();
    	 	 //  getDriver().findElement(By.xpath("//*[text()='Clear Filters']")).click();
   			log.debug("clear filter has been applied");

		   // Thread.sleep(3000);
		    System.out.println("CLEAR FILTER is clicked");
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());

		}
	    		  
	}
	@When("user search flower {string} and quantity {string}")
	public void user_search_flower_and_quantity(String flower, String quantity)
	{
		try {
			userFlower=flower;
			userQuantity=quantity;
			//   System.out.println("REACHED METHOD2"+flower);
			this.cartPage.getInputSearch().sendKeys(flower);
			 //  getDriver().findElement(By.xpath("//input[@data-testid='search-input']"))
		 
				log.debug("input:"+flower+" has been provided");

		   Thread.sleep(3000);
		    for(int i=1;i<=Integer.parseInt(quantity);i++)
		    {
		    	this.cartPage.getAddToCardBtn().click();
		    	 //  getDriver().findElement(By.xpath("//*[text()='Add to Cart']")).click();
		    		Thread.sleep(3000);
		    }	
			log.debug("quantity:"+userQuantity+" has been provided");

		 Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());

		}
			
	
	   
	}
	@Then("validate correct item is added")
	public void validate_correct_item_is_added() {
		try {
			this.cartPage.getCartBtn().click();
		//	getDriver().findElement(By.xpath("//*[@data-testid='toggle-cart']")).click();
		    Thread.sleep(3000);
		   String flower=this.cartPage.getItemName().getText();
				 //  getDriver().findElement(By.xpath("//p[@class='font-semibold']")).getText();
		    System.out.println("FLOWER:"+flower);
		    Assert.assertTrue(flower.equals(userFlower));
		    log.debug("correct item has been added");
		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());

		}
		   
   
	}
	@Then("validate correct item quantity")
	public void validate_correct_item_quantity(){
		try {
			Thread.sleep(3000);
			 String quantity=  this.cartPage.getItemQuantity().getText(); 
					 //getDriver().findElement
					 //(By.className("text-gray-600")).getText();

			    quantity=quantity.replaceAll("x","");
			    System.out.println(quantity);
			    Assert.assertTrue(quantity.equals(userQuantity));
			    log.debug("correct quantity has been selected");

		}
		catch(Exception ex)
		{
			log.error("Exception occurred:"+ex.getMessage());

		}
			
			  
		
	 
	}

}
