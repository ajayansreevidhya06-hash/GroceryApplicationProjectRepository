package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends TestNGBase {

	@Test(priority =1 ,description = "To create News")
	public void verifyWhetherUserIsAbleToAddNews() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();

		HomePage homePage = new HomePage(driver);
		homePage.toClickOnManageNewsMoreInfo();

		FakerUtility fakerUtility = new FakerUtility();
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.toClickOnNewsButtonToCreateNews();
		String news = fakerUtility.createRandomAddress();
		manageNewsPage.toEnterNews(news);
		manageNewsPage.toSaveNews();
		// manageNewsPage.toEnterNews(news);

	}

	@Test(priority =2 ,description = "To Search News")
	public void verifyWhetherUserIsAbleToSearchNews() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();

		HomePage homePage = new HomePage(driver);
		homePage.toClickOnManageNewsMoreInfo();

		FakerUtility fakerUtility = new FakerUtility();
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.toSearchNews();

		String news = fakerUtility.createRandomAddress();
		manageNewsPage.toEnterNewsToSearch(news);
		manageNewsPage.toClickOnSearchAfterProvidingNewsToSearch();

	}

	@Test(priority =3 ,description = "To Reset News Screen")
	public void verifyWhetherUserIsAbleToResetAfterNewsSearch() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.enterUserNameOnUserNameField(username);
		loginPageObject.enterPasswordeOnPasswordField(password);
		loginPageObject.clickOnSignInButton();

		HomePage homePage = new HomePage(driver);
		homePage.toClickOnManageNewsMoreInfo();
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.toResetManageNewsScreen();

	}
}
