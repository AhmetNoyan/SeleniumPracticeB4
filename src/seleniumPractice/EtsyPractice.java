package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyPractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		test1();
		 String dir = System.getProperty("user.dir");

		  // directory from where the program was launched
		  // e.g /home/mkyong/projects/core-java/java-io
		  System.out.println(dir);
		
	}
	
	public static void test1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.etsy.com/");
		Thread.sleep(1000);
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("join_neu_email_field")).sendKeys("automation");
		driver.findElement(By.id("join_neu_password_field")).sendKeys("automation");
		Thread.sleep(1000);
		driver.findElement(By.name("submit_attempt")).click();
		Thread.sleep(1000);
		//driver.quit();
	}
	public static void test2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.etsy.com/");
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys("jon.dow@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']")).sendKeys("jon");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("afvsdgv");
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
	    Thread.sleep(1000);
		//Verify you get the error message:
		//"Sorry, the email you have entered is already in use."
	    String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
	    String actualErrorMessage= 
	    		driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
	    
	    if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail!");
		}
	}
}
