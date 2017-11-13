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
	// M�todo tama�o
	public int tama�o(){
		return ca.size();
	}
	// M�todo obtener
	public Cama obtener(int posi){
		return ca.get(posi);
	}
	// M�todo adicionar
	public void adicionar(Cama obje){
		ca.add(obje);
	}
	// M�todo eliminarAlFinal
	public void eliminarFinal(){
		ca.remove(tama�o()-1);	
	}
	// M�todo eliminarTodo
	public void eliminarTodo(){
		ca.clear();
	}
	// M�todo Buscar
	public Cama buscar(int codigo){
		for (int i = 0; i < tama�o(); i++) {
			if(obtener(i).getNumeroCama()==codigo)return obtener(i);
		}return null;
	}
	// M�todo EliminarPorCod
	public void eliminarPorCod(Cama obje){
		ca.remove(obje);
	}
	
}
