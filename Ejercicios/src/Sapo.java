
public class Sapo extends Animal{
	
	public Sapo() {
		super(4);
	}

	@Override
	public void desplazarce(int mts) {
		System.out.println("El sapo se desplazó: " + mts);
	}

	@Override
	public void comer() {
		System.out.println("Los sapos comen insectos, como moscas, mosquitos, libélulas y hormigas.");
	}

}
