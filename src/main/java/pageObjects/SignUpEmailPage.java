package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpEmailPage {
	
	public WebDriver driver;

	private By signUpEmail = By.id("SignUpWithLogonEmailExchange");;

	public SignUpEmailPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public WebElement signUpEmail() {
		
		return driver.findElement(signUpEmail);
	}
}

