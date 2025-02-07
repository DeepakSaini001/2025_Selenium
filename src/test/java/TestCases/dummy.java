package TestCases;

import org.testng.annotations.Test;
import org.utils.TestDataProvider;
import org.Base.BaseTest;
import org.Pages.HomePage;
import org.Pages.HomePagePopUp;
import org.Pages.LoginPage;
import org.Pages.ProtienPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dummy extends BaseTest {

	@Test(groups = {
			"regression" }, priority = 0, description = "Login with Exisitng User in Application", dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	public void loginIntoApplication(String username, String password) {

		HomePage homePage = new HomePagePopUp(getDriver()).navigateToURL().verifyCookiesAndPopUp().clickOnAccount()
				.enterEmailId("deepaksn987@gmail.com").enterPassword("Flipkart.com@21").clickOnSignIn();
	}

}
