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

	public void toClickOnNewsButtonToCreateNews() {
		newButtonForNewsCreation.click();
	}

	public void toEnterNews(String news) {
		newsIntoTextBox.sendKeys(news);

	}

	public void toSaveNews() {
		saveButtonForEnteredNews.click();

	}

	public void toSearchNews() {
		searchButtonClick.click();
	}

	public void toEnterNewsToSearch(String news) {
		newsInSearchBox.sendKeys(news);
	}

	public void toClickOnSearchAfterProvidingNewsToSearch() {
		searchButtonClickAfterenteringNewsToSearch.click();
	}

	public void toResetManageNewsScreen() {
		resetButtonOnNewsPage.click();
	}
}
