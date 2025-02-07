package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePagePopUp extends BasePage {

	public HomePagePopUp(WebDriver driver) {
		super(driver);
	}

	private final By welcomePopUp = By.xpath("//h1[@id='popup-title']");
	private final By stayOnInternation = By.xpath("//button[@class='internationalOverlay_stayButton']");
	private final By cookies = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	private final By popUpMessage = By.xpath("//h2[@id='email-reengagement-title']");
	private final By PopUpMessageButton = By.xpath("//button[@class='emailReengagement_close_button']");

	public HomePagePopUp verifyWelcomeMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(welcomePopUp)).getText();
		return this;
	}

	public HomePage clickOn_No_Thanks_Stay_MYPROTEIN() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(stayOnInternation)).click();
		return new HomePage(driver);

	}

	private boolean clickOnAcceptCookies() {
		try {
			WebElement cookiesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cookies));
			if (cookiesElement.isDisplayed()) {
				cookiesElement.click();
				return true; // Cookies accepted
			}
		} catch (Exception e) {
			System.out.println("Cookies element not found or couldn't be clicked.");
		}
		return false; // Failed to accept cookies

	}

	private boolean handlePopUpAndClick() {
		try {
			WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessage));
			WebElement popupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpMessageButton));

			if (popupElement.isDisplayed()) {
				popupButton.click();
				return true; // Popup handled
			}
		} catch (Exception e) {
			System.out.println("Popup element not found or couldn't be clicked.");
		}
		return false; // Failed to handle popup

	}

	/*
	 * public HomePage verifyCookiesAndPopUp() { // Check cookies and handle them //
	 * boolean cookiesHandled = clickOnAcceptCookies();
	 * 
	 * // If cookies weren't handled, try handling pop-ups if
	 * (!clickOnAcceptCookies()) { //boolean popUpHandled = handlePopUpAndClick();
	 * 
	 * // Optional: Handle case where neither cookies nor pop-up were managed
	 * successfully if (!handlePopUpAndClick()) {
	 * System.out.println("Neither cookies nor pop-up could be handled."); } }
	 * return new HomePage(driver); }
	 */

	public HomePage verifyCookiesAndPopUp() {
		clickOnAcceptCookies();
		handlePopUpAndClick();
		return new HomePage(driver);
	}

	public HomePagePopUp navigateToURL() {
		navigateToURL("/");
		// wait.until(ExpectedConditions.titleContains(null));
		return this;
	}

}
