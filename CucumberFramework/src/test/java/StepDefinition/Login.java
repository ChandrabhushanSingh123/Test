package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		 ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.tvsmotor.com/");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("#text")).click();
	}
	
	@When("user is login with  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_is_login_with_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Entering  User ID and password:"+string+ " "+string2);
	}

	@Then("Able to login \"([^\"]*)\"$")
	public void able_to_login(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User Status is"+ " " + string);
	}



}
