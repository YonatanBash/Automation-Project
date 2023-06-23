package pageObjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishlistPage extends CommonPage {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".product-card_product-card__gB8_b")
	private List<WebElement> itemList;
	
	public boolean isItemOnList(String name) {
		waiting(5000);
		for (WebElement areaEl : itemList) {
			WebElement elTitle = areaEl.findElement(By.cssSelector("h4"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

}
