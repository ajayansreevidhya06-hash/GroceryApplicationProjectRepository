package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	PageUtility pageUtility=new PageUtility();

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

	public AdminUsersPage toClickOnNewUserCreateButton() {
		newUserButton.click();
		return this;
	}

	public AdminUsersPage enterUserNameForNewUser(String usrname) {
		toEnterUserNameOnAdminUserPageForNewUser.sendKeys(usrname);
		return this;
	}

	public AdminUsersPage enterPasswordForNewUser(String pswd) {
		toEnterPasswordOnAdminUserPageForNewUser.sendKeys(pswd);
		return this;
	}

	public AdminUsersPage toSelectUserTypeFromDropDown(String userType) {
		//Select select = new Select(userTypeDropDown);
		//select.selectByVisibleText(userType);
		pageUtility.selectDropDownByVisibleText(userTypeDropDown, userType);
		return this;
	}

	public AdminUsersPage toClickOnSaveButton() {
		
		waitUtility.waitUntilElementToBeClickable(driver, saveButton);
		saveButton.click();
		return this;
	}

	public AdminUsersPage toClickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public AdminUsersPage toInputUserNameForSearch(String userNametoSearch) {
		usernameInSearchUsersBox.sendKeys(userNametoSearch);
		return this;
	}

	public AdminUsersPage toClickOnSearchButtonAfterProvidingUserName() {
		waitUtility.waitUntilElementToBeClickable(driver, searchButtonClickAfterProvindingUserName);
		searchButtonClickAfterProvindingUserName.click();
		return this;
	}

	public AdminUsersPage toClickOnResetButton() {
		resetButton.click();
		return this;
	}
	
	public boolean isUserCreatedSuccessfully() {
		return usercreatedSuccessfully.isDisplayed();
	}
}
