package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNGBase {

	@Test(priority =1 ,description = "To create New User")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();

		HomePage homePage = new HomePage(driver);
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
		adminPage.enterUserNameForNewUser(usernameForNewAdmin);
		adminPage.enterPasswordForNewUser(passwordForNewAdmin);
		adminPage.toSelectUserTypeFromDropDown(userRoleType);
		adminPage.toClickOnSaveButton();

	}

	@Test(priority =2 ,description = "To Search users")
	public void verifyWhetherUserIsAbleToSearchUser() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();
		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.toClickOnSearchButton();
		String userNameToSearch = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		adminPage.toInputUserNameForSearch(userNameToSearch);
		adminPage.toClickOnSearchButtonAfterProvidingUserName();

	}

	@Test(priority =3 ,description = "To reset admin users screen")
	public void verifyWhetherUserIsAbleToReset() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();

		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.toClickOnResetButton();

	}

}