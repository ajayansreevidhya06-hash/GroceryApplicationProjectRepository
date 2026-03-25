package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

	public class LoginTest extends TestNGBase
	{
		// Login Page -TestCase :  1
		@Test(priority =1 ,description="Verify user is able to login with Valid credentials" , groups= {"smoke"})
		public void verifyUserLoginWithValidCredentials() throws IOException
		{
			String username=ExcelUtility.readStringData(0, 0, "LoginPage");
			String password=ExcelUtility.readStringData(0, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
			Boolean dashboardDisplay=loginPageObject.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplay, "User is unable to login with valid credentials");
			
		}		
		// Login Page -TestCase :  2
		@Test(priority =2 ,description="Verify user is not able to login with Valid Username and Invalid Password")
		public void verifyUserLoginWithInvalidCredentials() throws IOException
		{
				
			String username=ExcelUtility.readStringData(1, 0, "LoginPage");
			String password=ExcelUtility.readStringData(1, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
			String actualLoginPageTitle=loginPageObject.getTextFromLoginPageTitle();
			String expectedLoginPageTitle="7rmart supermarket";
			Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle,"User is to login with invalid credentials");
		}
		
		// Login Page -TestCase :  3
		@Test(priority =3 ,description="Verify user is not able to login with invalid Username and valid Password")
		public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException
		{
			String username=ExcelUtility.readStringData(2, 0, "LoginPage");
			String password=ExcelUtility.readStringData(2, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
			Boolean dashboardDisplay=loginPageObject.isDashboardDisplayed();
			Assert.assertFalse(dashboardDisplay, "User is able to login with invalid credentials");
		}
		
		// Login Page -TestCase :  4
		@Test(priority =4, description="Verify user is not able to login with invalid Username and invalid Password" , groups= {"smoke"})
		public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
		{
			String username=ExcelUtility.readStringData(3, 0, "LoginPage");
			String password=ExcelUtility.readStringData(3, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
			String actualLoginPageTitle=loginPageObject.getTextFromLoginPageTitle();
			String expectedLoginPageTitle="7rmart supermarket";
			Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle,"User is to login with invalid credentials");
		}

	}

