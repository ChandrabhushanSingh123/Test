package JunitTestCases;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicActions {
	
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		System.out.println("Clicked on login");
		WebElement ele=driver.findElement(By.xpath("//iframe[@title='widget containing checkbox for hCaptcha security challenge']"));
		driver.switchTo().frame(ele);
		WebDriverWait wait=new WebDriverWait(driver,6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		driver.findElement(By.id("checkbox")).click();
		driver.findElement(By.id("hcaptcha_submit")).click();
		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("test@email.com");
		System.out.println("Sending keys to username field");
		driver.findElement(By.id("user_password")).sendKeys("test");
		System.out.println("Sending keys to password field");
		driver.findElement(By.id("user_email")).clear();
		System.out.println("Clearing the username field");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}



}
