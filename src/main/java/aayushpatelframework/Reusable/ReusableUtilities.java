package aayushpatelframework.Reusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aayushpatelframework.PageObjects.CartPage;
import aayushpatelframework.PageObjects.OrderPage;

public class ReusableUtilities {

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderBtn;

	WebDriver driver;

	public ReusableUtilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitforElementExplicit(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitforElementAppear(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public void waitforElementDisappear(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}

	public CartPage goTocart() {
		cartBtn.click();
		return new CartPage(driver);

	}

	public OrderPage gotoOrders() {
		orderBtn.click();
		return new OrderPage(driver);
	}

}
