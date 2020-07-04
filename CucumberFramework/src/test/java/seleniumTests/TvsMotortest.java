package seleniumTests;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Test.DataDriven;
//import scala.collection.Set;

public class TvsMotortest {

	// FileOutputStream out=null;
//	@Test
	public static void main(String[] args) throws InterruptedException {

		DataDriven data = new DataDriven();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tvsmotor.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/ul/li[2]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.visitWebsite")));
		driver.findElement(By.cssSelector("div.visitWebsite")).click();
		Thread.sleep(10000);

		String mywindow = driver.getWindowHandle();
		java.util.Set<String> allhandles = driver.getWindowHandles();

		for (String s : allhandles) {
			if (s != mywindow) {
				driver.switchTo().window(s);
			}
		}

		Thread.sleep(5000);
		// other Xpath for below element (//ul[@class='nav navbar-nav'])[2]
		// //a[text()='PRICE']
		driver.findElement(By.xpath("(//ul[@class='nav navbar-nav'])[2]//li/a[text()='PRICE']")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='priceTable']//dl"));

		int rowCount = rows.size();
		System.out.println("Row count is:" + " " + rowCount);
		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet("Vehichle Info");
		//XSSFSheet spreadsheet = workbook.getSheetAt(0);
		// Create row object
		XSSFRow row;
		// This data needs to be written (Object[])
		Map<Integer, Object[]> Vehchileinfo = new TreeMap<Integer, Object[]>();

		for (int i = 1; i < rowCount; i++) {

			List<WebElement> memodelType = driver
					.findElements(By.xpath("(//div[@class='priceTabel'])//dl//dt[@class='col-xs-7']"));
			// System.out.println(memodelType.get(i).getText());
			String a = memodelType.get(i).getText();
			System.out.println(a);
			List<WebElement> modelprice = driver
					.findElements(By.xpath("(//div[@class='priceTabel'])//dl//dd//span[@class='productAmount']"));
			String b = modelprice.get(i - 1).getText();
			System.out.println(b);
			//Hardcoding the header value
			Vehchileinfo.put(0, new Object[] { "ModelType", "Price" });
			Vehchileinfo.put((i), new Object[] { a, b });

		}
		
		// Iterate over data and write to sheet
					Set<Integer> keyid = Vehchileinfo.keySet();
					int rowid = 0;

					for (Integer key : keyid) {
						row = spreadsheet.createRow(rowid++);
						Object[] objectArr = Vehchileinfo.get(key);
						int cellid = 0;

						for (Object obj : objectArr) {
							Cell cell = row.createCell(cellid++);
							cell.setCellValue((String) obj);
						}
					}
					// Write the workbook in file system
					FileOutputStream out = null;
					try {
						out = new FileOutputStream(new File("C:\\Users\\CHA\\OutPutFile.xlsx"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					try {
						workbook.write(out);
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Writesheet.xlsx written successfully");
	}

	/*
	 * for(int i=0;i<rowCount-1;i++) { List<WebElement>
	 * memodelType=driver.findElements(By.xpath(
	 * "(//div[@class='priceTabel'])//dl//dt[@class='col-xs-7']"));
	 * System.out.println(memodelType.get(i+1).getText());
	 * 
	 * List<WebElement> modelprice=driver.findElements(By.xpath(
	 * "(//div[@class='priceTabel'])//dl//dd//span[@class='productAmount']"));
	 * System.out.println(modelprice.get(i).getText());
	 * data.getdata(memodelType.get(i+1).getText(), modelprice.get(i).getText()); }
	 * 
	 * //(//div[@class='priceTabel'])//dl//dt[@class='col-xs-7']
	 * 
	 * // (//div[@class='priceTabel'])//dl//dd//span[@class='productAmount']
	 * System.out.println(rowCount);
	 * 
	 * driver.switchTo().defaultContent();
	 */
}
