package revsion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserting_employee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		Statement st = con.createStatement();
		st.executeUpdate("insert into employee values(1,'rekha','sde',3000)");
		st.executeUpdate("insert into employee values(2,'sweth','technical',2000)");
		st.executeUpdate("insert into employee values(3,'rekha','intern',1000)");
		System.out.println("inserted ");
		con.close();
	}

}
