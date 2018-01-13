
package Utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author Gilbert Montaña-Mariely Fernandez
 */
public class Fecha extends JLabel implements Runnable{

    private String dia, mes, a�o; 
    private Calendar calendario = new GregorianCalendar(); 
    Thread hilo; 

    public Fecha() { //Constructor 
        hilo = new Thread(this); 
        hilo.start(); 
    } //fin constructor 

    public void calcula () {

        Calendar calendario = new GregorianCalendar();
        dia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
        mes = String.valueOf((calendario.get(Calendar.MONTH))+1);
        a�o = String.valueOf(calendario.get(Calendar.YEAR)); 
    }
    
    @ Override 
    public void run() { 
        Thread ct = Thread.currentThread(); 
        while (ct == hilo) { 
            try { 
                
                calcula();  
                setText(dia+"-"+mes+"-"+a�o);
                Thread.sleep(1000); 
                
            }catch (InterruptedException ex) {            
                System.out.println(ex.getMessage()); 
            } 
        } 
    }
}

