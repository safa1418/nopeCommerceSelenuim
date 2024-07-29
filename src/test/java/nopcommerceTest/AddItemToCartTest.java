package nopcommerceTest;

import setup.BaseTest;

import org.testng.annotations.Test;

import nopcommerce.AddItemToCart;

public class AddItemToCartTest extends BaseTest {
	String size= "8";

	@Test
	public void addItemTest() {
		AddItemToCart addItemTest = new AddItemToCart(driver);
		int sizeInt = Integer.parseInt(size);
		addItemTest.addItem(sizeInt);
	}

}
