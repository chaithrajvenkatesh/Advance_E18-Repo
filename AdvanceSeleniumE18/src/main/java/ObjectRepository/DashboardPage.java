package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Campaigns")
	private WebElement campaginsLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(xpath = "//*[name()='svg' and @role='img']")
	private WebElement profileIcon;

	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutBtn;

	public WebElement getCampaginsLink() {
		return campaginsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void logout() {
		WebDriverUtility webUtility = new WebDriverUtility();
		webUtility.actionMoveToElementAndClick(driver, profileIcon);
		webUtility.actionMoveToElementAndClick(driver, logoutBtn);
	}

}
