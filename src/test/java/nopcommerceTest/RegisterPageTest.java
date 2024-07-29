package nopcommerceTest;

import setup.BaseTest;

import org.testng.annotations.Test;

import nopcommerce.RegisterPage;

public class RegisterPageTest extends BaseTest {

	String firstname = "test";
	String lastname = "testsai";
	String day = "12";
	String month = "April";
	String year = "1";
	String email = "test229@gmail.com";
	String campagny = "testCampagny";
	String password = "123987";
	String confirmpassword = "123987";

	@Test
	public void registerPageTest() {

		RegisterPage regPage = new RegisterPage(driver);

		int dayInt = Integer.parseInt(day);

		int yearInt = Integer.parseInt(year);

		regPage.register(firstname, lastname, dayInt, month, yearInt, email, campagny, password, confirmpassword);
	}

}
