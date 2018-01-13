import java.util.Calendar;
import java.util.Scanner;

import cafetera.Cafetera;

/**
*
* @author Yhovanny Quintero
* @version 1.0
* 
*/
public class demoCafetera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cafetera cafe = new Cafetera();
		Scanner teclado= new Scanner(System.in);
        /*cafe.servirTaza(6);
        cafe.servirTaza(5);
        cafe.servirTaza(4);
        cafe.llenarCafetera();
        cafe.servirTaza(15);
        cafe.agregarCafe(8);
        cafe.agregarCafe(5);*/
		int opcion, cantidad;
		do {
			System.out.println("Seleccione una opción: ");
			System.out.println("1.llenar la cafetera");
			System.out.println("2.Servir taza");
			System.out.println("3. Vaciar cafetera");
			System.out.println("4.Salir");
			opcion=teclado.nextInt();
			
			switch (opcion) {
			case 1:
				cafe.llenarCafetera();
				break;
				
			case 2:
				System.out.println("Introduzca la cantidad: ");
				cantidad=teclado.nextInt();
				cafe.servirTaza(cantidad);
				break;
				
			case 3:
				cafe.vaciarCafetera();
				break;
			}
			
			
		} while (opcion!=4); 
		
	}

}
