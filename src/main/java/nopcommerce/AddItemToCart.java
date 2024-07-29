package nopcommerce;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemToCart {

	WebDriver driver;
	WebDriverWait wait;
	WebElement selectSize;
	Select select;
	WebElement product;

	public AddItemToCart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Les locateurs
	private final By apparelButton = By.linkText("Apparel");
	private final By ShoesButton = By.linkText("Shoes");
	private final By articlShoes = By.linkText("adidas Consortium Campus 80s Running Shoes");
	private final By sizeFiled = By.id("product_attribute_9");
	private final By AddToCartButton = By.id("add-to-cart-button-25");
	private final By shoppingCartLink = By.linkText("shopping cart");
	private final By productName = By.className("product-name");

	public void addItem(int size) {
		driver.findElement(apparelButton).click();
		driver.findElement(ShoesButton).click();
		driver.findElement(articlShoes).click();
		selectSize = driver.findElement(sizeFiled);
		select = new Select(selectSize);
		select.selectByVisibleText(String.valueOf(size));
		driver.findElement(AddToCartButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLink));
		driver.findElement(shoppingCartLink).click();
		wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/cart"));
		
		product = driver.findElement(productName);
		String expectedText = "adidas Consortium Campus 80s Running Shoes";
		assertEquals(product.getText(), expectedText, "les deux messages ne sont pas compatibles");
	}
}
