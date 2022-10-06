package aayushpatelframework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aayushpatelframework.Reusable.ReusableUtilities;

public class CartPage extends ReusableUtilities {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='cart']//h3")
	List<WebElement> addedproduct;

	@FindBy(xpath = "//li[@class='totalRow']//*[@class='btn btn-primary']")
	WebElement checkoutBtn;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean addedProductList(String req) {

		boolean match = addedproduct.stream().anyMatch(p -> p.getText().equalsIgnoreCase(req));
		return match;
	}

	public CheckoutPage checkout() {
		checkoutBtn.click();
		CheckoutPage check = new CheckoutPage(driver);
		return check;

	}

}
