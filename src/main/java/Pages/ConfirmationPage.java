package Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBaseClass.TestBase;

public class ConfirmationPage extends TestBase {
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[2]")
	WebElement idText;
	
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String printText() {
		return idText.getText();
	}
}
