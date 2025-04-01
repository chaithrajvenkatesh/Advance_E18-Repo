package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selectProductsId;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchProductsId;

	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement addProductBtn;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement productConfirmationMessagePopUp;

	public WebElement getSelectProductsId() {
		return selectProductsId;
	}

	public WebElement getSearchProductsId() {
		return searchProductsId;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProductConfirmationMessagePopUp() {
		return productConfirmationMessagePopUp;
	}

}
