import java.util.Scanner;

public class CadenaDeCaracteres2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String apenom1, apenom2;
		int edad1, edad2;
		System.out.println("Ingrese el apellido y el nombre:");
		apenom1=teclado.nextLine();
		System.out.println("Ingrese la edad:");
		edad1=teclado.nextInt();
		System.out.println("Ingrese el apellido y el nombre:");
		teclado.nextLine();
		apenom2=teclado.nextLine();
		System.out.println("Ingrese la edad:");
		edad2=teclado.nextInt();
		System.out.println("La persona mayor de edad es:");
		if (edad1>edad2) {
			System.out.println(apenom1);
		} else {
			System.out.println(apenom2);
		}
	}

}
