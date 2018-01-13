package cafetera;
/**
*
* Desarrolla una clase Cafetera con atributos capacidadMaxima (la cantidad máxima de café
* que puede contener la cafetera) y cantidadActual (la cantidad actual de café que hay en
* la cafetera). Implementa, al menos, los siguientes métodos:
* 
* - Constructor predeterminado: establece la capacidad máxima en 1000 (c.c.)
*   y la actual en cero (cafetera vacía).
* 
* - Constructor con la capacidad máxima de la cafetera; inicializa la cantidad
*   actual de café igual a la capacidad máxima.
*   
* - Constructor con la capacidad máxima y la cantidad actual. Si la cantidad actual 
*   es mayor que la capacidad máxima de la cafetera, la ajustará al máximo. 
*   
* - llenarCafetera(): pues eso, hace que la cantidad actual sea igual a la capacidad.
* - servirTaza(int): simula la acción de servir una taza con la capacidad indicada.
*   Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede.
* - vaciarCafetera(): pone la cantidad de café actual en cero.
* - agregarCafe(int): añade a la cafetera la cantidad de café indicada. 
*
* @author Yhovanny Quintero
* @version 1.0
* 
*/
public class Cafetera {
	int capacidadMaxima;
    int capacidadActual;
    
    /**
     * Este constructor permite inicializar la clase Cafetera con
     * capacidadMaxima de 1000cc y capacidadActual en 0cc.
     */
    public Cafetera(){
        capacidadMaxima = 1000;
        capacidadActual = 0;
        System.out.println("");
        System.out.println("Constructor - Cafetera inicializada con capacidadMaxima: " +  capacidadMaxima + " capacidadActual: " + capacidadActual);
    }
    
    /**
     * Este constructor permite incializar la clase Cafetera con
     * capacidadMaxima y capacidadActual con el valor del
     * parámetro llenado.
     * 
     * @param llenadoMax: Establece el máximo llenado de la cafetera. 
     */
    public Cafetera(int llenado){
        capacidadMaxima = llenado;
        capacidadActual = llenado;
        System.out.println("");
        System.out.println("Constructor - Cafetera(int) inicializada con capacidadMaxima: " +  capacidadMaxima + " capacidadActual: " + capacidadActual);
    }
    
    /**
     * Este constructor permite inicializar la clase Cafetera con
     * capacidadMaxima igual al parámetro llenadoMaximo y
     * capacidadActual igual al parámetro llenadoActual.
     * 
     * @param llenadoMaximo: Establece la máxima capacidad de llenado.
     * @param llenadoActual: Establece la actual capacidad de llenado. 
     */
    public Cafetera(int llenadoMaximo, int llenadoActual){
        capacidadMaxima = llenadoMaximo;
        if (llenadoActual > llenadoMaximo){
            capacidadActual = llenadoMaximo;
        } else {
            capacidadActual = llenadoActual;
        }
        System.out.println("");
        System.out.println("Constructor - Cafetera(int, int) inicializada con capacidadMaxima: " +  capacidadMaxima + " capacidadActual: " + capacidadActual);
    }
    
    /**
     * Este método permite llenar a su máxima capacidad a la Cafetera.
     */
    public void llenarCafetera(){
        capacidadActual = capacidadMaxima;
        System.out.println("");
        System.out.println("Metodo: llenarCafetera");
        System.out.println("La capacidad actual de la Cafetera despues de llenar es: " + capacidadActual);
    }
    
    /**
     * Este método permite servir café a una taza estableciendo por el
     * parámetro cadInd, la cantidad deseada.
     * 
     * @param cantidad : Establece la cántidad de café en cc para llenar la taza.
     */
    public void servirTaza(int cantidad){
      //  int capTemporal;
    	System.out.println("");
        System.out.println("Método: servirTaza - Parámetro: int " + cantidad);
        if (cantidad > capacidadActual){
           // capTemporal = capacidadActual;
           System.out.println("Lo que se pudo servir de cafe fue: "+ capacidadActual); 
           capacidadActual = 0;
     
        } else {
           // capTemporal = capInd;
            capacidadActual -= cantidad;
        }
        System.out.println("La capacidad actual de la Cafetera despues de servir es: " + capacidadActual);
    }
    
    /**
     * Este método permite agregar café a la Cafetera indicanco la cantidad
     * necesaria en el parametro <strong>capInd</strong>.
     * 
     * @param cantidad : Establece la cántidad de café en cc para llenar la Cafetera.
     */
    public void agregarCafe(int cantidad){
        int capTemp = cantidad + capacidadActual;
        if ( capTemp > capacidadMaxima) {
            capacidadActual = capacidadMaxima;
        } else {
            capacidadActual += cantidad;
        }
        System.out.println("");
        System.out.println("Método: agregarCafe - Parámetro: int " + cantidad);
        System.out.println("La capacidad actual de la Cafetera despues de llenar es: " + capacidadActual);
        if (capTemp > capacidadMaxima){
            System.out.println("Sobró del llenado indicado: " + (capTemp - capacidadMaxima));
        }
    }
    
    public void vaciarCafetera() {
    	capacidadActual = 0;
    	System.out.println("La capacidad actual de la Cafetera despues de vaciae es: " + capacidadActual);
    }
    
    public void verCapacidadMaxima(){
        System.out.println("Capacidad Maxima: " + capacidadMaxima);
    }
    
    public void verCapacidadActual(){
        System.out.println("Capacidad Actual: " + capacidadActual);
    }
}
