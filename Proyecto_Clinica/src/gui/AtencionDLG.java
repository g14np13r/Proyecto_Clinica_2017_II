package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAtencion;
import arreglos.ArregloMedicina;
import arreglos.ArregloPaciente;
import clases.Atencion;
import clases.Medicina;
import clases.Paciente;
import libreria.Alerta;
import libreria.Fecha;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AtencionDLG extends JDialog implements ActionListener, MouseListener {

	ArregloPaciente ap = new ArregloPaciente("Pacientes.txt");
	ArregloMedicina am = new ArregloMedicina("Medicinas.txt");
	ArregloAtencion aa = new ArregloAtencion("Atenciones.txt");
	private DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private DefaultTableCellRenderer dtcr;
	
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVaciar;
	private JButton btnGrabar;
	private JButton btnSalir;
	private JButton btnOk;
	private JLabel lblCodAtencin;
	private JLabel lblCodPaciente;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField txtCodAt;
	private JComboBox cboCodPa;
	private JComboBox cboDia;
	private JComboBox cboEstado;
	private JComboBox cboMes;
	private JComboBox cboAño;
	private JTable AtencionTabla;
	private JLabel lblCantidad;
	private JTextField txtCan;
	private JScrollPane scrollPane;
	private JLabel lblMedicina;
	private JComboBox cboMed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AtencionDLG dialog = new AtencionDLG();
			dialog.setDefaultCloseOperation(0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtencionDLG() {
		setModal(true);
		setBounds(100, 100, 1000, 584);
		getContentPane().setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/ingresar.png")));
		btnIngresar.setBounds(707, 372, 121, 42);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(838, 372, 121, 42);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/exit.png")));
		btnEliminar.setBounds(707, 425, 121, 42);
		getContentPane().add(btnEliminar);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(this);
		btnVaciar.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(838, 425, 121, 42);
		getContentPane().add(btnVaciar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(707, 478, 121, 42);
		getContentPane().add(btnGrabar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(838, 478, 121, 42);
		getContentPane().add(btnSalir);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(AtencionDLG.class.getResource("/img/good.png")));
		btnOk.setBounds(889, 257, 70, 23);
		getContentPane().add(btnOk);
		
		lblCodAtencin = new JLabel("Cod. Atenci\u00F3n");
		lblCodAtencin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodAtencin.setBounds(707, 32, 104, 14);
		getContentPane().add(lblCodAtencin);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodPaciente.setBounds(707, 67, 104, 14);
		getContentPane().add(lblCodPaciente);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(707, 175, 104, 14);
		getContentPane().add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(707, 217, 104, 14);
		getContentPane().add(lblEstado);
		
		txtCodAt = new JTextField();
		txtCodAt.setEditable(false);
		txtCodAt.setBounds(821, 31, 138, 20);
		getContentPane().add(txtCodAt);
		txtCodAt.setColumns(10);
		
		cboCodPa = new JComboBox();
		cboCodPa.setEnabled(false);
		obtenerPacientes();
		cboCodPa.setBounds(821, 66, 138, 20);
		getContentPane().add(cboCodPa);
		
		cboDia = new JComboBox <String>();
		cboDia.addActionListener(this);
		Fecha.setDias(cboDia);
		cboDia.setEnabled(false);
		cboDia.setBounds(801, 174, 45, 20);
		getContentPane().add(cboDia);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado"}));
		cboEstado.setEnabled(false);
		cboEstado.setBounds(862, 216, 97, 20);
		getContentPane().add(cboEstado);
		
		cboMes = new JComboBox <String>();
		cboMes.addActionListener(this);
		Fecha.setMeses(cboMes);
		cboMes.setEnabled(false);
		cboMes.setBounds(848, 174, 50, 20);
		getContentPane().add(cboMes);
		
		cboAño = new JComboBox <String>();
		cboAño.addActionListener(this);
		Fecha.setAños(cboAño);
		cboAño.setEnabled(false);
		cboAño.setBounds(899, 174, 60, 20);
		getContentPane().add(cboAño);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(707, 102, 104, 14);
		getContentPane().add(lblCantidad);
		
		txtCan = new JTextField();
		txtCan.setEditable(false);
		txtCan.setBounds(821, 101, 138, 20);
		getContentPane().add(txtCan);
		txtCan.setColumns(10);
		

		lblMedicina = new JLabel("Medicina");
		lblMedicina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicina.setBounds(707, 138, 87, 14);
		getContentPane().add(lblMedicina);
		
		cboMed = new JComboBox();
		cboMed.setEnabled(false);
		obtenerMedicinas();
		cboMed.setBounds(821, 137, 138, 20);
		getContentPane().add(cboMed);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 34, 648, 486);
		getContentPane().add(scrollPane);
		
		AtencionTabla = new JTable();
		scrollPane.setViewportView(AtencionTabla);
		AtencionTabla.addMouseListener(this);
		AtencionTabla.setFillsViewportHeight(true);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Atención");
		modelo.addColumn("Cod. Paciente");
		modelo.addColumn("Medicina");
		modelo.addColumn("Fecha");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Total");
		modelo.addColumn("Estado");
		AtencionTabla.setModel(modelo);
		
		
		//Establecer alineamiento
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		AtencionTabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(3).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(4).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(5).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(6).setCellRenderer(dtcr);
		AtencionTabla.getColumnModel().getColumn(7).setCellRenderer(dtcr);
		

		//Inicializando
		listar();//para que aparezca los datos registrados
		dispoDatos(false);
		//para mostrar los datos al inicio, de lo contrario se tiene que hacer click a un fila
		editFil();
	}
	void obtenerPacientes() {
		Paciente x;
		for (int i=0; i<ap.tamaño(); i++) {
			x = ap.obtener(i);
			cboCodPa.addItem(x.getCodigoPaciente() + "");
		}	
	}
	void obtenerMedicinas(){
		Medicina x;
		for (int i = 0; i < am.tamaño(); i++) {
			x = am.obtener(i);
			cboMed.addItem(x.getNombre());
		}
	}
	double pre(){
		double precio = am.obtener(0).getPrecio();
		for (int i = 1; i < am.tamaño(); i++) {
				am.obtener(i).getPrecio();
		}
		return precio;
	}
	
	double total(){
		 return pre()*leerCant();
	}
	
	
	//  Métodos tipo void sin parámetros
	void limpieza(){
		txtCan.setText("");
		txtCan.requestFocus();
		Fecha.setFecha(cboDia, cboMes, cboAño);
	}
	void listar(){
   		//Para que tome la posicion al anterior--
   		Atencion x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = AtencionTabla.getSelectedRow();
		if (modelo.getRowCount() == aa.tamaño()-1)
			posFila = aa.tamaño()-1;
		if (posFila == aa.tamaño())
			posFila --;
		//obtener los datos de cama mediante la posicion
		modelo.setRowCount(0);
		for (int i=0; i<aa.tamaño(); i++) {
			Object[] fila = { aa.obtener(i).getCodigoAtencion(),
							  aa.obtener(i).getCodigoPaciente(),
							  leerMedi(),
					          aa.obtener(i).getFechaAtencion(),
					          leerCant(),
							  pre(),
					          total(),
					          aa.obtener(i).detalleEstado()};
			modelo.addRow(fila);
		}
		//Autoseleccionado en la tabla
		if (aa.tamaño() > 0)
			AtencionTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
   	//////////////////////////////////
   	//Métodos con retorno
   	int leerCodAten(){
   		return Integer.parseInt(txtCodAt.getText().trim());
   	}
   	int leerCodPaci(){
   		return Integer.parseInt(cboCodPa.getSelectedItem().toString());
   	}
   	String leerMedi(){
   		String medi = cboMed.getSelectedItem().toString();
   		for (int i = 0; i < am.tamaño(); i++) {
			if(medi==am.obtener(i).getNombre()){
				am.obtener(i);
			}
		}
   		return medi;
   	}
   	int leerCant(){
   		return Integer.parseInt(txtCan.getText().trim());
   	}
   	String leerFecha(){
   		return Fecha.getFecha(cboDia, cboMes, cboAño);
   	}
   	int leerEstado(){
   		return cboEstado.getSelectedIndex();
   	}
   	
	/////////////
	//Para habilitar o deshabilitar los datos
	void dispoDatos(boolean sino){
		txtCan.setEditable(sino);
		cboCodPa.setEnabled(sino);
		cboDia.setEnabled(sino);
		cboMes.setEnabled(sino);
		cboAño.setEnabled(sino);
		cboMed.setEnabled(sino);
		cboEstado.setEnabled(sino);
		btnOk.setEnabled(sino);//Es un boton, pero deben actuar a la vez para que tenga esa función y/o efecto :v
	}
	//Para habilitar o deshabilitar los botones
	void dispoBoton(boolean sino){
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//////////////////////////////////
	public void actionPerformed(ActionEvent arg0) {
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
		if (arg0.getSource() == btnOk) {
			Boton_Ok(arg0);
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
		txtCodAt.setText("" + aa.codigoCorrelativo());
		dispoDatos(true);
	}
	
	protected void Boton_Ok(ActionEvent arg0) {
		try {
			int codate = leerCodAten();
			int codpac = leerCodPaci();
			String med = leerMedi();
			String fec = leerFecha();
			int estado = leerEstado();
			double tot = total();
			double pre = pre();
			
			/*Luego de accionar boton ingresar,
			se añade datos y se habilita*/
			if (btnIngresar.isEnabled() == false) {
				Atencion na = new Atencion(codate, codpac, fec, tot, estado);
				aa.adicionar(na);
				btnIngresar.setEnabled(true);
			}
			/*Luego de accionar el boton modificar,
			 se cambia los datos y se habilita*/
			if (btnModificar.isEnabled() == false) {
				Atencion a = aa.buscar(codate);
				a.setCodigoPaciente(codpac);
				a.setFechaAtencion(fec);
				a.setTotalPagar(tot);
				a.setEstado(estado);
				btnModificar.setEnabled(true);
			}
			listar();
			dispoDatos(false);
			
		} catch (Exception e) {
			Alerta.mensaje(this, "Ingrese cantidad correcta");
		}
	}
	
	protected void Boton_Modificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if(aa.tamaño()>0){
			btnOk.setEnabled(true);
			dispoDatos(true);
			editFil();
		}
		else{
			btnOk.setEnabled(false);
			dispoDatos(false);
			Alerta.mensaje(this, "No hay atenciones");
		}
	}
	
	protected void Boton_Eliminar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (aa.tamaño() > 0) {
			btnEliminar.setEnabled(true);
			int co = Alerta.confirmar(this, "¿Desea eliminar el registro?");
			if (co == 0) {
				aa.eliminar(aa.buscar(leerCodAten()));
				listar();
				editFil();//para mostrar la siguiente fila por defecto
				Alerta.mensaje(this, "Registro eliminado");
			} else {
				Alerta.mensaje(this, "No se eliminó");
			}
		} else {
			Alerta.mensaje(this, "No existen atenciones");
		}
	}
	
	protected void Boton_Vaciar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (aa.tamaño() > 0) {
			int co = Alerta.confirmar(this, "Está seguro de vaciar la lista\""+aa.getArchivo()+"\" ?");
			if(co == 0){
				aa.eliminarTodo();
				listar();
			}
			else{
				Alerta.mensaje(this, "No se perdieron datos");
			}
		}
		else{
			Alerta.mensaje(this,"La lista de atenciones está vacía");
			limpieza();
		}
	}
	
	protected void Boton_Grabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (aa.existeArchivo()) {
			int ok = Alerta.confirmar(this,"¿ Desea actualizar \"" + aa.getArchivo() + "\" ?");
			if (ok == 0) {
				aa.grabarAtencion();
				Alerta.mensaje(this,"\"" + aa.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this,"No se actualizó  \"" + aa.getArchivo() + "\"");
		}
		else {
			aa.grabarAtencion();
			Alerta.mensaje(this,"\"" + aa.getArchivo() + "\" ha sido creado");
		}
	}
	
	protected void Boton_Salir(ActionEvent arg0) {
		dispose();
	}
	
	/*Obtener datos de cama para poder editarlos al hacer click, 
	pero ya que se inicio más arriba, no será necesario el click*/
	void editFil(){
		if (aa.tamaño() == 0){
			limpieza();
		}
		else{
			Atencion a =aa.obtener(AtencionTabla.getSelectedRow());
			txtCodAt.setText(""+a.getCodigoAtencion());
			cboMed.setSelectedItem(""+leerMedi());
			cboCodPa.setSelectedItem(a.getCodigoPaciente());
			Fecha.setFecha(cboDia, cboMes, cboAño, a.getFechaAtencion());
			cboEstado.setSelectedItem(a.detalleEstado());
			txtCan.setText(""+leerCant());
		}
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == AtencionTabla) {
			mouseClickedAtencionTabla(arg0);
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
	protected void mouseClickedAtencionTabla(MouseEvent arg0) {
		dispoDatos(false);
		dispoBoton(true);
		editFil();
	}
}
