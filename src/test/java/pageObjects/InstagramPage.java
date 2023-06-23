package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class InstagramPage extends CommonPage {

	public InstagramPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "[aria-label='Instagram']")
	private WebElement instagramLabel;


	public boolean isItInstagram() {
		waitForVisibilityOfElement(instagramLabel);
		try {
			return instagramLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}


