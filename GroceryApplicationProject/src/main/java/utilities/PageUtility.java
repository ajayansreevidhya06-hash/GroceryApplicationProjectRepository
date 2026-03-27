package utilities;

import org.openqa.selenium.WebElement;
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
		
}
