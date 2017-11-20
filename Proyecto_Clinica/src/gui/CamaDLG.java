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
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CamaDLG extends JDialog implements ActionListener {
	
	private ArregloCama ac = new ArregloCama("Camas.txt");
	
	private JButton btnAdicionar;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JLabel lblNumero;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtNum;
	private JTextField txtPre;
	private JComboBox cboEstado;
	private JTable CamaTabla;
	
	private DefaultTableModel modelo;

	private static final long serialVersionUID = 1L;
	private JButton btnHecho;
	private JButton btnModificar;
	private JButton btnSalir;
	private JButton btnVaciar;
	private JScrollPane scrollPane;

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
		setBounds(100, 100, 679, 459);
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/ingresar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(390, 242, 121, 44);
		getContentPane().add(btnAdicionar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(390, 352, 121, 44);
		getContentPane().add(btnGrabar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/exit.png")));
		btnEliminar.setBounds(390, 297, 121, 44);
		getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/mantenimiento.png")));
		btnBuscar.setBounds(390, 183, 121, 44);
		getContentPane().add(btnBuscar);
		
		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(390, 24, 73, 14);
		getContentPane().add(lblNumero);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(390, 64, 73, 14);
		getContentPane().add(lblPrecio);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(390, 104, 73, 14);
		getContentPane().add(lblEstado);
		
		txtNum = new JTextField();
		txtNum.setBounds(495, 24, 148, 20);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setBounds(495, 64, 148, 20);
		getContentPane().add(txtPre);
		txtPre.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado"}));
		cboEstado.setBounds(531, 99, 112, 20);
		getContentPane().add(cboEstado);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Nº Cama");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		
		btnHecho = new JButton("Ok");
		btnHecho.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/good.png")));
		btnHecho.setBounds(573, 130, 70, 23);
		getContentPane().add(btnHecho);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(521, 242, 122, 44);
		getContentPane().add(btnModificar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(521, 352, 122, 44);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 26, 332, 370);
		getContentPane().add(scrollPane);
		
		CamaTabla = new JTable();
		scrollPane.setViewportView(CamaTabla);
		CamaTabla.setFillsViewportHeight(true);
		CamaTabla.setModel(modelo);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(521, 297, 122, 44);
		getContentPane().add(btnVaciar);
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
