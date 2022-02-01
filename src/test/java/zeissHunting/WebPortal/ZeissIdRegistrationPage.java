package zeissHunting.WebPortal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DataPrivacyPage;
import pageObjects.InitialPage;
import pageObjects.LandingPageAccount;
import pageObjects.AccountCreateFirstPage;
import pageObjects.SignUpAskingPage;
import pageObjects.SignUpEmailPage;
import resources.Base;

public class ZeissIdRegistrationPage extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void zeissIdPageNavigation(String email, String password, String reenterPass, String firstName, String lastName)
			throws IOException, InterruptedException {

		driver.get(prop.getProperty("baseurl"));

		DataPrivacyPage dataPrivacyPage = new DataPrivacyPage(driver);
		dataPrivacyPage.acceptDataPrivacy().click();
		InitialPage initialPage = new InitialPage(driver);
		initialPage.getStarted().click();
		driver.get(prop.getProperty("signupurl"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		if (driver != null) {

			driver.get(prop.getProperty("signupurl"));

		} else {
			SignUpAskingPage signUpAskingPage = new SignUpAskingPage(driver);
			signUpAskingPage.initialSignup().click();
		}
		SignUpEmailPage signUpEmailPage = new SignUpEmailPage(driver);
		signUpEmailPage.signUpEmail().click();

		LandingPageAccount landingPageAccount = new LandingPageAccount(driver);
		AccountCreateFirstPage accountCreateFirstPage = landingPageAccount.getAccount();
		accountCreateFirstPage.getEmail().sendKeys(email);
		accountCreateFirstPage.getPass().sendKeys(password);
		accountCreateFirstPage.reenterPass().sendKeys(reenterPass);
		accountCreateFirstPage.firstName().sendKeys(firstName);
		accountCreateFirstPage.lastName().sendKeys(lastName);
		accountCreateFirstPage.userAggrementCheckBox().click();
		Assert.assertTrue(driver.findElement(By.id("tcaccepted_True")).isSelected());
		landingPageAccount.createAccount().click();
		Thread.sleep(10000);
		
		log.info("Created Zeiss ID for User");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][5];
		data[0][0] = "randomuser02@google.com";
		data[0][1] = "3inDoubleHelix!";
		data[0][2] = "3inDoubleHelix!";
		data[0][3] = "Random2";
		data[0][4] = "User02";

		/*data[1][0] = "randomuser02@google.com";
		data[1][1] = "3inDoubleHelix!";
		data[1][2] = "3inDoubleHelix!";
		data[1][3] = "Random2";
		data[1][4] = "User02";
		
		data[2][0] = "randomuser03@google.com";
		data[2][1] = "4inDoubleHelix!";
		data[2][2] = "4inDoubleHelix!";
		data[2][3] = "Random3";
		data[2][4] = "User03";
		
		data[3][0] = "randomuser04@google.com";
		data[3][1] = "5inDoubleHelix!";
		data[3][2] = "5inDoubleHelix!";
		data[3][3] = "Random4";
		data[3][4] = "User04";
		
		data[4][0] = "randomuser02@google.com";
		data[4][1] = "6inDoubleHelix!";
		data[4][2] = "6inDoubleHelix!";
		data[4][3] = "Random5";
		data[4][4] = "User05";*/

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
