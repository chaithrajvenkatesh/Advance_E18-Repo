package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {

	WebDriver driver;

	public CreateProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productName")
	private WebElement productName;

	@FindBy(name = "quantity")
	private WebElement quantity;

	@FindBy(name = "price")
	private WebElement price;

	@FindBy(name = "productCategory")
	private WebElement selectProductCategory;

	@FindBy(name = "vendorId")
	private WebElement selectVendorId;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addProductButton;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getSelectProductCategory() {
		return selectProductCategory;
	}

	public WebElement getSelectVendorId() {
		return selectVendorId;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}
	
	public void createProductWithMandatoryFields(String proName,String qty,String pri) {
		productName.sendKeys(proName);
		quantity.sendKeys(qty);
		price.sendKeys(pri);
		WebDriverUtility webUtility= new WebDriverUtility();
		webUtility.select(selectProductCategory, "Furniture");
		webUtility.select(selectVendorId, "VID_008");
		addProductButton.click();
	}

}
