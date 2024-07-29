package nopcommerceTest;

import setup.BaseTest;

import org.testng.annotations.Test;

import nopcommerce.LoginPage;

public class LoginPageTest extends BaseTest{
	String email=  "test229@gmail.com";
	String password = "123987";
	@Test
	public void loginTest() {
		LoginPage logTest = new LoginPage(driver);
		
		logTest.login(email, password);
	}

}
