package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	HomePage homePage;
	@Test(description = "verify that user is able to successfully LogOut from the application", retryAnalyzer=retryMechanism.Retry.class)
	public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);
		homePage=loginPageObject.clickOnSignInButton();
		//HomePage homePage = new HomePage(driver);//no need of this statemnet as we have declared home object above for method chaining
		homePage.toClickOnAdminButton();
		loginPageObject=homePage.clickOnLogOutButton();
		
		String actualLoginPageTitle=loginPageObject.getTextFromLoginPageTitle();
		String expectedLoginPageTitle="7rmart supermarket";
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle,Constants.ERRORIFLOGOUTFAILED);

	}

}
