package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected static WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	//@AfterClass
	/*public void tearDown() {
		if (driver != null) 
			driver.quit();// Quit all browser windows and end the WebDriver session.
        driver = null; // Set driver to null to indicate that the WebDriver session has ended.
	}*/
}
