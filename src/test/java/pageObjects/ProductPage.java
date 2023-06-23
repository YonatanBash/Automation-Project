package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;


public class ProductPage extends CommonPage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".size_size__zRXlq")
	private List<WebElement> sizeList;
	@FindBy(css = "[data-locator-id='pdp-addToBag-submit']")
	private WebElement addtobagBtn;
	@FindBy(css = "[data-locator-id='miniBag-bag-select']")
	private WebElement viewbagBtn;
	
	
	
	public void chooseSize(String size) {
		waiting(2000);
		for (WebElement sizeEl : sizeList) {
			if (getText(sizeEl).equalsIgnoreCase(size)) {
				click(sizeEl);
				break;
			}
		}
		click(addtobagBtn);
		waitforElementToBeClickable(viewbagBtn);
		click(viewbagBtn);
		
	}

}