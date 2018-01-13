package utilidades;
import calculos.Calculadora;
import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
 * Construir una aplicacion denominada demoCalculadora en el paquete utilidades.
 * 
 * Dentro del método main, realizar invocación de los métodos sumar, restar, y multiplicar de la clase calculadora.
 * 
 * Muestre por pantalla después de cada operación, los argumentos indicados y resultados obtenidos.
 *
 * @author Yhovanny Quintero
 * @version 1.0
 * 
 */
public class demoCalculadora {
    public static NumberFormat fn = new DecimalFormat("#0.00");
    
    public static void main(String[] args){
        Calculadora calc = new Calculadora("HP","50g");
                
        double num1 = 16;
        double num2 = 5;
        double numN = -15;
        
        double res = calc.sumar(num1, num2);
        System.out.println("La suma de " + num1 + " y " + num2 + " es : " + res);

        res = calc.restar(num1, num2);
        System.out.println("La resta de " + num1 + " y " + num2 + " es : " + res);

        res = calc.multiplicar(num1, num2);
        System.out.println("La multiplicacion de " + num1 + " y " + num2 + " es : " + res);

        res = calc.dividir(num1, num2);
        System.out.println("La division de " + num1 + " y " + num2 + " es : " + fn.format(res));

        res = calc.valorAbsoluto(numN);
        System.out.println("El valor absoluto de " + numN + " es : " + res);

        res = calc.raizCuadrada(num1);
        System.out.println("La raíz cuadrada de " + num1 + " es : " + fn.format(res));
        
        calc.getMostrar();
    }
    
}
