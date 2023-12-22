package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBaseClass.TestBase;
import UtilClass.UtilClass;

public class HomePage extends TestBase {
	@FindBy(linkText = "destination of the week! The Beach!")
	WebElement destlink;
	
	@FindBy(xpath = "//div[@class='container']/h1")
	WebElement homepageTitle;
	
	@FindBy(name = "fromPort")
	WebElement departCity;
	
	@FindBy(name="toPort")
	WebElement destCity;
	
	@FindBy(xpath = "//input[@value='Find Flights']")
	WebElement BtnOfFinTicket;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle() {
		String text=homepageTitle.getText();
		return text;
	}
	
	public String hyperLink() {
		destlink.click();
		return driver.getCurrentUrl();
	}
	
	public ReservePage findTicket() {
		UtilClass.selectOption(departCity, "Mexico City");
		UtilClass.selectOption(destCity, "London");
		 BtnOfFinTicket.click();
		 return new ReservePage();
	}
	
}
