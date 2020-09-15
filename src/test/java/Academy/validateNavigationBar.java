package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.*;

// hereda los metodos de base
public class validateNavigationBar extends base {
	public WebDriver driver; // this make run the test in paralell
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void basePageNavigation() throws IOException {
		LandingPage rd = new LandingPage(driver);
		rd.Popup().sendKeys("hola@gmail.com");
		rd.Subscribenow().click();
		rd.Continue().click();
		Assert.assertTrue(rd.HeaderExist().isDisplayed()); // este comando verificar si el header existe con los botones
		log.info("Navigation title is displayed");

	}

	@AfterTest
	public void Close() {
		driver.close();
	}

}
