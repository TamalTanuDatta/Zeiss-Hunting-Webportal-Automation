package zeissHunting.WebPortal;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DataPrivacyPage;
import pageObjects.InitialPage;
import pageObjects.LandingPageAccount;
import pageObjects.PortalDashboard;
import pageObjects.SignInPage;
import resources.Base;

public class LoginWebPortal extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("baseurl"));
	}

	@Test(dataProvider = "getData")
	public void loginHuntingPortal(String username, String password) throws InterruptedException {

		DataPrivacyPage dataPrivacyPage = new DataPrivacyPage(driver);
		dataPrivacyPage.acceptDataPrivacy().click();
		InitialPage initialPage = new InitialPage(driver);
		initialPage.signIn().click();
		SignInPage signInPage = new SignInPage(driver);
		signInPage.getUserName().sendKeys(username);
		signInPage.getPassword().sendKeys(password);
		signInPage.signIn().click();
		Thread.sleep(10000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://hunting.zeiss.com/dashboard");

		/*
		 * PortalDashboard portalDashboard = new PortalDashboard(driver); String
		 * titleName = portalDashboard.getTitleDashboard().getText();
		 * Assert.assertEquals(titleName, "Dashboard");
		 * log.info("Successfully Validated Title of Webportal Dashboard");
		 */

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][2];
		data[0][0] = "tamal.datta.innogy@gmail.com";
		data[0][1] = "2Sitterspace";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
