package nopcommerceTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import nopcommerce.CheckoutPage;
import setup.BaseTest;

public class CheckoutPageTest extends BaseTest {

	@Test(priority = 1, dataProvider = "checkoutData")
	public void checkouProcessTest(String country, String state ,String city, String addressOne, String addressTwo, String zip, String phone, String fax) {

		new CheckoutPage(driver).checkoutPage(country, state, city, addressOne, addressTwo, zip, phone, fax);

	}

	@DataProvider(name = "checkoutData")
	public Object[][] getData() {
		return new Object[][] { { "United States", "Alabama", "Lyon", "Vaise", "Vaise", "12254", "1515456465", "151545156" } };
	}
}