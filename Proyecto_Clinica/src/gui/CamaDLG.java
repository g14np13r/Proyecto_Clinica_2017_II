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
import libreria.Alerta;

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

public class CamaDLG extends JDialog implements ActionListener, MouseListener {
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
	

	private ArregloCama ac = new ArregloCama("Camas.txt");
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
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(390, 352, 121, 44);
		getContentPane().add(btnGrabar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
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
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(521, 352, 122, 44);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 26, 332, 370);
		getContentPane().add(scrollPane);
		
		CamaTabla = new JTable();
		CamaTabla.addMouseListener(this);
		scrollPane.setViewportView(CamaTabla);
		CamaTabla.setFillsViewportHeight(true);
		CamaTabla.setModel(modelo);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(this);
		btnVaciar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(521, 297, 122, 44);
		getContentPane().add(btnVaciar);
		
		listar();//para que aparezca los datos registrados
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
   	//Métodos con retorno
	int leerNumero() {
		return Integer.parseInt(txtNum.getText().trim());
	}
	double leerPrecio(){
		return Double.parseDouble(txtPre.getText().trim());
	}
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	/////////////
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			Boton_Eliminar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			Boton_Salir(arg0);
		}
		if (arg0.getSource() == btnVaciar) {
			Boton_Vaciar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			Boton_Grabar(arg0);
		}
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
				Alerta.mensaje(this,"Ingrese precio correcto");
			}
		} 
		catch (Exception e) {
			Alerta.mensaje(this,"ingrese Numero correcto");
			txtNum.setText("");
			txtNum.requestFocus();
		}
	}
	protected void Boton_Grabar(ActionEvent arg0) {
		if (ac.existeArchivo()) {
			int ok = Alerta.confirmar(this,"¿ Desea actualizar \"" + ac.getArchivo() + "\" ?");
			if (ok == 0) {
				ac.grabarCamas();
				Alerta.mensaje(this,"\"" + ac.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this,"No se actualizó  \"" + ac.getArchivo() + "\"");
		}
		else {
			ac.grabarCamas();
			Alerta.mensaje(this,"\"" + ac.getArchivo() + "\" ha sido creado");
		}
		txtNum.requestFocus();
	}
	protected void Boton_Vaciar(ActionEvent arg0) {
		if (ac.tamaño() > 0) {
			int co = Alerta.confirmar(this, "Está seguro de vaciar la lista\""+ac.getArchivo()+"\" ?");
			if(co == 0){
				ac.eliminarTodo();
				listar();
			}
			else{
				Alerta.mensaje(this, "No se perdieron datos");
			}
		}
		else
			Alerta.mensaje(this,"La lista de camas está vacía");
			limpieza();
	}
	protected void Boton_Salir(ActionEvent arg0) {
		dispose();
	}
	protected void Boton_Eliminar(ActionEvent arg0) {
		if (ac.tamaño() > 0) {
			int co = Alerta.confirmar(this, "¿Desea eliminar el registro?");
			if (co == 0) {
				ac.eliminarPorCod(ac.buscar(leerNumero()));
				listar();
				limpieza();
			} else {
				Alerta.mensaje(this, "No se eliminó");
			}
		} else {

		}
	}
	void actuFil(){
		if (ac.tamaño() == 0){
			limpieza();
		}
		else{
			Cama c=ac.obtener(CamaTabla.getSelectedRow());
			txtNum.setText(""+c.getNumeroCama());
			txtPre.setText(""+c.getPrecioDia());
			cboEstado.setSelectedItem(c.getEstado());
		}
		
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
		actuFil();
	}
}
