package arreglos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cama;

public class ArregloCama {
	private ArrayList<Cama> ca;
	private String archivo;
	
	public ArregloCama(String archivo){
		ca = new ArrayList<Cama>();
		this.archivo = archivo;
		cargarCamas();
	}
	//  M�todo de acceso p�blico: set/get
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
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
	//Metodo generarCodigo
	public int codigoCorrelativo() {
		if (tama�o() == 0)
			return 10001;
		else
			return obtener(tama�o()-1).getNumeroCama() + 1;		
	}
	
	public void grabarCamas(){
		try {
			PrintWriter pw;
			String linea;
			Cama x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tama�o(); i++) {
				x = obtener(i);
				linea = x.getNumeroCama()+";"+
						x.getPrecioDia()+";"+
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	public void cargarCamas(){
		try {
			BufferedReader br;
			String linea;
			double precio;
			String[] s;
			int numero, estado;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea=br.readLine()) !=null) {
				s = linea.split(";");
				numero = Integer.parseInt(s[0].trim());
				precio = Double.parseDouble(s[1].trim());
				estado = Integer.parseInt(s[2].trim());
				adicionar(new Cama(numero, precio, estado));
			}
			br.close();
		} 
		catch (Exception e) {
		}
	}
	
	public boolean existeArchivo(){
		File f = new File(archivo);
		return f.exists();
	}
	
	
	
}
