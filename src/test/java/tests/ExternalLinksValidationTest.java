package tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import pageObjects.AccountPage;
import pageObjects.DiscordPage;
import pageObjects.FacebookPage;
import pageObjects.InstagramPage;
import pageObjects.PinterestPage;
import pageObjects.TikTokPage;
import pageObjects.TwitterPage;
import pageObjects.YouTubePage;

public class ExternalLinksValidationTest extends BaseTest {

	AccountPage ap;
	FacebookPage fcp;
	InstagramPage ip;
	TwitterPage tp;
	YouTubePage ytp;
	PinterestPage pp;
	DiscordPage dp;
	TikTokPage ttp;

	@Test(description = "Checking the link to Facebook")
	public void tc01_visitFacebook() {
		ap = new AccountPage(driver);
		ap.visitFacebook();
		fcp = new FacebookPage(driver);
		boolean result = fcp.isItFacebookPage();
		AssertJUnit.assertTrue(result);
		fcp.moveBackToMainWindow();
	}
	
//	@Test(description = "Checking the link to Discord")
//	public void tc01_visitDiscrod() {
//		ap = new AccountPage(driver);
//		ap.visitDiscord();
//		dp = new DiscordPage(driver);
//		boolean result = dp.isItDiscord();
//		AssertJUnit.assertTrue(result);
//		dp.moveBackToMainWindow();
//	}
	

	
//	@Test(description = "Checking the link to Pinterest")
//	public void tc03_visitPinterest() {
//		ap = new AccountPage(driver);
//		ap.visitPinterest();
//		pp = new PinterestPage(driver);
//		boolean result = pp.isItPinterest();
//		AssertJUnit.assertTrue(result);
//		pp.moveBackToMainWindow();
//	}
//	
//	@Test(description = "Checking the link to YouTube")
//	public void tc04_visitYouTube() {
//		ap = new AccountPage(driver);
//		ap.visitYouTube();
//		ytp = new YouTubePage(driver);
//		boolean result = ytp.isItYoutube();
//		AssertJUnit.assertTrue(result);
//		ytp.moveBackToMainWindow();
//	}
//
//	@Test(description = "Checking the link to Instagram")
//	public void tc05_visitInstagram() {
//		ap = new AccountPage(driver);
//		ap.visitInstagram();
//		ip = new InstagramPage(driver);
//		boolean result = ip.isItInstagram();
//		AssertJUnit.assertTrue(result);
//		ip.moveBackToMainWindow();
//	}
//
//	@Test(description = "Checking the link to Twitter")
//	public void tc06_visitTwitter() {
//		ap = new AccountPage(driver);
//		ap.visitTwitter();
//		tp = new TwitterPage(driver);
//		boolean result = tp.isItTwitter();
//		AssertJUnit.assertTrue(result);
//		tp.moveBackToMainWindow();
//	}
//	
//	@Test(description = "Checking the link to TikTok")
//	public void tc07_visitTikTok() {
//		ap = new AccountPage(driver);
//		ap.visitTikTok();
//		ttp = new TikTokPage(driver);
//		boolean result = ttp.isItTikTok();
//		AssertJUnit.assertTrue(result);
//		ttp.moveBackToMainWindow();
//	}
	
}
