package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaginsPage {

	WebDriver driver;

	public CampaginsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selectCampaginId;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchCampaginId;

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaginBtn;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement campaginConfirmationMessagePopUp;

	public WebElement getSelectCampaginIdField() {
		return selectCampaginId;
	}

	public WebElement getSearchCampaginIdField() {
		return searchCampaginId;
	}

	public WebElement getCreateCampaginBtn() {
		return createCampaginBtn;
	}

	public WebElement getCampaginConfirmationMessagePopUp() {
		return campaginConfirmationMessagePopUp;
	}
}
