package exotica.practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exotica.GenericUtility.ExelFileUtility;

public class DataProviderPractice {
	
	@Test(dataProvider = "OrgName")
	public void addProductToCartTest(String OrgName,String Industry)
	{
		System.out.println(OrgName+"-"+Industry);
	}
	/*@DataProvider(name = "product")
	public Object[][] data()
	{
		Object[][] d=new Object[4][5];
		
		d[0][0]="samsung";
		d[0][1]="A50";
		d[0][2]=24000;
		d[0][3]="Camera";
		d[0][4]=12;
		
		d[1][0]="oppo";
		d[1][1]="r8";
		d[1][2]=29990;
		d[1][3]="Selfi cam";
		d[1][4]=13;
		
		d[2][0]="vivo";
		d[2][1]="x80";
		d[2][2]=85000;
		d[2][3]="Battery";
		d[2][4]=17;
		
		d[3][0]="apple";
		d[3][1]="13 pro";
		d[3][2]=250000;
		d[3][3]="Secure";
		d[3][4]=16;
		
		return d;
	}*/
	
	@DataProvider(name = "OrgName") 
	public Object[][] getData() throws IOException
	{
		ExelFileUtility eUtil=new ExelFileUtility();
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
		
	}

}
