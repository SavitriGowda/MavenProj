package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.HomePage;
import Pages.ReservePage;
import TestBaseClass.TestBase;

public class HomePageTest extends TestBase{
	public HomePage homepage;
	public ReservePage reservepage;
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentReports extent=new ExtentReports();
	
	ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialize();
		extent.attachReporter(spark);
		
		homepage=new HomePage();
	
	
	}
	
	@Test
	public void homepageTitleTest() {
		test=extent.createTest("Home Page title", "title of tha homa page test case");
		test.pass("passed");
		String title=homepage.HomePageTitle();
		Assert.assertEquals(title, "Welcome to the Simple Travel Agency!");
		
	}
	@Test
	public void hyperlinkUrlTest() {
		test=extent.createTest("Verify Link of vacation", "Link is working currect");
		test.pass("passed");
		String text=homepage.hyperLink();
		Assert.assertTrue(text.contains("vacation"));
		driver.navigate().back();
	}
	@Test
	public void findTecketTest() {
		test=extent.createTest("Verify Ticket booking button", "Verify Ticket booking button");
		test.pass("passed");
		reservepage=homepage.findTicket();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		extent.flush();
		driver.close();
	}
}
