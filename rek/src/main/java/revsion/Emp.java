package revsion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Emp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery("select name, designation from employee");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		con.close();
	}

}
