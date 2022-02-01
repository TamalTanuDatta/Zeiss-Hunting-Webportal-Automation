package zeissHunting.WebPortal;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DataPrivacyPage;
import pageObjects.InitialPage;
import resources.Base;

public class ValidateTitle extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("baseurl"));
		log.info("Navigate to Homepage");
	}

	@Test
	public void homePageValidation() {
		
		DataPrivacyPage dataPrivacyPage = new DataPrivacyPage(driver);
		dataPrivacyPage.acceptDataPrivacy().click();
		InitialPage initialPage = new InitialPage(driver);
		String titleName = initialPage.getTitle().getText();
		Assert.assertEquals(titleName, "My ZEISS Hunting Portal");
		log.info("Successfully Validated Title WebPortal");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
