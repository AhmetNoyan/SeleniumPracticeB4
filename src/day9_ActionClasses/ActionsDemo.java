package day9_ActionClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;

public class ActionsDemo {
	public static void main(String[] args) throws InterruptedException {

		//testCase1();
		// dragAndDropDemo();
		// dragAndDropHomeWork();
	}

	public static void dragAndDropHomeWork() throws InterruptedException {
		Actions letsdo = new Actions(Driver.getDriver());
		Driver.getDriver().get("http://practice.primetech-apps.com/practice/drag-and-drop");
		boolean isDisplayed = Driver.getDriver().findElement(By.xpath("//h3[text()='Drag And Drop']")).isDisplayed();
		if (isDisplayed) {
			System.out.println("Drag And Drop text is not displayed");
		} else {
			System.out.println("there is something wrong");
		}
		WebElement source = Driver.getDriver().findElement(By.id("text"));
		WebElement source1 = Driver.getDriver().findElement(By.id("textarea"));
		WebElement source2 = Driver.getDriver().findElement(By.id("Number"));
		WebElement targetElement = Driver.getDriver().findElement(By.id("dropzone"));
		letsdo.dragAndDrop(source, targetElement).perform();
		Thread.sleep(1000);
		letsdo.dragAndDrop(source1, targetElement).perform();
		Thread.sleep(1000);
		letsdo.dragAndDrop(source2, targetElement).perform();
		Thread.sleep(1000);
		List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//i[@class='bi bi-trash']"));
		for (WebElement webElement : elements) {
			webElement.click();
		}
		System.out.println("Test Has been completed");
		Driver.quitDriver();
	}

	public static void dragAndDropDemo() {
		Actions letsdo = new Actions(Driver.getDriver());
		Driver.getDriver().get("http://practice.primetech-apps.com/practice/drag-and-drop");
		WebElement source = Driver.getDriver().findElement(By.id("text"));
		WebElement targetElement = Driver.getDriver().findElement(By.id("dropzone"));
		letsdo.dragAndDrop(source, targetElement).perform();
		Driver.quitDriver();
	}

	public static void testCase1() throws InterruptedException {

		Actions letsdo = new Actions(Driver.getDriver());

		Driver.getDriver().get("https:/etsy.com");
		WebElement jeweleryTab = Driver.getDriver()
				.findElement(By.xpath("//span[contains(text(),'Jewelry & Accessories')]"));
		letsdo.moveToElement(jeweleryTab).build().perform();
		Thread.sleep(1000);
		WebElement bagsPurses = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Bags & Purses')][1]"));
		letsdo.moveToElement(bagsPurses).build().perform();
		Thread.sleep(1000);
		WebElement shoulderBags = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Shoulder Bags')]"));
		letsdo.moveToElement(shoulderBags).build().perform();
		Thread.sleep(1000);
		shoulderBags.click();

		if (Driver.getDriver().findElement(By.xpath("//h1[text()='Shoulder Bags']")).isDisplayed()) {
			System.out.println("We are on the Shoulder Bags page");
		} else {
			System.out.println("Something wrong");
		}
		Driver.quitDriver();
	}
}
