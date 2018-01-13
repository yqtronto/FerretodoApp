package dispositivosElectronicos;

public class DispositivoElectronico {
	private String marca;
	private String modelo;
	
	public DispositivoElectronico() {
		this.marca = "";
		this.modelo = "";
	}
	
	public DispositivoElectronico(String marca, String modelo) {
		this.marca= marca;
		this.modelo= modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
