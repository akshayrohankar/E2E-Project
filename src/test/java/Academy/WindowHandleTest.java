package Academy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;

public class WindowHandleTest extends base{

	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url_practicePage"));
	}

	@Test(priority = 1)
	public void windowHandleTest() throws InterruptedException {

		WebElement footerGroup = driver.findElement(By.id("gf-BIG"));
		int countFooterLinks = footerGroup.findElements(By.tagName("a")).size();
		System.out.println("Total links present in footer are: "+countFooterLinks);

		//   XPATH for footer column //div[@id="gf-BIG"]//table/tbody/tr/td[1]/ul
		WebElement footerColumnOne = footerGroup.findElement(By.xpath("//table/tbody/tr/td/ul"));
		List<WebElement> listOfLinks = footerColumnOne.findElements(By.tagName("a"));
		System.out.println("Column 1 total link in footer: "+listOfLinks.size());

		// Link open in separate tab
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		for (int i = 0; i < listOfLinks.size(); i++) {
			listOfLinks.get(i).click();
			System.out.println(listOfLinks.get(i).getText());
		}
		action.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void getTitleOnEachTab() throws InterruptedException {
		
		WebElement footerGroup = driver.findElement(By.id("gf-BIG"));
		int countFooterLinks = footerGroup.findElements(By.tagName("a")).size();
		System.out.println("Total links present in footer are: "+countFooterLinks);

		//   XPATH for footer column //div[@id="gf-BIG"]//table/tbody/tr/td[1]/ul
		WebElement footerColumnOne = footerGroup.findElement(By.xpath("//table/tbody/tr/td/ul"));
		List<WebElement> listOfLinks = footerColumnOne.findElements(By.tagName("a"));
		System.out.println("Column 1 total link in footer: "+listOfLinks.size());

		// Link open in separate tab
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		for (int i = 0; i < listOfLinks.size(); i++) {
			listOfLinks.get(i).click();
			System.out.println(listOfLinks.get(i).getText());
		}
		action.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
		
		// WINDOWS HANDLE
		Set<String> windowsId = driver.getWindowHandles();
		
		Iterator<String> it = windowsId.iterator();
		String mainWindow= it.next();
		
		System.out.println("Below are the title of each window:");
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.switchTo().window(mainWindow);
	}



	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
