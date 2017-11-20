package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCama;
import clases.Cama;

import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;

public class CamaDLG extends JDialog implements ActionListener {
	
	private ArregloCama ac = new ArregloCama("Camas.txt");
	
	private JButton btnAdicionar;
	private JButton btnListar;
	private JButton btnElimtodo;
	private JButton btnBuscar;
	private JButton btnElimxcod;
	private JButton btnElimfinal;
	private JLabel lblNumero;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtNum;
	private JTextField txtPre;
	private JComboBox cboEstado;
	private JLabel lblListadoDeCama;
	private JTable CamaTabla;
	private JScrollPane scrollPane;
	
	private DefaultTableModel modelo;

	private static final long serialVersionUID = 1L;

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
		btnAdicionar.addActionListener(this);
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
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado"}));
		cboEstado.setBounds(498, 196, 86, 20);
		getContentPane().add(cboEstado);
		
		lblListadoDeCama = new JLabel("LISTADO DE CAMA");
		lblListadoDeCama.setBounds(172, 88, 124, 14);
		getContentPane().add(lblListadoDeCama);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 413, 245);
		getContentPane().add(scrollPane);
		
		CamaTabla = new JTable();
		CamaTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(CamaTabla);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Nº Cama");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		CamaTabla.setModel(modelo);
	}
	
	//  Métodos tipo void sin parámetros
	void limpieza() {
		txtNum.setText("");
		txtPre.setText("");
		txtNum.requestFocus();
	}	
   	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++) {
			Object[] fila = { ac.obtener(i).getNumeroCama(),
					          ac.obtener(i).getPrecioDia(),
					          ac.obtener(i).detalleEstado() };
			modelo.addRow(fila);
		}
	}
   	
   	
   	//  Métodos tipo void con parámetros
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}		
	//Metodo
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	
	
	int leerNumero() {
		return Integer.parseInt(txtNum.getText().trim());
	}
	double leerPrecio(){
		return Double.parseDouble(txtPre.getText().trim());
	}
	//  Métodos que retornan valor con parámetros
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAdicionar) {
			Boton_Adicionar(arg0);
		}
	}
	protected void Boton_Adicionar(ActionEvent arg0) {
		try {
			int numero = leerNumero();
			try {
				double precio = leerPrecio();
					int estado = leerEstado();
					ac.adicionar(new Cama(numero, precio, estado));
					listar();
					limpieza();
			} 
			catch (Exception e) {
				mensaje("Ingrese precio correcto");
			}
		} 
		catch (Exception e) {
			mensaje("ingrese Numero correcto");
			txtNum.setText("");
			txtNum.requestFocus();
		}
	}
}
