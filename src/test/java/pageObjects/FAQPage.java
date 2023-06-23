package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FAQPage extends CommonPage {

	public FAQPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class^='sc-128zwpz-1']>h2")
	private WebElement faqPageTitle;
	@FindBy(css = "[placeholder='Search']")
	private WebElement searchField;
	@FindBy(css = "[title='Submit search query']")
	private WebElement submitBtn;

	public String getPageTitle() {
		waiting(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(faqPageTitle));
		return getText(faqPageTitle);
	}
	
	public void search(String text) {
		fillText(searchField, text);
		click(submitBtn);
	}
}
