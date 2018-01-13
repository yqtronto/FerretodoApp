import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.event.*;

public class EjercicioEventos3 extends JFrame implements ActionListener {
	ImageIcon icono;
	Container cp;
	JLabel etiqueta_nombre;
	JTextField textField_nombre;
	JButton boton_saludo;
	
	public EjercicioEventos3(String titulo) {
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
		boton_saludo.addActionListener(this);
				
		FlowLayout mLayout = new FlowLayout();
		mLayout.setAlignment(FlowLayout.RIGHT);
		mLayout.setHgap(50);
		mLayout.setVgap(20);
		
		
		
		cp.setLayout(mLayout);
		cp.add(etiqueta_nombre);
		cp.add(textField_nombre);
		cp.add(boton_saludo);
	}
	
	public static void main(String[] args) {
		EjercicioEventos3 marco = new EjercicioEventos3("Ferretodo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textField_nombre.setText("Hola mundo");
	}
	
}
