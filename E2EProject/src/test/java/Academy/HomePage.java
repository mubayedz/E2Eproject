package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.*;
// hereda los metodos de base
public class HomePage extends base {
	public WebDriver driver; // this make run the test in paralell
	public static Logger log = LogManager.getLogger(base.class.getName());
	/*@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}*/
	
	@Test(dataProvider ="getData")  /// dependiendo de la matriz se colocan argumentos en el metodo void
	public void basePageNavigation(String Username,String Password, String text, String pizza) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LandingPage rd = new LandingPage(driver);
		rd.Popup().sendKeys("hola@gmail.com");
		rd.Subscribenow().click();
		rd.Continue().click();
		rd.Login().click();
		rd.Email().sendKeys(Username); // con esto puedo enviar varios correos
		rd.Password().sendKeys(Password); // con esto puedo enviar varias claves
		log.info(text);
		rd.ClickLogin().click();
		System.out.println("pizza");
		driver.close();
		
	}
	
	/*@AfterTest
	public void Close() {
		driver.close();
	}*/
	
	// con esto ejecuto varios test cases
	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// coloumn stands for how many values per each test
		Object[][] data = new Object[2][4]; // 2 es la columna y 4 son las filas
		//0th row
		data[0][0]="akakkaakkaka@gmail.comm";
		data[0][1]="12345";
		data[0][2]="Restricted User";
		data[0][3]="Pizza de Jamon";
		
		//1st row
		data[1][0]="pizza@gmail.comm";
		data[1][1]="12345";
		data[1][2]="Non Restricted User";
		data[1][3]="Pizza de Queso";
		return data;
		
	}

}
