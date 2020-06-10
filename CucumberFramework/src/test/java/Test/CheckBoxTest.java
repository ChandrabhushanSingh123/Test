package Test;

//import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.Assert;

public class CheckBoxTest {
	private static final int List = 0;
	private static final int WebElement = 0;
	private static WebDriver driver;

	public static void main(String[] args) throws Exception {
		//ChromeOptions cap = new ChromeOptions();
		//cap.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#checkBoxOption2")).click();
	    String text=driver.findElement(By.cssSelector("#checkBoxOption2")).getAttribute("value");
	    System.out.println(text);
	    WebElement  dropDown=driver.findElement(By.cssSelector("#dropdown-class-example"));
	    Select sl=new Select(dropDown);
	    sl.selectByValue(text);
	  //  sl.selectByVisibleText(text);
	    driver.findElement(By.cssSelector("#name.inputs")).sendKeys(text);
	    driver.findElement(By.cssSelector("#alertbtn.btn-style")).click();
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	 
	    driver.quit();
	}
	
	}

