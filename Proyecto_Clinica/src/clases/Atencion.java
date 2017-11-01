package clases;

public class Atencion {
	//
	private int codigoAtencion, codigoPaciente, fechaAtencion;
	private double totalPagar;
	private int estado;
	
	
	public Atencion(int codigoAtencion, int codigoPaciente, int fechaAtencion, double totalPagar, int estado) {
		this.codigoAtencion = codigoAtencion;
		this.codigoPaciente = codigoPaciente;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}
	
	
}
