package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage extends CommonPage {

	public CareersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = ".sc-psCJM.dkDWuO > h1")
	private WebElement careersPageTitle;
	
	public String getPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-psCJM.dkDWuO > h1")));
		return getText(careersPageTitle);
	}
}
