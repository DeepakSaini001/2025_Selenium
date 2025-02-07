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

public class TC_01_MyProtien_Login_using_BaseTest extends BaseTest {

	@Test(groups = { "regression" }, priority = 2, description = "Login with Exisitng User in Application")
	public void loginIntoApplication_using_Credintails() {
	

		HomePage homePage = new HomePagePopUp(getDriver()).navigateToURL().verifyCookiesAndPopUp().clickOnAccount()
				.enterEmailId("deepaksn987@gmail.com").enterPassword("Flipkart.com@21").clickOnSignIn()
				.enterTextSearchField("Protien").clickSearchButton();
		ProtienPage proteinPage = homePage.navigatetoProtien();

		assertTextEquals(proteinPage.verifyProtienPageTitle(), "High Protein Powders & Protein Shakes",
				"proteinPage title verification");

		List<String> itemNames = proteinPage.getItemNames();
		log.info("Items Available: " + itemNames); 

		System.out.println("Items Available: " + itemNames);
		assertElementIsDisplayed(proteinPage.verifyCartProducts("Impact Whey Protein"),
				"Product not found in the cart!");
		
		test.pass("Login test passed successfully.");
		log.info("loginIntoApplication_using_Credintails.");

	}

	@Test(groups = { "smoke" }, priority = 1, description = "Create New User in Application")
	public void signUPIntoApplication_using_Registration() {

		String username = "user" + new FakerUtils().generateRandomNumber();

		SignUpPage signUp = new HomePagePopUp(getDriver()).navigateToURL().verifyCookiesAndPopUp().mouseHoverOnAccount()
				.clickOnRegisterButton().enterFullName(username).enterEmail(username + "@gmail.com")
				.enterConfirmEmail(username + "@gmail.com").enterpassword(username).enterConfirmpassword(username);
		HomePage homePage = signUp.clickOnContinueButton();
		log.info("signUPIntoApplication_using_Registration.");

	}

	@Test(groups = { "regression" }, priority = 0, description = "Direct_Search")
	public void Direct_Search() {
		test = report.createTest("Direct_Search");
		HomePagePopUp signUp = new HomePagePopUp(getDriver()).navigateToURL();
		test.pass("Login test passed successfully.");
        log.info("Direct_Search.");

	}

}
