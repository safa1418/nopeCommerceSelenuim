package nopcommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Constrecteur
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Les localisateurs :
	private final By loginButton = By.className("ico-login");
	private final By emailFiled = By.id("Email");
	private final By passwordFiled = By.id("Password");
	private final By loginSubmitButton = By.className("login-button");

	// Methode
	public void login(String email, String password) {
		driver.findElement(loginButton).click();
		driver.findElement(emailFiled).sendKeys(email);
		driver.findElement(passwordFiled).sendKeys(password);
		driver.findElement(loginSubmitButton).click();

		// Attendre que l'élément avec le texte "My account" soit présent
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My account")));

	}
}
