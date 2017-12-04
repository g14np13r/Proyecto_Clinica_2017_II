package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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

public class InternamientoDLG extends JDialog implements ActionListener {
	
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
	private JTextField txtFeIn;
	private JTextField txtHoEn;
	private JTextField txtFeSa;
	private JTextField txtHoSa;
	private JComboBox cboCodPa;
	private JComboBox cboNCa;
	private JTable InternaTabla;
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
		setBounds(100, 100, 1000, 584);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/clientes.png")));
		btnNuevo.setBounds(708, 300, 99, 23);
		btnNuevo.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(btnNuevo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/ingresar.png")));
		btnIngresar.setBounds(708, 367, 121, 42);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(839, 367, 121, 42);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/exit.png")));
		btnEliminar.setBounds(708, 423, 121, 42);
		getContentPane().add(btnEliminar);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(this);
		btnVaciar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(839, 423, 121, 42);
		getContentPane().add(btnVaciar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(708, 478, 121, 42);
		getContentPane().add(btnGrabar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(841, 478, 121, 42);
		getContentPane().add(btnSalir);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(InternamientoDLG.class.getResource("/img/good.png")));
		btnOk.setEnabled(false);
		btnOk.setBounds(890, 300, 70, 23);
		getContentPane().add(btnOk);
		
		lblCodInt = new JLabel("Cod. Internamiento");
		lblCodInt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodInt.setBounds(708, 30, 144, 14);
		getContentPane().add(lblCodInt);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodPaciente.setBounds(708, 68, 99, 14);
		getContentPane().add(lblCodPaciente);
		
		lblNCama = new JLabel("N\u00BA Cama");
		lblNCama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNCama.setBounds(708, 108, 99, 14);
		getContentPane().add(lblNCama);
		
		lblFecIngreso = new JLabel("Fec. Ingreso");
		lblFecIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecIngreso.setBounds(708, 139, 99, 31);
		getContentPane().add(lblFecIngreso);
		
		lblHoraIngreso = new JLabel("Hora. Ingreso");
		lblHoraIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraIngreso.setBounds(708, 177, 99, 23);
		getContentPane().add(lblHoraIngreso);
		
		lblFecSalida = new JLabel("Fec. Salida");
		lblFecSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecSalida.setBounds(708, 218, 99, 14);
		getContentPane().add(lblFecSalida);
		
		lblHoraSalida = new JLabel("Hora. Salida");
		lblHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraSalida.setBounds(708, 259, 99, 14);
		getContentPane().add(lblHoraSalida);
		
		CodIn = new JTextField();
		CodIn.setEditable(false);
		CodIn.setBounds(839, 27, 121, 20);
		getContentPane().add(CodIn);
		CodIn.setColumns(10);
		
		txtFeIn = new JTextField();
		txtFeIn.setEditable(false);
		txtFeIn.setBounds(839, 146, 121, 20);
		getContentPane().add(txtFeIn);
		txtFeIn.setColumns(10);
		
		txtHoEn = new JTextField();
		txtHoEn.setEditable(false);
		txtHoEn.setBounds(839, 180, 121, 20);
		getContentPane().add(txtHoEn);
		txtHoEn.setColumns(10);
		
		txtFeSa = new JTextField();
		txtFeSa.setEditable(false);
		txtFeSa.setBounds(839, 217, 121, 20);
		getContentPane().add(txtFeSa);
		txtFeSa.setColumns(10);
		
		txtHoSa = new JTextField();
		txtHoSa.setEditable(false);
		txtHoSa.setBounds(839, 258, 121, 20);
		getContentPane().add(txtHoSa);
		txtHoSa.setColumns(10);
		
		cboCodPa = new JComboBox();
		cboCodPa.setEnabled(false);
		cboCodPa.setBounds(839, 67, 121, 20);
		getContentPane().add(cboCodPa);
		
		cboNCa = new JComboBox();
		cboNCa.setEnabled(false);
		cboNCa.setBounds(839, 107, 121, 20);
		getContentPane().add(cboNCa);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 30, 653, 489);
		getContentPane().add(scrollPane);
		
		InternaTabla = new JTable();
		scrollPane.setViewportView(InternaTabla);
		InternaTabla.setFillsViewportHeight(true);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Interna.");
		modelo.addColumn("Cod. Paciente");
		modelo.addColumn("Nº Cama");
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
