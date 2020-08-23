package practice;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class AmazonIPhone extends base {

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void filterPrice() throws IOException, InterruptedException, ParseException {
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("i phone");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		

		/*
		 * WebElement name =
		 * driver.findElement(By.xpath("//a[contains(.,'Apple iPhone')]")); int count =
		 * driver.findElements(By.xpath("//a[contains(.,'Apple iPhone')]")).size();
		 * System.out.println("Aple link count: "+count);
		 */
		
		String price = "//div//span[@class='a-price-whole']";
		List<WebElement> list = driver.findElements(By.xpath(price));
		int size = list.size();
		
		for (WebElement webElement : list) {
			
			String pricePhone = webElement.getText();
			Number n =NumberFormat.getNumberInstance(java.util.Locale.US).parse(pricePhone);
			System.out.println("Number: "+n);
			
			System.out.println("========================================================");
			
			if(n.intValue()<50000) {
				System.out.println(n);
			}
		}
		
		
	}	

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
