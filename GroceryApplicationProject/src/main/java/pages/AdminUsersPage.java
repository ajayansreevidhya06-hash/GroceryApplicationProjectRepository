package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(1)']")
	WebElement newUserButton;
	@FindBy(id = "username")
	WebElement toEnterUserNameOnAdminUserPageForNewUser;
	@FindBy(id = "password")
	WebElement toEnterPasswordOnAdminUserPageForNewUser;
	// @FindBy(xpath="//option[@value='partner']") WebElement userTypeDropDown;
	@FindBy(name = "user_type")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement usernameInSearchUsersBox;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonClickAfterProvindingUserName;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement usercreatedSuccessfully;

	public void toClickOnNewUserCreateButton() {
		newUserButton.click();
	}

	public void enterUserNameForNewUser(String usrname) {
		toEnterUserNameOnAdminUserPageForNewUser.sendKeys(usrname);
	}

	public void enterPasswordForNewUser(String pswd) {
		toEnterPasswordOnAdminUserPageForNewUser.sendKeys(pswd);
	}

	public void toSelectUserTypeFromDropDown(String userType) {
		Select select = new Select(userTypeDropDown);
		select.selectByVisibleText(userType);
	}

	public void toClickOnSaveButton() {
		saveButton.click();
	}

	public void toClickOnSearchButton() {
		searchButton.click();
	}

	public void toInputUserNameForSearch(String userNametoSearch) {
		usernameInSearchUsersBox.sendKeys(userNametoSearch);
	}

	public void toClickOnSearchButtonAfterProvidingUserName() {
		searchButtonClickAfterProvindingUserName.click();
	}

	public void toClickOnResetButton() {
		resetButton.click();
	}
	
	public boolean isUserCreatedSuccessfully() {
		return usercreatedSuccessfully.isDisplayed();
	}
}
