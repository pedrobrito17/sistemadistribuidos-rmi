package com.ifma.sd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "fsadu";
	private static final String URL = "jdbc:mysql://localhost/bd_escola";

	public static Connection getConexao() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
