
public class Gato extends Animal implements Mascota {
	String nombre;
	
	public Gato(String nombre) {
		super(4);
		this.nombre = nombre;
	}
	
	public Gato() {
		super(4);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void jugar() {
		System.out.println("El gato esta jugando.");
	}

	@Override
	void desplazarce(int mts) {
		System.out.println("El gato avanzó: " + mts);
	}

	@Override
	void comer() {
		System.out.println("Los gatos comen comida de gato.");
	}
	
	

}
