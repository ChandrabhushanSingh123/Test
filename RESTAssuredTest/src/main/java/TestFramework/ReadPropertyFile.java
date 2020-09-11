package TestFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadPropertyFile {
	
	@Test
	public void printval() {
		System.out.println(getProperty("HOST"));
	}
	public static String getProperty(String key) {
		Properties prop=new Properties();
	try {
	FileInputStream fis;
	fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\TestFramework\\env.properties"));
	prop.load(fis);
	}
	catch(FileNotFoundException ex){
		ex.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop.getProperty(key);
}
}
