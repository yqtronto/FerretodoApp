import java.util.Scanner;

public class EjemplosExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nro1, nro2;
		char opc = 's';
		double res = 0;
		Scanner teclado = new Scanner(System.in);
		
		do {
			
			System.out.println("Indique el primer operando para la división:");
			nro1 = teclado.nextInt();

			System.out.println("Indique el segundo operando para la división:");
			nro2 = teclado.nextInt();
			try {
				res = nro1 / nro2;
			} catch(Exception excepcion) {
				System.out.println("Intento por dividir por cero...");
			} finally {
				System.out.println("El resultado de la división de sus operando es: " +  res);
				
			}
			System.out.println("Desea realizar otra operación? ( S o N )");
			opc = teclado.next().charAt(0);

		} while ( opc == 's' || opc == 'S' ); 
		
	}

}
