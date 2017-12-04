package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloInternamiento;
import clases.Cama;
import clases.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class InternamientoDLG extends JDialog implements ActionListener {
	
	private ArregloInternamiento ai = new ArregloInternamiento("Internamientos.txt");
	private DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private DefaultTableCellRenderer dtcr;
	
	private JButton btnNuevo;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnGrabar;
	private JButton btnSalir;
	private JButton btnOk;
	private JLabel lblCodInt;
	private JLabel lblCodPaciente;
	private JLabel lblNCama;
	private JLabel lblFecIngreso;
	private JLabel lblHoraIngreso;
	private JLabel lblFecSalida;
	private JLabel lblHoraSalida;
	private JTextField CodIn;
	private JComboBox cboCodPa;
	private JComboBox cboNCa;
	private JTable InternaTabla;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JComboBox comboBox_8;
	private JComboBox comboBox_9;
	private JLabel lblEstadoCama;
	private JComboBox comboBox_10;
	private JLabel lblEstado;
	private JComboBox comboBox_11;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InternamientoDLG dialog = new InternamientoDLG();
			dialog.setDefaultCloseOperation(0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InternamientoDLG() {
		setModal(true);
		setBounds(100, 100, 1000, 700);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/clientes.png")));
		btnNuevo.setBounds(709, 377, 99, 23);
		btnNuevo.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(btnNuevo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/ingresar.png")));
		btnIngresar.setBounds(709, 489, 121, 42);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(840, 489, 121, 42);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/exit.png")));
		btnEliminar.setBounds(709, 545, 121, 42);
		getContentPane().add(btnEliminar);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(this);
		btnVaciar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(840, 545, 121, 42);
		getContentPane().add(btnVaciar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(709, 600, 121, 42);
		getContentPane().add(btnGrabar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(842, 600, 121, 42);
		getContentPane().add(btnSalir);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/good.png")));
		btnOk.setEnabled(false);
		btnOk.setBounds(891, 377, 70, 23);
		getContentPane().add(btnOk);
		
		lblCodInt = new JLabel("Cod. Internamiento");
		lblCodInt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodInt.setBounds(709, 33, 144, 14);
		getContentPane().add(lblCodInt);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodPaciente.setBounds(709, 71, 99, 14);
		getContentPane().add(lblCodPaciente);
		
		lblNCama = new JLabel("N\u00BA Cama");
		lblNCama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNCama.setBounds(709, 111, 99, 14);
		getContentPane().add(lblNCama);
		
		lblFecIngreso = new JLabel("Fec. Ingreso");
		lblFecIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecIngreso.setBounds(709, 178, 99, 31);
		getContentPane().add(lblFecIngreso);
		
		lblHoraIngreso = new JLabel("Hora. Ingreso");
		lblHoraIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraIngreso.setBounds(709, 216, 99, 23);
		getContentPane().add(lblHoraIngreso);
		
		lblFecSalida = new JLabel("Fec. Salida");
		lblFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecSalida.setBounds(709, 257, 99, 14);
		getContentPane().add(lblFecSalida);
		
		lblHoraSalida = new JLabel("Hora. Salida");
		lblHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraSalida.setBounds(709, 298, 99, 14);
		getContentPane().add(lblHoraSalida);
		
		CodIn = new JTextField();
		CodIn.setEditable(false);
		CodIn.setBounds(840, 30, 121, 20);
		getContentPane().add(CodIn);
		CodIn.setColumns(10);
		
		cboCodPa = new JComboBox();
		cboCodPa.setEnabled(false);
		cboCodPa.setBounds(840, 70, 121, 20);
		getContentPane().add(cboCodPa);
		
		cboNCa = new JComboBox();
		cboNCa.setEnabled(false);
		cboNCa.setBounds(840, 110, 121, 20);
		getContentPane().add(cboNCa);
		
		comboBox = new JComboBox();
		comboBox.setBounds(840, 185, 28, 20);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(869, 185, 46, 20);
		getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(915, 185, 46, 20);
		getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(840, 219, 39, 20);
		getContentPane().add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(879, 219, 46, 20);
		getContentPane().add(comboBox_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setBounds(840, 256, 28, 20);
		getContentPane().add(comboBox_5);
		
		comboBox_6 = new JComboBox();
		comboBox_6.setBounds(869, 256, 46, 20);
		getContentPane().add(comboBox_6);
		
		comboBox_7 = new JComboBox();
		comboBox_7.setBounds(915, 256, 46, 20);
		getContentPane().add(comboBox_7);
		
		comboBox_8 = new JComboBox();
		comboBox_8.setBounds(840, 297, 39, 20);
		getContentPane().add(comboBox_8);
		
		comboBox_9 = new JComboBox();
		comboBox_9.setBounds(879, 297, 46, 20);
		getContentPane().add(comboBox_9);
		
		lblEstadoCama = new JLabel("Estado Cama");
		lblEstadoCama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstadoCama.setBounds(709, 153, 99, 14);
		getContentPane().add(lblEstadoCama);
		
		comboBox_10 = new JComboBox();
		comboBox_10.setEnabled(false);
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"Ocupada", "Libre"}));
		comboBox_10.setBounds(840, 152, 121, 20);
		getContentPane().add(comboBox_10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(709, 335, 46, 14);
		getContentPane().add(lblEstado);
		
		comboBox_11 = new JComboBox();
		comboBox_11.setEnabled(false);
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Alojado", "pagado"}));
		comboBox_11.setBounds(869, 334, 92, 20);
		getContentPane().add(comboBox_11);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 33, 666, 609);
		getContentPane().add(scrollPane);
		
		InternaTabla = new JTable();
		scrollPane.setViewportView(InternaTabla);
		InternaTabla.setFillsViewportHeight(true);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Interna.");
		modelo.addColumn("Cod. Paciente");
		modelo.addColumn("Nº Cama");
		modelo.addColumn("Estado Cama");
		modelo.addColumn("Fec. Ingreso");
		modelo.addColumn("Hor. Ingreso");
		modelo.addColumn("Fec. Salida");
		modelo.addColumn("Hor. Salida");
		modelo.addColumn("Estado");
		InternaTabla.setModel(modelo);

		//Establecer alineamiento
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		InternaTabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(3).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(4).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(5).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(6).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(7).setCellRenderer(dtcr);
		InternaTabla.getColumnModel().getColumn(8).setCellRenderer(dtcr);
		
	}
	

	//  Métodos tipo void sin parámetros
	
   	void listar() {
   		//Para que tome la posicion al anterior--
   		Cama x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = InternaTabla.getSelectedRow();
		if (modelo.getRowCount() == ai.tamaño()-1)
			posFila = ai.tamaño()-1;
		if (posFila == ai.tamaño())
			posFila --;
		//obtener los datos de cama mediante la posicion
		modelo.setRowCount(0);
		for (int i=0; i<ai.tamaño(); i++) {
			Object[] fila = { ai.obtener(i).getCodigoInternamiento(),
							  ai.obtener(i).getCodigoPaciente(),
							  ai.obtener(i).getNumeroCama(),
					          ai.obtener(i).detalleEstado() };
			modelo.addRow(fila);
		}
		//Autoseleccionado en la tabla
		if (ai.tamaño() > 0)
			InternaTabla.getSelectionModel().setSelectionInterval(posFila, posFila);	
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnVaciar) {
			actionPerformedBtnVaciar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnOk) {
			actionPerformedBtnOk(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			Boton_Nuevo(arg0);
		}
	}
	protected void Boton_Nuevo(ActionEvent arg0) {
		PacienteDLG pa = new PacienteDLG();
		pa.setVisible(true);
		pa.setLocationRelativeTo(this);
		pa.Boton_Ingresar(arg0);
	}
		
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnOk(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnVaciar(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}
