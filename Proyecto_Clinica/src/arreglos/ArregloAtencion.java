package arreglos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Atencion;

public class ArregloAtencion {
	
	private ArrayList<Atencion> at;
	private String archivo;
	
	public ArregloAtencion(String archivo){
		at = new ArrayList<>();
		this.archivo = archivo;
		cargarAtencion();
	}
	
	//  Mètodo de acceso público: set/get
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	// Método tamaño
		public int tamaño(){
			return at.size();
		}
		// Método obtener
		public Atencion obtener(int posi){
			return at.get(posi);
		}
		// Método Buscar
		public Atencion buscar(int codigo){
			for (int i = 0; i < tamaño(); i++) {
				if(obtener(i).getCodigoAtencion()==codigo)return obtener(i);
			}return null;
		}
		// Método adicionar
		public void adicionar(Atencion obje){
			at.add(obje);
		}
		// Método EliminarPorCod
		public void eliminar(Atencion obje){
			at.remove(obje);
		}
		// Método eliminarTodo
		public void eliminarTodo(){
			at.clear();
		}
		
		//Metodo generarCodigo
		public int codigoCorrelativo() {
			if (tamaño() == 0)
				return 10001;
			else
				return obtener(tamaño()-1).getCodigoAtencion() + 1;		
		}
		//
		public void grabarAtencion(){
			try {
				PrintWriter pw;
				String linea;
				Atencion x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = x.getCodigoAtencion()+";"+
							x.getCodigoPaciente()+";"+
							x.getFechaAtencion()+";"+
							x.getFechaAtencion()+";"+
							x.getTotalPagar()+";"+
							x.getEstado();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}
		
		public void cargarAtencion(){
			try {
				BufferedReader br;
				String linea, fec;
				String[] s ;
				int codat, codpa, estado;
				double total;
				
				br = new BufferedReader(new FileReader(archivo));
				while ((linea=br.readLine()) !=null) {
					s = linea.split(";");
					codat = Integer.parseInt(s[0].trim());
					codpa = Integer.parseInt(s[1].trim());
					fec = s[2].trim();
					total = Double.parseDouble(s[3].trim());
					estado = Integer.parseInt(s[4].trim());
					adicionar(new Atencion(codat, codpa, fec, total, estado));
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
