package GenericBaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass  {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	DatabaseUtility dbUtil = new DatabaseUtility();
	PropertiesFileUtility pro = new PropertiesFileUtility();

	@BeforeSuite
	public void beforeSuite() throws SQLException {
		System.out.println("Established database connection");
		dbUtil.getDbConnection("jdbc:mysql://localhost:3306/ninza_E18", "root", "chaithrajv@20");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Pre Configuration set up");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Launch the browser");
		String BROWSER = pro.readingDataFromPropFile("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Login");
		String URL = pro.readingDataFromPropFile("url");
		String UN = pro.readingDataFromPropFile("uname");
		String PWD = pro.readingDataFromPropFile("pwd");
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(UN, PWD);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Logout");
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Close the browser");
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Post configuration set up");
	}

	@AfterSuite
	public void afterSuite() throws SQLException {
		System.out.println("Close the db connection");
		dbUtil.closeDBConnection();
	}

}
