package Dictionary;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileWriter;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReadingFromDictionary {
	
	private static final int List = 0;
	private static final int WebElement = 0;
	private static final String String = null;
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedIOException
	{
				
    	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.dictionary.com/browse/words?s=t");
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 String csv = "C:\\Output.csv";
		 CSVWriter writer = null;
		 try {
			writer = new CSVWriter(new FileWriter(csv));
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		 
				String path = "C:\\Input.csv";
				Reader reader = null;
				try {
					reader = new FileReader(path);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			
				CSVReader csvreader = new CSVReader(reader);
				
				List<String[]> data = null;
				try {
					data = csvreader.readAll();
				} catch (IOException e) {	
					e.printStackTrace();
				} catch (CsvException e) {
					e.printStackTrace();
				}
		
				for(String[] d : data){
					
					for(String c : d ){
						
						if (c.startsWith("https"))
						{
						// System.out.println("1");
						 driver.navigate().to(c);
						 try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						 List<WebElement> items = driver.findElements(By.cssSelector(".default-content"));
						 System.out.println(items.get(0).getText());
			     		 String[] text =(items.get(0).getText()).split(",");
						 writer.writeNext(text);
						 
						// System.out.println(c);
						}
						
					}
				}
				 try {
					writer.close();
				    } 
				 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
}
				
			
		
