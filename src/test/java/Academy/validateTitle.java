package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;
// hereda los metodos de base
public class validateTitle extends base {
	public WebDriver driver; // this make run the test in paralell
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test  
	public void basePageNavigation() throws IOException {
		LandingPage rd = new LandingPage(driver);
		rd.Popup().sendKeys("hola@gmail.com");
		rd.Subscribenow().click();
		rd.Continue().click();
		// compare the text from the browser with actual text.. -- error... if doesnt match
		Assert.assertEquals(rd.GetTitle().getText(), "FEATURED COURSES"); // con el comando de arriba verifico si el texto es igual o no
		log.info("The title is displayed");
	
		
	}
	@AfterTest
	public void Close() {
		driver.close();
		System.out.println("Bye bye");
	}

}
