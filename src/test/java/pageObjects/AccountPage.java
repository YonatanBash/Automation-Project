package pageObjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends CommonPage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class^='page-title']>h1")
	private WebElement pageTitle;
	@FindBy(css = ".btn.classic-link.js-auth-logout")
	private WebElement logoutLabel;
	@FindBy(css = "[class^='header_mobile']>[aria-label='search']")
	private WebElement searchBtn;
	@FindBy(css = "[data-locator-id='search-search-enter']")
	private WebElement searchField;
	@FindBy(css = "[data-locator-id='miniBag-bag-select']")
	private WebElement viewBag;
	@FindBy(css = "[data-locator-id='pdp-addToBag-submit']")
	private WebElement addtobagBtn;
	@FindBy(css = ".product-card_product-card__gB8_b")
	private List<WebElement> productList;
	@FindBy(css = ".size_size__zRXlq")
	private List<WebElement> sizeList;

	public String getPageTitle() {
		waitForVisibilityOfElement(pageTitle);
		return getText(pageTitle);
	}

	public void searchAnything(String text, String itemName) {
		waitforElementToBeClickable(searchBtn);
		click(searchBtn);
		fillText(searchField, text);
		waiting(1000);
		for (WebElement el : productList) {
			WebElement elTitle = el.findElement(By.cssSelector("h4"));
			if (getText(elTitle).equalsIgnoreCase(itemName)) {
				click(el);
				break;
			}
		}
	}

	public void logout() {
		click(logoutLabel);
		waiting(1000);
	}
}
