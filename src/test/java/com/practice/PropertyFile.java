package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("..\\SDETHYD_1\\commond.properties");
		
		Properties prop =new Properties();
		prop.load(fis);
		String value = prop.getProperty("username");
		System.out.println(value);
		
	}

}
