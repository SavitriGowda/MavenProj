package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ReservePage;
import TestBaseClass.TestBase;

public class HomePageTest extends TestBase{
	public HomePage homepage;
	public ReservePage reservepage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage=new HomePage();
	}
	
	@Test
	public void homepageTitleTest() {
		String title=homepage.HomePageTitle();
		Assert.assertEquals(title, "Welcome to the Simple Travel Agency!");
	}
	@Test
	public void hyperlinkUrlTest() {
		String text=homepage.hyperLink();
		Assert.assertTrue(text.contains("vacation"));
		driver.navigate().back();
	}
	@Test
	public void findTecketTest() {
		reservepage=homepage.findTicket();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
