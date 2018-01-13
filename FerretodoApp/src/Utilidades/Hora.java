
package Utilidades;

import java.util.Calendar; 
import java.util.Date; 
import java.util.GregorianCalendar; 
import javax.swing.JLabel; 
/**
 *
 * @author Gilbert MontaÃ±a- Mariely Fernandez
 */
public class Hora extends JLabel implements Runnable{

    private String dia, mes, año, hora, minutos, segundos; 
    private Calendar calendario = new GregorianCalendar(); 
    Thread hilo; 

    public Hora() { //Constructor 
        hilo = new Thread(this); 
        hilo.start(); 
    } //fin constructor 

    public void calcula () {

        Calendar calendario = new GregorianCalendar();
        hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        minutos = String.valueOf(calendario.get(Calendar.MINUTE));
        segundos = String.valueOf(calendario.get(Calendar.SECOND)); 
    }
    
    @ Override 
    public void run() { 
        Thread ct = Thread.currentThread(); 
        while (ct == hilo) { 
            try { 
                
                calcula();  
                setText(hora+" : "+minutos+" : "+segundos);
                Thread.sleep(1000); 
                
            }catch (InterruptedException ex) {            
                System.out.println(ex.getMessage()); 
            } 
        } 
    }
}
