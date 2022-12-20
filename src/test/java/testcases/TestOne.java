package testcases;

import org.testng.annotations.Test;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class TestOne extends TestBase {

	@Test
	public static void Login() {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(Loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(Loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(Loc.getProperty("loginButton"))).click();

	}

	@Test
	public void CountItems() {
		driver.findElement(By.cssSelector(Loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(Loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(Loc.getProperty("loginButton"))).click();
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\\\"inventory_item_name\\\"]"));
		int itemCount = list.size();
		System.out.println(itemCount);

	}

	@Test
	public void GetTile() {
		driver.findElement(By.cssSelector(Loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(Loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(Loc.getProperty("loginButton"))).click();
		String title = driver.getTitle();
		System.out.println(title);
	}
}
