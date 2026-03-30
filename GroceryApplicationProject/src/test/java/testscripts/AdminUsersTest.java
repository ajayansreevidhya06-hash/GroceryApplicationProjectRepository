package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNGBase {
	HomePage homePage;

	@Test(priority = 1, description = "To verify user can create a New User")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);

		homePage = loginPageObject.clickOnSignInButton();

		homePage.clickOnAdminUsersMoreInfo();

		FakerUtility fakerUtility = new FakerUtility();
		// String usernameForNewAdmin=ExcelUtility.readStringData(0, 0,
		// "AdminUsersPage");
		// String passwordForNewAdmin=ExcelUtility.readStringData(0, 1,
		// "AdminUsersPage");
		String usernameForNewAdmin = fakerUtility.createRandomUserName();
		String passwordForNewAdmin = fakerUtility.createRandomPassword();
		String userRoleType = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.toClickOnNewUserCreateButton();
		//adminPage.enterUserNameForNewUser(usernameForNewAdmin);
		//adminPage.enterPasswordForNewUser(passwordForNewAdmin);
		//adminPage.toSelectUserTypeFromDropDown(userRoleType);
		//adminPage.toClickOnSaveButton();
		adminPage.enterUserNameForNewUser(usernameForNewAdmin).enterPasswordForNewUser(passwordForNewAdmin).toSelectUserTypeFromDropDown(userRoleType).toClickOnSaveButton();
		// Assertion added
		Boolean newUserCreatedmsgDisplayed = adminPage.isUserCreatedSuccessfully();
		Assert.assertTrue(newUserCreatedmsgDisplayed, Constants.ERRORIFNONEWUSERCREATED);

	}

	@Test(priority = 2, description = "To verify user can Search for specific user")
	public void verifyWhetherUserIsAbleToSearchUser() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);

		homePage = loginPageObject.clickOnSignInButton();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();
		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.toClickOnSearchButton();
		String userNameToSearch = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		adminPage.toInputUserNameForSearch(userNameToSearch).toClickOnSearchButtonAfterProvidingUserName();
		Boolean titleWhenClickOnSearchAdminUsersDisplayed = adminPage.isTitleDisplayedWhenClickOnSearchAdminUsers();
		Assert.assertTrue(titleWhenClickOnSearchAdminUsersDisplayed, Constants.ERRORWHILESEARCHINGUSERS);

	}

	@Test(priority = 3, description = "To verify user can reset admin users screen")
	public void verifyWhetherUserIsAbleToReset() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username).enterPasswordeOnPasswordField(password);

		homePage = loginPageObject.clickOnSignInButton();

		homePage.clickOnAdminUsersMoreInfo();

		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.toClickOnResetButton();
		String expectedUrl="https://groceryapp.uniqassosiates.com/admin/list-admin";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,Constants.ERRORINRESETADMINPAGE);

	}

}