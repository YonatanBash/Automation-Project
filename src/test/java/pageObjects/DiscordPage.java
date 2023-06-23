package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscordPage extends CommonPage {

	public DiscordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "[placeholder='What should everyone call you?']")
	private WebElement discordLabel;


	public boolean isItDiscord() {
		waitForVisibilityOfElement(discordLabel);
		try {
			return discordLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
