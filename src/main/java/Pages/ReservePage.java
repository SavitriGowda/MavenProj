package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBaseClass.TestBase;

public class ReservePage extends TestBase {
	
	
	@FindBy(xpath = "//table[@class='table']//tbody/tr/td[6]")
	List<WebElement> priceList;
	
	@FindBy(xpath = "//table[@class='table']//tbody/tr[4]/td/input")
	WebElement chooceFlightBtn;
	
	
	
	public ReservePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public PurchagePage findLowestPrizeFlight() {

		int rows=driver.findElements(By.xpath("//table[@class='table']//tbody/tr")).size();
		double min;
		min=Double.parseDouble(priceList.get(0).getText().substring(1));//$472.56
		//System.out.println(min);
		
		for(WebElement price:priceList) {
			double pricevalue=Double.parseDouble(price.getText().substring(1));
			if(pricevalue<min) {
				min=pricevalue;
			}
		}
		for(int i=1;i<=rows;i++) {
			String lowPrce="$"+String.valueOf(min);
			//System.out.println(lowPrce);
			String text=driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+i+"]/td[6]")).getText();
			if(lowPrce.equals(text)) {
				//System.out.println(lowPrce+" "+text);
				driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+i+"]/td/input")).click();
				break;
			}
		}
		return new PurchagePage();
	}
	
}
