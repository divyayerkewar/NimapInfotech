package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver; // this is our driver instance

	@BeforeMethod
	public void setup() {
	   WebDriverManager.chromedriver().browserVersion("135").setup();
	    driver = new ChromeDriver();
	   // System.setProperty("webdriver.chrome.driver", "C:\\Users\\divya yerkewar\\OneDrive\\Documents\\chromedriver-win32");

	     driver.get("https://testffc.nimapinfotech.com/");
	    driver.manage().window().maximize();
	}

	/*@AfterMethod
	public void tearDown() {
	    if (driver != null) {
	        driver.quit(); // close the browser*/
	    
	}


