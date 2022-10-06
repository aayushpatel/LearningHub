package aayushpatelframework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aayushpatelframework.Reusable.ReusableUtilities;

public class LandingPage extends ReusableUtilities {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorBoard;


	public ProductCatlougePage loginToApplication(String emailId, String password) {

		email.sendKeys(emailId);
		userPassword.sendKeys(password);
		loginBtn.click();
		return new ProductCatlougePage(driver);

	}

	public void luanchApplication() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getLoginError() {
		waitforElementAppear(errorBoard);
		return errorBoard.getText();

	}
}
