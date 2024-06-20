package exotica.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver();
		Connection con=null;
		try
		{
		//step 1:Register the driver
		DriverManager.registerDriver(driver);
		//step 2:Get the connection with database
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		//step 3:issue create the query
		Statement state=con.createStatement();
		//step 4: Execute the Query
		String query="insert into customerinfo(name,id,address) values('Arjun',10,'KPHB')";
		int result=state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data inserted");
		}
		else 
		{
			System.out.println("Data not inserted");
		}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
		//step 5: close database
		con.close();
		System.out.println("database closed");
		}
	}

}
