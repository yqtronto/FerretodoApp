
package Utilidades;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * UtilLayout creada para utilidades de layout
 * @author Luis Ochoa
 */
public class UtilLayout {
    
    /**
     * getFrameParent obtiene el padre de un Component(Panel) 
     * Ejemplo de uso UtilLayout.getFrameParent(PanelEmpleado.this)
     * Retorna el JFrame padre
     * @param panel
     * @return 
     */
    public static JFrame getFrameParent(Component panel){
        return (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, panel);
    }
    
}
