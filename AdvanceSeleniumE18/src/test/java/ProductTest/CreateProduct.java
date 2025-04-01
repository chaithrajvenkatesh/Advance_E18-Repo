package ProductTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericListenerUtility.ListenerImp;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.ProductPage;

import org.testng.Assert;
import org.testng.Reporter;


public class CreateProduct extends BaseClass {

	// @Parameters("browser")
	@Test(groups = "IntegrationTest")
	public void createProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		JavaUtility javaUtility = new JavaUtility();
		int randomNum = javaUtility.getRandomNumber(10000);

		ExcelFileUtility exUtility = new ExcelFileUtility();
		String productName = exUtility.readingDataFromExcel("Product", 1, 2) + randomNum;
		String quantity = exUtility.readingDataFromExcel("Product", 1, 3);
		String pricePerUnit = exUtility.readingDataFromExcel("Product", 1, 4);

		String expectedURL = "http://49.249.28.218:8098/dashboard";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(2000);
		// click on product link
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.getProductsLink().click();
		// Click on create product Button on product dashboard page
		ProductPage productPage = new ProductPage(driver);
		productPage.getAddProductBtn().click();
		// enter the mandatory field in create product page
		CreateProductsPage createProductPage = new CreateProductsPage(driver);
		createProductPage.createProductWithMandatoryFields(productName, quantity, pricePerUnit);

		// verification of confirmation message
		Thread.sleep(5000);
		String ConfirmationMsg = productPage.getProductConfirmationMessagePopUp().getText();
		boolean status = ConfirmationMsg.contains(productName);
		Assert.assertEquals(status, true, "Product not added");
		// Assert.assertTrue(status, "Product not added");
		Reporter.log("Product " + productName + " added successfully", true);
		Thread.sleep(5000);

	}
}
