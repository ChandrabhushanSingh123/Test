package seleniumTests;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import pages.Home;

public class SeleniumTest {
	
	@FindBy(id="country")
	WebElement countryDropdon;

	private static final int List = 0;
	private static final int WebElement = 0;
	private static WebDriver driver;
	 
	 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://www.shop.demoqa.com");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
	 //String myTdext = new Home().getLogoText();
	 List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
	 System.out.println(items.size());
	items.get(0).click();
	
	Select selcol= new Select(driver.findElement(By.cssSelector("select#pa_color")));
	selcol.selectByVisibleText("White");
	
	Select selsize=new Select(driver.findElement(By.cssSelector("select#pa_size")));
	selsize.selectByIndex(3);
	//driver.findElement(By.cssSelector("a.reset_variations")).click();
	driver.findElement(By.cssSelector(".icon_plus")).click();
	WebElement addToCart=driver.findElement(By.cssSelector(".single_add_to_cart_button"));
	addToCart.click();
	
	WebElement view=driver.findElement(By.cssSelector(".cart-name-and-total"));
	view.click();
	driver.findElement(By.cssSelector(".checkout-button.alt")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("input#billing_first_name.input-text")).sendKeys("Lakshay");
	driver.findElement(By.cssSelector("input#billing_last_name.input-text")).sendKeys("sharma");
	driver.findElement(By.cssSelector("input#billing_company.input-text")).sendKeys("XYZ");
	//driver.findElement(By.cssSelector("span.select2-selection__arrow")).click();
	//driver.findElement(By.cssSelector("span#select2-billing_country-container.select2-selection__rendered")).click();
	Thread.sleep(5000);
//	WebElement cuontry=driver.findElement(By.cssSelector("span#select2-billing_country-container.select2-selection__rendered"));
	WebElement cuontry =driver.findElement(By.id("billing_country"));
	Select dropdown=new Select(cuontry);
	dropdown.selectByValue("ES");
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("input#billing_address_1.input-text")).sendKeys("Shalimar Bagh");
	driver.findElement(By.cssSelector("input#billing_city.input-text")).sendKeys("Delhi");
	driver.findElement(By.cssSelector("input#billing_postcode.input-text")).sendKeys("711191");
	
	WebElement billcountry=driver.findElement(By.id("billing_state"));
	Select billdrpdwn=new Select(billcountry);
	billdrpdwn.selectByValue("VI");
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("input#billing_phone.input-text")).sendKeys("07447876155");
	driver.findElement(By.cssSelector("input#billing_email.input-text")).sendKeys("test@gmail.com");
	WebElement termandcond=driver.findElement(By.cssSelector("input#terms.woocommerce-form__input.woocommerce-form__input-checkbox.input-checkbox"));
	termandcond.click();
	// WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
	// placeOrder.submit();
	 
	 //driver.quit();
	
	/* 	 WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
	 cart.click();
	 
	 WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
	 continueToCheckout.click(); 
	 
	 
	 Thread.sleep(5000);
	 WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
	 firstName.sendKeys("Lakshay");
	 
	 WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
	 lastName.sendKeys("Sharma");
	 
	 WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
	 emailAddress.sendKeys("test@gmail.com");
	 
	 WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
	 phone.sendKeys("07438862327");
	 
	 WebElement countryDropDown = driver.findElement(By.cssSelector("#billing_country_field .select2-arrow"));
	 countryDropDown.click();
	 Thread.sleep(2000);
	 
	 List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
	 for(WebElement country : countryList){
	 if(country.getText().equals("India")) {
	 country.click(); 
	 Thread.sleep(3000);
	 break;
	 } 
	 }
	 
	 WebElement city = driver.findElement(By.cssSelector("#billing_city"));
	 city.sendKeys("Delhi");
	 
	 WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
	 address.sendKeys("Shalimar Bagh");
	 
	 WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
	 postcode.sendKeys("110088"); 
	 
	 WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
	 shipToDifferetAddress.click();
	 Thread.sleep(3000);
	 
	 List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
	 paymentMethod.get(0).click();
	 
	 WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
	 acceptTC.click();
	 
	 WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
	 placeOrder.submit();
	 
	 driver.quit();
	 */
	 
	 }
}
