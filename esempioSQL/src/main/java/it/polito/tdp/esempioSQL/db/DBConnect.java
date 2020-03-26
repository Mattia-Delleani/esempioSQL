package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Non è pubblica perche non vogliamo frala vedere
class DBConnect {
	
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=Jaqa7951ma";
		
		return DriverManager.getConnection(jdbcURL);
	}

}
