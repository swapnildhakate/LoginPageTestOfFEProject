package stepdefinition;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepTest {

	WebDriver driver;
	public LoginPage loginPage = new LoginPage();

	@Given("User is on the home page and navigating to login page")
	public void user_is_on_the_home_page_and_navigating_to_login_page() {
		loginPage.navigateTo();
	}

	@When("User enter a valid username and password")
	public void user_enter_a_valid_username_and_password() {
		loginPage.enterUsername("swapnil");
		loginPage.enterPassword("12345");
	}

	@When("User enter an invalid username and password")
	public void user_enter_an_invalid_username_and_password() {
		loginPage.enterUsername("swpnl");
		loginPage.enterPassword("12356");
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
		loginPage.clickLoginButton();
	}


	@Then("User should see a welcome message with the username")
	public void user_should_see_a_welcome_message_with_the_username() throws InterruptedException {
		Thread.sleep(2000);
		String welcomeMessage = loginPage.getWelcomeMessage();
		assertTrue(welcomeMessage.contains("Welcome"));
		loginPage.logout();
		loginPage.closeBrowser();
	}

	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String expectedMessage) throws InterruptedException {
		Thread.sleep(5000);
		String errorMessage = loginPage.getErrorMessage();
		assertEquals(expectedMessage, errorMessage);
		Thread.sleep(5000);
		loginPage.closeBrowser();
	}
}
