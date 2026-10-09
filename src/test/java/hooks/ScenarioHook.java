package hooks;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import base.Base;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
public class ScenarioHook extends Base{
	
	@Before
	public void setUp()
	{
		System.out.println("reached hook1");

		WebDriver driver;
		System.out.println("reached hook2");
		String browser=getData("browser");
		System.out.println("browser:****"+browser);
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
	
		setDriver(driver);
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		  if (!scenario.isFailed())
		  { byte[] screenshotBytes = ((TakesScreenshot)
				  getDriver()).getScreenshotAs(OutputType.BYTES);
				  
		Allure.addAttachment( "Screenshot", new ByteArrayInputStream(screenshotBytes) ); }
		getDriver().quit();
	}

}
