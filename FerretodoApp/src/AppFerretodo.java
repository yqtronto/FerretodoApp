
import DDBB.ConexionDB;
import java.awt.Container;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Luis Ochoa
 */
public class AppFerretodo{
    
    static public JFrame marco;
    
     
    
    public static void main(String[] args){
        marco = new JFrameFerretodo();//this is a BorderLayout()
        marco.setResizable(false);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        
    
        
   }
  
}
