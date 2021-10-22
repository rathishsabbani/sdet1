package Objectrepo;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility { 
	
		/**
		 * @throws Throwable 
		 * 
		 */
		public String readData(String key) throws Throwable
		
		{
			FileInputStream fis = new FileInputStream("..\\SDETHYD11\\commond.properties");

			Properties prop = new Properties();
			prop.load(fis);

			return prop.getProperty(key);
		}


	}



