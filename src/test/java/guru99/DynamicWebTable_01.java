package guru99;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DynamicWebTable_01 extends base{

	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url_guru99"));
	}

	@Test(priority = 1)
	public void dynamicWebTableTest() throws InterruptedException {

		List<WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		
		List<WebElement> row = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		
		
		
		System.out.println(row.size());
	}



	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
