package JunitTestCases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsAndCheckBoxes {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void test() {
	WebElement E1=	driver.findElement(By.id("bmwradio"));
	E1.click();
	try {
		Thread.sleep(3000);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement E2=	driver.findElement(By.id("benzradio"));
	E2.click();
	WebElement E3=	driver.findElement(By.id("bmwcheck"));
	E3.click();
	WebElement E4=	driver.findElement(By.id("benzcheck"));
	E4.click();
	
	System.out.println("BMW Radio Button is selected? " + E1.isSelected());
	System.out.println("Benz Radio Button is selected? " + E2.isSelected());
    
	System.out.println("BMW Checkbox is selected? " + E3.isSelected());
	System.out.println("BMW Checkbox is selected? " + E4.isSelected());
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}


}
