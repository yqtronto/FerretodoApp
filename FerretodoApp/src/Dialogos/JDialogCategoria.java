/*
 * To change this license header, choose License Heade in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Importacion de los paquetes
package Dialogos;
import DDBB.ConexionDB;
import DDBB.ManejoDatos;
import Utilidades.Item;
import Utilidades.NewComboBox;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariely Fernandez-Gilbert Montaña
 */
public class JDialogCategoria extends JDialog{
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;   
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelInterno;
    private javax.swing.JComboBox jcomboCuenta;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlCondicion;
    private javax.swing.JLabel jlDenominacion;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlFecha1;
    private javax.swing.JLabel jlHoraa;
    private javax.swing.JLabel jlHoraa1;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JLabel jlUsuario1;
    private javax.swing.JScrollPane jscpCategoria;
    private javax.swing.JTable jtCategoria1;
    private javax.swing.JTextField jtextCodigo;
    private javax.swing.JTextField jtextDenominacion;
    ImageIcon icono;
    private int idCuenta=0;//Asumiendo que no hay cuentas con id=0
    private String denominacionCuenta="";
    private int filaSeleccionada=-1;
    
    DefaultTableModel modelo=null;
    // End of variables declaration    
    
    public JDialogCategoria(JDialog parent, boolean modal){
        super(parent, modal);
        this.setTitle("Ferretodo");
        icono = new ImageIcon("image//ferretodoIco.PNG");
        this.setIconImage(icono.getImage());
        jPanel1 = new javax.swing.JPanel();
        jPanelInterno = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jlCondicion = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();
        jtextCodigo = new javax.swing.JTextField();
        jlDenominacion = new javax.swing.JLabel();
        jtextDenominacion = new javax.swing.JTextField();
        jlLogo = new javax.swing.JLabel();
        jscpCategoria = new javax.swing.JScrollPane();
        jtCategoria1 = new javax.swing.JTable();
        jlHoraa = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jlUsuario1 = new javax.swing.JLabel();
        jlHoraa1 = new javax.swing.JLabel();
        jlFecha1 = new javax.swing.JLabel();
        //Creacion del combo box utilizando la clase NewComboBox que permite hacer el llenado automatico desde la base de datos
        jcomboCuenta = new NewComboBox("SELECT ID_CUENTA_PRESUPUESTARIA,DENOMINACION FROM CUENTA_PRESUPUESTARIA");      
        jcomboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboCuentaActionPerformed(evt);
            }
        });
        
        //***********************Mostrar el id de la categoria a penas se abre la ventana**********************************
        jtextCodigo.setText(ManejoDatos.devolverId( "SELECT * FROM CATEGORIA_DE_PRODUCTOS"));
        //
        //******************************************************************************************************************
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jlTitulo.setText("CATEGORÍA DEL PRODUCTO");
        btnBuscar.setToolTipText("Buscar una categoría");      
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnNuevo.setToolTipText("Añadir una categoría");     
        btnNuevo.setPreferredSize(new java.awt.Dimension(24, 24));
        btnNuevo.setIcon(new javax.swing.ImageIcon("image//nuevo24.png"));
        btnNuevo.setToolTipText("");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnEditar.setToolTipText("Editar una categoría");  
        btnEditar.setEnabled(false);
        btnEditar.setIcon(new javax.swing.ImageIcon("image//editar24.png")); // NOI18N
        btnEditar.setPreferredSize(new java.awt.Dimension(24, 24));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnBorrar.setIcon(new javax.swing.ImageIcon("image//borrar24.png")); // NOI18N
        btnBorrar.setPreferredSize(new java.awt.Dimension(24, 24));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jPanelDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlCondicion.setText("Cuenta presupuestaria:");

        jlCodigo.setText("ID Categoría:");

        jtextCodigo.setEditable(false);
        jtextCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTyped(evt);
            }
        });  
         jtextDenominacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtextDenominacionMouseClicked(evt);
            }
        });

        jlDenominacion.setText("Denominación:");

        jtextDenominacion.setText("");
        
        
        

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jlCondicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcomboCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDenominacion)
                            .addComponent(jlCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtextDenominacion, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(jtextCodigo))))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCodigo)
                    .addComponent(jtextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDenominacion))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCondicion)
                    .addComponent(jcomboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jlLogo.setIcon(new javax.swing.ImageIcon("image//logo42.png")); // NOI18N
        jlLogo.setText(" ");

        jtCategoria1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Denominación", "Cuenta Presupuestaria"
            }
        ));
       jtCategoria1.setToolTipText("Si desea editar algun registro de la tabla, seleccionelo, ingrese los datos, y pulse editar");
        jtCategoria1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoria1MouseClicked(evt);
            }
        });
        jscpCategoria.setViewportView(jtCategoria1);
        if (jtCategoria1.getColumnModel().getColumnCount() > 0) {
            jtCategoria1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtCategoria1.getColumnModel().getColumn(1).setPreferredWidth(30);
            jtCategoria1.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jlHoraa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlHoraa.setText("00/00/0000");

        jlFecha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlFecha.setText("Hora:");

        jlUsuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlUsuario.setText("Usuario:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jlUsuario1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlUsuario1.setText("Jose");

        jlHoraa1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlHoraa1.setText("Fecha");

        jlFecha1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlFecha1.setText("03:20 am");

        javax.swing.GroupLayout jPanelInternoLayout = new javax.swing.GroupLayout(jPanelInterno);
        jPanelInterno.setLayout(jPanelInternoLayout);
        jPanelInternoLayout.setHorizontalGroup(
            jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInternoLayout.createSequentialGroup()
                .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelInternoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelInternoLayout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelInternoLayout.createSequentialGroup()
                                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jlTitulo)
                                .addGap(38, 38, 38)
                                .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelInternoLayout.createSequentialGroup()
                                        .addComponent(jlUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlUsuario1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInternoLayout.createSequentialGroup()
                                        .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlHoraa1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlFecha))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlFecha1)
                                            .addComponent(jlHoraa)))))))
                    .addGroup(jPanelInternoLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(btnCancelar))
                    .addGroup(jPanelInternoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jscpCategoria)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelInternoLayout.setVerticalGroup(
            jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInternoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInternoLayout.createSequentialGroup()
                        .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlUsuario)
                            .addComponent(jlUsuario1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlHoraa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlHoraa1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFecha)
                            .addComponent(jlFecha1)))
                    .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlTitulo)
                        .addComponent(jlLogo)))
                .addGap(18, 18, 18)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jscpCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(408, 408, 408))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    
    }
   //****************************Metodos manejadores de eventos**************************
                                                
    private void jcomboCuentaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        JComboBox comboBox = (JComboBox)evt.getSource();
        Item item = (Item)comboBox.getSelectedItem();
        //Variables que almacene los datos correspondientes al combo box
        idCuenta= item.getId();
        denominacionCuenta=item.getDescription().toUpperCase();
    }                                           

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {  
        int seHizo=-1;
        Object o=new Object();
        if ((jtCategoria1.getSelectedRow()==-1)){
        //No se puede editar por no haber seleccionado un registro de la tabla
        JOptionPane.showMessageDialog(null, "Seleccione una registro de la tabla para editar", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if(denominacionCuenta.equals("") && (jtextDenominacion.getText().isEmpty())){//Si no se llenaron los campos completos para hacer un update
               JOptionPane.showMessageDialog(null, "No hay datos suficientes para hacer la edición", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
            else
            {
                filaSeleccionada= jtCategoria1.getSelectedRow();               
                o=modelo.getValueAt(filaSeleccionada,0); 
                
               if(jtextDenominacion.getText().isEmpty() && idCuenta!=0){
                    //Solo se editara la cuenta presupuestaria y la denominacion se mantendra
                    seHizo=ManejoDatos.hacerUpdate("UPDATE CATEGORIA_DE_PRODUCTOS SET ID_CUENTA_PRESUPUESTARIA="+idCuenta+
                                            " WHERE ID_CATEGORIA_PRODUCTO="+o);
                     //Mostrar el registro ya editado en la tabla
                     modelo= ManejoDatos.llenarTabla("SELECT CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO, \n"
                    + "CATEGORIA_DE_PRODUCTOS.NOMBRE, CUENTA_PRESUPUESTARIA.DENOMINACION  FROM \n"
                    + "CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" 
                    +"WHERE (CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) \n"
                    + "AND (CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO="+o+")");
                    jtCategoria1.setModel(modelo);
               }
               else if(idCuenta==0 && (jtextDenominacion.getText().isEmpty()==false)){
                   //Solo se editara la denominacion de la categoria y no la cuenta
                   seHizo=ManejoDatos.hacerUpdate("UPDATE CATEGORIA_DE_PRODUCTOS \n"
                           + "SET NOMBRE='"+jtextDenominacion.getText().toUpperCase()+"' WHERE ID_CATEGORIA_PRODUCTO="+o);
                   
                   //Mostrar el registro ya editado en la tabla
                     modelo= ManejoDatos.llenarTabla("SELECT CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO, \n"
                    + "CATEGORIA_DE_PRODUCTOS.NOMBRE, CUENTA_PRESUPUESTARIA.DENOMINACION  FROM \n"
                    + "CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" 
                    +"WHERE (CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) \n"
                    + "AND (CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO="+o+")");
                    jtCategoria1.setModel(modelo);
                   
               }
               else
                   //Edicion de todos los campos
                   seHizo=ManejoDatos.hacerUpdate("UPDATE CATEGORIA_DE_PRODUCTOS SET NOMBRE='" +jtextDenominacion.getText().toUpperCase()+ "', \n" +
                                                   "ID_CUENTA_PRESUPUESTARIA="+idCuenta+" WHERE ID_CATEGORIA_PRODUCTO="+o);
               //Mostrar el registro ya editado en la tabla
                     modelo= ManejoDatos.llenarTabla("SELECT CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO, \n"
                    + "CATEGORIA_DE_PRODUCTOS.NOMBRE, CUENTA_PRESUPUESTARIA.DENOMINACION  FROM \n"
                    + "CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" 
                    +"WHERE (CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) \n"
                    + "AND (CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO="+o+")");
                    jtCategoria1.setModel(modelo);
                JOptionPane.showMessageDialog(null, "Edición exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }

     
        }
      
       //Alfinal del evento reestablecer valores para una nueva accion
       jtextDenominacion.setText("");      
       idCuenta=0;
       denominacionCuenta="";
        
        
          
    }

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                         
            if (jtextDenominacion.getText().isEmpty() || (idCuenta==0 &&denominacionCuenta.equals(""))){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para crear una categoría", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
            else{
                try {
                    ConexionDB.ConectarDB();
                    ConexionDB.sqlUpdate("INSERT INTO CATEGORIA_DE_PRODUCTOS VALUES(SEQ_CATEGORIA_DE_PRODUCTOS1.NEXTVAL,\n"
                            + "'"+jtextDenominacion.getText().toUpperCase()+"',"+idCuenta+")");
                    JOptionPane.showMessageDialog(null, "Creación de categoría exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    ConexionDB.limpiarConsulta();                  
                } catch (SQLException ex) {
                    Logger.getLogger(JDialogCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        modelo=null;
        
        if (idCuenta!=0){
            
            if(jtextDenominacion.getText().isEmpty() ){
                
                //Caso en el que se busca solo por cuenta presupuestaria, 
                
                modelo=ManejoDatos.llenarTabla("SELECT CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO,\n"
                            + " CATEGORIA_DE_PRODUCTOS.NOMBRE, CUENTA_PRESUPUESTARIA.DENOMINACION  FROM CATEGORIA_DE_PRODUCTOS,\n"
                            + " CUENTA_PRESUPUESTARIA WHERE \n"
                            + "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA)\n"
                            + " AND( CUENTA_PRESUPUESTARIA.DENOMINACION='"+denominacionCuenta+"')");
                jtCategoria1.setModel(modelo);//Asignacion del modelo de acuerdo al select a la tabla  
                jtextCodigo.setText("");
             }
             else{
            //Caso si hay una denominacion en el campo, se hace por coincidencia en denominacion y cuenta presupuestaria
                modelo=ManejoDatos.llenarTabla("SELECT CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO,\n"
                     + "CATEGORIA_DE_PRODUCTOS.NOMBRE, CUENTA_PRESUPUESTARIA.DENOMINACION  FROM CATEGORIA_DE_PRODUCTOS,\n"
                     + " CUENTA_PRESUPUESTARIA WHERE \n"
                     + "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA)\n"
                     + " AND( CUENTA_PRESUPUESTARIA.DENOMINACION='"+denominacionCuenta+"') AND \n"
                     + "( CATEGORIA_DE_PRODUCTOS.NOMBRE LIKE'%"+jtextDenominacion.getText().toUpperCase()+"%')");
                jtextCodigo.setText("");
             }
             
         }
        else{
            if(jtextDenominacion.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "No hay datos suficientes para realizar una busqueda", "Aviso", JOptionPane.WARNING_MESSAGE);

                
            }
            else{
                //Caso de busqueda por denominacion
                modelo=ManejoDatos.llenarTabla("SELECT CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO,\n"
                        + " CATEGORIA_DE_PRODUCTOS.NOMBRE, CUENTA_PRESUPUESTARIA.DENOMINACION  FROM\n"
                        + " CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n"
                        + "WHERE (CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA)\n"
                        + " AND( CATEGORIA_DE_PRODUCTOS.NOMBRE LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%')");
                jtextCodigo.setText("");
            
            }
       
           
        }
          //Condicion para verificar que existieron datos de coincidencia para hacerle saber al usuario       
        if(modelo!=null){
            if (modelo.getRowCount()!=0 ){
            
            jtCategoria1.setModel(modelo);
            btnEditar.setEnabled(true);//Habilitacion del boton editar
            
            }
            else{
                JOptionPane.showMessageDialog(null, "No hubo coincidencias en la busqueda", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                
            }
        }
 
                          
    }                                         

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
      //setVisible(false);
      
       int cd= JOptionPane.showConfirmDialog(null, "¿Está seguro que desea abandonar la ventana?", "Aviso",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if (cd==0){
           dispose();
         
       }
       
    }                                           
                                             
    private void jtCategoria1MouseClicked(java.awt.event.MouseEvent evt) {  
       //Cuando se marque una fila en la tabla automaticamente se limpiaron los campos de entrada de datos
       jtextDenominacion.setText("");
       jcomboCuenta.transferFocus();
       idCuenta=0;
       denominacionCuenta="";
       int filaClick=jtCategoria1.getSelectedRow();
       
       if (modelo!=null){
           jtextCodigo.setText(ManejoDatos.mostrarIdseleccionado(modelo, (filaClick)));
           jtextDenominacion.setText(ManejoDatos.mostrarDenominacion(modelo, (filaClick)));
       }
       jtCategoria1.setToolTipText("Si desea editar este registro, ingrese los datos de denominacion y cuenta presupuestaria nuevos, y pulse editar");
    }      
    private void campoTyped(java.awt.event.KeyEvent evt) {                                 
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
             Toolkit.getDefaultToolkit().beep();
             evt.consume();
        }
    }
    private void jtextDenominacionMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if(jtCategoria1.getSelectedRow()==-1){//Es por que no voy a por lo tanto es para buscar o agregar
            jtextCodigo.setText(ManejoDatos.devolverId("SELECT * FROM CATEGORIA_DE_PRODUCTOS"));
        }
    } 
    
    
    //********************************Main para JDialog*****************************************************
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCategoria dialog = new JDialogCategoria(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    //************************************Fin Main************************************************
    
}
