package clases;

public class Atencion {
	//Campos o atributos
	private int codigoAtencion, codigoPaciente, fechaAtencion;
	private double totalPagar;
	private int estado;
	
	//Metodo Constructor
	public Atencion(int codigoAtencion, int codigoPaciente, int fechaAtencion, double totalPagar, int estado) {
		this.codigoAtencion = codigoAtencion;
		this.codigoPaciente = codigoPaciente;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}
	
	//Metodo 
	public String detalleEstado(){
		switch (estado) {
		case 0: return "Pendiente";
		default:return "Pagado";
		}
	}

	//Metodos Setters & Getters. Propiedades de lectura(get return) y escritura(set void)
	public int getCodigoAtencion() {
		return codigoAtencion;
	}

	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public int getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(int fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
		
}
