package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

public class BaseTest extends Driver {

	public static WebDriver driver;
	public String url = ReadPropertiesFile.config.getProperty("url");
	public String browser = ReadPropertiesFile.config.getProperty("browser");
	public BasePage app;

	@BeforeClass
	public void setUp() {

		driver = initDriver(browser);
		Log.info("Started suite on: " + browser);
		driver.get(url);
		Log.info("Opened URL: " + url);
		app = new BasePage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Log.info("Closed all browsers tabs");
	}

	@AfterMethod(alwaysRun = true)
	public void recordFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {

			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			try {
				Files.copy(picture, new File("screenshots/" + result.getName() + "__" + timeStamp + ".png"));
				System.out.println("Picture saved");
			} catch (IOException e) {
				System.out.println("Picture could not be saved");
				e.printStackTrace();
			}
		}
	}

}
