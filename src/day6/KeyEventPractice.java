package day6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyEventPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.navigate().to("https:/www.google.com");
//		
//		WebElement searchBox=driver.findElement(By.name("q"));
//		searchBox.sendKeys("coffee mugs"+Keys.ENTER);
//		Thread.sleep(1000);
//		WebElement newSearchBox=driver.findElement(By.name("q"));
//		newSearchBox.clear();
//		driver.findElement(By.name("q")).sendKeys("Selenium Webdriver"+Keys.ADD+Keys.ENTER);
//		driver.navigate().back();
//		searchBox.clear();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.navigate().to("https:/www.amazon.com");
//		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//		searchBox.sendKeys("coffee mugs");
//		WebElement test1 = driver.findElement(By.id("nav-search-submit-button"));
//		test1.click();
//		driver.navigate().back();
//		WebElement searchBox1 = driver.findElement(By.id("twotabsearchtextbox"));
//		searchBox1.sendKeys("pretty coffee mugs");
//		 driver.findElement(By.id("nav-search-submit-button")).click();
//		//test1.click();
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().refresh();
		// webElementsTest();
		// radioButtons();
		// checkBoxes();
		// amazon();
		ebay();
	}

	public static void webElementsTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.cssSelector(".inventory_item"));
		List<WebElement> list1 = driver.findElements(By.cssSelector(".inventory_item_price"));

		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
		}

	}

	public static void elementStatus() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://indeed.com");
		WebElement whatField = driver.findElement(By.id("text-input-what"));
		WebElement whereField = driver.findElement(By.id("text-input-where"));

		if (whatField.isDisplayed() && whatField.isDisplayed()) {
			System.out.println("What field is enabled and displayed");
		} else {
			System.out.println("what field is either not enabled or displayed");
		}

		if (whereField.isDisplayed() && whereField.isDisplayed()) {
			System.out.println("Where field is enabled and displayed");
		} else {
			System.out.println("where field is either not enabled or displayed");
		}
	}

	public static void radioButtons() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/radio-button");
		List<WebElement> list = driver.findElements(By.cssSelector(".form-check-input"));

		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			if (element.isDisplayed() && element.isEnabled()) {

				System.out.println(element.getAttribute("id") + " is displayed and enabled");
				if (element.isSelected()) {
					System.out.println(element.getAttribute("id") + " is selected");
				} else {
					System.out.println(element.getAttribute("id") + " is not selected,selecting now");
					element.click();
				}
			} else {
				System.out.println("Cannot display or enable the elements.");
			}
			if (element.isSelected()) {
				System.out.println(element.getAttribute("id") + " is selected");
			} else {
				System.out.println(element.getAttribute("id") + " is not selected");
			}
			Thread.sleep(1000);
		}
		System.out.println("TEST COMPLETE");
	}

	public static void checkBoxes() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		List<WebElement> list = driver.findElements(By.cssSelector(".form-check-input"));

		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					System.out.println(element.getAttribute("id") + " is displayed and enabled");
					if (element.isSelected()) {
						System.out.println(element.getAttribute("id") + " is selected");
					} else {
						System.out.println(element.getAttribute("id") + " is not selected,selecting now");
						element.click();
					}
				} else {
					System.out.println("cannot enable ");
				}
			} else {
				System.out.println("Cannot display.");
			}
			if (element.isSelected()) {
				System.out.println(element.getAttribute("id") + " is checked");
			} else {
				System.out.println(element.getAttribute("id") + " is not checked");
			}
			Thread.sleep(1000);
		}
		System.out.println("TEST COMPLETE");

	}

	public static void amazon() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span")).click();
		Thread.sleep(1000);
		Boolean isSignInPage = driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).isDisplayed();
		if (isSignInPage) {
			System.out.println("We are on sign-in page");
		} else {
			System.out.println("Incorrect page");
		}
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().forward();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		isSignInPage = driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).isDisplayed();
		if (isSignInPage) {
			System.out.println("STILL on sign-in page");
		} else {
			System.out.println("Incorrect page");
		}
		WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]"));
		createAccount.click();
		Boolean isCreateAccount = driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).isDisplayed();
		if (isCreateAccount) {
			System.out.println("We are on new create account page");
		} else {
			System.out.println("Incorrect page");
		}
		driver.navigate().back();
		isSignInPage = driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).isDisplayed();
		if (isSignInPage) {
			System.out.println("STILL on sign-in page");
		} else {
			System.out.println("Incorrect page");
		}
		driver.navigate().forward();
		isCreateAccount = driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).isDisplayed();
		if (isCreateAccount) {
			System.out.println("STILL on new create account page");
		} else {
			System.out.println("Incorrect page");
		}
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		String errorMessage1 = driver.findElement(By.xpath("//*[@id=\"auth-customerName-missing-alert\"]/div/div"))
				.getText();
		if (errorMessage1.equals("Enter your name")) {
			System.out.println(errorMessage1 + " is displayed");
		} else {
			System.out.println(errorMessage1 + " not displayed");
		}
		String errorMessage2 = driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).getText();
		if (errorMessage2.equals("Enter your email or mobile phone number")) {
			System.out.println(errorMessage2 + " is displayed");
		} else {
			System.out.println(errorMessage2 + " not displayed");
		}
		String errorMessage3 = driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div"))
				.getText();
		if (errorMessage3.equals("Minimum 6 characters required")) {
			System.out.println(errorMessage3 + " is displayed");
		} else {
			System.out.println(errorMessage3 + " not displayed");
		}
	}

	public static void ebay() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='gh-ac']"));
		searchBox.sendKeys("coffee mug");
		searchBox.sendKeys(Keys.ENTER);
		List<WebElement> mugList = driver.findElements(By.xpath("//span[@class='s-item__price']"));
		System.out.println((mugList.size() - 1) + " offer found");
		for (int i = 1; i < mugList.size(); i++) {
			System.out.println(mugList.get(i).getText());
		}
		driver.quit();
	}

}
