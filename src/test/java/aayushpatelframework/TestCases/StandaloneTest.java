package aayushpatelframework.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aayushpatelframework.BaseTest.Base;
import aayushpatelframework.PageObjects.CartPage;
import aayushpatelframework.PageObjects.CheckoutPage;
import aayushpatelframework.PageObjects.ConfirmationPage;
import aayushpatelframework.PageObjects.OrderPage;
import aayushpatelframework.PageObjects.ProductCatlougePage;

public class StandaloneTest extends Base {


	@Test(dataProvider = "getdata", groups = { "purchase" })

	// public void E2Eorder(String email, String password, String req) throws
	// IOException {
// With HashMap
	public void E2Eorder(HashMap<String, String> input) throws IOException {
		// ProductCatlougePage Pp = Lp.loginToApplication(input.get("email"),
		// input.get("password"));
		ProductCatlougePage Pp = Lp.loginToApplication(input.get("email"), input.get("password"));
		List<WebElement> product1 = Pp.getList();
		Pp.getProductName(input.get("product"));
		Pp.addToCart(input.get("product"));
		CartPage Cp = Pp.goTocart();
		boolean match = Cp.addedProductList(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage check = Cp.checkout();
		check.selectCountry("Ind");
		ConfirmationPage confirm = check.submitOrder();
		String message = confirm.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "E2Eorder" })
	public void OrderHistoryTest() {
		Lp.loginToApplication("aayushp47@gmail.com", "Aayush@123");
		OrderPage Op = Lp.gotoOrders();
		boolean match = Op.getOrderList("zara coat 3");
		Assert.assertTrue(match);

	}


//	@DataProvider
//	public Object[][] getdata() {
//		return new Object[][] { { "aayushp47@gmail.com", "Aayush@123", "zara coat 3" },
//				{ "shetty@gmail.com", "Iamking@000", "adidas original" } };
//	}

//	@DataProvider
//	public Object[][] getdata2() {
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "aayushp47@gmail.com");
//		map.put("password", "Aayush@123");
//		map.put("product", "zara coat 3");
//
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map.put("email", "shetty@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("product", "adidas original");
//
//		return new Object[][] { { map },
//				{ map2 } };
//	}

	@DataProvider
	public Object[][] getdata() throws IOException {
		List<HashMap<String, String>> data = getJsonMapData(
				System.getProperty("user.dir") + "\\src\\test\\java\\aayushpatelframework\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}


}
