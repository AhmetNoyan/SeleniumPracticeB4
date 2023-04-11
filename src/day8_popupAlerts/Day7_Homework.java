package day8_popupAlerts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day7_Homework {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		// amazonSelect();
		// alertTestCase3();
		// case1();
		// case2();
		// alertPopUp();
		//confirmAlert();
		promptAlert();
	}

	public static void promptAlert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.id("prompt")).click();
		Alert handle=driver.switchTo().alert();
		handle.sendKeys("Primetech");
		handle.dismiss();
		String expectedResult="User cancelled the prompt.";
		WebElement demoPrompt=driver.findElement(By.id("demo"));
		if(demoPrompt.isDisplayed()) {
			String actualResult=demoPrompt.getText();
			if(actualResult.equals(expectedResult)) {
				System.out.println("pass");
			}else {
				System.out.println("fail");
			}
		}else {
			System.out.println("it does not display, fail");
		}
		
	}

	public static void confirmAlert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.id("confirm")).click();
		Alert handle = driver.switchTo().alert();
		String actualText = handle.getText();
		System.out.println(actualText);
		String expectedText = "Do you wish to continue or cancel?";
		if (actualText.equals(expectedText)) {
			System.out.println("Alert is valid");
			handle.accept();
		} else {
			System.out.println("Alert is not valid");
			handle.dismiss();
		}
	}

	public static void alertPopUp() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		Alert handle = driver.switchTo().alert();
		Thread.sleep(1000);
		handle.accept();
	}

	public static void case2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://amazon.com");
		String homePageTitle = "Amazon.com. Spend less. Smile more.";
		if (homePageTitle.equals(driver.getTitle())) {
			System.out.println("you are on the right page");
		} else {
			System.out.println("it is not the right page");
		}
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select choose = new Select(dropdown);
		String defaultValue = "All Departments";
		if (choose.getFirstSelectedOption().getText().equals(defaultValue)) {
			System.out.println("Default selected value is valid");
		} else {
			System.out.println("Default selected value is not valid");
		}

	}

	public static void case1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://amazon.com");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select choose = new Select(dropdown);
		List<WebElement> list = choose.getOptions();
		if (list.size() == 58) {
			System.out.println("There are total of 58 departments");
		} else {
			System.out.println("There are not 58 departments");
		}
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
	}

	public static void alertTestCase3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String text = "sadgsdaeg";
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle = driver.switchTo().alert();
		handle.sendKeys(text);
		handle.accept();
		WebElement greetingTextElement = driver.findElement(By.id("demo"));
		wait.until(ExpectedConditions.visibilityOf(greetingTextElement));
		String greetingText = greetingTextElement.getText();
		if (greetingText.equals("Hello " + text + "! How are you today?")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

	}

	public static void amazonSelect() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");

		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		if (driver.getTitle().equals(expectedTitle)) {

			System.out.println("We are on the Home page!");
		} else {
			System.out.println("We are not on the home page");
		}
		String defaultDropDownValue = "All Departments";
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

		Select letSelect = new Select(dropDown);
		String actualSelectedOption = letSelect.getFirstSelectedOption().getText();
		if (actualSelectedOption.equals(defaultDropDownValue)) {
			System.out.println("Defult dropdown value matches");
		} else {
			System.out.println("Defult dropdown value does not match");
		}

		String searchItem = "coffee mug";
		letSelect.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
		driver.findElement(By.id("nav-search-submit-button")).click();
		String itemPageTitle = driver.getTitle();
		int beginningIndex = itemPageTitle.length() - searchItem.length();
		if (itemPageTitle.substring(beginningIndex).equals(searchItem)) {
			System.out.println("Search item title match");
		} else {
			System.out.println("Search item title does not match");
		}
		WebElement dropDown2 = driver.findElement(By.id("searchDropdownBox"));
		Select letSelect2 = new Select(dropDown2);
		String actualSelectedOption2 = letSelect2.getFirstSelectedOption().getText();
		if (actualSelectedOption2.equals("Home & Kitchen")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}
}
