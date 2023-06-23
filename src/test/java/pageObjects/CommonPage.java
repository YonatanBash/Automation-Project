package pageObjects;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class CommonPage extends BasePage {

	
	@FindBy(css = "div > i > svg")
	private WebElement wishlistBtn;
	@FindBy(css = ".Styles__CartButton-sc-744ty0-11.jFYQie")
	private WebElement BagBtn;
	@FindBy(css = "#view-bag")
	private WebElement myBagBtn;
	@FindBy(css = ".Styles__AccountIcon-sc-744ty0-5.kRqbv")
	private WebElement profileBtn;
	@FindBy(css = ".Styles__Logo-sc-744ty0-10.hoitdW")
	private WebElement gymsharkBtn;
	@FindBy(css = "#pages > ul > li:nth-child(3) > a")
	private WebElement careersPageBtn;
	@FindBy(css = "[data-variant='accordion'] #panel-help:nth-child(3)>a[href='https://support.gymshark.com/en-US']")
	private WebElement faqLabel;
	@FindBy(css = "[placeholder='Search']")
	private WebElement faqSearchField;
	@FindBy(css = "[title='Submit search query']")
	private WebElement faqSearchBtn;
	@FindBy(css = "[data-locator-id='header-miniBag-select']")
	private WebElement numOfItemsInCart;
	@FindBy(css = "[aria-label='discord']")
	private WebElement discordLink;
	@FindBy(css = "[aria-label='facebook']")
	private WebElement facebookLink;
	@FindBy(css = "[aria-label='pinterest']")
	private WebElement pinterestLink;
	@FindBy(css = "[aria-label='youtube']")
	private WebElement youtubeLink;
	@FindBy(css = "[title='instagram']")
	private WebElement instagramLink;
	@FindBy(css = "[aria-label='twitter']")
	private WebElement twitterLink;
	@FindBy(css = "[aria-label='tiktok']")
	private WebElement tiktokLink;
	@FindBy(css = ".sc-AxirZ.bJCmFu.wishlist-outline")
	private WebElement addTowishlistBtn;

	// static = A common variable to all of the objects (for example: productpage,
	// facebookpage, menspage)
	static String mainWindow;

	// To Choose whether "Womens", "Mens", "Accessories"
	@FindBy(css = ".Styles__MenuItem-sc-1sr3wid-2.BYLPY.menu-item")
	private List<WebElement> genderList;

	// Women Elements
	@FindBy(css = "#women")
	private WebElement womenLabel;
	@FindBy(css = "[title='Vital Seamless ']")
	private WebElement womenRandomItem;
	@FindBy(css = "#panel-women .subcategory_sub-category-link__jrUsf")
	private List<WebElement> womenItemList;

	// Mens Elements
	@FindBy(css = "[title='Men']>#men")
	private WebElement menLabel;
	@FindBy(css = "[title='Power']")
	private WebElement menRandomItem;
	@FindBy(css = "#panel-men .subcategory_sub-category-link__jrUsf")
	private List<WebElement> menItemList;

	// Accessories Elements
	@FindBy(css = "[title='Accessories']>#accessories")
	private WebElement accessoriesLabel;
	@FindBy(css = "#panel-accessories [title='All Socks']")
	private WebElement accessoryRandomItem;
	@FindBy(css = "#panel-accessories .subcategory_sub-category-link__jrUsf")
	private List<WebElement> accessoryItemList;
	

	public CommonPage(WebDriver driver) {
		super(driver);
	}


	public void enterCareersPage() {
		click(careersPageBtn);
	}

	public void enterFAQ() {
		waitforElementToBeClickable(accessoriesLabel);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 650)");
		js.executeScript("arguments[0].click();", faqLabel);
	}

	public void enterWishlist() {
		click(wishlistBtn);
	}

	public void enterProfile() {
		click(profileBtn);
	}


	public void goToHome() {
		click(gymsharkBtn);
	}

	public void chooseWomenCategory(String item) {
		waiting(1000);
		moveToElement(womenLabel);
		waitforElementToBeClickable(womenRandomItem);
		WebElement desiredElement = womenItemList.stream().filter(el -> el.getText().equalsIgnoreCase(item)).findFirst()
				.orElse(null);
		if (desiredElement != null) {
			click(desiredElement);
		}
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ESCAPE).perform();
	}

	public void chooseMenCategory(String item) {
		waiting(1000);
		moveToElement(menLabel);
		waitforElementToBeClickable(menRandomItem);;
		WebElement desiredElement = menItemList.stream().filter(el -> el.getText().equalsIgnoreCase(item)).findFirst()
				.orElse(null);
		if (desiredElement != null) {
			click(desiredElement);
		}
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ESCAPE).perform();
	}

	public void chooseAccessoryCategory(String item) {
		waiting(1000);
		moveToElement(accessoriesLabel);
		waitforElementToBeClickable(accessoryRandomItem);
		WebElement desiredElement = accessoryItemList.stream().filter(el -> el.getText().equalsIgnoreCase(item)).findFirst()
				.orElse(null);
		if (desiredElement != null) {
			click(desiredElement);
		}
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ESCAPE).perform();
	}

	public int getNumOfItemsInCart() {
		String num = getText(numOfItemsInCart);
		  if (num == null || num.trim().isEmpty()) {
		        return 0;
		    }
		int iNum = Integer.parseInt(num);
		return iNum;
	}
	

	// External links methods:

	public void moveToNewWindow() {
		// A new tab was opened
		// Move the driver to the new window by setting a list of windows
		mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		// Iterate over the list of windows until reaching the last one (win)
		for (String win : windows) {
			driver.switchTo().window(win);
		}

	}

	public void moveBackToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
		waiting(1000);
	}
	
	public void visitDiscord() {
		scrollDown();
		click(discordLink);
		moveToNewWindow();
		waiting(2000);
	}

	public void visitFacebook() {
		scrollDown();
		waitforElementToBeClickable(facebookLink);
		click(facebookLink);
		moveToNewWindow();
		waiting(2000);
	}
	
	public void visitPinterest() {
		scrollDown();
		waitforElementToBeClickable(pinterestLink);
		click(pinterestLink);
		moveToNewWindow();
		waiting(2000);
	}

	public void visitYouTube() {
		scrollDown();
		waitforElementToBeClickable(youtubeLink);
		click(youtubeLink);
		moveToNewWindow();
		waiting(2000);
	}
	
	public void visitInstagram() {
		scrollDown();
		waitforElementToBeClickable(instagramLink);
		click(instagramLink);
		moveToNewWindow();
		waiting(2000);
	}

	public void visitTwitter() {
		scrollDown();
		waitforElementToBeClickable(twitterLink);
		click(twitterLink);
		moveToNewWindow();
		waiting(2000);
	}
	
	
	public void visitTikTok() {
		scrollDown();
		waitforElementToBeClickable(tiktokLink);
		click(tiktokLink);
		moveToNewWindow();
		waiting(2000);
	}
	
	public void goBack() {
		waiting(2000);
		driver.navigate().back();
	}
}
