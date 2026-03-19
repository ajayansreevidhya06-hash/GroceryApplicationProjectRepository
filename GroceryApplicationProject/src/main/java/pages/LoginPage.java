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
		
		
		public void enterUserNameOnUserNameField(String userNameValue)
		{
			usernameWebelement.sendKeys(userNameValue);
		}
						
		
		public void enterPasswordeOnPasswordField(String passWordValue)
		{
			passwordWebelement.sendKeys(passWordValue);
		}
		
		public void clickOnSignInButton()
		{
			signInButtonWebelement.click();
		}
}
