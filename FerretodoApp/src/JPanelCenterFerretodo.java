
import Paneles.JPanelProducto;
import Paneles.PanelEmpleado;
import Paneles.PanelInicio;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Luis Ochoa
 */
public class JPanelCenterFerretodo extends JPanel{
       
    CardLayout card;
    PanelEmpleado panelEmpleado; 
    JPanel panelInicio; 
    //Panel panelProducto;
    JPanelProducto panelProducto;
    public JPanelCenterFerretodo() {
        card = new CardLayout();
        
        //Creando paneles
        panelEmpleado = new PanelEmpleado(); 
        panelInicio = new PanelInicio();
        panelProducto=new JPanelProducto();
        
        //Añadiendo paneles al cardLayout
        card.addLayoutComponent(panelEmpleado, "Empleados");
        card.addLayoutComponent(panelInicio, "panelInicio");
        card.addLayoutComponent(panelProducto, "Producto");
        //setiando cardlayout a jpanel
        this.setLayout(card);
        
        //añadiendo paneles al Jpanel gracias a q es tipo cardLayout
        this.add(panelEmpleado);
        this.add(panelInicio);
        this.add(panelProducto);
        card.show(this, "panelInicio");
    }
       
}
