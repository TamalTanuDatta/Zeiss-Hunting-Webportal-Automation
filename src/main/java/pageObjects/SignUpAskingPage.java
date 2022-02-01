package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpAskingPage {

	public WebDriver driver;

	private By initialSignUp = By.cssSelector("a[href*='/account/signup']");
	// driver.get("https://hunting.zeiss.com/account/signup");

	public SignUpAskingPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement initialSignup() {

		return driver.findElement(initialSignUp);
	}
}
