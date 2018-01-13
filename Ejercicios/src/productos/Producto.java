package productos;
/**
* 
* Especifique una clase que represente productos con las siguientes propiedades:
* 
* - Tienen un código que los identifica de manera única y que se asigna en el momento de la creación.
* - Guardan la descripción y el precio sin impuesto.
* - No todos los productos comparten el mismo impuesto (Unos estarán exentos, 12%), que puede variar
*   en función de las decisiones del gobierno.
* - Fecha de incorporación a la oferta de productos de la empresa y fecha de desincorporación.
* 
* La clase Producto debe proporcionar los atributos necesarios y  métodos adecuados:
* 
* -  Constructores.
* -  Métodos para consulta y modificación de los atributos.
* -  Método para calcular el precio de venta del producto que se obtiene sumándole
*    al precio el IVA correspondiente. 
*
* @author Yhovanny Quintero
* @version 1.0
* 
*/
public class Producto {
	
	String codigo;
	String descripcion;
	double precio;
	double impuesto;
	boolean exento;

	public Producto(String codigo) {
		this.codigo = codigo;
		this.descripcion = "";
		this.precio = 0;
		this.impuesto = 0;
		this.exento = true;
	}
	
	public Producto(String codigo, String descripcion, double precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.impuesto = 0;
		this.exento = true;
	}

	public Producto(String codigo, String descripcion, double precio, double impuesto, boolean exento) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.impuesto = impuesto;
		this.exento = exento;
	}
	
	
	// Metodos SET
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public void setExento(boolean exento) {
		this.exento = exento;
	}

	
	// Metodos GET
	/**
	 * Metodo para obtener el código del producto.
	 * @return Retorna el código del producto en formato String.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo para obtener la descripción del producto.
	 * @return Retorna la descripción en formato String.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo para saber el precio sin impuesto (IVA) del producto.
	 * @return Retorna el precio en formato double.
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Método que permite saber cual es el impuesto (IVA) del producto.
	 * @return Retorna el impuesto en formato double.
	 */
	public double getImpuesto() {
		return impuesto;
	}
	
	/**
	 * Método para obtener si el producto esta exento o nó del iva.
	 * @return Retorna un booleano (true o false). 
	 */
	public boolean isExento() {
		return exento;
	}

	/**
	 * Método para obtener el precio de venta de un producto.
	 * @return Retorna el precio de venta en formato double.
	 */
	public double getPrecioVenta(){
		return precio + ( precio * impuesto / 100 );
	}
	
}
