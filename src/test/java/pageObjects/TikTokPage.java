package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TikTokPage extends CommonPage {

	public TikTokPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[aria-label='Search accounts and videos']")
	private WebElement tiktokSearch;


	public boolean isItTikTok() {
		waitForVisibilityOfElement(tiktokSearch);
		try {
			return tiktokSearch.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
