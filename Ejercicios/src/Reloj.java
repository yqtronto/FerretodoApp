import java.util.GregorianCalendar;
import dispositivosElectronicos.DispositivoElectronico;

public class Reloj extends DispositivoElectronico {
	private String marca, modelo;
	private int hora, min, seg, medidiem;
	private int tipoFormato;
	private GregorianCalendar fecha;
	
	public Reloj(){
		super("","");
		this.marca = "";
		this.modelo = "";
		this.hora = 0;
		this.min = 0;
		this.seg = 0;
		this.medidiem = 0;
		this.tipoFormato = 0;
		this.fecha = new GregorianCalendar(); 
	}
	
	public Reloj(String modelo, String marca, GregorianCalendar fecha) {
		super(marca,modelo);
		this.modelo = modelo;
		this.marca = marca;
		this.hora = 0;
		this.min = 0;
		this.seg = 0;
		this.medidiem = 0;
		this.tipoFormato = 0;
		this.fecha = fecha;
	}
	
	public void setHora(int hora, int min, int seg, int tipoFormato) {
		this.hora = hora;
		this.min = min;
		this.seg = seg;
		this.tipoFormato = tipoFormato;
	}
	
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}
	
	private void setFormato(int formato) {
		this.tipoFormato = formato;
	}
	
}
