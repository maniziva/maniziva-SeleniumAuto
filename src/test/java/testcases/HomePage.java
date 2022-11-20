package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.HomePageObjects;

public class HomePage extends HomePageObjects {
	static Logger logger = Logger.getLogger(HomePage.class);

	@Test
	public void HomePageElementcheck() throws IOException {
		PageFactory.initElements(driver, HomePageObjects.class);
		loadPropertyFile();
		String name = properties.getProperty("username");

		HomePageObjects.name.click();
		HomePageObjects.name.sendKeys(name);
		logger.info("Username:" + name + " was feeded on name element");
	}
}
