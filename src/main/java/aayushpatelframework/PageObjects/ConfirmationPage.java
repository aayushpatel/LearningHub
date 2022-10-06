package aayushpatelframework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aayushpatelframework.Reusable.ReusableUtilities;

public class ConfirmationPage extends ReusableUtilities {

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement successMessage;

	public String getConfirmationMessage() {
		return successMessage.getText();
	}


}
