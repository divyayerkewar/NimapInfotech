package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
	    return new Object[][]{
	            {"divyayerkewar123@gmail.com", "Divya@123"},
	            {"invalid@admin.com", "wrong123"}
	    };
	}

	@Test(dataProvider = "loginData")
	public void testLogin(String email, String password) {
	    LoginPage login = new LoginPage(driver);
	    login.login(email, password);
	    
	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentUrl = driver.getCurrentUrl();

        if (email.equals("divyayerkewar123@gmail.com") && password.equals("Divya@123")) {
            // Expected success
            Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed, expected dashboard but got: " + currentUrl);
            System.out.println("Login Passed for: " + email);
        } else {
            // Expected failure
            Assert.assertTrue(currentUrl.contains("login"), "Expected login to fail but it succeeded!");
            System.out.println("Login Failed as expected for: " + email);
        }
    }
}

