package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateTheDataToDB {

	public static void main(String[] args) throws SQLException {
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ninza_E18", "root", "chaithrajv@20");
		Statement stmt=conn.createStatement();
		int result= stmt.executeUpdate("update Ninza_CRM_Details set uname='admin' where Browser='firefox'");
		System.out.println(result);
		if(result!=0) {
			System.out.println("Operation done successfully");

		}else {
			System.out.println("Operation failed");
		}
		conn.close();		
	}
}


