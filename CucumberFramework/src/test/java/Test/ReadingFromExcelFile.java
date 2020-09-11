package Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ReadingFromExcelFile {
	
	//String filePath="C:\\Users\\CHA\\Documents\\InputDataFile.xlsx";
	//String sheetName="Sheet1";
	//public void readExcel(String filePath,String sheetName) throws IOException
	@Test
	public void readExcel() throws IOException {
		String filePath="C:\\Users\\CHA\\Documents\\InputDataFile.xlsx";
		String sheetName="Sheet1";
		FileInputStream fis=null;
		XSSFWorkbook workbook;
		XSSFSheet worksheet;
		try {
			File file = new File(filePath);
			 fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		workbook = new XSSFWorkbook(fis);
		//worksheet = workbook.getSheetAt(0);
		worksheet = workbook.getSheet(sheetName);
		int rowCount = (worksheet.getLastRowNum() - worksheet.getFirstRowNum());
		for(int i=0;i<=rowCount;i++) {
			
			Row row=worksheet.getRow(i);
			int colCount=row.getLastCellNum();
			for(int j=0;j<colCount;j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"||");
			}
			
			System.out.println();
		}
		
	

	}
	/*
	 * public static void main(String[] args) throws IOException{
	 * ReadingFromExcelFile name = new ReadingFromExcelFile(); //String
	 * filePath="C:\\Users\\CHA\\Documents\\InputDataFile.xlsx"; //String
	 * sheetName="Sheet1";
	 * name.readExcel("C:\\Users\\CHA\\Documents\\InputDataFile.xlsx","Sheet1"); }
	 */
	
}
