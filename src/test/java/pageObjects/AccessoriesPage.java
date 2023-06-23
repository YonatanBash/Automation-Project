package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessoriesPage extends CommonPage {

	public AccessoriesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class^='product-filters_information']>h4")
	private WebElement pageTitle;
	@FindBy(css = "[data-locator-id='plp-filterButton-select']")
	private WebElement filterMainBtn;
	@FindBy(css = "#filters-component")
	private WebElement filterWindow;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SIZE-select']>summary")
	private WebElement sizeFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SIZE-select'] ul>li")
	private List<WebElement> sizeListChoice;
	@FindBy(css = "[data-locator-id='filters-filterCategory-COLOUR-select']>summary")
	private WebElement colorFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-COLOUR-select'] ul>li")
	private List<WebElement> colorListChoice;
	@FindBy(css = "[data-locator-id='filters-filterCategory-DISCOUNT-select']")
	private WebElement discountFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-DISCOUNT-select'] ul>li")
	private List<WebElement> discountListChoice;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SORT_BY-select']>summary")
	private WebElement sortbyFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SORT_BY-select'] .radio_label__pswqz")
	private List<WebElement> sortbyChoice;
	@FindBy(css = "[data-locator-id='filters-closeFilters-select']")
	private WebElement exitFilterWindow;
	@FindBy(css = ".product-card_product-card__gB8_b")
	private List<WebElement> itemList;
	@FindBy(css = "[data-locator-id='pdp-addToBag-submit']")
	private WebElement addtobagBtn;
	@FindBy(css = "[data-locator-id='miniBag-bag-select']")
	private WebElement viewbagBtn;
	@FindBy(css = "a[title='Wishlist']")
	private WebElement enterWishlist;

		public String getPageTitle() {
			waiting(1000);
			waitForVisibilityOfElement(pageTitle);
			return getText(pageTitle);
		}

	public String getPageUrl() {
		waiting(1000);
		return driver.getCurrentUrl();
	}

	// Filter and close the filters
	public void filtering(String sort, String size) {
		waiting(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", filterMainBtn);
		click(sortbyFilter);
		for (WebElement sortEl : sortbyChoice) {
			if (getText(sortEl).equalsIgnoreCase(sort)) {
				click(sortEl);
				break;
			}
		}
		click(sortbyFilter);
		waitforElementToBeClickable(sizeFilter);
		click(sizeFilter);
		for (WebElement sizeEl : sizeListChoice) {
			if (getText(sizeEl).equalsIgnoreCase(size)) {
				click(sizeEl);
				break;
			}
		}
		click(sizeFilter);
		click(exitFilterWindow);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(exitFilterWindow));
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

	}

	public void addProduct(String name) {
		for (WebElement areaEl : itemList) {
			WebElement elTitle = areaEl.findElement(By.cssSelector("h4"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				click(areaEl);
				break;
			}
		}
	}
	
	public void insertItemToWishlist(String name) {
		waiting(1000);
		for (WebElement areaEl : itemList) {
			WebElement elTitle = areaEl.findElement(By.cssSelector("h4"));
			WebElement wishlistBtn = areaEl.findElement(By.cssSelector("button[class^='wishlist-button_wishlist-button']"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(wishlistBtn).build().perform();
				actions.sendKeys(Keys.ESCAPE).perform();
				click(wishlistBtn);
				break;
			}
		}
		waitforElementToBeClickable(enterWishlist);
		click(enterWishlist);
	}
}
