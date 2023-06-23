package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubePage extends CommonPage {

	public YouTubePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#center>#search")
	private WebElement youtubeSearch;


	public boolean isItYoutube() {
		waitForVisibilityOfElement(youtubeSearch);
		try {
			return youtubeSearch.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
