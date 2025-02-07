package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage{

	public SignUpPage(WebDriver driver) {
		super(driver);
			}

	private final By AboutYouTitile=By.xpath("//h1[@id='registration-title']");
	
	private final By FullName=By.xpath("//input[@name='Full Name:']");
	private final By Email=By.xpath("//input[@name='Email address']");
	private final By ConfirmEmail=By.xpath("//input[@name='Confirm Email address']");
	private final By Password=By.xpath("//input[@name='Password']");
	private final By Confirmpassword=By.xpath("//input[@name='Confirm Password']");
	private final By NoThanks=By.xpath("//span[contains(text(),'No Thanks')]");
	private final By Continue=By.xpath("//button[@type='submit']");
	
	
	public SignUpPage VerfiyAboutYouTitile() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(AboutYouTitile)).getText();
		return this;
	}
	public SignUpPage enterFullName(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FullName)).sendKeys(name);
		return this;
	}
	public SignUpPage enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(email);
		return this;
	}
	public SignUpPage enterConfirmEmail(String confirmEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmEmail)).sendKeys(confirmEmail);
		return this;
	}
	public SignUpPage enterpassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys(password);
		return this;
	}
	public SignUpPage enterConfirmpassword(String confirmPassowrd) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Confirmpassword)).sendKeys(confirmPassowrd);
		return this;
	}
	public SignUpPage clickOnRadioButton_NoThanks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoThanks)).click();
		return this;
	}
	public HomePage clickOnContinueButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Continue)).click();
		return new HomePage(driver);
	}
}
