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

public class TC_02_MyProtien_validation_BaseTest extends BaseTest {

	@Test(groups = { "regression" }, priority = 2, description = "TC_02_Login with Exisitng User in Application")
	public void TC_02_loginIntoApplication_using_Credintails() {

		HomePagePopUp homePage = new HomePagePopUp(getDriver()).navigateToURL();

		log.info("loginIntoApplication_using_Credintails ");

	}

	@Test(groups = { "smoke" }, priority = 1, description = "TC_02_Create New User in Application")
	public void TC_02_signUPIntoApplication_using_Registration() {

		HomePagePopUp signUp = new HomePagePopUp(getDriver()).navigateToURL();

		log.info("signUPIntoApplication_using_Registration.");

	}

	@Test(groups = { "regression" }, priority = 0, description = "TC_02_Direct_Search")
	public void TC_02_Direct_Search() {
		HomePagePopUp signUp = new HomePagePopUp(getDriver()).navigateToURL();
	
		log.info("Direct_Search. ");

	}

}
