package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelData {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis  = new FileInputStream ("..\\SDETHYD_1\\assign.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String excelvalue = wb.getSheet("Sheet1").getRow(0).getCell(1).toString();
		System.out.println(excelvalue);
	//}
	
	//public static void Properties() throws Throwable{
		
		//Properties pro = new Properties();
		
		//pro.load(fis);
		//String value = pro.getProperty("browser");
		//System.out.println(value);
		
		
	}

}
