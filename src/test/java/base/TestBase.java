package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties property = new Properties();
	public static Properties Loc = new Properties();

//FileInputStream input = new FileInputStream("/Users/sahadevbasnet/eclipse-workspace/basicjava/testautomationprocess/src/test/resources/configfiles/config.properties");

	@BeforeMethod
	public void setup() throws IOException {
	
			if (driver == null) {
			//System.out.println(System.getProperty("user.dir"));
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
			FileInputStream input1 = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configfiles/Locators.properties");
			
			property.load(input);
			Loc.load(input1);
			System.out.println(property.getProperty("browser"));

		}

		if(property.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(property.getProperty("baseUrl"));
		}
		else if(property.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(property.getProperty("baseUrl"));
		}
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();	
	}
}