package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import pageObjects.AccessoriesPage;
import pageObjects.AccountPage;
import pageObjects.CareersPage;
import pageObjects.CartPage;
import pageObjects.FAQPage;
import pageObjects.FacebookPage;
import pageObjects.HomePage;
import pageObjects.InstagramPage;
import pageObjects.MensPage;
import pageObjects.TwitterPage;
import pageObjects.WomensPage;

public class VisitPagesTest extends BaseTest {

	HomePage hp;
	AccountPage ap;
	WomensPage wp;
	MensPage mp;
	AccessoriesPage asp;
	CartPage cp;
	CareersPage cap;
	FAQPage fp;
	FacebookPage fcp;
	InstagramPage ip;
	TwitterPage tp;

	@Test
	public void tc01_goToWomenPage() {
		ap = new AccountPage(driver);
		ap.chooseWomenCategory("leggings");
		wp = new WomensPage(driver);
		String actual = wp.getPageTitle();
		String expected = "LEGGINGS";
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void tc02_goToMenPage() {
		ap = new AccountPage(driver);
		ap.chooseMenCategory("running");
		mp = new MensPage(driver);
		String actual = mp.getPageTitle();
		String expected = "RUNNG";
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void tc03_goToAccessoriesPage() {
		ap = new AccountPage(driver);
		ap.chooseAccessoryCategory("beanies");
		asp = new AccessoriesPage(driver);
		String actual = asp.getPageTitle();
		String expected = "BEANIES";
		AssertJUnit.assertEquals(actual, expected);
	}
	

	@Test
	public void tc04_enterFAQ() {
		ap = new AccountPage(driver);
		ap.enterFAQ();
		fp = new FAQPage(driver);
		String actual = fp.getPageTitle();
		String expected = "HOW CAN WE HELP?";
		AssertJUnit.assertEquals(actual, expected);
	}


}
