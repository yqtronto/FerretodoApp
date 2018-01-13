import calculos.Calculadora;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
/**
 *
 * @author Yhovanny Quintero
 * @version 1.0
 * 
 */
public class demoCalculadora {
    public static NumberFormat fn = new DecimalFormat("#0.00");
    
    public static void main(String[] args){
        Calculadora calc = new Calculadora("","");
        Calendar cal = new Calendar.Builder().build();
        
        
        
        System.out.println("La fecha es: " + cal);
        
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
        
        System.out.println("El factorial de 5 es: " + Calculadora.factorial(5));
    }
    
}
