package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class MMT_Homepage extends base{
	

	public MMT_Homepage(WebDriver driver) {
		base.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="fromCity")
	public WebElement sourceCity;
	
	@FindBy(id="toCity")
	public WebElement destinationCity;
	
	@FindBy(xpath="//div[contains(@class,'fsw_inputBox dates inactiveWidget')]//label")
	public WebElement departureDate;
	
	@FindBy(xpath="//div[contains(@class,'fsw_inputBox dates reDates inactiveWidget')]//div//label")
	public WebElement returnDate;
	
	@FindBy(xpath="//a[contains(@class,'primaryBtn font24 latoBold widgetSearchBtn')]")
	public WebElement searchBtn;

	
}
