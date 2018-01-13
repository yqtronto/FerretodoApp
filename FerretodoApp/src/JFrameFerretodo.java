import Menus.MenuJToolBarFerretodo;
import Menus.MenuBarFerretodo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Luis Ochoa
 */
public class JFrameFerretodo extends JFrame implements ActionListener{
    
    String titulo  = "Ferretodo";  //imagen (colocarla en la carpeta raiz)  
    ImageIcon icono  = new ImageIcon("image//ferretodoIco.PNG");  //imagen (colocarla en la carpeta raiz)  
    MenuBarFerretodo menu = new MenuBarFerretodo();
    MenuJToolBarFerretodo subMenu = new MenuJToolBarFerretodo();
    JPanelSouthFerretodo jPanelSouthFerreto = new JPanelSouthFerretodo();
    JPanelCenterFerretodo jPanelCenterFerretodo = new JPanelCenterFerretodo();
    
    public JFrameFerretodo(){
        this.setTitle(titulo);
        this.setIconImage(icono.getImage());
        this.setResizable(false);//Redimensionar JFrame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Libera recursos al salir.
        this.setLocation(60, 20);
        this.setSize(900, 700);
        this.setLayout(new BorderLayout());
        this.eventosMenu();
        this.eventosSubMenu();
        this.agregarPaneles();
    }

    /**
     * agregarPaneles agrega los panes al BorderLayout Central
     */
    public void agregarPaneles(){
        this.setJMenuBar(menu);
        this.add(subMenu, BorderLayout.NORTH);
        this.add(jPanelCenterFerretodo, BorderLayout.CENTER);
        this.add(jPanelSouthFerreto, BorderLayout.SOUTH);       
    }
    
    /**
     * eventosMenu agrega un addActionListener a todos los menus manualmente
     */
    public void eventosMenu(){
        subMenu.almacen.addActionListener(this);        
        subMenu.cargo.addActionListener(this);        
        subMenu.catProducto.addActionListener(this);        
        subMenu.clientes.addActionListener(this);        
        subMenu.cuentPresupuestaria.addActionListener(this);        
        subMenu.discapacidad.addActionListener(this);        
        subMenu.empleado.addActionListener(this);        
        subMenu.facturacion.addActionListener(this);        
        subMenu.inventario.addActionListener(this);        
        subMenu.modalidadPago.addActionListener(this);        
        subMenu.ordenPago.addActionListener(this);        
        subMenu.producto.addActionListener(this);        
        subMenu.proveedores.addActionListener(this);        
        subMenu.surcursal.addActionListener(this);        
        subMenu.usuario.addActionListener(this);
    }
    
    /**
     * eventosSubMenu agrega un addActionListener a todos los sub-menus manualmente
     */
    public void eventosSubMenu(){
        menu.administracionS.addActionListener(this);        
        menu.almacen.addActionListener(this);        
        menu.cargo.addActionListener(this);        
        menu.certificadosDis.addActionListener(this);        
        menu.cuentaPresupuestaria.addActionListener(this);     
        menu.ordenPago.addActionListener(this);
        menu.discapacidad.addActionListener(this);        
        menu.facturacion.addActionListener(this);        
        menu.gestProducto.addActionListener(this);        
        menu.clientes.addActionListener(this);        
        menu.proveedores.addActionListener(this);        
        menu.empleado.addActionListener(this);  //gestionAEm      
        menu.inventario.addActionListener(this);        
        menu.modalidaPago.addActionListener(this);        
        menu.sucursal.addActionListener(this);
        menu.usuario.addActionListener(this);
        menu.ventas.addActionListener(this);
    }
    
    /**
     * actionPerformed manejador de eventos
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        //Eventos disparados si se cumplen las condiciones
        if (e.getSource() == menu.empleado || e.getSource() == subMenu.empleado ) {
            jPanelCenterFerretodo.card.show(jPanelCenterFerretodo, "Empleados");
        }
        if (e.getSource() == menu.gestProducto || e.getSource() == subMenu.producto ) {
            jPanelCenterFerretodo.card.show(jPanelCenterFerretodo, "Producto");
        }
        
    }
   
}
