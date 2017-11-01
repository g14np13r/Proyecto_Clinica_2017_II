package clases;

public class Internamiento {
	//
	private int codigoInternamiento, codigoPaciente, numeroCama;
	private String fechaIngreso, horaIngreso, fechaSalida, horaSalida;
	private int estado;
	
	public Internamiento(int codigoInternamiento, int codigoPaciente, int numeroCama, String fechaIngreso,
			String horaIngreso, String fechaSalida, String horaSalida, int estado) {
		this.codigoInternamiento = codigoInternamiento;
		this.codigoPaciente = codigoPaciente;
		this.numeroCama = numeroCama;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.estado = estado;
	}
	
	
}
