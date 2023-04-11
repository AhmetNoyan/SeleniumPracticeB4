package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class FaceBookPage {
	
	public FaceBookPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	//@FindBy	(name="name")
	@FindBy(name = "name") 
	public WebElement name;
}
