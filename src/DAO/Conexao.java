package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String driver = "org.postgresql.Driver";
	
	private static final String url = "jdbc:postgresql://localhost:5432/mydb";
	
	private static final String user = "postgres";
	
	private static final String pass = "root";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("Erro: "+ ex);
			return null;
		}
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				System.err.println("Erro: " +ex);
			}
		}
	}
	

}
