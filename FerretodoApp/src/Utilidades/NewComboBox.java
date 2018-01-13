package Utilidades;

import DDBB.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Luis Ochoa
 */
public class NewComboBox extends JComboBox{
    public Vector model = new Vector();
    
    public NewComboBox(String consulta) {       
        try {
            //se realiza la consulta
            ConexionDB.ConectarDB();
            ResultSet rs = ConexionDB.sqlQuery(consulta);
            //se llena el model(Vector)
            while(rs.next()){
                model.addElement( new Item(Integer.parseInt(rs.getObject(1).toString()), rs.getObject(2).toString() ) );
            }
            
            //recorremos el model y se lo agregamos al newComboBox
            for(int i = 0; i<model.size(); i++){
               this.addItem(model.get(i)); 
            }
        ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(NewComboBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void actualizar(String consulta) { 
        Vector v=new Vector();
        try {
            //se realiza la consulta
            ConexionDB.ConectarDB();
            ResultSet rs = ConexionDB.sqlQuery(consulta);
            //se llena el model(Vector)
            while(rs.next()){
                v.addElement( new Item(Integer.parseInt(rs.getObject(1).toString()), rs.getObject(2).toString() ) );
            }
            
            //recorremos el model y se lo agregamos al newComboBox
            for(int i = 0; i<v.size(); i++){
               this.addItem(v.get(i)); 
            }
            model=(Vector)v.clone();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewComboBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConexionDB.limpiarConsulta();
    }
   
    
    
}