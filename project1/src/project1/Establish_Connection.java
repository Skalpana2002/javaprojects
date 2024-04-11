package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Establish_Connection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish connection
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		 
		 System.out.println("connection established");
	}

}