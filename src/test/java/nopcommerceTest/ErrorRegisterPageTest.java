package nopcommerceTest;
import org.testng.annotations.Test;

import nopcommerce.ErrorRegisterPage;
import setup.BaseTest;

public class ErrorRegisterPageTest extends BaseTest {
	@Test
	public void errorTest() {
		ErrorRegisterPage errorRegistration = new ErrorRegisterPage(driver);
		errorRegistration.error();
	}
}
