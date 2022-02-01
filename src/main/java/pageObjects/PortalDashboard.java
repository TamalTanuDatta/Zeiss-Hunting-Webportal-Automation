package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalDashboard {

	public WebDriver driver;

	private By titleDashboard = By.className("header-page-title");

	public PortalDashboard(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getTitleDashboard() {
		return driver.findElement(titleDashboard);
	}

}
