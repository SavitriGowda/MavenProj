package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.PurchagePage;
import Pages.ReservePage;
import TestBaseClass.TestBase;

public class PurchagePageTest extends TestBase{
	public HomePage homepage;
	public ReservePage reservepage;
	public PurchagePage purchagepage;
	
	public PurchagePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage=new HomePage();
		reservepage=new ReservePage();
		purchagepage=new PurchagePage();
		homepage.findTicket();
		reservepage.findLowestPrizeFlight();
		
	}
	@Test(priority = 1)
	public void verifyTotalCostTest() { 
		purchagepage.VerifytotalCostText();
		//Assert.assertEquals(false, false);
	}
	
	@Test(priority = 2)
	public void verifyPurchageFlightBtn() {
		purchagepage.clickOnPurchageFlightBtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
