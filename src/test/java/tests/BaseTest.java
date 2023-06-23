package tests;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import pageObjects.HomePage;
import utils.Utils;

public class BaseTest {

	WebDriver driver;
	HomePage hp;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		Utils u = new Utils();
		String url = u.getValue("url");
		String user = u.getValue("user");
		String password = u.getValue("password");
		driver.get(url);
		hp = new HomePage(driver);
		hp.login(user, password);
	}

	@AfterSuite
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void goBack() {
		driver.navigate().back();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
