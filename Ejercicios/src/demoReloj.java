import java.util.Calendar;
import java.util.GregorianCalendar;

//import Reloj;

public class demoReloj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GregorianCalendar fecha = new GregorianCalendar();
		Calendar calendar = new GregorianCalendar();
		calendar.set(2018, 0, 8);
		
		Reloj reloj = new Reloj();
		//calendar = Calendar.Builder.setFeilds(Calendar.YEAR, 2013, Calendar.MONTH, Calendar.DECEMBER, Calendar.DAY_OF_MONTH, 23);
		fecha.set(2018,0,8);
		System.out.println("Fecha: " + calendar.get(Calendar.YEAR));
		System.out.println(fecha.get(GregorianCalendar.YEAR));
		
		reloj.setFecha(fecha);
		System.out.println("");

	}

}
