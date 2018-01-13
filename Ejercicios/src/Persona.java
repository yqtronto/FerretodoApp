
public class Persona {
	private static int nPersonas;
	
	public Persona() {
		nPersonas++;
	}
	
	public int getPersonas() {
		return nPersonas;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona();
		Persona carols = new Persona();
		Persona maria = new Persona();
		Persona lucia = new Persona();
		
		System.out.println("P1: " + p1.getPersonas());
		//System.out.println("P2: " + carols.getPersonas());
		//System.out.println("P3: " + maria.getPersonas());
		//System.out.println(Persona.getPersonas());
	}

}
