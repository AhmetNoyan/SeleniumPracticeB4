package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeTechPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		// test1();
		test2();
	}

	public static void test1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.primetech-apps.com/practice/text-box");

		String firstName = "Ahmet";
		String lastName = "Noyan";
		String email = "automation@gmail.com";
		String password = "sdgsdfbhsrfb";
		String address = "gaithersburg";

		driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[id='lastName']")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@class, 'btn-enable')]")).click();
		driver.findElement(By.cssSelector("textarea[id='address']")).sendKeys(address);
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		
		String actualFirstName = driver.findElement(By.cssSelector("div[class='firstName']")).getText();
		
		String actualLasttName = driver.findElement(By.cssSelector("div[class='lastName']")).getText();
		String actualEmail = driver.findElement(By.cssSelector("div[class='email']")).getText();
		String actualPassword = driver.findElement(By.cssSelector("div[class='password']")).getText();
		String actualAddress = driver.findElement(By.cssSelector("div[class='address']")).getText();

		Thread.sleep(1000);
		if (firstName.equals(actualFirstName)) {
			System.out.println("First name validation, PASS");
		} else {

			System.out.println("First name validation, FAIL");
		}

		if (lastName.equals(actualLasttName)) {
			System.out.println("Last name validation, PASS");
		} else {

			System.out.println("Last name validation, FAIL");
		}
		if (email.equals(actualEmail)) {
			System.out.println("Email validation, PASS");
		} else {

			System.out.println("Email validation, FAIL");
		}
		if (password.equals(actualPassword)) {
			System.out.println("Password validation, PASS");
		} else {

			System.out.println("Password validation, FAIL");
		}
		if (address.equals(actualAddress)) {
			System.out.println("Address validation, PASS");
		} else {
			System.out.println("Address validation, FAIL");

		}
	}

	public static void test2() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		String webTable = driver.findElement(By.xpath("//h3[contains(text(), 'Web')]")).getText();
		if (webTable.equals("Web Tables")) {

			System.out.println("Web Tables Present");
		} else {

			System.out.println("Web Table is not Present");
		}
		String id = "123456789";
		String firstName = "Ahmet";
		String lastName = "Noyan";
		String salary = "100000";
		driver.findElement(By.cssSelector("input[id='Id']")).sendKeys(id);
		driver.findElement(By.cssSelector("input[id='First Name']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[id='Last Name']")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input[id='Salary']")).sendKeys(salary);
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(1000);
		
		String actualId = driver.findElement(By.xpath("//td[contains(text(),'"+id+"')]")).getText();
		String actualFirstName = driver.findElement(By.xpath("//td[contains(text(),'"+firstName+"')]")).getText();
		String actualLastName = driver.findElement(By.xpath("//td[contains(text(),'"+lastName+"')]")).getText();
		String actualSalary = driver.findElement(By.xpath("//td[contains(text(),'"+salary+"')]")).getText();
		
		
		
		
		if(id.equals(actualId)) {
			System.out.println("Id validation, PASS");
			
		}else {
			System.out.println("Id validation, FAIL");
		}
		if(firstName.equals(actualFirstName)) {
			System.out.println("First Name validation, PASS");
			
		}else {
			System.out.println("First Name validation, FAIL");
		}
		if(lastName.equals(actualLastName)) {
			System.out.println("Last Name validation, PASS");
			
		}else {
			System.out.println("Last Name validation, FAIL");
		}
		if(salary.equals(actualSalary)) {
			System.out.println("Salary validation, PASS");
			
		}else {
			System.out.println("Salary validation, FAIL");
		}
		

	}

}
