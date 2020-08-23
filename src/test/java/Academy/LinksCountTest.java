package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class LinksCountTest extends base{

public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url_practicePage"));
	}
	
	@Test
	public void linkCountInPage() {
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println("Total links count in page: "+count);
		
		WebElement footerGroup = driver.findElement(By.id("gf-BIG"));
		int countFooterLinks = footerGroup.findElements(By.tagName("a")).size();
		System.out.println("Total links present in footer are: "+countFooterLinks);
		
		//    //div[@id="gf-BIG"]//table/tbody/tr/td[1]/ul
		
		WebElement footerColumnOne = footerGroup.findElement(By.xpath("//table/tbody/tr/td/ul"));
		int countFooterColumnLinksOne = footerColumnOne.findElements(By.tagName("a")).size();
		System.out.println("Column 1 total link in footer: "+countFooterColumnLinksOne);
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
