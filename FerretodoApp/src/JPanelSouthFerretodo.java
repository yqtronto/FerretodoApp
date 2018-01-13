
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel del Sur
 * @author Luis Ochoa
 */
public class JPanelSouthFerretodo extends JPanel{
    JLabel logo = new JLabel(new ImageIcon("image//ferretodoLogoMin.png"));
    JLabel copyRight = new JLabel("Creado por: Programa de formación de sistemas Cohorte III ");

    public JPanelSouthFerretodo() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(logo);
        this.add(copyRight);
    }

}
