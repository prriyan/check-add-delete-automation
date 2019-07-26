package company.samuel.run;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task {
 WebDriver driver;
	@Test
	public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test(dependsOnMethods = {"openBrowser"})
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		Actions s=new Actions(driver);
		s.moveToElement(driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule"))).build().perform();
		s.moveToElement(driver.findElement(By.id("menu_leave_Configure"))).build().perform();
		driver.findElement(By.xpath("//a[@id='menu_leave_leaveTypeList']")).click();
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		driver.findElement(By.id("leaveType_txtLeaveTypeName")).sendKeys("aarani");
		driver.findElement(By.id("saveButton")).submit();
		
		WebElement s1 = driver.findElement(By.xpath("//*[text()=\"aarani\"]"));
		if(s1.isDisplayed())
		System.out.println("New LeaveType Added Successfuly");
		
		else
			System.out.println("False");
			
		driver.findElement(By.xpath("//a[text()='aarani']//parent::td//preceding-sibling::td//child::input[@name='chkSelectRow[]']")).click();
		driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"dialogDeleteBtn\"]")).click();
//		WebElement s2 = driver.findElement(By.xpath("//a[text()='aarani']"));
//		if(s2.isDisplayed())
//			System.out.println("Deleted Successfuly");
//		else
//			System.out.println("New LeaveType Deleted Successfuly");
//		String text=s2.getText();
//		String expectedText = "aarani";
//		Assert.assertEquals(text,expectedText);
//		if(s2.isDisplayed())
//			System.out.println("New LeaveType Deleted Successfuly");
//			
//			else
//				System.out.println("False");
	}
}
	
		
//public boolean isListElementsVisible(WebDriver driver, By id) {
//		    boolean result = false;
//		    try {
//		        WebDriverWait wait = new WebDriverWait(driver, 30);
//		        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(id);
//		        result = true;
//		    } catch (Exception e) {
//		        System.out.println(e.getMessage());
//		        result = false;
//		    }
//		   return result;
//		}
//}

//		WebElement element = driver.findElement(By.xpath("//a[@href='https://opensource-demo.orangehrmlive.com/index.php/leave/defineLeaveType?id=5']//parent::td[@class='left']"));
//
//		WebDriverWait wait = new WebDriverWait(driver,10);
//	
//		wait.until(ExpectedConditions.visibilityOf(By.xpath("//a[@href='https://opensource-demo.orangehrmlive.com/index.php/leave/defineLeaveType?id=5']//parent::td[@class='left']"));
//		String expectedTitle="priya";
//		String Actual="";
//
//		Actual=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
//		if(Actual.contentEquals(expectedTitle))
//		{
//		System.out.println("name created");

	


