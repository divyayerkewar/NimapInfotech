package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By emailField = By.cssSelector("input[formcontrolname='username']");
	private By passwordField = By.cssSelector("input[formcontrolname='password']");
	private By SigninButton = By.id("kt_login_signin_submit");

	public LoginPage(WebDriver driver) {
	    this.driver = driver;
	}

	public void login(String email, String password) {
	    driver.findElement(emailField).sendKeys(email);
	    driver.findElement(passwordField).sendKeys(password);
	    driver.findElement(SigninButton).click();
	}

}
