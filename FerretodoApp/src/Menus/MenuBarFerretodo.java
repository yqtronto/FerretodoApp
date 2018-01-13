package Menus;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Ochoa
 */
public class MenuBarFerretodo extends JMenuBar{
    public JMenu ventas                        = new JMenu("Ventas"); 
        public JMenuItem facturacion           = new JMenuItem("Facturación");    

    public JMenu gestionA                      = new JMenu("Gestion Administrativa");
        public JMenuItem clientes              = new JMenuItem("Clientes");
        public JMenuItem proveedores           = new JMenuItem("Proveedores");
        public JMenuItem ordenPago             = new JMenuItem("Orden de pago");  
        
    public JMenu menuRRHH                      = new JMenu("Recursos Humanos");
        public JMenuItem empleado              = new JMenuItem("Empleados");
        public JMenuItem certificadosDis       = new JMenuItem("Certificado de discapacidad");

    public JMenu producto                      = new JMenu("Producto");
        public JMenuItem gestProducto          = new JMenuItem("Gestion de Productos");
        public JMenuItem inventario            = new JMenuItem("Inventario");
        
    public JMenu administracionS               = new JMenu("Administracion de Sistemas");
        public JMenuItem usuario               = new JMenuItem("Usuarios");
        public JMenuItem sucursal              = new JMenuItem("Sucursal");        
        public JMenuItem cargo                 = new JMenuItem("Cargo");        
        public JMenuItem discapacidad          = new JMenuItem("Discapacidad");
        public JMenuItem cuentaPresupuestaria  = new JMenuItem("Cuenta Presupuestaria");
        public JMenuItem almacen               = new JMenuItem("Almacen");
        public JMenuItem modalidaPago          = new JMenuItem("Modalidad de Pago");
        public JMenuItem salir                 = new JMenuItem("Salir");         
        
    public MenuBarFerretodo() {
        this.add(menuVentas());
        this.add(menuGestionAdministrativa());
        this.add(menuRRHH());
        this.add(menuProducto());
        this.add(menuAdministracionDeSistemas());
    }
    
    public JMenu menuVentas(){
        ventas.add(facturacion);
        return ventas;
    }
    
    public JMenu menuGestionAdministrativa(){
        gestionA.add(clientes);
        gestionA.add(proveedores);
        gestionA.add(ordenPago);
        return gestionA;
    }
    
    public JMenu menuRRHH(){
        menuRRHH.add(empleado);
        menuRRHH.add(certificadosDis);
        return menuRRHH;
    }

    
    public JMenu menuProducto(){
        producto.add(gestProducto);
        producto.add(inventario);
        return producto;
    }
    
    public JMenu menuAdministracionDeSistemas(){
        administracionS.add(almacen);
        administracionS.add(cargo);
        administracionS.add(cuentaPresupuestaria);
        administracionS.add(discapacidad);
        administracionS.add(modalidaPago);
        administracionS.add(sucursal);
        administracionS.add(usuario);
        administracionS.add(salir);
        return administracionS;
    }
    

}
