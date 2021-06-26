package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	
	
	static Connection connection;
	static Statement statement;
	static ResultSet resultset;
	static String updateQuery = "UPDATE records SET open_date='2021-04-20', close_date='2021-05-10' WHERE id=1";
	
	public static void main(String[] args) throws SQLException {
	
		connection = DriverManager.getConnection(
				"jdbc:mysql://database-1.cbf9mjnqgnfr.us-east-2.rds.amazonaws.com:3306/stock_trading_tracker", "admin", "Password123!");
		
		System.out.println("DB connection established.");
		
		statement = connection.createStatement();
		statement.executeUpdate(updateQuery);
		
		connection.close();
		
		//jdbc:mysql://databaseURL:port/databaseName, username, password
	}
	

}
