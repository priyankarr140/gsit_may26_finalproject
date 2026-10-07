package base;
import org.openqa.selenium.*;
public class Base {
	private static WebDriver driver;
	public WebDriver getDriver()
	{
		return driver;
	}
	public void setDriver(WebDriver driver1)
	{
		 driver=driver1;
	}

}
