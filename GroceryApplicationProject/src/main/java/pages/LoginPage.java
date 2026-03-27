package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		@FindBy(xpath="//input[@placeholder='Username']") WebElement usernameWebelement;
		@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordWebelement;
		@FindBy(xpath="//button[text()='Sign In']") WebElement signInButtonWebelement;
		@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboardTile;
		@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginPageTitle;
		
		
		public LoginPage enterUserNameOnUserNameField(String userNameValue)
		{
			usernameWebelement.sendKeys(userNameValue);
			return this;
		}
						
		
		public LoginPage enterPasswordeOnPasswordField(String passWordValue)
		{
			passwordWebelement.sendKeys(passWordValue);
			return this;
		}
		
		public HomePage clickOnSignInButton() //moving driver's control from login page to home page
		{
			signInButtonWebelement.click();
			return new HomePage(driver);
		}
		
		public boolean isDashboardDisplayed()
		{
			return dashboardTile.isDisplayed();
		}
		
		public String getTextFromLoginPageTitle()
		{
			return loginPageTitle.getText();
		}
}
