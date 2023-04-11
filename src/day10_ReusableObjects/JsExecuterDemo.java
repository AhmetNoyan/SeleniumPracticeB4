package day10_ReusableObjects;

import org.openqa.selenium.JavascriptExecutor;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class JsExecuterDemo {

	
	public static void main(String[] args) {
		IndeedPage indeedpage=new IndeedPage();
		BrowserUtils utils=new BrowserUtils();
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		utils.clearText(indeedpage.whereField);
		utils.clearText(indeedpage.whatField);
		indeedpage.whatField.sendKeys("SDET");

		indeedpage.searchButton.click();
		JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
		js.executeScript("window.scrollBy(0,400)");
		
	}
	
}
