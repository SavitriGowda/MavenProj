package TestClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ReservePage;
import TestBaseClass.TestBase;

public class ReservePageTest extends TestBase {
	public HomePage homepage;
	public ReservePage reservepage;
	
	
	public ReservePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage=new HomePage();
		reservepage=new ReservePage();
		homepage.findTicket();
		
	}
	@Test
	public void findLowestPrizeFlightTest() { 
		reservepage.findLowestPrizeFlight();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
