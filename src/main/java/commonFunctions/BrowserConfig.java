package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserConfig {
	public static WebDriver driver = null;
	public static Properties properties = new Properties();
	Logger logger = Logger.getLogger(BrowserConfig.class);

	public static Properties loadPropertyFile() throws IOException {
		try {
			FileInputStream fp = new FileInputStream("config.properties");
			properties.load(fp);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return properties;
	}

	@BeforeSuite
	public void launch() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		loadPropertyFile();
		String url = properties.getProperty("url");
		String driverLoc = properties.getProperty("driverLoc");
		System.setProperty("webdriver.chrome.driver", driverLoc);

		driver = new ChromeDriver();
		logger.info("Chrome Driver Launched");

		driver.manage().window().maximize();
		driver.get(url);
		logger.info("Target URL Loaded");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		logger.info("Chrome Driver Closed");
	}
}