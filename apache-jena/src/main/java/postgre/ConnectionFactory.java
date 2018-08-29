package postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String URI = "jdbc:postgresql://localhost:5432/postgres";
	private static final String usuario = "postgres";
	private static final String senha = "user";
	
	public static Connection gerarConexao(){
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URI,usuario,senha);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;       
	}
	
	

}
