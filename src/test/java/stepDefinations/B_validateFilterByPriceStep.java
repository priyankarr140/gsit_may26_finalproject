package stepDefinations;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.chrome.*;
import java.util.*;

import io.cucumber.java.en.*;

public class B_validateFilterByPriceStep {
	WebDriver driver;
    String inputRange;
    List<WebElement>flowerList;
	@Given("user is on search screen and in stock is checked")
	public void user_is_on_search_screen_and_in_stock_is_checked() throws Exception{
	driver=new ChromeDriver();
	Thread.sleep(3000);
	driver.get("https://www.engineerdiaries.com/ui-framework");
	Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@type='checkbox']")).click();
	Thread.sleep(3000);
		
	    
	}
	@When("Range {string} is selected")
	public void range_is_selected(String range) throws Exception{
	 
			//priceFilterPage = new PriceFilterPage(getDriver()); 
			   WebElement filterByPrice=driver.findElement(By.tagName("select"));		
			    inputRange=range;
			    Select selectFilter=new Select(filterByPrice);
			    selectFilter.selectByContainsVisibleText(inputRange);
			    Thread.sleep(3000);
			    flowerList=driver.findElements(By.className("hover:shadow-lg"));
			    		//priceFilterPage.getItemCard();
			    System.out.println("size:"+flowerList.size());
			    		
			
		
	
	}
	@Then("price is validated")
	public void price_is_validated() {
	
			System.out.print(flowerList.size()+"***SIZE");		
			for(int i=1;i<=flowerList.size();i++)
		    {	   
		     String text=driver
		     .findElement
		     (By.xpath("(//p[contains(@data-testid,'flower-price')])["+i+"]"))
		    	 .getText();
		     text=text.replaceAll("[^0-9]","");
		    // Assert.assertT
		     System.out.println(text);
		     //ADD ASSERTION
		    
		     if(inputRange.equals("Below ₹60") && !text.isEmpty())
		     {
			        int value = Integer.parseInt(text);
			        // Assertion
			        Assert.assertTrue(value < 60, "Value is not less than 60");
		     }
		     else if(inputRange.equals("₹60 - ₹70") && !text.isEmpty())
		     {
		    	 int value = Integer.parseInt(text);
			        // Assertion
			        Assert.assertTrue(value >= 60, "Value is not less than 60");
			        Assert.assertTrue(value <= 70, "Value is not greater than 70");

		     
		     }
		     else if(inputRange.equals("Above ₹70") && !text.isEmpty())
		     {
		    	 		int value = Integer.parseInt(text);
			        // Assertion
			        Assert.assertTrue(value >= 70, "Value is not greater than 70");
		     
		     }
		        // Extract number		     
		    }
			System.out.println("PRICE FILTER FOR "+inputRange+" is working");
		  //  logger.debug("PRICE FILTER FOR "+inputRange+" is working");
		   // Thread.sleep(3000);
		  //  System.out.println("URL last"+getDriver().getCurrentUrl());

	}

}
