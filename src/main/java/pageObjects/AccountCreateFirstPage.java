package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreateFirstPage {

	public WebDriver driver;
	
	private By email = By.id("email");
	private By password = By.id("newPassword");
	private By reenterPassword = By.id("reenterPassword");
	private By firstName = By.id("givenName");
	private By lastName = By.id("surname");
	private By userAggrementCheckBox = By.id("tcaccepted_True");
	
	public AccountCreateFirstPage(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public WebElement getPass() {
		return driver.findElement(password);
	}
	
	public WebElement reenterPass() {
		return driver.findElement(reenterPassword);
	}
	
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement userAggrementCheckBox() {
		return driver.findElement(userAggrementCheckBox);
	}

}

