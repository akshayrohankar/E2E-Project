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

public class DynamicWebTable_02 extends base{

	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get("http://demo.guru99.com/test/table.html");
	}

	@Test(priority = 1)
	public void dynamicWebTableTest() throws InterruptedException {
		
		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
		
		List<WebElement> rowElements = table.findElements(By.tagName("tr"));
		int rowCount = rowElements.size();
		
		
		for (int row = 0; row < rowCount; row++) {
			
			List<WebElement> colElements = rowElements.get(row).findElements(By.tagName("td"));
			int colCount = colElements.size();
			
			System.out.println("No. of elements in row: "+colCount);
			for (int col = 0; col < colCount; col++) {
				String element = colElements.get(col).getText();
				System.out.println(element);
			}
		}
	}



	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
