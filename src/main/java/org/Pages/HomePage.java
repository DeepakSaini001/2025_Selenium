package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	// constructor is used here to inilitized the instance variable which is Webdriver driver coming from the BASEPAGE.
	// here super keyword is used to call the parent class constructor
	}
	private final By welcomePopUp = By.xpath("//h1[@id='popup-title']");
	private final By accountLoginButton = By.xpath("//span[contains(text(),'Account')]");
	private final By RegisterButton = By.xpath("//a[@class='responsiveAccountHeader_accountRegister']");
	private final By searchField = By.xpath("//input[@id='header-search-input']");
	private final By SearchButton = By.xpath("//button[@class='headerSearch_button']");
	private final By Protien = By.xpath(
			"//a[@class='responsiveFlyoutMenu_levelOneLink responsiveFlyoutMenu_levelOneLink-hasChildren'][contains(text(),'Protein')]");

	public HomePage navigateToURL() {
		 log.info("Navigating to URL");
		navigateToURL("/");
		return this;
	}

	public HomePage verifyWelcomeMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(welcomePopUp)).getText();
		return this;
	}

	public LoginPage clickOnAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountLoginButton)).click();
		return new LoginPage(driver);
	}

	public HomePage mouseHoverOnAccount() {
		Actions action = new Actions(driver);
		WebElement HoverAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(accountLoginButton));

		action.moveToElement(HoverAccountButton).build().perform();

		return this;
	}

	public SignUpPage clickOnRegisterButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterButton)).click();
		return new SignUpPage(driver);
	}

	public HomePage enterTextSearchField(String searchIteam) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchIteam);
		return this;
	}

	public HomePage clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
		return this;
	}
	public ProtienPage navigatetoProtien() {
		wait.until(ExpectedConditions.elementToBeClickable(Protien)).click();
		return new ProtienPage(driver);
	}
}
