package arreglos;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Internamiento;

public class ArregloInternamiento {

	private ArrayList <Internamiento> in;
	private String archivo;

    public ArregloInternamiento(String archivo) {
    	in = new ArrayList <Internamiento> ();
    	this.archivo = archivo;
		cargarFunciones();
    }
	public int tamaño() {
		return in.size();
	}
	public Internamiento obtener(int i) {
		return in.get(i);
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getArchivo() {
		return archivo;
	}
	public void adicionar(Internamiento x) {
		in.add(x);
	}
	public void eliminar(Internamiento x) {
		in.remove(x);
	}
	public Internamiento buscar(int codigo) {
		Internamiento x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoInternamiento() == codigo)
				return x;
		}
		return null;
	}
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño()-1).getCodigoInternamiento() + 1;		
	}
	public void grabarFunciones() {
		try {
			PrintWriter pw;
			String linea;
			Internamiento x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoInternamiento() + ";" +
					    x.getCodigoPaciente() + ";" +
						x.getNumeroCama() + ";" +
						x.getFechaIngreso() + ";" +
						x.getHoraIngreso() + ";" +
				        x.getFechaSalida() + ";" +
				        x.getHoraSalida() + ";" +
				        x.getEstado() + ";";
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void cargarFunciones() {
		try {
			BufferedReader br;
			String linea, fechaIngreso, horaIngreso, fechaSalida, horaSalida;
			String s[];
			int codigoInternamiento, codigoPaciente, numeroCama, estado;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoInternamiento = Integer.parseInt(s[0].trim());
				codigoPaciente = Integer.parseInt(s[1].trim());
				numeroCama = Integer.parseInt(s[2].trim());
				fechaIngreso = s[3].trim();
				horaIngreso = s[4].trim();
				fechaSalida = s[5].trim();
				horaSalida = s[6].trim();
				estado = Integer.parseInt(s[7].trim());
				adicionar(new Internamiento(codigoInternamiento, codigoPaciente, numeroCama, fechaIngreso, horaIngreso, fechaSalida, horaSalida, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}		
	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}
	
}
