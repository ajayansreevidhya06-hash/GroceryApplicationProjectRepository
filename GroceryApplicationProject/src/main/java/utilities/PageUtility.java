package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropDownByVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}

	public void selectDropDownByIndexValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByIndex(0);
	}

	public void toGetFirstSelectedOption(WebElement element, String value) {
		Select object = new Select(element);
		object.getFirstSelectedOption();
	}

	public void toDeselectByText(WebElement element, String value) {
		Select object = new Select(element);
		object.deselectByVisibleText(value);
	}

	public void toMoveToAnElement(WebElement element, WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void toDoubleClickOnElement(WebElement element, WebDriver driver) {

		Actions action = new Actions(driver);
		action.doubleClick().build().perform();

	}

	public void toSelectAll(WebDriver driver) {

		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

	}
}
