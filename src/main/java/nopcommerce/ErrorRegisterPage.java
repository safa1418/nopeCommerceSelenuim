package nopcommerce;

import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorRegisterPage {
	private WebDriver driver;
	private WebDriverWait wait;

	WebElement errorMsgFirstName;

// Constrecteur 
	public ErrorRegisterPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

//Les localisateurs
	private final By registerBouton = By.linkText("Register");
	private final By firstNameError = By.id("FirstName-error");
	private final By lastNameError = By.id("LastName-error");
	private final By emailError = By.id("Email-error");
	private final By passwordError = By.id("ConfirmPassword-error");
	private final By registerSubmitBoutton = By.id("register-button");

	public void error() {
		driver.findElement(registerBouton).click();
		driver.findElement(registerSubmitBoutton).click();
		errorMsgFirstName = driver.findElement(firstNameError);

		String expectedText = "First name is required.";
		assertEquals(errorMsgFirstName.getText(), expectedText, "Confirmation message mismatch");

	}

}