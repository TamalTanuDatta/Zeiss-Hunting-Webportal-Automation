package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public WebDriver driver;

	private By username = By.id("signInName");
	private By password = By.id("password");
	private By signIn = By.id("next");

	public SignInPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getUserName() {

		return driver.findElement(username);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement signIn() {

		return driver.findElement(signIn);
	}

}
