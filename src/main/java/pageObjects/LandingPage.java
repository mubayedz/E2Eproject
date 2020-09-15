package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) { // Constructor 1 argumetno
		this.driver = driver;
		PageFactory.initElements(driver, this); // asi se inicializa el PF
	}
	
	/* PAGE FACTORY*/
	@FindBy(xpath="//input[@placeholder='Enter your Email']")
	WebElement popup;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe Now')]")
	WebElement subscribenow;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement continuee;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement getTitle;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
	WebElement validateHeader;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement Login;
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	WebElement clickLogin;
	
	public WebElement Popup() {
		return popup;
	}
	
	public WebElement Subscribenow() {
		return subscribenow;
	}
	
	public WebElement Continue() {
		return continuee;
	}
	
	public WebElement HeaderExist() {
		return 	validateHeader;
	}
	
	public WebElement GetTitle() {
		return getTitle;
	}
	
	public WebElement Login() {
		return Login;
	}
	
	public WebElement Email() {
		return email;
	}
	
	public WebElement Password() {
		return password;
	}
	
	public WebElement ClickLogin() {
		return clickLogin;
	}
	
}
