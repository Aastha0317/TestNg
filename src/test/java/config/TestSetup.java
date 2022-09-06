package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSetup {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Throwable {

		driver = null;
		driver = OpenBrowser();

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		driver.quit();

	}

	public static WebDriver OpenBrowser() {
		WebDriver localDriver = null;

		String platform = System.getProperty("os.name");
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "Drivers/" + "chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		localDriver = new ChromeDriver(cap);

		return localDriver;
	}

	public static void closeBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();

		}
	}

}