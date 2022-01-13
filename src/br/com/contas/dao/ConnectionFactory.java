package br.com.contas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String url = "jdbc:mysql://localhost/conta";
	private String user = "root";
	private String password = "secret";
	
	public Connection getConnection() throws SQLException {
		System.out.println("conectando ...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection(url, user , password);
	}

}
