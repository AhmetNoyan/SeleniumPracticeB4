package day8_popupAlerts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupWindowsOrTabs {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		//newTabDemo2();
		frames();
	}
	
	public static void frames() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		driver.switchTo().frame("iframe1");
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.id("firstName")).sendKeys("Test");
		driver.switchTo().parentFrame();//goes back one step out 
		driver.switchTo().defaultContent();// it goes to all the way out which is the default content 
		System.out.println(driver.getWindowHandle());
		
	}

	public static void newTabDemo2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowid = driver.getWindowHandle();// It gets the current page's id
		driver.findElement(By.id("newTab")).click();
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		if (mainWindowid.equals(firstWindowId)) {
			System.out.println("Main window ids' are the same");
		} else {
			System.out.println("Main window ids' are not the same");
		}
		String secondWindowId = ids.next();
		driver.switchTo().window(secondWindowId);
		String newTabButton = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		if (newTabButton.equals("New Tab")) {
			System.out.println("New Tab button verified");
		} else {
			System.out.println("New Tab button is not verified");
		}
		driver.close();

		driver.switchTo().window(mainWindowid);

		if (mainWindowid.equals(driver.getWindowHandle())) {
			System.out.println("You are on the main window, pass");
		} else {
			System.out.println("You are not on the main window, fails");
		}

	}

	public static void newTabDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowid = driver.getWindowHandle();// It gets the current page's id
		System.out.println("main window id: " + mainWindowid);
		driver.findElement(By.id("newTab")).click();
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			System.out.println("Window Id is: " + windowId);
		}
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();

		System.out.println("First window id: " + firstWindowId);
		System.out.println("Second window id: " + secondWindowId);

		driver.switchTo().window(secondWindowId);

		String new1 = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(new1);
		driver.close();// closes the current window
		driver.switchTo().window(firstWindowId);
		String window1 = driver.findElement(By.xpath("//h3[text()='Browser Windows']")).getText();
		System.out.println("Main window browser text is: " + window1);
		if (driver.getWindowHandle().equals(mainWindowid)) {
			System.out.println("test pass");
		} else {
			System.out.println("test fail");
		}
		driver.quit();
	}
}
