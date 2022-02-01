package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageAccount {

	public WebDriver driver;

	private By createAccount = By.id("continue");

	public LandingPageAccount(WebDriver driver) {

		this.driver = driver;

	}

	public AccountCreateFirstPage getAccount() {

		// driver.findElement(createAccount).click();
		AccountCreateFirstPage accountCreateFirstPage = new AccountCreateFirstPage(driver);
		return accountCreateFirstPage;
	}

	public WebElement createAccount() {

		return driver.findElement(createAccount);
	}

}
