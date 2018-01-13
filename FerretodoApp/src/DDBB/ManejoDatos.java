/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDBB;

import Dialogos.JDialogCategoria;
import Utilidades.Item;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariely Carolina
 */
public class ManejoDatos {

    public ManejoDatos() {
    }
  
    public static DefaultTableModel llenarTabla(String select){
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ConexionDB.ConectarDB();
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
                      
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                        }
                      modelo.addRow(fila);
                    }
                    
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    return modelo;
    }
    public static int hacerUpdate(String update){
    int seHizo=-1;
        try {
            seHizo=  ConexionDB.sqlUpdate(update);
            ConexionDB.limpiarConsulta();
            
            } catch (SQLException ex) {
                Logger.getLogger(JDialogCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        return seHizo;
    }
    public static String devolverId(String select){
        String id="";
        int filaultimo;
        int columnaid;
        Object idObject;
        long idLong=-1;
        Number n;
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                        }
                     modelo.addRow(fila);
                    }
                    filaultimo=modelo.getRowCount();
                    columnaid=0;//El id es siempre la columna 1
                   // System.out.println(filaultimo+ ", " + columnaid);
                    idObject=modelo.getValueAt((filaultimo-1), columnaid);
                    
                    if(idObject instanceof Number){
                   // System.out.println(idObject);
                    n=(Number)idObject;
                    idLong=n.longValue();
                    idLong=idLong+1;
                     }
                    
                    
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Long.toString(idLong) ;
    
    }
    public static String mostrarIdseleccionado(DefaultTableModel mimodelo, int filaSeleccionada){
       
                    int columnaid=0;
                    Object idObject=new Object();
                   System.out.println("FILA: "+ filaSeleccionada+ ", COLUMNA " + columnaid);
                    idObject=mimodelo.getValueAt((filaSeleccionada), columnaid);
                   System.out.println(idObject);
                    Number n=(Number)idObject;
                    
                    
        return n.toString() ;
    }
    
    public static String mostrarDenominacion(DefaultTableModel mimodelo, int filaSeleccionada){
       //A partir de tabla
                    int columnaid=1;//Denominacion
                    Object idObject=new Object();
                   // System.out.println("FILA: "+ filaSeleccionada+ ", COLUMNA " + columnaid);
                    idObject=mimodelo.getValueAt((filaSeleccionada), columnaid);
                   // System.out.println(idObject);
                    String n=(String)idObject;                                      
        return n ;
    }
    
     public static String devolverDenominacion(String select){
   
        int filaultimo;
        int columnaid;
        Object idObject;
        String n="";
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                           
                        }
                     modelo.addRow(fila);
                    }                
                    columnaid=1;//La denominacion
                    //System.out.println(0+ ", " + columnaid);
                    idObject=modelo.getValueAt(0, columnaid);
                    //System.out.println(idObject);
                    n=(String)idObject;
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n ;
    
    }
     
     public static String devolverDescripcion(String select){
   
        int filaultimo;
        int columnaid;
        Object idObject;
        String n="";
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                           
                        }
                     modelo.addRow(fila);
                    }                
                    columnaid=2;//La descripcion
                    //System.out.println(0+ ", " + columnaid);
                    idObject=modelo.getValueAt(0, columnaid);
                   // System.out.println(idObject);
                    n=(String)idObject;
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n ;
    
    }
     public static String devolverPrecio(String select){
   
        int filaultimo;
        int columnaid;
        Object idObject;
        String n="";
        Number precio;
        long p=0;
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                           
                        }
                     modelo.addRow(fila);
                    }                
                    columnaid=3;//Precio
                   // System.out.println(0+ ", " + columnaid);
                    idObject=modelo.getValueAt(0, columnaid);
                    //System.out.println(idObject);
                    precio=(Number)idObject;
                    p= precio.longValue();
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  Long.toString(p) ;
    
    }
     
    public static String devolverIva(String select){
   
        int filaultimo;
        int columnaid;
        Object idObject;
        String n="";
        Number precio;
        long p=0;
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                           
                        }
                     modelo.addRow(fila);
                    }                
                    columnaid=4;//Iva
                   // System.out.println(0+ ", " + columnaid);
                    idObject=modelo.getValueAt(0, columnaid);
                   // System.out.println(idObject);
                    precio=(Number)idObject;
                    p= precio.longValue();
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  Long.toString(p) ;
    
    }
    
     public static String devolverEstado(String select){
   
        int filaultimo;
        int columnaid;
        Object idObject;
        String n="";
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                           
                        }
                     modelo.addRow(fila);
                    }                
                    columnaid=5;//status
                    //System.out.println(0+ ", " + columnaid);
                    idObject=modelo.getValueAt(0, columnaid);
                    //System.out.println(idObject);
                    n=(String)idObject;
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n ;
     }
     public static int devolverItem(String select , ComboBoxModel c){
        int pos=0;
        int columnaid;
        Object idObject;
        Item item;
        String nombreCategoria="";
        String n="";
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            ResultSet rs=ConexionDB.sqlQuery(select);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
             //Establecer las cabeceras de las columnas en el JTable
                    for (int i = 1; i <= cantidadColumnas; i++) {
                        modelo.addColumn(rsMd.getColumnLabel(i));
                    }
            
                    //Creando las filas para el JTable
                    while (rs.next()) {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                           fila[i]=rs.getObject(i+1);
                           
                        }
                     modelo.addRow(fila);
                    }                
                    columnaid=0;
                    //System.out.println(0+ ", " + columnaid);
                    idObject=modelo.getValueAt(0, columnaid);
                   // System.out.println(idObject);
                    n=(String)idObject;//Nombre de la categoria resultante
                    
                    //Recorrido del modelo del combobox
                    int size = c.getSize();
                    for (int i = 0; i < size; i++) {
                          Object element=c.getElementAt(i);
                          item=(Item)element;
                         // System.out.println(element);
                          nombreCategoria=item.getDescription().toUpperCase();
                          if(nombreCategoria.equals(n)){
                          pos=i;
                          }
                        }
                                       
                    rs.close(); 
                    ConexionDB.limpiarConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println(pos + " ," + n);
        return pos ;
     }
    
}
