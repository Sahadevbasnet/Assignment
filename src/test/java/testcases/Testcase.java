package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase {

	public static void main(String[] args) throws IOException {
		
		Properties property = new Properties();
		
			FileInputStream input = new FileInputStream(
	"/Users/sahadevbasnet/eclipse-workspace/basicjava/testautomationprocess/src/test/resources/configfiles/config.properties");
			property.load(input);
			System.out.println(property.getProperty("browser"));
			
			System.out.println(property.getProperty("baseUrl"));
			
			if(property.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				
				driver.get((property.getProperty("baseUrl")));
				
				driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
				driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
				driver.findElement(By.cssSelector("#login-button")).click();
				driver.quit();
				
			}
			else if(property.getProperty("browser").equals("firefox")){
				
			}
			
			
			
			}
}
//		
//		System.setProperty("webdriver.chrome.driver", "/Users/sahadevbasnet/Desktop/selljar/chromedriver");
//		WebDriver driver = new ChromeDriver();
//
//		WebDriverManager.chromedriver().setup();
//
//		driver.manage().window().maximize();
//		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
//		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
//		driver.findElement(By.cssSelector("#login-button")).click();
//		
//
//
//	

