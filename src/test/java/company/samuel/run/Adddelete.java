package company.samuel.run;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Adddelete {
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
		

}}
