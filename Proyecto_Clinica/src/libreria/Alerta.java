package libreria;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Alerta {
	//  Métodos tipo void con parámetros
	public static void mensaje(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "                       Programa Clínica 1.0              ", JOptionPane.WARNING_MESSAGE);
	}
	// Métodos que retorna valor con parámetros
	public static int confirmar(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "                       Programa Clínica 1.0              ", JOptionPane.YES_NO_OPTION);
	}
	
}