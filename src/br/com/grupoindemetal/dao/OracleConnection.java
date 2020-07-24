package br.com.grupoindemetal.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {

	protected Connection conn;

	// Connection string OracleJDBC
	private String url = "jdbc:oracle:thin:@<hostname>:1521:<SID>";
	private String username = "<username>";
	private String password = "<password>";

	public Connection createConnection(){
		conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(this.url,this.username,this.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
