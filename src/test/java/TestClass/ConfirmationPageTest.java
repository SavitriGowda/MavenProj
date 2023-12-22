package TestClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ConfirmationPage;
import Pages.HomePage;
import Pages.PurchagePage;
import Pages.ReservePage;
import TestBaseClass.TestBase;

public class ConfirmationPageTest extends TestBase {
	public HomePage homepage;
	public ReservePage reservepage;
	public PurchagePage purchagepage;
	public ConfirmationPage confirmationpage;
	
	
	public ConfirmationPageTest() {
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
		purchagepage.clickOnPurchageFlightBtn();
		confirmationpage=new ConfirmationPage();
		
	}
	@Test
	public void printIdTest() {
		String text=confirmationpage.printText();
		System.out.println(text);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
