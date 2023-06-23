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

public class WomensPage extends CommonPage {

	public WomensPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class^='product-filters']>h4")
	private WebElement womenPageTitle;
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
	@FindBy(css = "[data-locator-id='filters-filterCategory-DISCOUNT-select']>summary")
	private WebElement discountFilter;
	@FindBy(css = ".Styles__Wrapper-sc-9kless-0.hgLeZy")
	private List<WebElement> fitListChoice;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SORT_BY-select']>summary")
	private WebElement sortbyFilter;
	@FindBy(css = "[data-locator-id='filters-filterCategory-SORT_BY-select'] .radio_label__pswqz")
	private List<WebElement> sortbyChoice;
	@FindBy(css = "[data-locator-id='filters-closeFilters-select']")
	private WebElement exitFilterWindow;
	@FindBy(css = ".product-card_product-card__gB8_b")
	private List<WebElement> itemList;
	@FindBy(css = "[data-locator-id='miniBag-bag-select']")
	private WebElement viewBag;
	@FindBy(css = "")
	private List<WebElement> listOfItems;
	@FindBy(css = ".Styles__VariantWrap-n6v9cx-1.foZtnA > img")
	private List<WebElement> itemColorList;
	@FindBy(css = ".Styles__SizeButtonBase-sc-8ocgtc-3.Styles__SizeButton-sc-8ocgtc-6.cTyQLh")
	private List<WebElement> listOfSizesInsideItem;
	@FindBy(css = "#add-to-cart_cta_pdp")
	private WebElement addToBagBtn;
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;

	public String getPageTitle() {
		waiting(1000);
		waitForVisibilityOfElement(womenPageTitle);
		return getText(womenPageTitle);
	}

	// Filter and close the filters
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
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOf(exitFilterWindow));
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

	public void addProductFromInside(String name, String color, String size) {
		waiting(300);
		for (WebElement el : listOfItems) {
			if (el.getAttribute("title").equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}

		for (WebElement colorEl : itemColorList) {
			if (colorEl.getAttribute("alt").equalsIgnoreCase(color)) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", colorEl);
				break;
			}
		}
		waiting(300);
		for (WebElement sizeEl : listOfSizesInsideItem) {
			if (getText(sizeEl).equalsIgnoreCase(size)) {
				click(sizeEl);
				break;
			}
		}
		waiting(300);
		click(addToBagBtn);
		waiting(300);
		click(checkoutBtn);
	}
}
