import java.sql.*;

public class DemoJDBC {
	public static void main(String[] args) throws SQLException {
		final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
		final String DB_USER = "SYSTEM";
		final String DB_PASSWORD = "123456";
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conBD;
		conBD = DriverManager.getConnection(DB_CONNECTION,DB_USER, DB_PASSWORD);
		
		String instruccionSQL = "SELECT * FROM HR.COUNTRIES";
		Statement instruccionBD = conBD.createStatement();
		ResultSet resultadoBD = instruccionBD.executeQuery(instruccionSQL);
		
		while (resultadoBD.next()) {
			System.out.println(resultadoBD.getString(1) + " " + resultadoBD.getString(2) + " " + resultadoBD.getInt(3)); 
			
		}
				
		conBD.close();
	}
}
