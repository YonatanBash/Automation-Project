package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TwitterPage extends CommonPage {

	public TwitterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[aria-label='Twitter']")
	private WebElement twitterLabel;
	@FindBy(css = "[aria-label='Close']")
	private WebElement closePopupBtn;

	public boolean isItTwitter() {
		waitForVisibilityOfElement(twitterLabel);
		try {
			return twitterLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
	}
}
