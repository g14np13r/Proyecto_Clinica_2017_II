package libreria;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Alerta {
	//  M�todos tipo void con par�metros
	public static void mensaje(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "                       Programa Cl�nica 1.0              ", JOptionPane.WARNING_MESSAGE);
	}
	// M�todos que retorna valor con par�metros
	public static int confirmar(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "                       Programa Cl�nica 1.0              ", JOptionPane.YES_NO_OPTION);
	}
	
}