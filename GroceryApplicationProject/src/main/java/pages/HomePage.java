package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement adminOption;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logOutButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewsMoreInfo;

	public void toClickOnAdminButton() {
		adminOption.click();
	}

	public void clickOnLogOutButton() {
		logOutButton.click();
	}

	public void clickOnAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
	}

	public void toClickOnManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
	}
}
