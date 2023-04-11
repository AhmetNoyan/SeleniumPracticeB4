package day8_popupAlerts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day8_Homework {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		// case1();
		case2();
	}

	public static void case2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		String headerText = driver.findElement(By.xpath("//h3[text()='Frames']")).getText();
		if (headerText.equals("Frames")) {
			System.out.println("There is a header named Frames");
		} else {
			System.out.println("Error");
		}
		driver.switchTo().frame("iframe1");
		driver.findElement(By.id("firstName")).sendKeys("jack");
		driver.findElement(By.id("lastName")).sendKeys("jackss");
		driver.findElement(By.id("address")).sendKeys("afsdgdsw");
		driver.findElement(By.id("city")).sendKeys("Gaithersburg");
		WebElement dropDown = driver.findElement(By.id("state"));
		Select choose = new Select(dropDown);
		choose.selectByVisibleText("Maryland");
		driver.findElement(By.id("zipCode")).sendKeys("22222");
		driver.findElement(By.xpath("//input[@id='male']")).click();
		driver.findElement(By.id("gridCheck")).click();
		WebElement submitBTN = driver.findElement(By.xpath("//button[@type='submit']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submitBTN);

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(submitBTN)).click();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}

	public static void case1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/popup.php");
		String homePageTitle = driver.getTitle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> ids = windowIds.iterator();
		String firstWindow = ids.next();
		String secondWindow = ids.next();

		driver.switchTo().window(secondWindow);
		driver.findElement(By.name("emailid")).sendKeys("email@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		String userId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		String password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();
		System.out.println(userId);
		System.out.println(password);
		WebElement textBox = driver.findElement(By.xpath("//h3[contains(text()='This access')]"));
		String expectedText = "This access is valid only for 20 days.";
		if (textBox.getText().equals(expectedText)) {
			System.out.println("Text box is valid,pass");
		} else {
			System.out.println("Text box is not valid,fail");
		}
		driver.close();
		driver.switchTo().window(firstWindow);
		if (driver.getTitle().equals(homePageTitle)) {
			System.out.println("We are on the home page now");
		} else {
			System.out.println("We are not on the home page");
		}
		driver.quit();

	}
}
