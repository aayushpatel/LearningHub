package aayushpatelframework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aayushpatelframework.Reusable.ReusableUtilities;

public class ProductCatlougePage extends ReusableUtilities {

	WebDriver driver;

	public ProductCatlougePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> productList;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productBy = By.cssSelector("#toast-container");
	By cartby = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getList() {
		waitforElementExplicit(productBy);
		return productList;

	}

	public WebElement getProductName(String req) {
		WebElement desire = getList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(req))
				.findFirst()
				.orElse(null);
		return desire;
	}

	public void addToCart(String reqProduct)
	{
		WebElement desire = getProductName(reqProduct);
		desire.findElement(cartby).click();
		waitforElementExplicit(toastMessage);
		waitforElementDisappear(spinner);

	}

}
