package base;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.*;
public class Base {
	private static WebDriver driver;
	private static Properties prop;
	//private static String path;
	/*static String getPath()
	{
		 String path=System.getProperty("user.dir")+"\\src\\main\\java\\data.properties";
         return path;
	}
	public static void main(String[] args) {
		System.out.println(getPath());
	
	}*/

    static {
        try {
   		 String path=System.getProperty("user.dir")+"\\src\\main\\java\\data.properties";
            FileInputStream fis = new FileInputStream
            (path);
            prop = new Properties();
            prop.load(fis);
            System.out.println(path+"*******");
            System.out.println(getData("browser")+"*********");
        } catch (Exception e) {
            throw new RuntimeException("Properties not loaded");
        }
    }

    public static String getData(String key) {
        return prop.getProperty(key);
    }
	public WebDriver getDriver()
	{
		return driver;
	}
	public void setDriver(WebDriver driver1)
	{
		 driver=driver1;
	}
	
	

}
