package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomerTest {

	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://testffc.nimapinfotech.com/");
	    }

	    @DataProvider(name = "customerData")
	    public Object[][] customerData() {
	        return new Object[][] {
	            { "John Doe", "john.doe@example.com", "1234567890" },
	            { "Jane Smith", "jane.smith@example.com", "0987654321" }
	        };
	    }

	    @Test(dataProvider = "customerData")
	    public void addCustomerTest(String name, String email, String phone) {
	        // Fill in customer details
	        WebElement nameField = driver.findElement(By.id("customerName"));
	        WebElement emailField = driver.findElement(By.id("customerEmail"));
	        WebElement phoneField = driver.findElement(By.id("customerPhone"));
	        WebElement submitButton = driver.findElement(By.id("submitButton"));

	        nameField.sendKeys(name);
	        emailField.sendKeys(email);
	        phoneField.sendKeys(phone);
	        submitButton.click();

	        // Validate success (example: checking for a confirmation message)
	        WebElement successMessage = driver.findElement(By.id("successMessage"));
	        assert successMessage.isDisplayed() : "Customer not added successfully";
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}


