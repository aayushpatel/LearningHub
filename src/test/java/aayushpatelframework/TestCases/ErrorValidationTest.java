package aayushpatelframework.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import aayushpatelframework.BaseTest.Base;
import aayushpatelframework.PageObjects.CartPage;
import aayushpatelframework.PageObjects.ProductCatlougePage;

public class ErrorValidationTest extends Base {

	@Test
	public void loginValidation() {
		Lp.loginToApplication("aayushp47@gmail.com", "Aayush@12");
		String message = Lp.getLoginError();
		Assert.assertEquals(message, "Incorrect email or password.");
	}

	@Test
	public void loginValidationerror() {
		// intentionally fail
		Lp.loginToApplication("aayushp47@gmail.com", "Aayush@12");
		String message = Lp.getLoginError();
		Assert.assertEquals(message, "Incorrect emai or password.");
	}

	@Test
	public void productValidation() {
		String req = "zara coat 3";
		ProductCatlougePage Pp = Lp.loginToApplication("aayushp47@gmail.com", "Aayush@123");
		Pp.addToCart(req);
		CartPage Cp = Pp.goTocart();
		boolean match = Cp.addedProductList("zara coat 4");
		Assert.assertFalse(match);
	}

}
