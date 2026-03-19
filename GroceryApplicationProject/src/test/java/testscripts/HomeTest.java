package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	@Test(priority =1 ,description = "verify User is able to successfully LogOut")
	public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();
		HomePage homePage = new HomePage(driver);
		homePage.toClickOnAdminButton();
		// homePage.clickOnLogOutButton();

	}

}
