package clases;

public class Paciente {
	//Campos o atributos
	private int codigoPaciente;
	private String apellidos, nombres, telefono, dni;
	
	//Metodo Constructor
	public Paciente(int codigoPaciente, String apellidos, String nombres, String telefono, String dni) {
		this.codigoPaciente = codigoPaciente;
		this.apellidos = apellidos;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
