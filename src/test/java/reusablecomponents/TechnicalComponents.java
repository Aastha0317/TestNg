package reusablecomponents;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import config.FrameworkException;
import config.TestSetup;

public class TechnicalComponents extends TestSetup {

	public static void navigatetoUrl(String url) {
		try {
			if (url != "") {
				driver.get(url);
				Thread.sleep(2000);

			} else {
				throw new FrameworkException("Please enter the URL in config.");
			}

		} catch (Exception e) {
			throw new FrameworkException(
					"Unable to navigate to URL--- " + url + "---" + e.getClass() + "---" + e.getMessage());
		}
	}


	public static void type(WebElement element, String text, String desc) {
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					waitTill(2);
					element.sendKeys(text);
					waitTill(1);
				}
			}
		} catch (NoSuchElementException e) {

			throw new FrameworkException("Field " + desc + " not found.");

		}
	}

	public static void waitTill(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {

		}
	}

	public static void click(WebElement element, String desc) {
		try {
			element.click();
		} catch (Exception e) {
			throw new FrameworkException("Unknown exception occured : "+ e.getClass() + "---" + e.getMessage());
		}
		
	}

}