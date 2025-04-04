package CampaignTest;

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
import ObjectRepository.CampaginsPage;
import ObjectRepository.CreateCampaginsPage;
import ObjectRepository.DashboardPage;


public class CreateCampaignTest extends BaseClass {
	// @Parameters("browser")
	@Test()
	public void createCampaignTest() throws InterruptedException, IOException {

		JavaUtility javaUtility = new JavaUtility();
		int randomNum = javaUtility.getRandomNumber(10000);

		ExcelFileUtility exUtility = new ExcelFileUtility();
		String campagin = exUtility.readingDataFromExcel("DDT", 1, 2) + randomNum;
		String targetSize = exUtility.readingDataFromExcel("DDT", 1, 3);

		String expectedURL = "http://49.249.28.218:8098/dashboard";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(4000);
		// click on campagin link
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.getCampaginsLink().click();
		// Click on create campagin Button on campagin page
		CampaginsPage campaginPage = new CampaginsPage(driver);
		campaginPage.getCreateCampaginBtn().click();
		// enter the mandatory field in create campagin page
		CreateCampaginsPage createCampaginPage = new CreateCampaginsPage(driver);
		createCampaginPage.createCampaginWithMandatoryFields(campagin, targetSize);
		// verification of confirmation message
		Thread.sleep(2000);
		String ConfMsg = campaginPage.getCampaginConfirmationMessagePopUp().getText();
		boolean status = ConfMsg.contains(campagin);
		Assert.assertEquals(status, true, "Campagin not added");
		// Assert.assertTrue(status, "Campagin not added");
		Reporter.log("Campagin " + campagin + " added successfully", true);
		Thread.sleep(5000);

	}

	// @Parameters("browser")
	@Test()
	public void createCampaginWithCloseDateTest() throws IOException, InterruptedException {
		JavaUtility javaUtility = new JavaUtility();
		int randomNum = javaUtility.getRandomNumber(10000);

		String closeDate = javaUtility.generateRequiredDate(30);

		ExcelFileUtility exUtility = new ExcelFileUtility();
		String campagin = exUtility.readingDataFromExcel("DDT", 1, 2) + randomNum;
		String targetSize = exUtility.readingDataFromExcel("DDT", 1, 3);

		String expectedURL = "http://49.249.28.218:8098/dashboard";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(4000);
		// click on campagin link
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.getCampaginsLink().click();
		// Click on create campagin Button on campagin page
		CampaginsPage campaginPage = new CampaginsPage(driver);
		campaginPage.getCreateCampaginBtn().click();
		// enter the mandatory field in create campagin page
		CreateCampaginsPage createCampaginPage = new CreateCampaginsPage(driver);
		createCampaginPage.createCampaginWithCloseDate(campagin, targetSize, closeDate);

		// verification of confirmation message
		Thread.sleep(2000);
		String ConfMsg = campaginPage.getCampaginConfirmationMessagePopUp().getText();
		boolean status = ConfMsg.contains(campagin);
		Assert.assertEquals(status, true, "Campagin not added");
		// Assert.assertTrue(status, "Campagin not added");
		Reporter.log("Campagin " + campagin + " added successfully", true);
		Thread.sleep(5000);
	}

}
