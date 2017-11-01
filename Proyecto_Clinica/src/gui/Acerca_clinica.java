package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;

@SuppressWarnings({ "unused", "serial" })
public class Acerca_clinica extends JDialog implements ActionListener {
	private JLabel lblAutores;
	private JLabel lblGianmarcoPierreYauri;
	private JLabel lblSandraVera;
	private JLabel lblJoseCabrera;
	private JButton btnCerrar;
	private JLabel lblSebastinLuque;
	private JSeparator separator;
	private JLabel lblI;
	private JLabel lblIcibertecedupe;
	private JLabel lblIcibertecedupe_1;
	private JLabel lblIcibertecedupe_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Acerca_clinica dialog = new Acerca_clinica();
			dialog.setDefaultCloseOperation(0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Acerca_clinica() {
		setModal(true);
		setTitle("Acerca de Cl\u00EDnica");
		setDefaultCloseOperation(0);// Quitar cerrar
		setBounds(100, 100, 462, 450);
		getContentPane().setLayout(null);
		{
			JLabel lblTienda = new JLabel("Cl\u00EDnica 1.0");
			lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblTienda.setFont(new Font("Monotype Corsiva", Font.BOLD, 31));
			lblTienda.setBounds(0, 11, 446, 27);
			getContentPane().add(lblTienda);
		}
		{
			lblAutores = new JLabel("Autores");
			lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutores.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
			lblAutores.setBounds(0, 78, 446, 23);
			getContentPane().add(lblAutores);
		}
		{
			lblGianmarcoPierreYauri = new JLabel("Yauri Meza Gianmarco Pierre ");
			lblGianmarcoPierreYauri.setFont(new Font("Verdana", Font.ITALIC, 18));
			lblGianmarcoPierreYauri.setHorizontalAlignment(SwingConstants.CENTER);
			lblGianmarcoPierreYauri.setBounds(0, 129, 446, 27);
			getContentPane().add(lblGianmarcoPierreYauri);
		}
		{
			lblSandraVera = new JLabel("Languasco Siccha Bruno Marcelo");
			lblSandraVera.setFont(new Font("Verdana", Font.ITALIC, 18));
			lblSandraVera.setHorizontalAlignment(SwingConstants.CENTER);
			lblSandraVera.setBounds(0, 183, 446, 23);
			getContentPane().add(lblSandraVera);
		}
		{
			lblJoseCabrera = new JLabel("Carhuancho Porras Jhon Jairo");
			lblJoseCabrera.setFont(new Font("Verdana", Font.ITALIC, 18));
			lblJoseCabrera.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoseCabrera.setBounds(0, 278, 446, 27);
			getContentPane().add(lblJoseCabrera);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(180, 365, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			lblSebastinLuque = new JLabel("Caycho Bardales Josue Jair");
			lblSebastinLuque.setFont(new Font("Verdana", Font.ITALIC, 18));
			lblSebastinLuque.setHorizontalAlignment(SwingConstants.CENTER);
			lblSebastinLuque.setBounds(0, 230, 446, 27);
			getContentPane().add(lblSebastinLuque);
		}
		{
			separator = new JSeparator();
			separator.setBounds(10, 49, 426, 2);
			getContentPane().add(separator);
		}
		{
			lblI = new JLabel("i201711697@cibertec.edu.pe");
			lblI.setForeground(SystemColor.textHighlight);
			lblI.setHorizontalAlignment(SwingConstants.CENTER);
			lblI.setFont(new Font("Verdana", Font.ITALIC, 13));
			lblI.setBounds(0, 156, 446, 17);
			getContentPane().add(lblI);
		}
		{
			lblIcibertecedupe = new JLabel("i201711212@cibertec.edu.pe");
			lblIcibertecedupe.setHorizontalAlignment(SwingConstants.CENTER);
			lblIcibertecedupe.setForeground(SystemColor.textHighlight);
			lblIcibertecedupe.setFont(new Font("Verdana", Font.ITALIC, 13));
			lblIcibertecedupe.setBounds(0, 206, 446, 17);
			getContentPane().add(lblIcibertecedupe);
		}
		{
			lblIcibertecedupe_1 = new JLabel("i201713423@cibertec.edu.pe");
			lblIcibertecedupe_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblIcibertecedupe_1.setForeground(SystemColor.textHighlight);
			lblIcibertecedupe_1.setFont(new Font("Verdana", Font.ITALIC, 13));
			lblIcibertecedupe_1.setBounds(0, 256, 446, 17);
			getContentPane().add(lblIcibertecedupe_1);
		}
		{
			lblIcibertecedupe_2 = new JLabel("i201713363@cibertec.edu.pe");
			lblIcibertecedupe_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblIcibertecedupe_2.setForeground(SystemColor.textHighlight);
			lblIcibertecedupe_2.setFont(new Font("Verdana", Font.ITALIC, 13));
			lblIcibertecedupe_2.setBounds(0, 304, 446, 17);
			getContentPane().add(lblIcibertecedupe_2);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			Boton_Cerrar(arg0);
		}
	}
	protected void Boton_Cerrar(ActionEvent arg0) {
	dispose();
	}
}
