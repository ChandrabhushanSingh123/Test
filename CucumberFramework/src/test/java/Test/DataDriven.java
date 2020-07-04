package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class DataDriven {
	FileOutputStream fos;
	public FileOutputStream getOutPutFile() {
		
		try {
			fos = new FileOutputStream("C:\\Users\\CHA\\OutPutFile.xlsx");
			// fos;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fos;
		
	}
	
}
