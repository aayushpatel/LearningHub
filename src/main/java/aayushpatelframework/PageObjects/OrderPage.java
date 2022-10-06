package aayushpatelframework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aayushpatelframework.Reusable.ReusableUtilities;

public class OrderPage extends ReusableUtilities {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[@class='ng-star-inserted']//td[2]")
	List<WebElement> ordersNames;

	public boolean getOrderList(String orderName) {
		
		boolean value = ordersNames.stream().anyMatch(s -> s.getText().equalsIgnoreCase(orderName));
		return value;

	}

}
