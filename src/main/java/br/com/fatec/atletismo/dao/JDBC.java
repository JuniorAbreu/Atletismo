package br.com.fatec.atletismo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {
	private final static String JDBC_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String JDBC_URL = "jdbc:sqlserver://localhost:1433/atletismo";
	private final static String JDBC_USERID = "root";
	private final static String JDBC_PASSWORD = "root";
	private Connection con;
	private static JDBC jdbc;
	private JDBC() { 		
	}
	public Connection getConnection() throws SQLException {
		if (con == null) {
			try {
				Class.forName( JDBC_CLASS );
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (con == null || (con != null && !con.isValid(3))) { 
			con = DriverManager.getConnection(JDBC_URL, JDBC_USERID, JDBC_PASSWORD);
		}
		return con;
	}
	public static JDBC getInstance() { 
		if (jdbc == null) { 
			jdbc = new JDBC();
		}
		return jdbc;
	}

}
