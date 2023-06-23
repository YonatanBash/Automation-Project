package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PinterestPage extends CommonPage{

	public PinterestPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css = "#searchBoxContainer")
	private WebElement pinterestSearch;


	public boolean isItPinterest() {
		waitForVisibilityOfElement(pinterestSearch);
		try {
			return pinterestSearch.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
