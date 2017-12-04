package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PagoDLG extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PagoDLG dialog = new PagoDLG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagoDLG() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}

}
