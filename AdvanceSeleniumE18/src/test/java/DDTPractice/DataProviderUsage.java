package DDTPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage {

	@Test(dataProvider = "getData")
	public void testCase(String firstName, String lastName) {

		System.out.println("FirstName " + firstName + "LastName " + lastName);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objRef = new Object[3][2];
		objRef[0][0] = "John";
		objRef[0][1] = "dave";
		objRef[1][0] = "Annie";
		objRef[1][1] = "ravan";
		objRef[2][0] = "Smith";
		objRef[2][1] = "Louise";

		return objRef;

	}
}
