package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloMedicina;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MedicinaDLG extends JDialog {
	
	private ArregloMedicina am = new ArregloMedicina("Medicinas.txt");
	private DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private DefaultTableCellRenderer dtcr;
	
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnVaciar;
	private JButton btnSalir;
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblLaboratorio;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtLab;
	private JTextField txtPre;
	private JTextField txtStock;
	private JButton btnOk;
	private JTable MedicinaTabla;
	private JScrollPane scrollPane;

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
		setTitle("Mantenimiento | Medicina");
		setBounds(100, 100, 907, 584);
		getContentPane().setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/ingresar.png")));
		btnIngresar.setBounds(611, 366, 122, 44);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(743, 366, 122, 44);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/exit.png")));
		btnEliminar.setBounds(611, 420, 122, 44);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(611, 475, 122, 44);
		getContentPane().add(btnGrabar);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(743, 420, 122, 44);
		getContentPane().add(btnVaciar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(743, 475, 122, 44);
		getContentPane().add(btnSalir);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(610, 26, 95, 20);
		getContentPane().add(lblCdigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(610, 67, 95, 14);
		getContentPane().add(lblNombre);
		
		lblLaboratorio = new JLabel("Laboratorio");
		lblLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLaboratorio.setBounds(610, 104, 95, 14);
		getContentPane().add(lblLaboratorio);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(610, 141, 95, 14);
		getContentPane().add(lblPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(610, 175, 95, 14);
		getContentPane().add(lblStock);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(715, 28, 149, 20);
		getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(715, 64, 149, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtLab = new JTextField();
		txtLab.setEditable(false);
		txtLab.setBounds(715, 101, 149, 20);
		getContentPane().add(txtLab);
		txtLab.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setEditable(false);
		txtPre.setBounds(715, 138, 149, 20);
		getContentPane().add(txtPre);
		txtPre.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setBounds(715, 172, 149, 20);
		getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/good.png")));
		btnOk.setEnabled(false);
		btnOk.setBounds(795, 210, 70, 23);
		getContentPane().add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 25, 543, 497);
		getContentPane().add(scrollPane);
		
		MedicinaTabla = new JTable();
		MedicinaTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(MedicinaTabla);
		
		//DefaultTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Laboratorio");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		MedicinaTabla.setModel(modelo);

		//Establecer alineamineto
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		MedicinaTabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		MedicinaTabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		MedicinaTabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		MedicinaTabla.getColumnModel().getColumn(3).setCellRenderer(dtcr);
		MedicinaTabla.getColumnModel().getColumn(4).setCellRenderer(dtcr);
	}

}
