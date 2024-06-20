package exotica.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {
	
	public static void main(String[] args) throws IOException {
		
		//step 1: load the file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//step 2: create object of properties 
		Properties pObj=new Properties();
		
		//step 3: load the file to properties obj
		pObj.load(fis);
		
		//step 4: read data through key
		String BROWSER= pObj.getProperty("browser");
		System.out.println(BROWSER);
		String URL=pObj.getProperty("url");
		System.out.println(URL);
		String USERNAME=pObj.getProperty("username");
		System.out.println(USERNAME);
		String PASSWORD=pObj.getProperty("password");
		System.out.println(PASSWORD);
	}

}
