package day10_ReusableObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Driver;

public class Reusable {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver",
//				"C:/Users/noyan.ahmet/Desktop/SeleniumWork/chromedriver_win32/chromedriver.exe");
		Reusable obj=new Reusable();
		obj.testcase1();
		obj.testcase2();
	}

	//WebDriver driver;// we declare here

	public void testcase1() {
		
		Driver.getDriver().get("https://facebook.com");
		
		Driver.getDriver().findElement(By.name("email")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("pass")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("login")).click();
		Driver.getDriver().quit();
		Driver.quitDriver();
		
	}
	public void testcase2() {
		
		Driver.getDriver().get("https://facebook.com");
		
		Driver.getDriver().findElement(By.name("email")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("pass")).sendKeys("automation");
		Driver.getDriver().findElement(By.name("login")).click();
		Driver.quitDriver();
		
	}
}
