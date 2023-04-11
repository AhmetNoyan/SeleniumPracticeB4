package day7;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropdown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		nonSelectDropdown();
	}

	public static void dropDown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));

		Select choose = new Select(selectElement);
		System.out.println(choose.getFirstSelectedOption());
		choose.selectByVisibleText("Home & Kitchen");
		Thread.sleep(1000);
		choose.selectByIndex(1);

		List<WebElement> list = choose.getOptions();
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
	}

	public static void nonSelectDropdown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement dropdown=driver.findElement(By.xpath("(//div[@class='ui fluid selection dropdown'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		dropdown.click();
		//Thread.sleep(1000);
		WebElement mattOption=driver.findElement(By.xpath("//div[@data-value='matt']"));
		wait.until(ExpectedConditions.visibilityOf(mattOption));
		mattOption.click();
	}
	
	public static void alertDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
	}

}
