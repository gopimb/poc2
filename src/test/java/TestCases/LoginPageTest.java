package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BasePage;

public class LoginPageTest extends BasePage {

	private WebDriver driver;
	private BasePage basePage;
	private Page_Class.SignUpPage SignUpPage;

	public LoginPageTest() {
		// Initialize BasePage
		this.basePage = new BasePage();
		// Initialize WebDriver
		this.driver = basePage.getDriver();
	}

	 @BeforeClass()
	 public void openURL() 
	 {
	 driver.get("http://43.204.112.21:8080/");
	 driver.manage().window().maximize(); 
	
	 }
	 
	@Test(priority = 1)
	public void verifySignUpLoginLink() throws InterruptedException

	{
		Thread.sleep(3000);
		List<WebElement> loginLink = driver.findElements(By.xpath("//h4[contains(text(),'Login')]"));
		if (!loginLink.isEmpty()) {
			System.out.println("Link with text 'Login' is present.");
		} else {
			System.out.println("Link with text 'Login' is NOT present.");
		}

		List<WebElement> signupLink = driver.findElements(By.xpath("//h4[contains(text(),'Sign Up')]"));
		if (!signupLink.isEmpty()) {
			System.out.println("Link with text 'Sign Up' is present.");
		} else {
			System.out.println("Link with text 'Sign Up' is NOT present.");
		}
	}

	@Test(priority = 2)
	public void verifyLoginButton() throws InterruptedException

	{
		Thread.sleep(5000);
		WebElement loginLink = driver.findElement(By.xpath("//h4[contains(text(),'Login')]"));
		loginLink.click();

		List<WebElement> cancelButtons = driver.findElements(By.xpath("//input[@value='Login']"));
		if (!cancelButtons.isEmpty()) {
			System.out.println("Button element with text 'Login' is present.");
		} else {
			System.out.println("Button element with text 'Login' is NOT present.");
		}
	}

	@Test(priority = 3)
	public void verifyLogin() throws InterruptedException {

		/*
		 * WebElement homeBtn
		 * =driver.findElement(By.xpath("//a[contains(text(),'HOME')]"));
		 * homeBtn.click();
		 */

		/*
		 * WebElement loginLink =
		 * driver.findElement(By.xpath("//h4[contains(text(),'Login')]"));
		 * loginLink.click();
		 */

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("test131@test.com");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("12345678");

		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginBtn.click();

		Thread.sleep(5000);

		// WebElement logoutBtn =
		// driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		// logoutBtn.click();

		/*
		 * WebElement registeredMsg = driver.findElement(By.
		 * xpath("//a[contains(text(),' User has been successfully registered.')]"));
		 * String actualText = registeredMsg.getText(); String expectedText =
		 * "User has been successfully registered."; Assert.assertEquals(actualText,
		 * expectedText, "Text not matching!");
		 */
	}

	
	 @AfterClass() 
	 public void closeBrowser()
	 { 
		 driver.quit();
	 }
	 
}
