package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;

	public void getDbConnection(String url, String uname, String password) throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, uname, password);
		} catch (Exception e) {
			System.out.println("Connection  not established");
		}
	}

	public void closeDBConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection not closed");
		}

	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
