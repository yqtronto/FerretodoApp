import java.util.GregorianCalendar;

public class Gerente extends Empleado {
	public String placaVehicCorpo;
	public double bonoProduc;
	
	public Gerente(String nombre, double sueldo, GregorianCalendar fechaIngreso, String departamento, String placaVehicCorpo, double bonoProduc) {
		super(nombre, sueldo, fechaIngreso, departamento);
		// TODO Auto-generated constructor stub
		this.placaVehicCorpo = placaVehicCorpo;
		this.bonoProduc = bonoProduc;
	}
	
	@Override
	public void getDetalles() {
		super.getDetalles();
		System.out.println("Placa de vehiculo corporativo: " + this.placaVehicCorpo + "\nBono productivo: " + this.bonoProduc);
	}
	
}
