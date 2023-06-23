package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {

	@FindBy(css = "[data-locator-id='storeSelector-confirm-select']")
	private WebElement europeLabel;
	@FindBy(css = "[class^='header_action-bar'] [title='account']")
	private WebElement accountLabel;
	@FindBy(css = "#login-email")
	private WebElement emailField;
	@FindBy(css = "#login-password")
	private WebElement passwordField;
	@FindBy(css = "#btn-login")
	private WebElement loginBtn;
	@FindBy(css = "#RecoverPassword")
	private WebElement forgotPwLink;
	@FindBy(css = "#login-forgotten-password")
	private WebElement forgotPwEmailField;
	@FindBy(css = ".cta.primary.btn--login.js-reset-pw-submit")
	private WebElement resetPwBtn;
	@FindBy(css = ".customer-general__links > .btn.classic-link")
	private WebElement backToStore;
	@FindBy(css = "#login-form [class^='text-error']")
	private WebElement loginErrorMsg;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void loginAndStop(String email, String password) {
		confirmPopup();
		click(accountLabel);
		fillText(emailField, email);
		fillText(passwordField, password);
		click(loginBtn);
		waiting(1000);

	}

	public void chooseCountryWindow() {
		try {
			click(europeLabel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(String email, String password) {
		try {
			waitforElementToBeClickable(europeLabel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		confirmPopup();
		click(accountLabel);
		waitforElementToBeClickable(emailField);
		fillText(emailField, email);
		fillText(passwordField, password);
		click(loginBtn);
	}

	public void forgotPassword(String email) {
		click(forgotPwLink);
		fillText(forgotPwEmailField, email);
		click(resetPwBtn);
	}

	public String getLoginErrorMsg() {
		waitForVisibilityOfElement(loginErrorMsg);
		return getText(loginErrorMsg);
	}

	public void confirmPopup() {
		try {
			click(europeLabel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetLoginPage() {
		emailField.clear();
		passwordField.clear();
		driver.navigate().refresh();
	}
}
