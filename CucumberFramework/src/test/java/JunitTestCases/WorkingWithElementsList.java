package JunitTestCases;

import static org.junit.Assert.*;

import java.util.List;
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



public class WorkingWithElementsList {
	
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
		boolean isSelected=false;
		List<WebElement> radioButtons=driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		int size=radioButtons.size();
		for(int i=0;i<size;i++)
		{
			isSelected=radioButtons.get(i).isSelected();
			if (!isSelected) {
				radioButtons.get(i).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	
	}



}
