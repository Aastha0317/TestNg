package testScript;

import org.testng.annotations.Test;

import config.FrameworkException;
import objectRepo.AddCategory;
import reusablecomponents.TechnicalComponents;
import com.github.javafaker.Faker;

public class TestCategory extends TechnicalComponents {

	@Test
	public void testCategory() {
		Faker fake = new Faker();

		String name = "DemoCategory_" + fake.name().firstName();
		try {
			String homePage = "https://techfios.com/test/101/";

			AddCategory cat = new AddCategory(driver);
			cat.navigateURL(homePage);
			cat.addCategory(name);
			cat.verifyCategoryAdded(name);

		} catch (Exception e) {
			throw new FrameworkException("Exception  " + e.toString() + " occurred");
		}
	}

	@Test
	public void testMessageForDuplicateCategory() {

		Faker fake = new Faker();

		String name = "Demo_" + fake.name().firstName();
		try {
			String homePage = "https://techfios.com/test/101/";

			AddCategory cat = new AddCategory(driver);
			cat.navigateURL(homePage);
			cat.addCategory(name);
			cat.verifyDuplicateMessage(name);

		} catch (Exception e) {
			throw new FrameworkException("Exception  " + e.toString() + " occurred");
		}
	}
	
	@Test
	public void testMonthList() {
		
		try {
			String homePage = "https://techfios.com/test/101/";

			AddCategory cat = new AddCategory(driver);
			cat.navigateURL(homePage);
			cat.verifyMonthList();

		} catch (Exception e) {
			throw new FrameworkException("Exception  " + e.toString() + " occurred");
		}
	}
	
}
