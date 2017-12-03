package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Paciente;

public class ArregloPaciente {
	private ArrayList<Paciente> pa;
	private String archivo;
	public ArregloPaciente(String archivo){
		pa = new ArrayList<Paciente>();
		this.archivo=archivo;
		cargarPacientes();
	}
	//
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	//
	public int tamaño(){
		return pa.size();
	}
	
	public Paciente obtener(int i){
		return pa.get(i);
	}
	
	public Paciente buscar(int cod){
		Paciente x;
		for(int i=0;i<tamaño();i++){
			x=obtener(i);
			if(x.getCodigoPaciente()==cod)
				return x;
				}
		return null;
	}
	public void adicionar(Paciente x){
		pa.add(x);
	}
	public void eliminar(Paciente x) {
		pa.remove(x);
	} 
	
	public int codigoCorrelativo(){
		if(tamaño()==0)
			return 1001;
		else
			return obtener(tamaño()-1).getCodigoPaciente()+1;
	}
	
	
	public void grabarClientes(){
		try{
			PrintWriter pw;
			String linea;
			Paciente x;
			pw=new PrintWriter(new FileWriter(archivo));
			for(int i=0;i<tamaño();i++){
				x=obtener(i);
				linea=  x.getCodigoPaciente()+";"+
						x.getNombres()+";"+
						x.getApellidos() +";"+
						x.getDni()+";"+
						x.getTelefono()+";";
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	public void cargarPacientes(){
		try{
			BufferedReader br;
			String linea,nombre,ape,tel,dni;
			String s[];
			int cod;
			br=new BufferedReader(new FileReader(archivo));
			while ((linea=br.readLine())!=null){
				s=linea.split(";");
				cod=Integer.parseInt(s[0].trim());
				nombre=s[1].trim();
				ape=s[2].trim();
				tel=s[3].trim();
				dni=s[4].trim();
				adicionar(new Paciente(cod, nombre, ape, tel, dni));
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