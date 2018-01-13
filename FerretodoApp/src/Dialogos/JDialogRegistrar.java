/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import DDBB.ConexionDB;
import DDBB.ManejoDatos;
import Utilidades.Fecha;
import Utilidades.Hora;
import Utilidades.Item;
import Utilidades.NewComboBox;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariely Fernandez. Gilbert Montana
 */
public class JDialogRegistrar extends JDialog {
    // Variables declaration - do not modify                     
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnGuardar;
        private javax.swing.JButton btnNuevo;
        private javax.swing.ButtonGroup buttonGroup;
        private javax.swing.JButton btnActualizar;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JCheckBox jcbActivo;
        private javax.swing.JCheckBox jcbNoactivo;
        private javax.swing.JLabel jlCategoria;
        private javax.swing.JLabel jlCondicion;
        private javax.swing.JLabel jlDenominacion;
        private javax.swing.JLabel jlDescripcion;
        private javax.swing.JLabel jlFecha;
        private javax.swing.JLabel jlFecham;
        private javax.swing.JLabel jlHora;
        private javax.swing.JLabel jlHoram;
        private javax.swing.JLabel jlIdproducto;
        private javax.swing.JLabel jlIva;
        private javax.swing.JLabel jlLogo;
        private javax.swing.JLabel jlPrecio;
        private javax.swing.JLabel jlTitulo;
        private javax.swing.JLabel jlUsuario;
        private javax.swing.JLabel jlUsuariom;
        private javax.swing.JTextField jtextDenominacion;
        private javax.swing.JTextField jtextDescripcion;
        private javax.swing.JTextField jtextIdproducto;
        private javax.swing.JTextField jtextIva;
        private javax.swing.JTextField jtextPrecio;
        //private javax.swing.JComboBox jCombocategoria;
        private int itemSeleccionado=-1;//Si no se selecciona un item del combo box itemSeleccionado=-1, si no vale 1;
        private String status;
        private int idCategoria;
        private String denominacionCategoria;
        private NewComboBox  jCombocategoria;
        private int miestado=-1;
        private String mistatus="";
        private int miIdeditar=0;
        private Vector modeloCombo=new Vector();
    public JDialogRegistrar(java.awt.Frame parent, boolean modal,int estado, int idEditar){
    //Metodo super que invoca al constructor del padre
        super(parent, modal); 
       
    //Creacion de los objetos    
        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlIdproducto = new javax.swing.JLabel();
        jtextIdproducto = new javax.swing.JTextField();
        jlDenominacion = new javax.swing.JLabel();
        jtextDenominacion = new javax.swing.JTextField();
        jlDescripcion = new javax.swing.JLabel();
        jtextDescripcion = new javax.swing.JTextField();
        jlPrecio = new javax.swing.JLabel();
        jtextPrecio = new javax.swing.JTextField();
        jlIva = new javax.swing.JLabel();
        jtextIva = new javax.swing.JTextField();
        jlCondicion = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jcbNoactivo = new javax.swing.JCheckBox();
        jlCategoria = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jlLogo = new javax.swing.JLabel();
        jlUsuariom = new javax.swing.JLabel();
        jlFecham = new Fecha();
        jlHoram = new Hora();
        //Creacion del combo box utilizando la clase NewComboBox que permite hacer el llenado automatico desde la base de datos
        jCombocategoria = new NewComboBox("SELECT ID_CATEGORIA_PRODUCTO,NOMBRE FROM CATEGORIA_DE_PRODUCTOS");   
        jCombocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombocategoriaActionPerformed(evt);
            }
        });
      
   //Condicion que define si la ventana es de edicion o de registro
    //Estado=0 si es de registro, Estado=1 si es de edicion
        miestado=estado;//si es registro o edicion
        miIdeditar=idEditar;//ID QUE VIENE DE LA BUSQUEDA PARA LA EIDCION
        if (estado==1){
        //ESTADO DE EDICION
        jtextIdproducto.setEditable(false);
        //***********************Mostrar el id de la categoria a penas se abre la ventana**********************************
        jtextIdproducto.setText(Integer.toString(miIdeditar));
        //
        //******************************************************************************************************************
        jtextDenominacion.setEditable(false);
        jlTitulo.setText("EDICIÓN DE PRODUCTO");
        //Si es edicion debo mostrar todos los campos llenos siguiendo el id dado
           
        jtextDenominacion.setText(ManejoDatos.devolverDenominacion("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO="+miIdeditar));
        jtextDescripcion.setText(ManejoDatos.devolverDescripcion("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO="+miIdeditar));
        jtextPrecio.setText(ManejoDatos.devolverPrecio("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO="+miIdeditar));
        jtextIva.setText(ManejoDatos.devolverIva("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO="+miIdeditar));
        mistatus=ManejoDatos.devolverEstado("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO="+miIdeditar);
        
        if (mistatus.equals("DISP")){
            jcbActivo.setSelected(true);
        }
        else if (mistatus.equals("NOT")){
            jcbNoactivo.setSelected(true);
        
        }
        
       
        jCombocategoria.setSelectedIndex(ManejoDatos.devolverItem("SELECT CATEGORIA_DE_PRODUCTOS.NOMBRE FROM CATEGORIA_DE_PRODUCTOS, PRODUCTO \n" +
"WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND (PRODUCTO.ID_CATEGORIA_PRODUCTO="+miIdeditar+")", jCombocategoria.getModel()));
                  
        }
        else{
      //Si es solo registro
        
        jlTitulo.setText("REGISTRO DE PRODUCTO");
        jtextIdproducto.setEditable(true);
        jtextDenominacion.setEditable(true);
        jtextIdproducto.setText(ManejoDatos.devolverId("SELECT * FROM PRODUCTO"));
        }
        
        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlIdproducto.setText("ID  Producto:");
        jtextIdproducto.setEditable(false);
        jtextIdproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextIdproductoActionPerformed(evt);
            }
        });

        jlDenominacion.setText("Denominación:");

        jtextDenominacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextDenominacionActionPerformed(evt);
            }
        });

        jlDescripcion.setText("Descripción:");

        jtextDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextDescripcionActionPerformed(evt);
            }
        });

        jlPrecio.setText("Precio:");
        
        jtextPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTyped(evt);
            }
        });  

        jlIva.setText("IVA(%)");

        jtextIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTyped(evt);
            }
        });  

        jlCondicion.setText("Condición:");

        buttonGroup.add(jcbActivo);
        jcbActivo.setText("Activo");
        jcbActivo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcbActivoStateChanged(evt);
            }
        });

        buttonGroup.add(jcbNoactivo);
        jcbNoactivo.setText("No Activo");
        jcbNoactivo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcbNocactivoStateChanged(evt);
            }
        });

        jlCategoria.setText("Categoría: ");
        jlCategoria.setName(""); // NOI18N

        
        btnNuevo.setToolTipText("Añadir una categoría");  
        btnNuevo.setIcon(new javax.swing.ImageIcon("image//nuevo15.png")); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnActualizar.setToolTipText("Actualiza lista de categorías");  
        btnActualizar.setIcon(new javax.swing.ImageIcon("image//actualizar16.png")); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
       //***********************Layout panel de datos********************************************************
        
      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlIdproducto)
                            .addComponent(jlPrecio))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlIva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextIva, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCondicion)
                            .addComponent(jlCategoria))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jcbNoactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 168, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCombocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtextIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlDenominacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextDenominacion))
                    .addComponent(jtextDescripcion))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdproducto)
                    .addComponent(jtextIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDenominacion)
                    .addComponent(jtextDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescripcion)
                    .addComponent(jtextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlPrecio)
                            .addComponent(jlCategoria)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCombocategoria)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlIva))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlCondicion)
                        .addComponent(jcbNoactivo)
                        .addComponent(jcbActivo)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

       //******************************************Fin layout panel de datos*************************************************

        jlUsuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlUsuario.setText("Usuario:");

        jlFecha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlFecha.setText("Fecha:");

        jlHora.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlHora.setText("Hora:");

        jlLogo.setIcon(new javax.swing.ImageIcon("image//logo42.png")); // NOI18N

        jlUsuariom.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlUsuariom.setText("Jose");

        jlFecham.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N


        jlHoram.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

         
        //*************************************Layout de panel externo*************************************************
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(btnGuardar)
                .addGap(109, 109, 109)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTitulo)
                        .addGap(176, 176, 176)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlHoram))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jlFecha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlFecham))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jlUsuario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlUsuariom))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlUsuario)
                            .addComponent(jlUsuariom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFecha)
                            .addComponent(jlFecham))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlHoram)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlTitulo)
                        .addComponent(jlLogo)))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        //************************************Fin layout de panel externo*********************************************
    }
    
    //****************************Manejadores de eventos**************************
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                         
             JDialogCategoria dialogocategoria = new JDialogCategoria(new JDialog(),true);
             dialogocategoria.setLocationRelativeTo(null);
             dialogocategoria.setSize(600,600);
             dialogocategoria.setResizable(false);
             dialogocategoria.setVisible(true);
    }                                        

    private void jCombocategoriaActionPerformed(java.awt.event.ActionEvent evt) {
        itemSeleccionado=1;
        JComboBox comboBox = (JComboBox)evt.getSource();
        Item item = (Item)comboBox.getSelectedItem();
        //Variables que almacene los datos correspondientes al combo box
        idCategoria= item.getId();
        denominacionCategoria=item.getDescription().toUpperCase();
    }                                               

    private void jtextDenominacionActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jtextIdproductoActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        if(miestado==0){
            //Registro de producto
            if( jtextDenominacion.getText().isEmpty() || jtextDescripcion.getText().isEmpty() || jtextPrecio.getText().isEmpty() || jtextIva.getText().isEmpty() || itemSeleccionado==-1 || (jcbActivo.isSelected()==false && jcbNoactivo.isSelected()==false)){
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para crear producto", "Aviso", JOptionPane.WARNING_MESSAGE);

        }
        else{
            if(jcbActivo.isSelected()){
                status="DISP";
            }
            else if(jcbNoactivo.isSelected()){
                status="NOT";
            }
            
            try {
                    ConexionDB.ConectarDB();
                    ConexionDB.sqlUpdate("INSERT INTO PRODUCTO VALUES(SEQ_PRODUCTO.NEXTVAL,\n"
                            + "'"+jtextDenominacion.getText().toUpperCase()+"','"+jtextDescripcion.getText().toUpperCase()+"',"+jtextPrecio.getText()+","+jtextIva.getText()+",\n"
                            + "'"+status.toUpperCase()+"',"+idCategoria+",to_date('22-10-2015','DD-MM-YYYY'))");
                    
                    
                    JOptionPane.showMessageDialog(null, "Producto registrado exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    //dispose();
                    ConexionDB.limpiarConsulta();
                } catch (SQLException ex) {
                    Logger.getLogger(JDialogCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }else{
        //Edicion de producto
        //Deben estar llenos los campos
        if( jtextDescripcion.getText().isEmpty() || jtextPrecio.getText().isEmpty() || jtextIva.getText().isEmpty() || itemSeleccionado==-1 || (jcbActivo.isSelected()==false && jcbNoactivo.isSelected()==false)){
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para editar un producto", "Aviso", JOptionPane.WARNING_MESSAGE);

        }
        else{
             if(jcbActivo.isSelected()){
                status="DISP";
            }
            else if(jcbNoactivo.isSelected()){
                status="NOT";
            }
           int valor= ManejoDatos.hacerUpdate("UPDATE PRODUCTO SET DENOMINACION='"+jtextDenominacion.getText().toUpperCase()+"',\n"
                   + " DESCRIPCION='"+jtextDescripcion.getText().toUpperCase()+"',PRECIO="+jtextPrecio.getText()+",\n"
                   + " IMPUESTO="+jtextIva.getText()+", STATUS='"+status.toUpperCase()+"', FECHA_REGISTRO=to_date('25-10-2015',\n"
                   + " 'DD-MM-YYYY') WHERE ID_PRODUCTO="+miIdeditar);
           JOptionPane.showMessageDialog(null, "Producto registrado exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
      
          // dispose();
        
        }
       
        }
        
    }       
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {  
        
       int cd= JOptionPane.showConfirmDialog(null, "¿Está seguro que desea abandonar la ventana?", "Aviso",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if (cd==0){
           dispose();
         
       }
    }            
        private void jtextDescripcionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jtextPrecioActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jtextIvaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jcbNocactivoStateChanged(javax.swing.event.ChangeEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jcbActivoStateChanged(javax.swing.event.ChangeEvent evt) {                                       
        // TODO add your handling code here:
    }             
    private void campoTyped(java.awt.event.KeyEvent evt) {                                 
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
             Toolkit.getDefaultToolkit().beep();
             evt.consume();
        }
    }
        private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {  
               
        jCombocategoria.setModel(new DefaultComboBoxModel());
        jCombocategoria.actualizar("SELECT ID_CATEGORIA_PRODUCTO,NOMBRE FROM CATEGORIA_DE_PRODUCTOS");
        
    }                                             
       
    
    //********************************Main para JDialog*****************************************************
     public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogRegistrar dialog = new JDialogRegistrar(new javax.swing.JFrame(), true,0,-1);
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
