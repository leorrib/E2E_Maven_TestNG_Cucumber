package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	private By load = By.cssSelector("div[class='preloader']");
	private By login = By.cssSelector("[class='login-btn'] [class='theme-btn']");
	private By navBar = By.cssSelector("[class='header-upper'] [class='nav-outer clearfix']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openSite() {
		driver.get("https://www.rahulshettyacademy.com");
	}

	public WebElement loading() {
		return driver.findElement(load);
	}

	public void clickLogin() {
		driver.findElement(login).click();
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
