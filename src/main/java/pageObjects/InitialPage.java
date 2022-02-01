package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InitialPage {

	public WebDriver driver;

	private By getStarted = By.cssSelector("a[href*='/get-started']");	
	private By title = By.className("header-page-title");
	private By signIn = By.cssSelector("a[href*='/account/signin']");	

	public InitialPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public WebElement getStarted() {
		
		return driver.findElement(getStarted);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement signIn() {
		return driver.findElement(signIn);
	}

}
