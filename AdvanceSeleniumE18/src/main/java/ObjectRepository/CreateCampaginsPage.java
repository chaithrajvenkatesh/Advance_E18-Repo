package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaginsPage {

	WebDriver driver;

	public CreateCampaginsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignName")
	private WebElement campaginName;

	@FindBy(name = "targetSize")
	private WebElement targetSize;

	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;

	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaginButton;

	public WebElement getCampaginNameField() {
		return campaginName;
	}

	public WebElement getTargetSizeField() {
		return targetSize;
	}

	public WebElement getExpectedCloseDateField() {
		return expectedCloseDate;
	}

	public WebElement getCreateCampaginButton() {
		return createCampaginButton;
	}
	
	public void createCampaginWithMandatoryFields(String campName,String target) {
		campaginName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		createCampaginButton.click();
	}
	
	public void createCampaginWithCloseDate(String campName,String target,String date) {
		campaginName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		expectedCloseDate.sendKeys(date);
		createCampaginButton.click();
	}


}
