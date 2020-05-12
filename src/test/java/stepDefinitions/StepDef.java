package stepDefinitions;

import java.io.IOException;

//import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.DriverInit;

@RunWith(Cucumber.class)
public class StepDef extends DriverInit {
	WebDriver driver;
	
	@Before
	public void initDriver() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	} 
	
	@Given("^user enters QA tutorial website$")
	public void user_enters_QA_tutorial_website() throws IOException {
		LandingPage LandP = new LandingPage(driver);
		LandP.openSite();
	}
	
	@When("^user enters (.+) and (.+)$")
	public void user_enters_email_and_password(String email, String password) {
		LoginPage LoginP = new LoginPage(driver); 
		LandingPage LandP = new LandingPage(driver);
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.invisibilityOf(LandP.loading()));
		
		LandP.clickLogin();
		LoginP.fillEmail(email);
		LoginP.fillPassword(password);
	}
	
	@Then("^error message \"([^\"]*)\" is displayed$")
	public void error_message_is_displayed(String error_message) {
		LoginPage LoginP = new LoginPage(driver);
		
		LoginP.clickLoginButton();
		Assert.assertEquals(LoginP.AlertText(), error_message);
	}
	
	@Then("^verifies if navigation bar is present$")
	public void verifies_if_navigation_bar_is_present() {
		LandingPage LandP = new LandingPage(driver);
		Assert.assertTrue(LandP.getNavBar().isDisplayed());
	}
	
	@After
	public void quitDriver() {	
		driver.close();
		driver = null;
	}
}
