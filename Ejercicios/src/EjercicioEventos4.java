import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.event.*;

public class EjercicioEventos4 extends JFrame {
	ImageIcon icono;
	Container cp;
	JLabel etiqueta_nombre;
	JTextField textField_nombre;
	JButton boton_saludo;
	JButton boton_limpiar;
	
	public EjercicioEventos4(String titulo) {
		setTitle(titulo);
		icono = new ImageIcon("image//sucursal.png");
		setIconImage(icono.getImage());
		setLocation(220,20); // posicion del JFrame en el escritorio.
		setSize(900, 500);
		addComponentes();
		//addTabla();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	void addComponentes() {
		cp = getContentPane();
		//cp.setLayout(new FlowLayout());
		etiqueta_nombre = new JLabel ("Nombre: ");
		textField_nombre = new JTextField(20);
		boton_saludo = new JButton("Saludar");
		
		boton_saludo.addActionListener(new MiClaseManejaEventos());
		
		boton_limpiar = new JButton("Limpiar");
		boton_limpiar.addActionListener(new MiClaseManejaEventos());
		
		FlowLayout mLayout = new FlowLayout();
		mLayout.setAlignment(FlowLayout.RIGHT);
		mLayout.setHgap(50);
		mLayout.setVgap(20);
		
		
		
		cp.setLayout(mLayout);
		cp.add(etiqueta_nombre);
		cp.add(textField_nombre);
		cp.add(boton_saludo);
		cp.add(boton_limpiar);
	}
	
	public static void main(String[] args) {
		EjercicioEventos4 marco = new EjercicioEventos4("Ferretodo");
	}
	
	class MiClaseManejaEventos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == boton_saludo) {
				textField_nombre.setText("Hola con clase anonima");				
			} else if (e.getSource() == boton_limpiar) {
				JOptionPane aviso = new JOptionPane();
				aviso.showMessageDialog(null, "Gracias por utilizar nuestro programa");
				System.exit(0);
			}
			//System.out.println("Hola luanda 4");
		}
	}
	
}
