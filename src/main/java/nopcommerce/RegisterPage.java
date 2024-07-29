package nopcommerce;

import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private WebDriver driver;
	private WebDriverWait wait;
	WebElement selectmonthOfBirth;
	Select select;
	WebElement regMsg;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Les localisateurs : the best practices il faut separer le declaration
	// avec driver.findElement()
	private By registerButton = By.linkText("Register");
	private By genderMaleRadioButton = By.id("gender-male");
	private By firstNameFiled = By.id("FirstName");
	private By lastNameFiled = By.id("LastName");
	private By birthDayFiled = By.name("DateOfBirthDay");
	private By birthMonthFiled = By.name("DateOfBirthMonth");
	private By birthYearFiled = By.name("DateOfBirthYear");
	private By emailFiled = By.id("Email");
	private By companyNameFiled = By.id("Company");
	private By passwordFiled = By.id("Password");
	private By confirmPasswordFiled = By.id("ConfirmPassword");
	private By registerSubmitBoutton = By.id("register-button");
	private By registrationMessage = By.className("result");
	private By logoutBoutton = By.linkText("Log out");

	public void register(String firstname, String lastname, int day, String month, int year, String email,
			String campagny, String password, String confirmpassword) {
		driver.findElement(registerButton).click();
		driver.findElement(genderMaleRadioButton).click();
		driver.findElement(firstNameFiled).sendKeys(firstname);
		driver.findElement(lastNameFiled).sendKeys(lastname);
		driver.findElement(birthDayFiled).sendKeys(String.valueOf(day));
		// driver.findElement(birthMonthFiled).sendKeys(month);

		// Localisez l'élément <select> par son nom
		selectmonthOfBirth = driver.findElement(birthMonthFiled);

		// Créez une instance de la classe Select et passez l'élément <select> comme
		// paramètre
		select = new Select(selectmonthOfBirth);

		// Sélectionnez l'option par sa valeur
		// select.selectByValue("7");
		select.selectByVisibleText(month);

		driver.findElement(birthYearFiled).sendKeys(String.valueOf(year));
		driver.findElement(emailFiled).sendKeys(email);
		driver.findElement(companyNameFiled).sendKeys(campagny);
		driver.findElement(passwordFiled).sendKeys(password);
		driver.findElement(confirmPasswordFiled).sendKeys(confirmpassword);
		driver.findElement(registerSubmitBoutton).click();

		regMsg = driver.findElement(registrationMessage);
		String expectedText = "Your registration completed";
		assertEquals(regMsg.getText(), expectedText, "les deux messages ne sont pas compatibles");

		driver.findElement(logoutBoutton).click();
	}
}
