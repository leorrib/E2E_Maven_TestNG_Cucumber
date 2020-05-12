package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.id("user_email");
	private By password = By.id("user_password");
	private By login = By.cssSelector("[type='submit']");
	private By alert = By.cssSelector("div[class*='danger']");
	
	public void fillEmail(String arg) {
		driver.findElement(email).sendKeys(arg);;
	}

	public void fillPassword(String arg) {
		driver.findElement(password).sendKeys(arg);;
	}

	public void clickLoginButton() {
		driver.findElement(login).click();
	}
	
	public String AlertText() {
		return driver.findElement(alert).getText();
	}
}
