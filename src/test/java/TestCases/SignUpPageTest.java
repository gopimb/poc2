package TestCases;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BasePage;

public class SignUpPageTest {

	private WebDriver driver;
	private BasePage basePage;
	private Page_Class.SignUpPage SignUpPage;

	public SignUpPageTest() {
		// Initialize BasePage
		this.basePage = new BasePage();
		// Initialize WebDriver
		this.driver = basePage.getDriver();

	}

	@BeforeClass()
	public void openURL() {
		driver.get("http://43.204.112.21:8080/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void verifyButtonPresent() throws InterruptedException

	{
		Thread.sleep(3000);
		
		WebElement signUpLink = driver.findElement(By.xpath("//h4[contains(text(),'Sign Up')]"));
		signUpLink.click();
		
		 List<WebElement> cancelButtons = driver.findElements(By.xpath("//button[contains(text(),'Cancel')]"));

	        if (!cancelButtons.isEmpty()) {
	            System.out.println("Button element with text 'Cancel' is present.");
	        } else {
	            System.out.println("Button element with text 'Cancel' is NOT present.");
	        }
	        
	     List<WebElement> signUpButtons = driver.findElements(By.xpath("//button[contains(text(),'Sign Up')]"));

		        if (!signUpButtons.isEmpty()) {
		            System.out.println("Button element with text 'Sign Up' is present.");
		        } else {
		            System.out.println("Button element with text 'Sign Up' is NOT present.");
		        }
	}

	@Test(priority = 2)
	public void verifySignUp() throws InterruptedException

	{
		/*
		 * WebElement signUpLink =
		 * driver.findElement(By.xpath("//h4[contains(text(),'Sign Up')]"));
		 * signUpLink.click();
		 */

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Enter First Name']"));
		firstName.sendKeys("Jack");

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']"));
		lastName.sendKeys("Den");

		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
		email.sendKeys("test136@test.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		password.sendKeys("12345678");

		WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Enter Mobile']"));
		mobile.sendKeys("1122334455");

		WebElement signUpBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		signUpBtn.click();
		
		Thread.sleep(5000);
		
		/*
		 * WebElement registeredMsg = driver.findElement(By.xpath("//h3[@xpath='1']"));
		 * String actualText = registeredMsg.getText(); System.out.println("Text" +
		 * actualText); String expectedText
		 * ="Oops! There is already a user registered with the email provided.";
		 * Assert.assertEquals(actualText, expectedText, "Text not matching!");
		 */
	}
	
	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}

}
