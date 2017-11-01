package clases;

public class DetalleAtencion {
	//
	private int codigoAtencion, codigoMedicina, cantidad;
	private double precioUnitario;

	
	public DetalleAtencion(int codigoAtencion, int codigoMedicina, int cantidad, double precioUnitario) {
		this.codigoAtencion = codigoAtencion;
		this.codigoMedicina = codigoMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	
	
}
