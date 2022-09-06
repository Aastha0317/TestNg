package objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import reusablecomponents.TechnicalComponents;

public class AddCategory {

	private final WebDriver driver;
	WebDriverWait wait;
	String [] months = {"None","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

	public AddCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	@FindBy(name = "categorydata")
	WebElement categoryName;

	@FindBy(xpath = "//input[@value='Add category']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[@class='controls']/a/span")
	List<WebElement> categoryList;
	
	@FindBy(xpath="//body")
	WebElement duplicateMessage;
	
	@FindBy(xpath="//select[@name='due_month']/option")
	List<WebElement> calMonthList;
	

	public void addCategory(String name) {
		wait.until(ExpectedConditions.visibilityOf(categoryName));
		TechnicalComponents.type(categoryName, name, "category");
		TechnicalComponents.click(submitBtn, "submit button");
	}

	public void navigateURL(String url) {
		TechnicalComponents.navigatetoUrl(url);
	}
	
	public void verifyCategoryAdded(String name) {
		for (int i = 0; i < categoryList.size(); i++) {
				if (categoryList.get(i).getText().trim().equalsIgnoreCase(name)) {
				Assert.assertTrue(categoryList.get(i).getText().trim().equalsIgnoreCase(name));
				System.out.println("Category successfully added");
				}
				
		}
	}
	
	public void verifyDuplicateMessage(String name) {
		addCategory(name);
		TechnicalComponents.waitTill(4);
		Assert.assertTrue(duplicateMessage.getText().contains("The category you want to add already exists: "+name));
	}
	
	public void verifyMonthList() {
	
		for(int i=0;i<calMonthList.size();i++)
		{
			 System.out.println(calMonthList.get(i).getText());  
			    Assert.assertEquals(months[i], calMonthList.get(i).getText());
			
		}
	}
}
