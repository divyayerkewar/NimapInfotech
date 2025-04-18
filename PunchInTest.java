package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PunchInTest extends BaseTest {
	
	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://testffc.nimapinfotech.com/");
	    }

	    @Test
	    public void punchInTest() {
	        // Click PunchIn button
	        WebElement punchInButton = driver.findElement(By.id("punchInButton"));
	        punchInButton.click();

	        // Wait for the Toast message to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toastMessage")));

	        // Validate Toast Message
	        String expectedMessage = "Punch-In Successful!";
	        String actualMessage = toastMessage.getText();
	        assert actualMessage.equals(expectedMessage) : "Toast message not as expected";
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}

