package exotica.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driver =new Driver();
		
		//step 1:Register the driver
		DriverManager.registerDriver(driver);
		
		//step 2:Get the connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//step 3: issue create the query
		Statement state= con.createStatement();
		
		//step 4: Execute the query
		ResultSet result= state.executeQuery("select * from customerinfo;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}

		//step 5: Close the database
				
		con.close();
	}

}
