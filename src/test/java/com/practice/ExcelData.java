package com.practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelData {


	public String readDatafromExcel(int row ,int cell,String sheetname) throws Throwable, Throwable {
		
		FileInputStream fis  = new FileInputStream ("..\\SDETHYD_1\\assign.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String excelvalue = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	//}
		return excelvalue;
	
	//public static void Properties() throws Throwable{
		
		//Properties pro = new Properties();
		
		//pro.load(fis);
		//String value = pro.getProperty("browser");
		//System.out.println(value);
		
		
	}

}
