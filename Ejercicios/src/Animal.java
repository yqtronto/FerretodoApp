
public abstract class Animal {
	protected int patas;
	
	protected Animal(int patas) {
		this.patas = patas;
	}
	
	abstract void desplazarce(int mts);
	
	abstract void comer();
	
}
