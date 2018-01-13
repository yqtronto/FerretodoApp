import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.event.*;

public class EjercicioEventos2 extends JFrame {
	private static JButton bAceptar;
	private static JButton bCancelar;
	ImageIcon icono;
	Container cp;
	JLabel etiqueta_nombre;
	JTextField textField_nombre;
	JButton boton_saludo;
	
	public EjercicioEventos2(String titulo) {
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
		
		//boton_saludo.addActionListener(new MiClaseManejaEventos());
		boton_saludo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField_nombre.setText("Eventos con clase Anónimas");
			}
		});
		
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
		EjercicioEventos2 marco = new EjercicioEventos2("Ferretodo");
		/*
		JPanel panelBotones = new JPanel();
		bAceptar = new JButton("Aceptar");
		bCancelar = new JButton("Cancelar");
		
		bAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// miTextField.setText("Boton Aceptar Presionado...");
			}
		});*/
	}
	
	class MiClaseManejaEventos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Hola luanda 4");
			textField_nombre.setText("Hola");
		}
	}
	
}
