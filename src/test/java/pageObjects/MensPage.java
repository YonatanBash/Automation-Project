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

public class MensPage extends CommonPage {

	public MensPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class^='product-filters']>h4")
	private WebElement menPageTitle;
	@FindBy(css = "[data-locator-id='plp-filterButton-select']")
	private WebElement filterMainBtn;
	@FindBy(css = "#filters-component")
	private WebElement filterWindow;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SORT_BY-select']>summary")
	private WebElement sortbyFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SORT_BY-select'] .radio_label__pswqz")
	private List<WebElement> sortbyChoice;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SIZE-select']>summary")
	private WebElement sizeFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SIZE-select'] ul>li")
	private List<WebElement> sizeListChoice;
	@FindBy(css = "[data-locator-id='filters-filterCategory-COLOUR-select']>summary")
	private WebElement colorFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-COLOUR-select'] ul>li")
	private List<WebElement> colorListChoice;
	@FindBy(css = "[data-locator-id='filters-closeFilters-select']")
	private WebElement exitFilterWindow;
	@FindBy(css = ".product-card_product-card__gB8_b")
	private List<WebElement> itemList;
	@FindBy(css = ".Styles__SizeButtonBase-sc-1hxn211-3.Styles__SizeButton-sc-1hxn211-4.fKdXAG")
	private List<WebElement> sizeList;
	@FindBy(css = "[data-locator-id='miniBag-bag-select']")
	private WebElement viewBag;
	@FindBy(css = "i.sc-AxirZ.bJCmFu.wishlist-outline > svg")
	private WebElement addToWishlistBtn;
	@FindBy(css = "a[title='Wishlist']")
	private WebElement enterWishlist;
	
	
	public String getPageTitle() {
		waiting(1000);
		waitForVisibilityOfElement(menPageTitle);
		return getText(menPageTitle);
	}

	public void filtering(String sort, String size, String color) {
		waitforElementToBeClickable(filterMainBtn);
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
		waitforElementToBeClickable(colorFilter);
		click(colorFilter);
		for (WebElement colorEl : colorListChoice) {
			if (getText(colorEl).equalsIgnoreCase(color)) {
				click(colorEl);
				break;
			}
		}
		click(colorFilter);
		click(exitFilterWindow);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(exitFilterWindow));
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

	}
	

	public void addProductToCart(String name, String size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(itemList)); 
		for (WebElement areaEl : itemList) {
			WebElement elTitle = areaEl.findElement(By.cssSelector("h4"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				moveToElement(areaEl);
				List<WebElement> sizeList = areaEl.findElements(By.cssSelector("[class^='quick-add_sizes']>button"));
				for (WebElement sizeEl : sizeList) {
					if (getText(sizeEl).equalsIgnoreCase(size)) {
						click(sizeEl);
						break;
					}
				}
				break;
			}

		}
		waitforElementToBeClickable(viewBag);
		click(viewBag);
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
