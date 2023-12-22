package TestBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	
	public TestBase() {
		prop=new Properties();
		try {
			FileInputStream fs=new FileInputStream("C:\\Users\\savit\\eclipse-workspace\\MvnProj\\src\\main\\java\\ConfigClass\\Config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialize() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users"
					+ "\\savit\\Downloads\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
