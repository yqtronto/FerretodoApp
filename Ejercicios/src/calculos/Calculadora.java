package calculos;

import dispositivosElectronicos.DispositivoElectronico;

/**
*
* @author Yhovanny Quintero
* @version 1.0
* 
*/
public class Calculadora extends DispositivoElectronico {
    
    //private String marca;
    //private String modelo;
    
    
    public Calculadora() {
    	super("","");
    }
    
    /**
     * Constructor de la Clase Calculadora, el cual acepta dos parámetros para indicar
     * la marca y el modelo de la Calculadora.
     * 
     * @param marca  Especifica la marca de la calculadora en formato String.
     * @param modelo  Especifica el modelo de la calculadora en formato String.
     */
    public Calculadora(String marca, String modelo){
		super(marca,modelo);
    	//this.marca = marca;
        //this.modelo = modelo;
    }
    
    /**
     * Método que permite sumar dos números ingresados en los parámetros  numero1 y numero2.
     * 
     * @param numero1 Primer número para la suma en formato double.
     * @param numero2 Segundo número para la suma en formato double.
     * @return Resultado de la suma en formato double.
     */
    public double sumar(double numero1, double numero2){
        return numero1 + numero2;
    }
    
    /**
     * Método que permite restar dos números ingresados en los parámetros  numero1 y numero2.
     * 
     * @param numero1 Primer número para la resta en formato double.
     * @param numero2 Segundo número para la resta en formato double.
     * @return Resultado de la resta en formato double.
     */
    public double restar(double numero1, double numero2){
        return numero1 - numero2;
    }
    
    /**
     * Método que permite multiplicar dos números ingresados en los parámetros  numero1 y numero2.
     * 
     * @param numero1 Primer número para la multiplicación en formato double.
     * @param numero2 Segundo número para la multiplicación en formato double.
     * @return Resultado de la multiplicación en formato double.
     */
    public double multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    }
    
    /**
     * Método que permite dividir dos números ingresados en los parametros numero1 y numero2.
     * 
     * @param numero1 Primer número para la división en formato double.
     * @param numero2 Segundo número para la división en formato double.
     * @return Resultado de la división en formato double.
     */
    public double dividir(double numero1, double numero2){
        return numero1 / numero2;
    }
    
    /**
     * Método que permite obtener el valor absoluto a travéz de su parámetro numero.
     * 
     * @param numero Ingreso del número en formato double.
     * @return Resultado del valor absoluto en formato double.
     */
    public double valorAbsoluto(double numero){
        return Math.abs(numero);
    }
    
    /**
     * Método que permite obtener la raíz cuadrada a travéz de su parametro número.
     * 
     * @param numero Ingreso del número en formato double.
     * @return Resultado de la raíz cuadrada en formato double.
     */
    public double raizCuadrada(double numero){
        return Math.sqrt(numero);
    }
    
    public void getMostrar() {
    	System.out.println("El modelo es: " + super.getModelo());
    }
    
    public static int factorial(int n) {
    	int fact = 1;
    	while ( n > 0) {
    		fact *= n--;
    	}
    	return fact;
    }

}
