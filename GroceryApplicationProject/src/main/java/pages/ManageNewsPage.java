package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonForNewsCreation;
	@FindBy(id = "news")
	WebElement newsIntoTextBox;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButtonForEnteredNews;
	// search
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonClick;
	@FindBy(xpath = "//input[@name='un']")
	WebElement newsInSearchBox;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonClickAfterenteringNewsToSearch;
	// Reset
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButtonOnNewsPage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newsCreatedMsg;
	@FindBy(xpath = "//h1[@class='m-0 text-dark' and text()='Manage News']")
	WebElement searchNewsPageTitleToValidate;
	@FindBy(xpath = "//h1[@class='m-0 text-dark' and text()='Manage News']")
	WebElement resetNewsPageTitleToValidate;

	public ManageNewsPage toClickOnNewsButtonToCreateNews() {
		newButtonForNewsCreation.click();
		return this;
	}

	public ManageNewsPage toEnterNews(String news) {
		newsIntoTextBox.sendKeys(news);
		return this;

	}

	public ManageNewsPage toSaveNews() {
		saveButtonForEnteredNews.click();
		return this;

	}

	public ManageNewsPage toSearchNews() {
		searchButtonClick.click();
		return this;
	}

	public ManageNewsPage toEnterNewsToSearch(String news) {
		newsInSearchBox.sendKeys(news);
		return this;
	}

	public ManageNewsPage toClickOnSearchAfterProvidingNewsToSearch() {
		searchButtonClickAfterenteringNewsToSearch.click();
		return this;
	}

	public ManageNewsPage toResetManageNewsScreen() {
		resetButtonOnNewsPage.click();
		return this;
	}

	public boolean isNewsCreatedMsgDisplayed() {
		return newsCreatedMsg.isDisplayed();

	}

	public String searchNewsPageTitleToValidate() {
		return searchNewsPageTitleToValidate.getText();

	}

	public String resetNewsPageTitleToValidate() {
		return resetNewsPageTitleToValidate.getText();

	}

}
