package TestCases;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.Base.BaseTest;
import org.Pages.HomePage;
import org.Pages.HomePagePopUp;
import org.Pages.ProtienPage;
import org.Pages.SignUpPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utils.CustomAssert;
import org.utils.FakerUtils;
//import static org.utils.CustomAssert.assertTextEquals;
//import static org.utils.CustomAssert.assertElementIsDisplayed;
import static org.utils.CustomAssert.*;
import com.aventstack.extentreports.Status;

public class MyProtien_Login_using_BaseTest extends BaseTest {

	@Test(groups = { "regression" }, priority = 2, description = "Login with Exisitng User in Application")
	public void loginIntoApplication_using_Credintails() {
		// test = extent.createTest("Login Test", "Verify login functionality using
		// valid credentials");

		HomePage homePage = new HomePagePopUp(getDriver()).navigateToURL().verifyCookiesAndPopUp().clickOnAccount()
				.enterEmailId("deepaksn987@gmail.com").enterPassword("Flipkart.com@21").clickOnSignIn()
				.enterTextSearchField("Protien").clickSearchButton();
		ProtienPage proteinPage = homePage.navigatetoProtien();

		/*
		 * CustomAssert.assertTextEquals(proteinPage.verifyProtienPageTitle(),
		 * "High Protein Powders & Protein Shakes", "proteinPage title verification");
		 */
		assertTextEquals(proteinPage.verifyProtienPageTitle(), "High Protein Powders & Protein Shakes",
				"proteinPage title verification");

		// Assert.assertEquals(proteinPage.verifyProtienPageTitle(), "High Protein
		// Powders & Protein Shakes");
		List<String> itemNames = proteinPage.getItemNames();
		assertElementIsDisplayed(proteinPage.verifyCartProducts("Impact Whey Protein"),
				"Product not found in the cart!");
		
		//Assert.assertTrue(proteinPage.verifyCartProducts("Impact Whey Protein"), "Product not found in the cart!");

	}

	@Test(groups = { "smoke" }, priority = 1, description = "Create New User in Application")
	public void signUPIntoApplication_using_Registration() {
		// test = extent.createTest("SignUp Test", "Verify signUp functionality using
		// newly created credentials");

		String username = "user" + new FakerUtils().generateRandomNumber();

		SignUpPage signUp = new HomePagePopUp(getDriver()).navigateToURL().verifyCookiesAndPopUp().mouseHoverOnAccount()
				.clickOnRegisterButton().enterFullName(username).enterEmail(username + "@gmail.com")
				.enterConfirmEmail(username + "@gmail.com").enterpassword(username).enterConfirmpassword(username);
		HomePage homePage = signUp.clickOnContinueButton();

	}

	@Test(groups = { "regression" }, priority = 0, description = "Direct_Search")
	public void Direct_Search() {
		// test = extent.createTest("Direct Search Test", "Direct_Search extent report
		// description");

		/*
		 * HomePage signUp = new HomePagePopUp(getDriver()).navigateToURL()
		 * .verifyCookiesAndPopUp()
		 * .enterTextSearchField("Protien").clickSearchButton();
		 */

		HomePagePopUp signUp = new HomePagePopUp(getDriver()).navigateToURL();
				

	}

}
