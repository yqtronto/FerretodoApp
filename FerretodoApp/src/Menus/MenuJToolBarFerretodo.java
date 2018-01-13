
package Menus;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author Luis Ochoa
 */
public class MenuJToolBarFerretodo extends JToolBar{
    public JButton facturacion          = new JButton(new ImageIcon("image//factura2.png"));
    public JButton clientes             = new JButton(new ImageIcon("image//clientes.png"));
    public JButton proveedores          = new JButton(new ImageIcon("image//proveedor.jpg"));
    public JButton ordenPago            = new JButton(new ImageIcon("image//odp.png"));
    public JButton empleado             = new JButton(new ImageIcon("image//empleados.png"));
    public JButton producto             = new JButton(new ImageIcon("image//producto.png"));
    public JButton inventario           = new JButton(new ImageIcon("image//inventario.png"));
    
    public JButton almacen              = new JButton(new ImageIcon("image//almacen.png")); 
    public JButton cargo                = new JButton(new ImageIcon("image//cargo.png")); 
    public JButton catProducto          = new JButton(new ImageIcon("image//categoria.gif")); 
    public JButton cuentPresupuestaria  = new JButton(new ImageIcon("image//cuentaPresupuestaria.png")); 
    public JButton discapacidad         = new JButton(new ImageIcon("image//certificado.png"));
    public JButton modalidadPago        = new JButton(new ImageIcon("image//modalidadPago.png"));
    public JButton surcursal            = new JButton(new ImageIcon("image//sucursal.png"));
    public JButton usuario              = new JButton(new ImageIcon("image//usr.jpg"));

    public MenuJToolBarFerretodo() {

        this.MenuJToolBarTooltips();
        
        this.add(facturacion);
        this.add(clientes);
        this.add(proveedores);
        this.add(ordenPago);
        this.add(empleado);
        this.add(producto);
        this.add(inventario);
        
        this.add(almacen);
        this.add(cargo);
        this.add(catProducto);
        this.add(cuentPresupuestaria);
        this.add(discapacidad);        
        this.add(modalidadPago);        
        this.add(surcursal);    
        this.add(usuario);

    }

    /**
     * MenuJToolBarTooltips agrega los tooltips a los subMenu manualmente
     */
    public void MenuJToolBarTooltips(){
        //agregando tooltips
        facturacion.setToolTipText("Facturacion");
        clientes.setToolTipText("Clientes");
        proveedores.setToolTipText("Proveedores");
        ordenPago.setToolTipText("Orden de Pago");
        empleado.setToolTipText("Empleado");
        producto.setToolTipText("Gestion Productos");
        inventario.setToolTipText("Inventario");
        
        almacen.setToolTipText("Almacen");
        cargo.setToolTipText("Cargo");
        catProducto.setToolTipText("Cuenta Presupuestaria");
        cuentPresupuestaria.setToolTipText("Categoria Producto");
        discapacidad.setToolTipText("Discapacidad");
        modalidadPago.setToolTipText("Modalidad de Pago");         
        surcursal.setToolTipText("Sucursales");         
        usuario.setToolTipText("Usuario");
    }
    
}
