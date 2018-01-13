
package Paneles;
import DDBB.ConexionDB;
import DDBB.ManejoDatos;
import Dialogos.JDialogCategoria;
import Dialogos.JDialogRegistrar;
import Utilidades.Fecha;
import Utilidades.Hora;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariely Carolina- Gilbert Montana
 */
public class JPanelProducto extends JPanel {

    
    // Variables declaration - do not modify                     
    private javax.swing.JTable JTable1;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
   
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JCheckBox jcbnAactivo;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlCondicion;
    private javax.swing.JLabel jlDenominacion;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlFecha1;
    private javax.swing.JLabel jlHasta;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel jlHora1;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JLabel jlUsuario1;
    private javax.swing.JScrollPane jscpTabla;
    private javax.swing.JTextField jtextCodigo;
    private javax.swing.JTextField jtextDenominacion;
    private javax.swing.JTextField jtextHasta;
    private javax.swing.JTextField jtextPrecio;
    private javax.swing.ButtonGroup buttonGroup;
    private int idEditar=-1;//ESTE ES EL VALOR QUE SE LE PASA COMO PARAMETROA LA JDIALOG PARA INDICAR EL ID QUE SE VA EDITAR
    DefaultTableModel modelo=null;

    public JPanelProducto() {
          
        
    //  Paleta            
  
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jtextPrecio = new javax.swing.JTextField();
        jlHasta = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jtextHasta = new javax.swing.JTextField();
        jcbnAactivo = new javax.swing.JCheckBox();
        jlCondicion = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();
        jtextCodigo = new javax.swing.JTextField();
        jlDenominacion = new javax.swing.JLabel();
        jtextDenominacion = new javax.swing.JTextField();
        jlPrecio = new javax.swing.JLabel();
        jscpTabla = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        jlHora = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlLogo = new javax.swing.JLabel();
        jlUsuario1 = new javax.swing.JLabel();
        jlFecha1 = new Fecha();
        jlHora1 = new Hora();

        jLabel10.setText("GESTIÓN DE PRODUCTOS");

        jLabel11.setText("Usuario:");

        jLabel12.setText("Fecha:");

        jLabel13.setText("Hora:");

        jLabel14.setText("Codigo:");

        jTextField5.setText("jTextField1");

        jLabel15.setText("Denominación:");

        jTextField6.setText("jTextField2");

        jLabel16.setText("Precio desde:");

        jTextField7.setText("jTextField3");

        jLabel17.setText("jLabel8");

        jTextField8.setText("jTextField4");

        jLabel18.setText("Conidición");

        
        JTable1.setToolTipText("Si desea editar algun registro de la tabla, seleccionelo, ingrese los datos, y pulse editar");
        JTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        JTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Denominación", "Descripción", "Categoria", "Precio", "IVA", "Total", "Condición"
            }
        ));
        jScrollPane4.setViewportView(JTable1);
        if (JTable1.getColumnModel().getColumnCount() > 0) {
            JTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            JTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            JTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            JTable1.getColumnModel().getColumn(5).setHeaderValue("IVA");
            JTable1.getColumnModel().getColumn(6).setHeaderValue("Total");
            JTable1.getColumnModel().getColumn(7).setResizable(false);
            JTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        jScrollPane3.setViewportView(jScrollPane4);

        jButton5.setText("Cancelar");

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setToolTipText("");
        jButton9.setIconTextGap(0);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Activo");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("No activo");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField8))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(32, 32, 32)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckBox3)
                                                .addGap(44, 44, 44)
                                                .addComponent(jCheckBox4)
                                                .addGap(230, 230, 230))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField6)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(374, 374, 374))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jlTitulo.setText("        GESTIÓN DE PRODUCTOS");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar un Producto");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setToolTipText("");
        btnNuevo.setIconTextGap(0);
        btnNuevo.setRolloverEnabled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnEditar.setEnabled(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(24, 24));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setPreferredSize(new java.awt.Dimension(24, 24));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jPanelDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtextPrecio.setText("");
        jtextPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTyped(evt);
            }
        });  

        jlHasta.setText("Hasta:");
         
        buttonGroup.add(jcbActivo);
        jcbActivo.setText("Activo");
        jcbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActivoActionPerformed(evt);
            }
        });

        jtextHasta.setText("");
        jtextHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTyped(evt);
            }
        });  

        buttonGroup.add(jcbnAactivo);
        jcbnAactivo.setText("No activo");
        jcbnAactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbnAactivoActionPerformed(evt);
            }
        });

        jlCondicion.setText("Condición");

        jlCodigo.setText("ID Producto:");

        jtextCodigo.setText("");
        jtextCodigo.setEditable(true);
        jtextCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTyped(evt);
            }
        });  

        jlDenominacion.setText("Denominación:");

        jtextDenominacion.setText("");

        jlPrecio.setText("Precio desde:");
         
        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPrecio)
                    .addComponent(jlCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jtextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jlHasta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtextHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDenominacion)
                    .addComponent(jlCondicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jcbActivo)
                        .addGap(42, 42, 42)
                        .addComponent(jcbnAactivo)
                        .addGap(0, 160, Short.MAX_VALUE))
                    .addComponent(jtextDenominacion))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCodigo)
                    .addComponent(jtextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDenominacion)
                    .addComponent(jtextDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecio)
                    .addComponent(jtextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHasta)
                    .addComponent(jtextHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCondicion)
                    .addComponent(jcbActivo)
                    .addComponent(jcbnAactivo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        JTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Denominación", "Precio", "Status", "Descripción", "Categoria", "Cuenta Presupuestaria"
            }
        ));
        jscpTabla.setViewportView(JTable1);
        if (JTable1.getColumnModel().getColumnCount() > 0) {
            JTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            JTable1.getColumnModel().getColumn(3).setResizable(false);
            JTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            JTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            JTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            JTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jlHora.setText("Hora:");

        jlFecha.setText("Fecha:");

        jlUsuario.setText("Usuario");     
        jlUsuario1.setText("Jose");


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscpTabla)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlLogo)
                        .addGap(178, 178, 178)
                        .addComponent(jlTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlHora)
                                    .addComponent(jlFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlFecha1)
                                    .addComponent(jlHora1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlUsuario1)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlUsuario)
                            .addComponent(jlUsuario1))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlFecha)
                                    .addComponent(jlFecha1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlHora)
                                    .addComponent(jlHora1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jlTitulo)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(26, 26, 26)))
                .addComponent(jscpTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
        btnNuevo.setIcon(new javax.swing.ImageIcon("image//nuevo24.png"));
        
        btnEditar.setIcon(new javax.swing.ImageIcon("image//editar24.png"));
        
        btnBorrar.setIcon(new javax.swing.ImageIcon("image//borrar24.png"));
      
        jlLogo.setIcon(new javax.swing.ImageIcon("image//logo60.png")); // NOI18N

      //Paleta
    }
    
      private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jcbnAactivoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jcbActivoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                          
          System.out.println("Mostrar ventana de edicion");
          if ((JTable1.getSelectedRow()==-1)){
          JOptionPane.showMessageDialog(null, "Seleccione una registro de la tabla para editar", "Aviso", JOptionPane.WARNING_MESSAGE);
      
          }else{
            JDialogRegistrar dialog=new JDialogRegistrar(new JFrame(),true,1,idEditar); 
             dialog.setLocationRelativeTo(null); 
             dialog.setSize(830, 390);
             dialog.setResizable(false);
             dialog.setVisible(true);
          }
            
    }                                         

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                         
          System.out.println("Mostrar ventana Registrar Producto");
             JDialogRegistrar dialog=new JDialogRegistrar(new JFrame(),true,0,idEditar);
             dialog.setLocationRelativeTo(null); 
             dialog.setSize(830, 390);
             dialog.setResizable(false);
             dialog.setVisible(true);
             
    }                                        

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        btnEditar.setEnabled(true);
        modelo=null;

        if(jtextCodigo.getText().isEmpty()){ 
            
            if((jtextDenominacion.getText().isEmpty()) && (jtextHasta.getText().isEmpty()) && (jtextPrecio.getText().isEmpty())){
                
                if(jcbnAactivo.isSelected()){
                    //Consulta de Productos por No activo
                    modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                    "WHERE ((PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                    "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.STATUS= 'NOT'))");

                }
//                
                else if(jcbActivo.isSelected()){
                    //Consulta de Productos Activos
                    modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                    "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                    "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.STATUS='DISP')");

                }
                else{
                    //Consulta para traerse todo
                    modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO, CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                    "WHERE ((PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                    "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA))");

                }
            }
            if((jtextHasta.getText().isEmpty()) && (jtextPrecio.getText().isEmpty())){
                if(jtextDenominacion.getText().isEmpty()){
                }
                else{
                    if(jcbnAactivo.isSelected()){
                    //Consulta de Productos por Denominacion y por no activos
                        modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                        "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                        "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='NOT')");

                    }
                    else if(jcbActivo.isSelected()){
                        //Consulta de Productos por Denominacion y por Activos
                        modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                        "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                        "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='DISP')");

                    }
                    else{
                        //Consulta de Productos por denominacion
                        modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                        "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                        "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%')");

                    }   
                }
            }
//            
            if(jtextDenominacion.getText().isEmpty()){
                
                if(jtextHasta.getText().isEmpty()){
                    if (jtextPrecio.getText().isEmpty()){    
                    }
                    else{
                        if(jcbnAactivo.isSelected()){
                            //Consulta de Productos mayores a un precio y no activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<=99999999999999999999) AND (PRODUCTO.STATUS='NOT'))");

                        }
                        else if(jcbActivo.isSelected()){
                            //Consulta de Productos mayores a un precio y activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<=99999999999999999999) AND (PRODUCTO.STATUS='DISP'))");

                        }
                        else{
                            //Consulta de Productos mayores a un precio
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<=9999999999999999999999999999999))");
                        }    
                    }
                }
                else{
                    if (jtextPrecio.getText().isEmpty()){
                        if(jcbnAactivo.isSelected()){
                            //Consulta de Productos menores a un precio y no activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>=0) AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+") AND (PRODUCTO.STATUS='NOT'))");
                        }
                        else if(jcbActivo.isSelected()){
                            //Consulta de Productos menores a un precio y activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>=0) AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+") AND (PRODUCTO.STATUS='DISP'))");
                        }
                        else{
                            //Consulta de Productos menores a un precio
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>=0) AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }
                    }
                    else{
                        if(jcbnAactivo.isSelected()){
                            //Consulta de Productos en un rango de precio y no activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+") AND (PRODUCTO.STATUS='NOT'))");
                        }
                        else if(jcbActivo.isSelected()){
                            //Consulta de Productos en un rango de precio y activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+") AND (PRODUCTO.STATUS='DISP'))");
                        }
                        else{
                            //Consulta de Productos en un rango de precio
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }    
                    }
                }
            }
            else{
                if(jtextHasta.getText().isEmpty()){
                    if (jtextPrecio.getText().isEmpty()){
    
                    }
                    else{
                        if(jcbnAactivo.isSelected()){
                            //Consulta de Productos mayores a un precio,denominacion y no activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='NOT') AND ((PRODUCTO.PRECIO>= "+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<=9999999999999999999999))");
                        }
                        else if(jcbActivo.isSelected()){
                            //Consulta de Productos mayores a un precio,denominacion y activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='DISP') AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<=9999999999999999999999))");
                        }
                        else{
                            //Consulta de Productos mayores a un precio y denominacion
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<=999999999999999999999))");
                        }    
                    }
                }
                else{
                        
                    if (jtextPrecio.getText().isEmpty()){
                        if(jcbnAactivo.isSelected()){
                            //Consulta de Productos menores a un precio,denominacion y no activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='NOT') AND ((PRODUCTO.PRECIO>=0) AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }
                        else if(jcbActivo.isSelected()){
                            //Consulta de Productos menores a un precio,denominacion y activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='DISP') AND ((PRODUCTO.PRECIO>=0) AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }
                        else{
                            //Consulta de Productos menores a un precio y denominacion
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND ((PRODUCTO.PRECIO>=0) AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }
                    }
                    else{
                        if(jcbnAactivo.isSelected()){
                            //Consulta de Productos en un rango de precio,denominacion y no activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='NOT') AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }
                        else if(jcbActivo.isSelected()){
                            //Consulta de Productos en un rango de precio,denominacion y activos
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND (PRODUCTO.STATUS='DISP') AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        }
                        else{
                            //Consulta de Productos en un rango de precio y denominacion
                            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
                            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
                            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.DENOMINACION LIKE '%"+jtextDenominacion.getText().toUpperCase()+"%') AND ((PRODUCTO.PRECIO>="+jtextPrecio.getText()+") AND (PRODUCTO.PRECIO<="+jtextHasta.getText()+"))");
                        
                        }    
                    }
                }
            }
        }

        //Consulta por Codigo
        else{
            modelo=ManejoDatos.llenarTabla("SELECT PRODUCTO.ID_PRODUCTO, PRODUCTO.DENOMINACION, PRODUCTO.PRECIO, PRODUCTO.STATUS, CUENTA_PRESUPUESTARIA.DENOMINACION FROM PRODUCTO , CATEGORIA_DE_PRODUCTOS, CUENTA_PRESUPUESTARIA\n" +
            "WHERE (PRODUCTO.ID_CATEGORIA_PRODUCTO= CATEGORIA_DE_PRODUCTOS.ID_CATEGORIA_PRODUCTO) AND \n" +
            "(CATEGORIA_DE_PRODUCTOS.ID_CUENTA_PRESUPUESTARIA= CUENTA_PRESUPUESTARIA.ID_CUENTA_PRESUPUESTARIA) AND (PRODUCTO.ID_PRODUCTO= "+jtextCodigo.getText()+")");
        }
    JTable1.setModel(modelo);
    jtextPrecio.setText("");
    jtextHasta.setText("");
    jtextDenominacion.setText(""); 
    jtextCodigo.setText(""); 
    }                                         

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {  
       //Cuando se marque una fila en la tabla automaticamente se limpiaron los campos de entrada de datos
       idEditar = 0;
       int filaClick=JTable1.getSelectedRow();
       System.out.println(filaClick);
       if (modelo!=null){
           idEditar = Integer.valueOf(ManejoDatos.mostrarIdseleccionado(modelo, (filaClick)));
       }
       JTable1.setToolTipText("Si desea editar este registro, ingrese los datos de denominacion y cuenta presupuestaria nuevos, y pulse editar");
    }   
    
    private void jtextPrecioActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jtextHastaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jtextCodigoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }   
     private void campoTyped(java.awt.event.KeyEvent evt) {                                 
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
             Toolkit.getDefaultToolkit().beep();
             evt.consume();
        }
    }



    // End of variables declaration                   
}
