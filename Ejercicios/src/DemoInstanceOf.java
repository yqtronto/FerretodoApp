import java.util.GregorianCalendar;

public class DemoInstanceOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.set(2018,1,8);
		
		Empleado miEmpleado = new Gerente("Yurelis",1600000,fecha, "Sistema", "LDO 75G", 600000);
		Gerente miGerente = new Gerente("Yhovanny",2600000,fecha, "Sistema", "XRT 89Y", 1600000);
		
		//miEmpleado.placaVehicCorpo = "LDO 75G";
		
		miEmpleado.getDetalles();
	}

}
