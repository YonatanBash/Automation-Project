package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FacebookPage extends CommonPage {

	public FacebookPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[data-imgperflogname='profileCoverPhoto']")
	private WebElement faceBookLabel;

	public boolean isItFacebookPage() {
		waitForVisibilityOfElement(faceBookLabel);
		try {
			return faceBookLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
