package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BasePage;

public class LogoutTest {

	private WebDriver driver;
	private BasePage basePage;
	private Page_Class.SignUpPage SignUpPage;
	private LoginPageTest LoginPageTest;

	public LogoutTest() {
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
	public void verifyUserLogout() throws InterruptedException{
		
		WebElement loginLink =
		driver.findElement(By.xpath("//h4[contains(text(),'Login')]"));
		loginLink.click();
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("test131@test.com");
		
		Thread.sleep(3000);

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("12345678");
		
		Thread.sleep(3000);

		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginBtn.click();
	
		Thread.sleep(3000);

		WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logoutBtn.click();
		
		Thread.sleep(5000);

	}
	
	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}
}
