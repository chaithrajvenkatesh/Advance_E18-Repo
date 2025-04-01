package LoginTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericListenerUtility.ListenerImp;


public class LoginTest extends BaseClass {

	// @Parameters("browser")
	@Test(retryAnalyzer = GenericListenerUtility.RetryListenerImp.class)
	public void loginTest() throws InterruptedException, IOException {

		String expectedURL = "http://49.249.28.218:8098/dashboar";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(2000);
		// verification of dashboard
		String actualURL = driver.getCurrentUrl();
		/*
		 * SoftAssert sf= new SoftAssert(); sf.assertEquals(actualURL,
		 * expectedURL,"Validation is failed"); sf.assertAll();
		 */
		Assert.assertEquals(actualURL, expectedURL, "Validation is failed");
		Reporter.log("Validation is passed", true);

	}
}
