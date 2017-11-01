package clases;

public class Medicina {
	//
	private int codigoMedicina;
	private String nombre, laboratorio;
	private double precio;
	private int stock;
	
	
	public Medicina(int codigoMedicina, String nombre, String laboratorio, double precio, int stock) {
		this.codigoMedicina = codigoMedicina;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	
}
