package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Paciente;

public class ArregloPaciente {
	private ArrayList<Paciente> paciente;
	private String archivo;
	public ArregloPaciente(String archivo){
		paciente=new ArrayList<Paciente>();
		this.archivo=archivo;
		cargarPacientes();
	}
	public int tamaño(){
		return paciente.size();
	}
	public Paciente obtener(int i){
		return paciente.get(i);
	}
	public void adicionar(Paciente x){
		paciente.add(x);
	}
	public void eliminar(Paciente x) {
		paciente.remove(x);
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
	public int codigoCorrelativo(){
		if(tamaño()==0)
			return 1001;
		else
			return obtener(tamaño()-1).getCodigoPaciente()+1;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
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
						x.getApepat() +";"+
						x.getApemat()+";"+
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
			String linea,nombre,apePat,apeMat,telefono,dni;
			String s[];
			int cod;
			br=new BufferedReader(new FileReader(archivo));
			while ((linea=br.readLine())!=null){
				s=linea.split(";");
				cod=Integer.parseInt(s[0].trim());
				nombre=s[1].trim();
				apePat=s[2].trim();
				apeMat=s[3].trim();
				telefono=s[4].trim();
				dni=s[5].trim();
				adicionar(new Paciente(cod, nombre, apePat, apeMat, telefono, dni));
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