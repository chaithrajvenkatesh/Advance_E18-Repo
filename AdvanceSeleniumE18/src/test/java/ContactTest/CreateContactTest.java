package ContactTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericListenerUtility.ListenerImp;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaginsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaginsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;


public class CreateContactTest extends BaseClass {

	// @Parameters("browser")
	@Test(groups = "RegressionTest")
	public void createContactWithCampaginTest() throws InterruptedException, IOException {
		JavaUtility javaUtility = new JavaUtility();
		int randomNum = javaUtility.getRandomNumber(10000);

		ExcelFileUtility exUtility = new ExcelFileUtility();
		String campagin = exUtility.readingDataFromExcel("DDT", 1, 2) + randomNum;
		String targetSize = exUtility.readingDataFromExcel("DDT", 1, 3);
		String organization = exUtility.readingDataFromExcel("Contact", 1, 2) + randomNum;
		String title = exUtility.readingDataFromExcel("Contact", 1, 3);
		String contactName = exUtility.readingDataFromExcel("Contact", 1, 4) + randomNum;
		String mobileNum = exUtility.readingDataFromExcel("Contact", 1, 5);

		String expectedURL = "http://49.249.28.218:8098/dashboard";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		// click on comapagin link
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.getCampaginsLink().click();
		// Click on create campagin Button on campagin page
		CampaginsPage campaginPage = new CampaginsPage(driver);
		campaginPage.getCreateCampaginBtn().click();
		// enter the mandatory field in create campagin page
		CreateCampaginsPage createCampaginPage = new CreateCampaginsPage(driver);
		createCampaginPage.createCampaginWithMandatoryFields(campagin, targetSize);
		Thread.sleep(3000);
		// click on contact link
		WebDriverUtility webUtility = new WebDriverUtility();
		webUtility.waitForElementToBeClickable(driver, dashboardPage.getContactsLink(), 20);
		dashboardPage.getContactsLink().click();
		Thread.sleep(5000);
		ContactsPage contactPage = new ContactsPage(driver);
		webUtility.waitForElementToBeClickable(driver, contactPage.getCreateContactBtn(), 20);
		contactPage.getCreateContactBtn().click();

		// enter the mandatory field in create campagin page
		CreateContactPage createContactPage = new CreateContactPage(driver);
		String childUrl = "selectCampaign";
		String parentUrl = "create-contact";
		createContactPage.createContactWithMandatoryFields(organization, title, contactName, mobileNum, childUrl,
				parentUrl, campagin);

		// verification of confirmation message
		Thread.sleep(5000);
		String ConfirmationMsg = contactPage.getContactConfirmationMessagePopUp().getText();
		boolean status = ConfirmationMsg.contains(contactName);
		Assert.assertEquals(status, true, "Contact not added");
		// Assert.assertTrue(status, "Contact not added");
		Reporter.log("Contact " + contactName + " added successfully", true);
		Thread.sleep(5000);

	}
}
