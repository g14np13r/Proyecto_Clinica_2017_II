package clases;

public class Internamiento {
	//Campos o atributos
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
	//Metodo 
	public String detalleEstado(){
			switch (estado) {
			case 0: return "Alojado";
			default:return "Pagado";
		}
	}

	//Metodos Setters & Getters. Propiedades de lectura(get return) y escritura(set void)
	public int getCodigoInternamiento() {
		return codigoInternamiento;
	}

	public void setCodigoInternamiento(int codigoInternamiento) {
		this.codigoInternamiento = codigoInternamiento;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public int getNumeroCama() {
		return numeroCama;
	}

	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
