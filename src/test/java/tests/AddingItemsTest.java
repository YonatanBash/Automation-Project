package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import pageObjects.AccessoriesPage;
import pageObjects.AccountPage;
import pageObjects.CareersPage;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.CommonPage;
import pageObjects.FAQPage;
import pageObjects.HomePage;
import pageObjects.MensPage;
import pageObjects.ProductPage;
import pageObjects.WishlistPage;
import pageObjects.WomensPage;

public class AddingItemsTest extends BaseTest {

	CommonPage cmp;
	HomePage hp;
	AccountPage ap;
	WomensPage wp;
	MensPage mp;
	AccessoriesPage asp;
	CartPage cp;
	CareersPage cap;
	FAQPage fp;
	CheckoutPage cop;
	ProductPage pp;
	WishlistPage wlp;

	@Test(description = "Adding a Women 'All in one' to the cart")
	public void tc01_addingWomenAllInOne() {
		ap = new AccountPage(driver);
		ap.chooseWomenCategory("all in one");
		wp = new WomensPage(driver);
		int before = wp.getNumOfItemsInCart();
		wp.addProductToCart("jersey all in one", "xs");
		cp = new CartPage(driver);
		AssertJUnit.assertEquals(cp.getNumOfItemsInCart(), before + 1);
	}

	@Test(description = "Adding a Women leggings to the cart")
	public void tc02_addingWomenLeggings() {
		ap = new AccountPage(driver);
		ap.chooseWomenCategory("new releases");
		wp = new WomensPage(driver);
		int before = wp.getNumOfItemsInCart();
		wp.filtering("price: high to low", "s", "blue");
		wp.addProductToCart("elevate leggings", "m");
		cp = new CartPage(driver);
		AssertJUnit.assertEquals(cp.getNumOfItemsInCart(), before + 1);
	}

	@Test(description = "Purchasing red shirt from search")
	public void tc03_purchasingShirtFromSearch() {
		ap = new AccountPage(driver);
		ap.searchAnything("red shirt", "sport t-shirt");
		pp = new ProductPage(driver);
		pp.chooseSize("s");
		cp = new CartPage(driver);
		cp.checkout();
		cop = new CheckoutPage(driver);
		cop.goBack();
		String actual = cp.getPageTitle();
		String expected = "YOUR BA";
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Purchasing black pants from search")
	public void tc04_purchasingPantsFromSearch() {
		ap = new AccountPage(driver);
		ap.searchAnything("black pants", "crest joggers");
		pp = new ProductPage(driver);
		pp.chooseSize("m");
		cp = new CartPage(driver);
		cp.checkout();
		cop = new CheckoutPage(driver);
		cop.goBack();
		String actual = cp.getPageTitle();
		String expected = "YOUR BAG";
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Adding a Men shorts to the cart")
	public void tc05_addingMenShorts() {
		ap = new AccountPage(driver);
		ap.chooseMenCategory("best sellers");
		mp = new MensPage(driver);
		int before = mp.getNumOfItemsInCart();
		mp.filtering("relevancy", "m", "black");
		mp.addProductToCart("arrival shorts", "l");
		cp = new CartPage(driver);
		AssertJUnit.assertEquals(cp.getNumOfItemsInCart(), before + 1);
	}

	@Test(description = "Adding a Men T-Shirt to the cart")
	public void tc06_addingMenShirt() {
		ap = new AccountPage(driver);
		ap.chooseMenCategory("functional fitness");
		mp = new MensPage(driver);
		int before = mp.getNumOfItemsInCart();
		mp.addProductToCart("apex seamless t-shirt", "s");
		cp = new CartPage(driver);
		AssertJUnit.assertEquals(cp.getNumOfItemsInCart(), before + 1);
	}

	@Test(description = "Adding an accessory item")
	public void tc07_addingAccessoryItem() {
		ap = new AccountPage(driver);
		ap.chooseAccessoryCategory("all socks");
		asp = new AccessoriesPage(driver);
		int before = asp.getNumOfItemsInCart();
		asp.filtering("price: low to high", "m");
		asp.addProduct("premium jacquard single socks");
		pp = new ProductPage(driver);
		pp.chooseSize("m");
		cp = new CartPage(driver);
		AssertJUnit.assertEquals(cp.getNumOfItemsInCart(), before + 1);
	}

	@Test(description = "Adding a hoodie to wishlist")
	public void tc08_addingHoodieToWishlist() {
		ap = new AccountPage(driver);
		ap.chooseMenCategory("power");
		mp = new MensPage(driver);
		mp.insertItemToWishlist("power zip hoodie");
		wlp = new WishlistPage(driver);
		boolean result = wlp.isItemOnList("power zip hoodie");
		AssertJUnit.assertTrue(result);
	}

	@Test(description = "Adding a shaker to wishlist")
	public void tc09_addingShakerToWishlist() {
		ap = new AccountPage(driver);
		ap.chooseAccessoryCategory("bottles");
		asp = new AccessoriesPage(driver);
		asp.insertItemToWishlist("2.2l water bottle");
		wlp = new WishlistPage(driver);
		boolean result = wlp.isItemOnList("2.2l water bottle");
		AssertJUnit.assertTrue(result);
	}
}
