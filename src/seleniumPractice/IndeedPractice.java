package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedPractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		test1();
	}

	public static void test1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.indeed.com/");
		driver.manage().window().maximize();
		String searchCriteria = "Software Developer";
		String where = "Washington DC";
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		driver.findElement(By.xpath("//input[@placeholder='Job title, keywords, or company']"))
				.sendKeys(searchCriteria);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-labelledby='label-text-input-where']")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath("//input[@aria-labelledby='label-text-input-where']")).sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-labelledby='label-text-input-where']")).sendKeys(where);
		driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		Thread.sleep(2000);
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();

		if (!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {

			System.out.println("URL and search criteria pass");
		} else {
			System.out.println("URL and search criteria fail");
		}
		if (!searchTitle.equals(homeURL) && searchTitle.contains(searchCriteria)) {

			System.out.println("Title and search criteria pass");
		} else {
			System.out.println("Title and search criteria fail");
		}

		String location = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
//		
		String search=location.substring(0,searchCriteria.length());
		
	
		System.out.println(search);
		
		if(searchCriteria.equals(search) && !homeTitle.equals(searchTitle)) {
			
			System.out.println("Title and sarch field pass");
		}else {
			System.out.println("Location field fail!");
		}
		driver.quit();
		
//		
	}
}
