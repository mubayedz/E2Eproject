package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
static ExtentReports extent; // this is a global variable
	
	@BeforeTest
	public static ExtentReports getReportObject() {
		// ExtentReports, ExtentSparkReporter
	 String path = System.getProperty("user.dir")+"\\reports\\index.html";
	 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	 reporter.config().setReportName("Web Automation Result");
	 reporter.config().setDocumentTitle("Test Results");
	 
	 //ExtentReports extent = new ExtentReports();
	 extent = new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Test", "Juan Bermudez");
	 return extent;
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Initial demo"); // croe el reporte
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubayed\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.google.com");
	    System.out.println(driver.getTitle());
	    driver.close();
	    test.addScreenCaptureFromBase64String("Picture");
	    extent.flush(); // con esto cierro el reporte
	}

}
