package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class FacebookActivities {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		//testCase1();
		testCase2();
		//getTextPractice();
	}

	public static void testCase1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("Automation");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();

	}

	public static void testCase2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		driver.quit();
	}

	public static void getTextPractice() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String loginText = driver.findElement(By.name("login")).getText();
		System.out.println("this is login button text: " + loginText);
		if(loginText.equals("Log In")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test fail! Text does not match with expected value");
		}
	}
}
