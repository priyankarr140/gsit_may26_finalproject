package hooks;
import io.cucumber.java.*;
import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenarioHook extends Base{
	
	@Before
	public void setUp()
	{
		WebDriver driver=new ChromeDriver();
		setDriver(driver);
	}
	
	@After
	public void tearDown()
	{
		getDriver().quit();
	}

}
