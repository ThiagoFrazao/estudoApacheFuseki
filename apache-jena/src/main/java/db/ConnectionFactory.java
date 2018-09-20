package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String POSTGRE = "jdbc:postgresql://localhost:5432/postgres";
	private static final String HSQLDB = "jdbc:hsqldb:file:C:/hsqldb/demo/estudo";
	private static final String usuario = "postgres";
	private static final String senha = "20071992";
	
	public static Connection gerarConexao(){
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(POSTGRE,usuario,senha);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;       
	}
	
	public static Connection conexaoHSQLDB(){
		Connection con = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection(HSQLDB,"sa","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		
		return con;
	}

}
