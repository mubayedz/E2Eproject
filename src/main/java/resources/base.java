package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver; // global variable
	public Properties prop;

// SCRIPT TO CHANGE THE BROWSER EASILY
	public WebDriver initializeDriver() throws IOException {
		// en el archivo data.properties tengo el browser que voy a ejecutar
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		// mvn test -Dbrowser=chrome >> maven con esto elijo el brwoser donde lanzo la
		// prueba
		String browserName = System.getProperty("browser"); // >> maven se tiene que parametrizar en jenkins sino no
															// sirve
		// String browserName = prop.getProperty("browser"); // >> jenkins
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			// execute in chrome driverC:\Users\mubayed\Desktop
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubayed\\Desktop\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				// mvn test -Dbrowser=chromeheadless este es el comando para lanzar los test desde la consola sin que tenga que abrir los navegadores
				options.addArguments("headless");}
				driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			// execute firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mubayed\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			// execute IE
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
