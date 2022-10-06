package aayushpatelframework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aayushpatelframework.Reusable.ReusableUtilities;

public class CheckoutPage extends ReusableUtilities {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='form-group']//input[@class='input txt text-validated']")
	WebElement country;

	@FindBy(css = ".ta-item")
	List<WebElement> listCountry;

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submitBtn;

	public void selectCountry(String reqcountry) {

		Actions a = new Actions(driver);
		a.sendKeys(country, reqcountry).build().perform();
		waitforElementExplicit(By.cssSelector(".ta-results"));
		WebElement t = listCountry.stream()
				.filter(l -> l.findElement(By.cssSelector("span")).getText().equalsIgnoreCase("India")).findFirst()
				.orElse(null);
		t.click();
	}

	public ConfirmationPage submitOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		waitforElementEnable(submitBtn);
		submitBtn.click();
		return new ConfirmationPage(driver);
	}

}
