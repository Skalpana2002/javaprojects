package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creating_database {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		
		//create a statement
		Statement sat=	con.createStatement();
		
		//execute the query
		sat.execute("create a database school");
		
		System.out.println("database created");
		
		//close connection
		con.close();
	}

}
