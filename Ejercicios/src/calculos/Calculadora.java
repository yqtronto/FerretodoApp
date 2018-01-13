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
     * Constructor de la Clase Calculadora, el cual acepta dos par�metros para indicar
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
     * M�todo que permite sumar dos n�meros ingresados en los par�metros  numero1 y numero2.
     * 
     * @param numero1 Primer n�mero para la suma en formato double.
     * @param numero2 Segundo n�mero para la suma en formato double.
     * @return Resultado de la suma en formato double.
     */
    public double sumar(double numero1, double numero2){
        return numero1 + numero2;
    }
    
    /**
     * M�todo que permite restar dos n�meros ingresados en los par�metros  numero1 y numero2.
     * 
     * @param numero1 Primer n�mero para la resta en formato double.
     * @param numero2 Segundo n�mero para la resta en formato double.
     * @return Resultado de la resta en formato double.
     */
    public double restar(double numero1, double numero2){
        return numero1 - numero2;
    }
    
    /**
     * M�todo que permite multiplicar dos n�meros ingresados en los par�metros  numero1 y numero2.
     * 
     * @param numero1 Primer n�mero para la multiplicaci�n en formato double.
     * @param numero2 Segundo n�mero para la multiplicaci�n en formato double.
     * @return Resultado de la multiplicaci�n en formato double.
     */
    public double multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    }
    
    /**
     * M�todo que permite dividir dos n�meros ingresados en los parametros numero1 y numero2.
     * 
     * @param numero1 Primer n�mero para la divisi�n en formato double.
     * @param numero2 Segundo n�mero para la divisi�n en formato double.
     * @return Resultado de la divisi�n en formato double.
     */
    public double dividir(double numero1, double numero2){
        return numero1 / numero2;
    }
    
    /**
     * M�todo que permite obtener el valor absoluto a trav�z de su par�metro numero.
     * 
     * @param numero Ingreso del n�mero en formato double.
     * @return Resultado del valor absoluto en formato double.
     */
    public double valorAbsoluto(double numero){
        return Math.abs(numero);
    }
    
    /**
     * M�todo que permite obtener la ra�z cuadrada a trav�z de su parametro n�mero.
     * 
     * @param numero Ingreso del n�mero en formato double.
     * @return Resultado de la ra�z cuadrada en formato double.
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
