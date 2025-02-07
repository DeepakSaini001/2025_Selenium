package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final By CustomerloginTitle = By.xpath("//h1[contains(text(),'Customer login')]");
	private final By EmailId = By.xpath("//input[@label='Email address']");
	private final By Password = By.xpath("//input[@label='Password']");
	private final By SignIn = By.xpath("//button[@type='submit']");
	private final By SignUp = By.xpath("//a[@data-testid='guest-journey-button']");

	public LoginPage verifyCustomerLoginTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerloginTitle)).getText();
	//	softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerloginTitle)).getText(),"Customer login");
		return this;

	}

	public LoginPage enterEmailId(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailId)).sendKeys(email);
		return this;

	}

	public LoginPage enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys(password);
		return this;

	}

	public HomePage clickOnSignIn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignIn)).click();
		return new HomePage(driver);

	}
	public SignUpPage clickOnSignUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignUp)).click();
		return new SignUpPage(driver);

	}

}
