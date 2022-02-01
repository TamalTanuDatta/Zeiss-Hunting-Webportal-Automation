package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataPrivacyPage;
import pageObjects.InitialPage;
import pageObjects.SignInPage;
import resources.Base;

public class StepDefinationLoginWebPortal extends Base {

	@Given("^Initialize browser with Chrome$")
	public void initialize_browser_with_chrome() throws Throwable {

		driver = initializeDriver();

	}

	@And("^Navigate to \"([^\"]*)\" Website$")
	public void navigate_to_something_website(String url) throws Throwable {

		driver.get(url);
	}

	@And("^Click on SignIn link in Homepage to land on secure sign in Page$")
	public void click_on_signin_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {

		DataPrivacyPage dataPrivacyPage = new DataPrivacyPage(driver);
		dataPrivacyPage.acceptDataPrivacy().click();
		InitialPage initialPage = new InitialPage(driver);
		initialPage.signIn().click();

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_something_and_something_and_logs_in(String username, String password) throws Throwable {

		SignInPage signInPage = new SignInPage(driver);
		signInPage.getUserName().sendKeys(username);
		signInPage.getPassword().sendKeys(password);
		signInPage.signIn().click();
		Thread.sleep(10000);

	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://hunting.zeiss.com/dashboard");
		driver.close();

	}

}
