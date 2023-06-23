package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import utils.Utils;

public class LoginTest {

	WebDriver driver;
	AccountPage ap;
	private HomePage hp;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		Utils u = new Utils();
		String url = u.getValue("url");
		driver.get(url);
	}

	@Test(description = "login with an invalid mail")
	public void tc01_loginInvalidMail() {
		hp = new HomePage(driver);
		hp.login("WrongEmaiil@Test.Test", "YoniPoni147!");
		String actual = hp.getLoginErrorMsg();
		String expected = "Wrong email or password.";
		AssertJUnit.assertEquals(actual, expected);
	}
	
	 @Test(description = "login with an invalid pw")
		 public void tc02_loginInvalidPW() {
		 hp = new HomePage(driver);
		 hp.login("yonatanbashiri1@gmail.com", "1234567891234567891234567891234569789");
		 String actual = hp.getLoginErrorMsg();
		 String expected = "Wrong email or password.";
		 AssertJUnit.assertEquals(actual, expected);
		 }

	@Test(description = "Successfull login")
	public void tc03_login() {
		hp = new HomePage(driver);
		hp.login("yonatanbashiri1@gmail.com", "YoniPoni147!");
		ap = new AccountPage(driver);
		String actual = ap.getPageTitle();
		String expected = "YOUR GYMSHARK ACCOUNT";
		AssertJUnit.assertEquals(actual, expected);
	}

	

	// @Test(dataProvider = "getData")
	// public void tc01_failLogin(String user, String password) {
	// hp = new HomePage(driver);
	// hp.login(user, password);
	// String actual = hp.getLoginErrorMsg();
	// String expected = "Wrong email or password.";
	// AssertJUnit.assertEquals(actual, expected);
	// hp.resetLoginPage();
	// }
	//

	// Invalid data for fail login test

	// @DataProvider
	// public Object[][] getData() {
	// return new Object[][] {
	// { "testuser1@example.com", "password1" },
	// { "testuser2@example.com", "password2" }
	// };
	// }

	// @DataProvider
	// public Object[][] getData() {
	// String data[][] = { { "test1@gmail.com", "123456" },
	// { "test2@gmail.comm", "shshs" }};
	// return data;
	// }

	// @AfterMethod
	// @AfterClass
	// public void tearDown() {
	// driver.quit();
	//
	// }

}
