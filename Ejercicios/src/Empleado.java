import java.util.GregorianCalendar;

public class Empleado {
	public String nombre;
	public double sueldo;
	public GregorianCalendar fechaIngreso;
	public String departamento;
	
	public Empleado(String nombre, double sueldo, GregorianCalendar fechaIngreso, String departamento) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.fechaIngreso = fechaIngreso;
		this.departamento = departamento;
	}
	
	public void getDetalles() {
		System.out.println("Nombre: " + this.nombre + "\nSueldo: " + this.sueldo + "\nFecha Ingreso: " + this.fechaIngreso.get(GregorianCalendar.DAY_OF_MONTH) + "/" + this.fechaIngreso.get(GregorianCalendar.MONTH) + "/" + this.fechaIngreso.get(GregorianCalendar.YEAR) + "\nDepartamento: " + this.departamento);
	}
	
}
