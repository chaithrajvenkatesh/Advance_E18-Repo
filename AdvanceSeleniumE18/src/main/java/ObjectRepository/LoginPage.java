package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameField;

	@FindBy(id = "inputPassword")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement SignInBtn;

	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPwdLink;

	@FindBy(linkText = "Create Account")
	private WebElement CreateAccBtn;

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSignInBtn() {
		return SignInBtn;
	}

	public WebElement getForgotPwdLink() {
		return forgotPwdLink;
	}

	public WebElement getCreateAccBtn() {
		return CreateAccBtn;
	}

	public void login(String uname, String pwd) {
		usernameField.sendKeys(uname);
		passwordField.sendKeys(pwd);
		SignInBtn.click();
	}

}
