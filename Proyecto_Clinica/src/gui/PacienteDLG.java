package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloPaciente;
import clases.Paciente;
import libreria.Alerta;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class PacienteDLG extends JDialog implements ActionListener, MouseListener {
	
	private ArregloPaciente ap = new ArregloPaciente("Pacientes.txt");
	private DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private DefaultTableCellRenderer dtcr;
	
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelfono;
	private JLabel lblDni;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtTel;
	private JTextField txtDni;
	private JButton btnOk;
	private JTable PacienteTabla;
	private JScrollPane scrollPane;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnGrabar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PacienteDLG dialog = new PacienteDLG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PacienteDLG() {
		setTitle("Mantenimiento | Paciente");
		setBounds(100, 100, 907, 584);
		getContentPane().setLayout(null);
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(this);
			btnIngresar.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/ingresar.png")));
			btnIngresar.setBounds(614, 365, 121, 44);
			getContentPane().add(btnIngresar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/modificar.png")));
			btnModificar.setBounds(745, 365, 121, 44);
			getContentPane().add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/exit.png")));
			btnEliminar.setBounds(614, 420, 121, 44);
			getContentPane().add(btnEliminar);
		}
		{
			btnVaciar = new JButton("Vaciar");
			btnVaciar.addActionListener(this);
			btnVaciar.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/eliminar.png")));
			btnVaciar.setBounds(745, 420, 121, 44);
			getContentPane().add(btnVaciar);
		}
		{
			btnGrabar = new JButton("Grabar");
			btnGrabar.addActionListener(this);
			btnGrabar.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/grabar.png")));
			btnGrabar.setBounds(614, 475, 121, 44);
			getContentPane().add(btnGrabar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/salir2.png")));
			btnSalir.setBounds(745, 475, 121, 44);
			getContentPane().add(btnSalir);
		}
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(614, 31, 95, 19);
		getContentPane().add(lblCdigo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(614, 75, 95, 14);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(614, 110, 95, 19);
		getContentPane().add(lblApellidos);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelfono.setBounds(614, 155, 95, 14);
		getContentPane().add(lblTelfono);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(614, 197, 95, 14);
		getContentPane().add(lblDni);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(708, 32, 158, 20);
		getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(708, 74, 158, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setEditable(false);
		txtApe.setBounds(708, 111, 158, 20);
		getContentPane().add(txtApe);
		txtApe.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setBounds(708, 154, 158, 20);
		getContentPane().add(txtTel);
		txtTel.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(708, 196, 158, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);
		btnOk.setIcon(new ImageIcon(PacienteDLG.class.getResource("/img/good.png")));
		btnOk.setBounds(796, 233, 70, 23);
		getContentPane().add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 31, 561, 488);
		getContentPane().add(scrollPane);
		
		PacienteTabla = new JTable();
		PacienteTabla.addMouseListener(this);
		PacienteTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(PacienteTabla);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		PacienteTabla.setModel(modelo);
		
		//Establecer alineamineto
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		PacienteTabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		PacienteTabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		PacienteTabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		PacienteTabla.getColumnModel().getColumn(3).setCellRenderer(dtcr);
		PacienteTabla.getColumnModel().getColumn(4).setCellRenderer(dtcr);
		
		//Inicializando
		listar();//para que aparezca los datos registrados
		dispoDatos(false);
		//para mostrar los datos al inicio, de lo contrario se tiene que hacer click a un fila
		editFil();
	}
	
	
	//  Métodos tipo void sin parámetros
	void limpieza() {
		txtCod.setText("");
		txtNom.setText("");
		txtApe.setText("");
		txtTel.setText("");
		txtDni.setText("");
		txtNom.requestFocus();
	}	
   	void listar() {
   		//Para que tome la posicion al anterior--
   		Paciente x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = PacienteTabla.getSelectedRow();
		if (modelo.getRowCount() == ap.tamaño()-1)
			posFila = ap.tamaño()-1;
		if (posFila == ap.tamaño())
			posFila --;
		//obtener los datos de cama mediante la posicion
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamaño(); i++) {
			Object[] fila = { ap.obtener(i).getCodigoPaciente(),
							  ap.obtener(i).getNombres(),
					          ap.obtener(i).getApellidos(),
					          ap.obtener(i).getTelefono(),
					          ap.obtener(i).getDni()};
			modelo.addRow(fila);
		}
		//Autoseleccionado en la tabla
		if (ap.tamaño() > 0)
			PacienteTabla.getSelectionModel().setSelectionInterval(posFila, posFila);	
		
	}
   	//////////////////////////////////
   	//Métodos con retorno
   	int leerCodigo(){
   		return Integer.parseInt(txtCod.getText().trim());
   	}
   	String leerNombres(){
   		return txtNom.getText().trim();
   	}
   	String leerApellidos(){
   		return txtApe.getText().trim();
   	}
   	String leerTelefono(){
   		return txtTel.getText().trim();
   	}
   	String leerDNI(){
   		return txtDni.getText().trim();
   	}
   	
	/////////////
	//Para habilitar o deshabilitar los datos
	void dispoDatos(boolean sino){
		txtNom.setEditable(sino);
		txtApe.setEditable(sino);
		txtTel.setEditable(sino);
		txtDni.setEditable(sino);
		btnOk.setEnabled(sino);//Es un boton, pero deben actuar a la vez para que tenga esa función y/o efecto :v
	}
	//Para habilitar o deshabilitar los botones
	void dispoBoton(boolean sino){
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//////////////////////////////////
   	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			Boton_Ok(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			Boton_Salir(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			Boton_Grabar(arg0);
		}
		if (arg0.getSource() == btnVaciar) {
			Boton_Vaciar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			Boton_Eliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			Boton_Modificar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			Boton_Ingresar(arg0);
		}
	}
	protected void Boton_Ingresar(ActionEvent arg0) {
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(true);
		limpieza();
		txtCod.setText("" + ap.codigoCorrelativo());
		dispoDatos(true);
	}
	
	protected void Boton_Ok(ActionEvent arg0) {
		try {
			int codigo = leerCodigo();
			String nombre = leerNombres();
			String apellido = leerApellidos();
			String telefono = leerTelefono();
			String dni = leerDNI();			
				if (leerNombres().length()==0) {
					Alerta.mensaje(this, "Ingrese nombre");
					txtNom.setText("");
					txtNom.requestFocus();
				}
				else if (leerApellidos().length()==0) {
					Alerta.mensaje(this, "Ingrese apellidos");
					txtApe.setText("");
					txtApe.requestFocus();
				}
				else if (leerTelefono().length()==0) {
					Alerta.mensaje(this, "Ingrese teléfono");
					txtTel.setText("");
					txtTel.requestFocus();
				}
				else if (leerDNI().length()==0) {
					Alerta.mensaje(this, "Ingrese DNI");
					txtDni.setText("");
					txtDni.requestFocus();
				}
				else{
					/*Luego de accionar boton ingresar,
					se añade datos y se habilita*/
					if (btnIngresar.isEnabled() == false) {
						Paciente np = new Paciente(codigo, apellido, nombre, telefono, dni);
						ap.adicionar(np);
						btnIngresar.setEnabled(true);
					}
					/*Luego de accionar el boton modificar,
					 se cambia los datos y se habilita*/
					if (btnModificar.isEnabled() == false) {
						Paciente p = ap.buscar(codigo);
						p.setCodigoPaciente(codigo);
						p.setApellidos(apellido);
						p.setNombres(nombre);
						p.setTelefono(telefono);
						p.setDni(dni);
						btnModificar.setEnabled(true);
					}
					listar();
					dispoDatos(false);
				}
		}
		catch(Exception e){
			Alerta.mensaje(this, "Datos Erróneos o vacíos");
		}		
	}
	
	protected void Boton_Modificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if(ap.tamaño()>0){
			btnOk.setEnabled(true);
			dispoDatos(true);
			editFil();
		}
		else{
			btnOk.setEnabled(false);
			dispoDatos(false);
			Alerta.mensaje(this, "No hay pacientes");
		}
	}
	
	protected void Boton_Eliminar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (ap.tamaño() > 0) {
			btnEliminar.setEnabled(true);
			int co = Alerta.confirmar(this, "¿Desea eliminar el registro?");
			if (co == 0) {
				ap.eliminar(ap.buscar(leerCodigo()));
				listar();
				editFil();//para mostrar la siguiente fila por defecto
				Alerta.mensaje(this, "Registro eliminado");
			} else {
				Alerta.mensaje(this, "No se eliminó");
			}
		} else {
			Alerta.mensaje(this, "No existen camas");
		}
	}
	
	protected void Boton_Vaciar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (ap.tamaño() > 0) {
			int co = Alerta.confirmar(this, "Está seguro de vaciar la lista\""+ap.getArchivo()+"\" ?");
			if(co == 0){
				ap.eliminarTodo();
				listar();
			}
			else{
				Alerta.mensaje(this, "No se perdieron datos");
			}
		}
		else{
			Alerta.mensaje(this,"La lista de pacientes está vacía");
			limpieza();
		}
	}
	
	protected void Boton_Grabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (ap.existeArchivo()) {
			int ok = Alerta.confirmar(this,"¿ Desea actualizar \"" + ap.getArchivo() + "\" ?");
			if (ok == 0) {
				ap.grabarPacientes();
				Alerta.mensaje(this,"\"" + ap.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this,"No se actualizó  \"" + ap.getArchivo() + "\"");
		}
		else {
			ap.grabarPacientes();
			Alerta.mensaje(this,"\"" + ap.getArchivo() + "\" ha sido creado");
		}
		txtCod.requestFocus();
	}
	protected void Boton_Salir(ActionEvent arg0) {
		dispose();
	}
	
	/*Obtener datos de cama para poder editarlos al hacer click, 
	pero ya que se inicio más arriba, no será necesario el click*/
	void editFil(){
		if (ap.tamaño() == 0){
			limpieza();
		}
		else{
			Paciente p =ap.obtener(PacienteTabla.getSelectedRow());
			txtCod.setText(""+p.getCodigoPaciente());
			txtNom.setText(p.getNombres());
			txtApe.setText(p.getApellidos());
			txtTel.setText(p.getTelefono());
			txtDni.setText(p.getDni());
		}
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == PacienteTabla) {
			mouseClickedPacienteTabla(arg0);
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
	protected void mouseClickedPacienteTabla(MouseEvent arg0) {
		dispoDatos(false);
		dispoBoton(true);
		editFil();
	}
}
