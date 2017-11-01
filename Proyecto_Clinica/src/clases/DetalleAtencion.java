package clases;

public class DetalleAtencion {
	//Campos o atributos
	private int codigoAtencion, codigoMedicina, cantidad;
	private double precioUnitario;

	//Metodo Constructor
	public DetalleAtencion(int codigoAtencion, int codigoMedicina, int cantidad, double precioUnitario) {
		this.codigoAtencion = codigoAtencion;
		this.codigoMedicina = codigoMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	//Metodos Setters & Getters. Propiedades de lectura(get return) y escritura(set void)
	public int getCodigoAtencion() {
		return codigoAtencion;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	public int getCodigoMedicina() {
		return codigoMedicina;
	}

	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
