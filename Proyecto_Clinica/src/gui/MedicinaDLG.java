package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MedicinaDLG extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MedicinaDLG dialog = new MedicinaDLG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MedicinaDLG() {
		setModal(true);
		setTitle("Medicina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}

}
