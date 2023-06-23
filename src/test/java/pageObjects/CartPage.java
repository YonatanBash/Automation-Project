package pageObjects;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends CommonPage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class^='cart-page_left']>[class^='cart-page_intro-content']>h1")
	private WebElement cartPageTitle;
	@FindBy(css = "[class^='cart-page_cta-container__yLf6q']>a")
	private WebElement checkoutBtn;
	
	public String getPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cartPageTitle));
		return getText(cartPageTitle);
	}

	public void checkout() {
		waitforElementToBeClickable(checkoutBtn);
		click(checkoutBtn);
	}
	
}
