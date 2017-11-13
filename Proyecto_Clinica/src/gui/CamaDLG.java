package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloCama;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CamaDLG extends JDialog implements MouseListener {
	
	private ArregloCama ac = new ArregloCama();
	
	private JButton btnAdicionar;
	private JButton btnListar;
	private JButton btnElimtodo;
	private JButton btnBuscar;
	private JButton btnElimxcod;
	private JButton btnElimfinal;
	private JTable CamaTabla;
	private JScrollPane scrollPane;
	private JLabel lblNumero;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtNum;
	private JTextField txtPre;
	private JComboBox comboBox;
	private JLabel lblListadoDeCama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CamaDLG dialog = new CamaDLG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CamaDLG() {
		setTitle("Cama");
		setModal(true);
		setBounds(100, 100, 647, 419);
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 22, 89, 44);
		getContentPane().add(btnAdicionar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(114, 22, 89, 44);
		getContentPane().add(btnListar);
		
		btnElimtodo = new JButton("ElimTodo");
		btnElimtodo.setBounds(532, 22, 89, 44);
		getContentPane().add(btnElimtodo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(220, 22, 89, 44);
		getContentPane().add(btnBuscar);
		
		btnElimxcod = new JButton("ElimXcod");
		btnElimxcod.setBounds(325, 22, 89, 44);
		getContentPane().add(btnElimxcod);
		
		btnElimfinal = new JButton("ElimFinal");
		btnElimfinal.setBounds(430, 22, 89, 44);
		getContentPane().add(btnElimfinal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 121, 359, 244);
		getContentPane().add(scrollPane);
		
		CamaTabla = new JTable();
		scrollPane.setViewportView(CamaTabla);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(442, 124, 46, 14);
		getContentPane().add(lblNumero);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(442, 164, 46, 14);
		getContentPane().add(lblPrecio);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(442, 199, 46, 14);
		getContentPane().add(lblEstado);
		
		txtNum = new JTextField();
		txtNum.setBounds(498, 121, 86, 20);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setBounds(498, 161, 86, 20);
		getContentPane().add(txtPre);
		txtPre.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado"}));
		comboBox.setBounds(498, 196, 86, 20);
		getContentPane().add(comboBox);
		
		lblListadoDeCama = new JLabel("LISTADO DE CAMA");
		lblListadoDeCama.setBounds(172, 88, 124, 14);
		getContentPane().add(lblListadoDeCama);
		CamaTabla.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == CamaTabla) {
			mouseClickedCamaTabla(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedCamaTabla(MouseEvent arg0) {
	}
}
