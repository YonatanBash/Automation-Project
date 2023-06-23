package pageObjects;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends CommonPage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageUrl() {
		waiting(500);
		return driver.getCurrentUrl();
	}

	
}
