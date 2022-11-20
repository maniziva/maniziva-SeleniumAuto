package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends BrowserConfig {

	@FindBy(name = "name")
	public static WebElement name;

	@FindBy(name = "email")
	public static WebElement email;
}
