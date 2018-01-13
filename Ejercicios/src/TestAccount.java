import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		double cantidad;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca el monto para aperturar la cuenta:");
		cantidad= teclado.nextDouble();
		Account cuenta = new Account(cantidad);
		System.out.println("La apertura de la cuenta se realizó con la cantidad: " + cuenta.getBalance());
		do {
			System.out.println("Selecciona una opción:\n1. Deposito.\n2. Retiro.\n3. Ver balance.\n0. Salir.");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduzca la cantidad a depositar: ");
				cantidad= teclado.nextDouble();
				cuenta.deposit(cantidad);
				break;
			case 2:
				System.out.println("Introduzca el monto a retirar:");
				cantidad= teclado.nextDouble();
				cuenta.withdraw(cantidad);
				break;
			case 3:
				System.out.println("Su balance actual es: " + cuenta.getBalance());
				break;
			}
		
		}while (opcion > 0);
		System.out.println("Gracias por visitarnos");
		
	}

}
