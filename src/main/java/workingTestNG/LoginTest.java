package workingTestNG;
/*I CREATED THIS PROJECT SO THAT I CAN BE ABLE TO TRABLE SHOUT THE PROBLEMS WITH SESSION 5. 
 I SOLVED DRIVER PATH ISSUES AND POM ISSUE. */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	By USERNAME =By.xpath("//*[@id=\"username\"]");
	By PASSWORD = By.xpath("//*[@id=\"password\"]");
	By LOGIN = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]");
	String userName = "demo@techfios.com";
	String passWord = "abc123";
	String exp = "Dashboard";

	WebDriver driver;
	
	@BeforeMethod
	public void inti() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void login() {
		driver.findElement(USERNAME).sendKeys(userName);
		driver.findElement(PASSWORD).sendKeys(passWord);
		driver.findElement(LOGIN).click();
		Assert.assertEquals(driver.findElement(DASHBOARD).getText(), exp, "Page not found");
	}
//	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}
	}

