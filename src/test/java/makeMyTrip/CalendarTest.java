package makeMyTrip;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.MMT_Homepage;
import resources.base;

public class CalendarTest extends base{

	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url_mmt"));
	}

	@Test(priority = 1)
	public void calendarTest() throws InterruptedException {

		//MMT_Homepage home = new MMT_Homepage();	
		MMT_Homepage homepage = new MMT_Homepage(driver);
		
		homepage.sourceCity.sendKeys("BL");
		Thread.sleep(5000);
		
		WebElement autosuggest = homepage.sourceCity;
		int size = autosuggest.findElements(By.xpath("\\div[3]")).size();
		System.out.println("Size ---- "+size);
	}



	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
