package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountCreateSecondPage {

	public WebDriver driver;

	public AccountCreateSecondPage(WebDriver driver) {

		this.driver = driver;

	}

	public Select getGender() {

		Select gender = new Select(driver.findElement(By.id("SF_salutation")));
		return gender;
	}
}
