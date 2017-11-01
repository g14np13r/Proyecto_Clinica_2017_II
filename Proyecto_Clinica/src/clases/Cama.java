package clases;

public class Cama {
	//Campos o atributos
	private int numeroCama;
	private double precioDia;
	private int estado;
	
	//Metodo Constructor
	public Cama(int numeroCama, double precioDia, int estado) {
		this.numeroCama = numeroCama;
		this.precioDia = precioDia;
		this.estado = estado;
	}
	
	//Metodo
	public String detalleEstado() {
		switch (estado) {
			case 0: return "Libre";
			default: return "Ocupada";
		}
	}

	//Metodos Setters & Getters. Propiedades de lectura(get return) y escritura(set void)
	public int getNumeroCama() {
		return numeroCama;
	}

	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
