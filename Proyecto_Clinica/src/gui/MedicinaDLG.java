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
import clases.Medicina;
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

public class MedicinaDLG extends JDialog implements ActionListener, MouseListener {
	
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
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/ingresar.png")));
		btnIngresar.setBounds(611, 366, 122, 44);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(743, 366, 122, 44);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/exit.png")));
		btnEliminar.setBounds(611, 420, 122, 44);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(611, 475, 122, 44);
		getContentPane().add(btnGrabar);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(this);
		btnVaciar.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(743, 420, 122, 44);
		getContentPane().add(btnVaciar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
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
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(MedicinaDLG.class.getResource("/img/good.png")));
		btnOk.setEnabled(false);
		btnOk.setBounds(795, 210, 70, 23);
		getContentPane().add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 25, 543, 497);
		getContentPane().add(scrollPane);
		
		MedicinaTabla = new JTable();
		MedicinaTabla.addMouseListener(this);
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
		
		//Inicializando
		listar();//para que aparezca los datos registrados
		dispoDatos(false);
		//para mostrar los datos al inicio, de lo contrario se tiene que hacer click a un fila
		editFil();
	}


	//  Métodos tipo void sin parámetros
	void limpieza() {
		txtNom.setText("");
		txtLab.setText("");
		txtPre.setText("");
		txtStock.setText("");
		txtNom.requestFocus();
	}	
   	void listar() {
   		//Para que tome la posicion al anterior--
   		Medicina x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = MedicinaTabla.getSelectedRow();
		if (modelo.getRowCount() == am.tamaño()-1)
			posFila = am.tamaño()-1;
		if (posFila == am.tamaño())
			posFila --;
		//obtener los datos de cama mediante la posicion
		modelo.setRowCount(0);
		for (int i=0; i<am.tamaño(); i++) {
			Object[] fila = { am.obtener(i).getCodigoMedicina(),
							  am.obtener(i).getNombre(),
					          am.obtener(i).getLaboratorio(),
					          am.obtener(i).getPrecio(),
					          am.obtener(i).getStock()};
			modelo.addRow(fila);
		}
		//Autoseleccionado en la tabla
		if (am.tamaño() > 0)
			MedicinaTabla.getSelectionModel().setSelectionInterval(posFila, posFila);	
		
	}
   	//////////////////////////////////
   	//Métodos con retorno
   	int leerCodigo(){
   		return Integer.parseInt(txtCod.getText().trim());
   	}
   	String leerNombre(){
   		return txtNom.getText().trim();
   	}
   	String leerLaboratorio(){
   		return txtLab.getText().trim();
   	}
   	double leerPrecio(){
   		return Double.parseDouble(txtPre.getText().trim());
   	}
   	int leerStock(){
   		return Integer.parseInt(txtStock.getText().trim());
   	}
   	
	/////////////
	//Para habilitar o deshabilitar los datos
	void dispoDatos(boolean sino){
		txtNom.setEditable(sino);
		txtLab.setEditable(sino);
		txtPre.setEditable(sino);
		txtStock.setEditable(sino);
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
		txtCod.setText("" + am.codigoCorrelativo());
		dispoDatos(true);
	}
	protected void Boton_Ok(ActionEvent arg0) {
			
	int codigo = leerCodigo();
		String nombre = leerNombre();
		String lab = leerLaboratorio();
		if (leerNombre().length()==0) {
			Alerta.mensaje(this, "Ingrese nombre");
			txtNom.setText("");
			txtNom.requestFocus();
		}
		else if (leerLaboratorio().length()==0) {
			Alerta.mensaje(this, "Ingrese laboratorio");
			txtLab.setText("");
			txtLab.requestFocus();
		}
	
		else {
					
			try {
				double precio = leerPrecio();
				try {
					int stock = leerStock();
					/*Luego de accionar boton ingresar,
					se añade datos y se habilita*/
					if (btnIngresar.isEnabled() == false) {
						Medicina nm = new Medicina(codigo, nombre, lab, precio, stock);
						am.adicionar(nm);
						btnIngresar.setEnabled(true);
						listar();
						dispoDatos(false);
					}
					/*Luego de accionar el boton modificar,
					se cambia los datos y se habilita*/
					if (btnModificar.isEnabled() == false) {
						Medicina m = am.buscar(codigo);
						m.setCodigoMedicina(codigo);
						m.setNombre(nombre);
						m.setLaboratorio(lab);
						m.setPrecio(precio);
						m.setStock(stock);
						btnModificar.setEnabled(true);
						listar();
						dispoDatos(false);
					}
				} catch (Exception e) {
					Alerta.mensaje(this, "Ingrese Stock correcto");
					txtStock.setText("");
					txtStock.requestFocus();
				}
			} 
			catch (Exception e) {
				Alerta.mensaje(this, "Ingrese precio correcto");
				txtPre.setText("");
				txtPre.requestFocus();
			}
		}
	}
	protected void Boton_Modificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if(am.tamaño()>0){
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
		if (am.tamaño() > 0) {
			btnEliminar.setEnabled(true);
			int co = Alerta.confirmar(this, "¿Desea eliminar el registro?");
			if (co == 0) {
				am.eliminar(am.buscar(leerCodigo()));
				listar();
				editFil();//para mostrar la siguiente fila por defecto
				Alerta.mensaje(this, "Registro eliminado");
			} else {
				Alerta.mensaje(this, "No se eliminó");
			}
		} else {
			Alerta.mensaje(this, "No existen medicinas");
		}
	}
	protected void Boton_Vaciar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (am.tamaño() > 0) {
			int co = Alerta.confirmar(this, "Está seguro de vaciar la lista \"" +am.getArchivo()+ "\" ?");
			if(co == 0){
				am.eliminarTodo();
				listar();
			}
			else{
				Alerta.mensaje(this, "No se perdieron datos");
			}
		}
		else{
			Alerta.mensaje(this,"La lista de medicinas está vacía");
			limpieza();
		}
	}
	protected void Boton_Grabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (am.existeArchivo()) {
			int ok = Alerta.confirmar(this,"¿ Desea actualizar \"" + am.getArchivo() + "\" ?");
			if (ok == 0) {
				am.grabarMedicinas();
				Alerta.mensaje(this,"\"" + am.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this,"No se actualizó  \"" + am.getArchivo() + "\"");
		}
		else {
			am.grabarMedicinas();
			Alerta.mensaje(this,"\"" + am.getArchivo() + "\" ha sido creado");
		}
	}
	protected void Boton_Salir(ActionEvent arg0) {
		dispose();
	}
	

	/*Obtener datos de cama para poder editarlos al hacer click, 
	pero ya que se inicio más arriba, no será necesario el click*/
	void editFil(){
		if (am.tamaño() == 0){
			limpieza();
		}
		else{
			Medicina m =am.obtener(MedicinaTabla.getSelectedRow());
			txtCod.setText(""+m.getCodigoMedicina());
			txtNom.setText(m.getNombre());
			txtLab.setText(m.getLaboratorio());
			txtPre.setText(""+m.getPrecio());
			txtStock.setText(""+m.getStock());
		}
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == MedicinaTabla) {
			mouseClickedMedicinaTabla(arg0);
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
	protected void mouseClickedMedicinaTabla(MouseEvent arg0) {
		dispoDatos(false);
		dispoBoton(true);
		editFil();
	}
}
