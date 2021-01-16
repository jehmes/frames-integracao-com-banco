package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:sqlserver://DESKTOP-LF5ODRE;user=sa;password=123;databaseName=DB_ACADEMIA";
	

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
			e.printStackTrace();
		}
		return null;

	}

	public static void closeConnection(Connection con) {

		try {	
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();

		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();

		}
	}
	
public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();

		}
	}

}
