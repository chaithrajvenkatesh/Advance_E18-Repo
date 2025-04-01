package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateContactPage {

	WebDriver driver;

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "organizationName")
	private WebElement organizationName;

	@FindBy(name = "title")
	private WebElement title;

	@FindBy(name = "contactName")
	private WebElement contactName;

	@FindBy(name = "mobile")
	private WebElement mobileNo;

	@FindBy(xpath = "(//*[name()='svg' and @role='img'])[2]")
	private WebElement selectCampaginBtn;

	@FindBy(id = "search-criteria")
	private WebElement selectCompaginId;

	@FindBy(id = "search-input")
	private WebElement searchBar;

	@FindBy(xpath = "//button[@class='select-btn']")
	private WebElement selectBtn;

	@FindBy(xpath = "//button[text()='Create Contact']")
	private WebElement createContactButton;

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getSelectCampaginBtn() {
		return selectCampaginBtn;
	}

	public WebElement getSelectCompaginId() {
		return selectCompaginId;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}
	
	public void createContactWithMandatoryFields(String orgnName,String titleName,String contName,String mobileNum,String childUrl,String parentUrl,String campName) {
		organizationName.sendKeys(orgnName);
		title.sendKeys(titleName);
		contactName.sendKeys(contName);
		mobileNo.sendKeys(mobileNum);
		selectCampaginBtn.click();
		WebDriverUtility wUtil= new WebDriverUtility();
		wUtil.switchToWindow(driver, childUrl);
		wUtil.select(selectCompaginId, 1);
		searchBar.sendKeys(campName);
		selectBtn.click();
		wUtil.switchToWindow(driver, parentUrl);
		createContactButton.click();
	}
	
}
