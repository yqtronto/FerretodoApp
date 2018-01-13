
package DDBB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uclides Gil
 */
public class ConexionDB {
    
    //se define las constantes para conectar a la DB
    
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "manager";
    private static Connection con;
    private static Statement statement;
    private static ResultSet resultSet;
    
    //metodo para conectar a la DB
    public static void ConectarDB()throws SQLException{
        // (1) Cargamos Driver Oracle JDBC Driver
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 
        // Nota: El Driver es buscado cuando la clase es interpretada
        
        // (2) Establecer la conexión a la base de datos Oracle 
        con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }
    
    
    //metodo para cerrar la conexion a la DB
    public static void CerrarConexionDB() throws SQLException{
        con.close();
    }
    
        //metodo para realizar CONSULTAS,
        //retorna valor TRUE si se efectua correctamente
        //FALSE en caso contrario
    public static boolean sqlExecute(String sql) throws SQLException{
    
        //Crear el objeto Statement  
        statement=con.createStatement();
        //boolean para almacenar resultado de consulta  
         boolean bool = statement.execute(sql);
        
     return bool;
    }
    
    //metodo para realizar CONSULTAS
    //retorna RESULTSET que contiene el resultado de la busqueda
    public static ResultSet sqlQuery(String sql) throws SQLException{
        //Crear el objeto Statement  
        statement=con.createStatement();
        //Crear el objeto ResultSet para almacenar resultado de consulta  
         resultSet = statement.executeQuery(sql); 

     return resultSet;

}
        //metodo CREAR TABLAS,INSERTAR ELEMENTOS A TABLAS
        //retorna un entero como resultado a la operacion
    public static int sqlUpdate(String sql) throws SQLException{

        //Crear el objeto Statement  
        statement=con.createStatement();
        //Crear el objeto ResultSet para almacenar resultado de consulta  
         int valor = statement.executeUpdate(sql); 
        
     return valor;
    }
    
    public static void limpiarConsulta(){
        try {
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
