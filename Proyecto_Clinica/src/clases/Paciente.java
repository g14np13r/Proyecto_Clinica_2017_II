package clases;

public class Paciente {
	//Campos o atributos
	private int codigoPaciente;
	private String apepat,apemat, nombres, telefono, dni;
	
	//Metodo Constructor
	public Paciente(int codigoPaciente, String apepat,String apemat, String nombres, String telefono, String dni) {
		this.codigoPaciente = codigoPaciente;
		this.apepat =apepat;
		this.apemat=apemat;
		this.nombres = nombres;
		this.telefono = telefono;
		this.dni = dni;
	}
	//Metodos Setters & Getters. Propiedades de lectura(get return) y escritura(set void)
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getApemat() {
		return apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
}
