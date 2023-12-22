package Pages;

import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBaseClass.TestBase;

public class PurchagePage extends TestBase{
	@FindBy(xpath = "//em[text()='914.76 '] ")
	WebElement totalCostText;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement purchFightBtn;
	
	public PurchagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifytotalCostText() {
		 Pattern patt=Pattern.compile("\\ddd.\\dd");
		 return totalCostText.getText();
	}
	
	public ConfirmationPage clickOnPurchageFlightBtn()
	{
		purchFightBtn.click();
		return new ConfirmationPage();
	}
	
	
}
