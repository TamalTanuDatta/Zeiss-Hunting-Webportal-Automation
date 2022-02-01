package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataPrivacyPage {

	public WebDriver driver;

	private By acceptDataPrivacy = By.id("onetrust-accept-btn-handler");

	public DataPrivacyPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement acceptDataPrivacy() {

		return driver.findElement(acceptDataPrivacy);
	}
}
