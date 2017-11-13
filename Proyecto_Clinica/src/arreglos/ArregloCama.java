package arreglos;
import java.util.ArrayList;

import clases.Cama;

public class ArregloCama {
	private ArrayList<Cama> ca;
	
	public ArregloCama(){
		ca = new ArrayList<>();
		
		ca.add(new Cama(1, 15.1, 1));
		ca.add(new Cama(2, 33.2, 0));
		ca.add(new Cama(3, 42.3, 0));
		ca.add(new Cama(4, 53.4, 1));
		ca.add(new Cama(5, 85.5, 0));
		ca.add(new Cama(6, 46.6, 1));
		ca.add(new Cama(7, 37.7, 1));
		ca.add(new Cama(8, 68.8, 0));
		ca.add(new Cama(9, 29.9, 1));
		ca.add(new Cama(10, 18.0, 1));
	}
	// Método tamaño
	public int tamaño(){
		return ca.size();
	}
	// Método obtener
	public Cama obtener(int posi){
		return ca.get(posi);
	}
	// Método adicionar
	public void adicionar(Cama obje){
		ca.add(obje);
	}
	// Método eliminarAlFinal
	public void eliminarFinal(){
		ca.remove(tamaño()-1);	
	}
	// Método eliminarTodo
	public void eliminarTodo(){
		ca.clear();
	}
	// Método Buscar
	public Cama buscar(int codigo){
		for (int i = 0; i < tamaño(); i++) {
			if(obtener(i).getNumeroCama()==codigo)return obtener(i);
		}return null;
	}
	// Método EliminarPorCod
	public void eliminarPorCod(Cama obje){
		ca.remove(obje);
	}
	
}
