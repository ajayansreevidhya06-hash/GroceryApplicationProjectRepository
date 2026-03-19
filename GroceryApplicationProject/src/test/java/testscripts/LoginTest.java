package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

	public class LoginTest extends TestNGBase
	{
		// Login Page -TestCase :  1
		@Test(priority =1 ,description="Validating User Login with Valid credentials")
		public void verifyUserLoginWithValidCredentials() throws IOException
		{
			String username=ExcelUtility.readStringData(0, 0, "LoginPage");
			String password=ExcelUtility.readStringData(0, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
		}
		
		// Login Page -TestCase :  2
		@Test(priority =2)
		public void verifyUserLoginWithInvalidCredentials() throws IOException
		{
				
			String username=ExcelUtility.readStringData(1, 0, "LoginPage");
			String password=ExcelUtility.readStringData(1, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
		}
		
		// Login Page -TestCase :  3
		@Test(priority =3)
		public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException
		{
			String username=ExcelUtility.readStringData(2, 0, "LoginPage");
			String password=ExcelUtility.readStringData(2, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
		}
		
		// Login Page -TestCase :  4
		@Test(priority =4)
		public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
		{
			String username=ExcelUtility.readStringData(3, 0, "LoginPage");
			String password=ExcelUtility.readStringData(3, 1, "LoginPage");
			LoginPage loginPageObject=new LoginPage(driver);
			loginPageObject.enterUserNameOnUserNameField(username);
			loginPageObject.enterPasswordeOnPasswordField(password);
			loginPageObject.clickOnSignInButton();
		}

	}

