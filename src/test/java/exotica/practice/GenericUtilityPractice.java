package exotica.practice;

import java.io.IOException;

import exotica.GenericUtility.ExelFileUtility;
import exotica.GenericUtility.JavaUtility;
import exotica.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		JavaUtility jLib = new JavaUtility();
		int ra =jLib.getRandomNumber();
		System.out.println(ra);
		String date = jLib.getSystemDate();
		System.out.println(date);
		String d=jLib.getSystemDateInFormat();
		System.out.println(d);
		
		PropertyFileUtility pLib= new PropertyFileUtility();
		String b= pLib.readDataFromPropertyFile("browser");
		System.out.println(b);
		
		ExelFileUtility eLib =new ExelFileUtility();
		String data=eLib.readDataFromExcel("Organization", 1, 2);
		System.out.println(data);
		eLib.writeDataIntoExcel("Organization", 3, 7, "Nag");
		System.out.println("Data added");

	}

}
