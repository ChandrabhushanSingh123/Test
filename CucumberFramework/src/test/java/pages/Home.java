
package pages;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home   {
	
	 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	 ChromeDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// WebElement billcountry=driver.findElement(By.id("billing_state"));
	 driver.get("https://www.dictionary.com/browse/words?s=t");
	 Thread.sleep(5000);
	// List<WebElement> items = driver.findElements(By.cssSelector("[class='css-kg6o37 e1q3nk1v3']"));
	 List<WebElement> items = driver.findElements(By.cssSelector(".default-content"));
	 
	 System.out.println(items.size());
	// for(int i = 0;i<items.size();i++)
	 //  {
		 System.out.println(items.size());
		 System.out.println(items.get(0).getText());
		 
	 //   }
	 
	 }
}
/*  @FindBy(css = ".noo-product-inner")
	WebElement first1;
	
	public String getLogoText() {
		return first1.getText();
	}
	
	
	@FindBy(how = How.XPATH,using = "/body/name")
	WebElement first;
	
	@FindBy(xpath = "")
	WebElement loginButton1;
	
	@FindBy(id = "")
	WebElement loginButton2;
	
	@FindBy(name = "")
	WebElement loginButton3;
	
	@FindBy(linkText =  "")
	WebElement loginButton4;
	
	@FindBy(partialLinkText =  "")
	WebElement loginButton6;
	*/
	
	
