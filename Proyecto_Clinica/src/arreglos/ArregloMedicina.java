package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Medicina;

public class ArregloMedicina {
	private ArrayList<Medicina> me;
	private String archivo;
	
	public ArregloMedicina(String archivo){
		me = new ArrayList<>();
		this.archivo=archivo;
		cargarMedicinas();
	}
	//
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	public int tamaño(){
		return me.size();
	}
	
	public Medicina obtener(int i){
		return me.get(i);
	}
	
	public Medicina buscar(int cod){
		Medicina x;
		for(int i=0;i<tamaño();i++){
			x=obtener(i);
			if(x.getCodigoMedicina()==cod)
				return x;
				}
		return null;
	}
	public void adicionar(Medicina x){
		me.add(x);
	}
	public void eliminar(Medicina x) {
		me.remove(x);
	} 
	
	public int codigoCorrelativo(){
		if(tamaño()==0)
			return 10001;
		else
			return obtener(tamaño()-1).getCodigoMedicina()+1;
	}
	

	public void grabarMedicinas(){
		try{
			PrintWriter pw;
			String linea;
			Medicina x;
			pw=new PrintWriter(new FileWriter(archivo));
			for(int i=0;i<tamaño();i++){
				x=obtener(i);
				linea=  x.getCodigoMedicina()+";"+
						x.getNombre()+";"+
						x.getLaboratorio() +";"+
						x.getPrecio()+";"+
						x.getStock()+";";
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	public void cargarMedicinas(){
		try{
			BufferedReader br;
			int cod, stock;
			String linea,nom,lab;
			double pre;
			String s[];
			br=new BufferedReader(new FileReader(archivo));
			while ((linea=br.readLine())!=null){
				s=linea.split(";");
				cod=Integer.parseInt(s[0].trim());
				nom=s[1].trim();
				lab=s[2].trim();
				pre=Double.parseDouble(s[3].trim());
				stock=Integer.parseInt(s[4].trim());
				adicionar(new Medicina(cod, nom, lab, pre, stock));
			}
			br.close();
		}
		catch (Exception e){
		}
	}
	public boolean existeArchivo(){
		File f=new File(archivo);
		return f.exists();
	}
}
