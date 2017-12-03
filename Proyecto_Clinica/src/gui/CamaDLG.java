package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
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
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CamaDLG extends JDialog implements ActionListener, MouseListener {
	
	private ArregloCama ac = new ArregloCama("Camas.txt");
	private DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private DefaultTableCellRenderer dtcr;
	
	private JButton btnIngresar;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JLabel lblNumero;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtNum;
	private JTextField txtPre;
	private JComboBox cboEstado;
	private JTable CamaTabla;
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
			dialog.setDefaultCloseOperation(0);//JDialog.DISPOSE_ON_CLOSE eliminamos el x cerrar :v
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CamaDLG() {
		setTitle("Mantenimiento | Cama");
		setModal(true);
		setBounds(100, 100, 679, 459);
		getContentPane().setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/ingresar.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(390, 242, 121, 44);
		getContentPane().add(btnIngresar);
		
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
		txtNum.setEditable(false);
		txtNum.setBounds(495, 24, 148, 20);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setEditable(false);
		txtPre.setBounds(495, 64, 148, 20);
		getContentPane().add(txtPre);
		txtPre.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupada"}));
		cboEstado.setBounds(531, 99, 112, 20);
		getContentPane().add(cboEstado);
		
		
		btnHecho = new JButton("Ok");
		btnHecho.setEnabled(false);
		btnHecho.addActionListener(this);
		btnHecho.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/good.png")));
		btnHecho.setBounds(573, 130, 70, 23);
		getContentPane().add(btnHecho);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(521, 242, 122, 44);
		getContentPane().add(btnModificar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/salir2.png")));
		btnSalir.setBounds(521, 352, 122, 44);
		getContentPane().add(btnSalir);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(this);
		btnVaciar.setIcon(new ImageIcon(CamaDLG.class.getResource("/img/eliminar.png")));
		btnVaciar.setBounds(521, 297, 122, 44);
		getContentPane().add(btnVaciar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 26, 332, 370);
		getContentPane().add(scrollPane);
		
		CamaTabla = new JTable();
		CamaTabla.addMouseListener(this);
		scrollPane.setViewportView(CamaTabla);
		CamaTabla.setFillsViewportHeight(true);
		
		//DefaulTable
		modelo = new DefaultTableModel();
		modelo.addColumn("Nº Cama");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		CamaTabla.setModel(modelo);
		
		//Establecer alineamineto
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		CamaTabla.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		CamaTabla.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		CamaTabla.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		
		//Inicializando
		listar();//para que aparezca los datos registrados
		dispoDatos(false);
		//para mostrar los datos al inicio, de lo contrario se tiene que hacer click a un fila
		editFil();
		
	}
	
	//  Métodos tipo void sin parámetros
	void limpieza() {
		txtNum.setText("");
		txtPre.setText("");
		txtPre.requestFocus();
	}	
   	void listar() {
   		//Para que tome la posicion al anterior--
   		Cama x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = CamaTabla.getSelectedRow();
		if (modelo.getRowCount() == ac.tamaño()-1)
			posFila = ac.tamaño()-1;
		if (posFila == ac.tamaño())
			posFila --;
		//obtener los datos de cama mediante la posicion
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++) {
			Object[] fila = { ac.obtener(i).getNumeroCama(),
/*String.format("%,6.2f",)*/  ac.obtener(i).getPrecioDia(),
					          ac.obtener(i).detalleEstado() };
			modelo.addRow(fila);
		}
		//Autoseleccionado en la tabla
		if (ac.tamaño() > 0)
			CamaTabla.getSelectionModel().setSelectionInterval(posFila, posFila);	
		
	}
   	//////////////////////////////////
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
	//Para habilitar o deshabilitar los datos
	void dispoDatos(boolean sino){
		txtPre.setEditable(sino);
		cboEstado.setEnabled(sino);
		btnHecho.setEnabled(sino);//Es un boton, pero deben actuar a la vez para que tenga esa función y/o efecto :v
	}
	//Para habilitar o deshabilitar los botones
	void dispoBoton(boolean sino){
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//////////////////////////////////
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			Boton_Modificar(arg0);
		}
		if (arg0.getSource() == btnHecho) {
			Boton_Hecho(arg0);
		}
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
		if (arg0.getSource() == btnIngresar) {
			Boton_Ingresar(arg0);
		}
	}
	
	
	protected void Boton_Ingresar(ActionEvent arg0) {
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnHecho.setEnabled(true);
		limpieza();
		txtNum.setText("" + ac.codigoCorrelativo());
		dispoDatos(true);
		/**/
	}
	
	protected void Boton_Hecho(ActionEvent arg0) {
		try {
			int numero = leerNumero();
			double precio = leerPrecio();
			int estado = leerEstado();
			
			if (leerPrecio()<=0) {
				Alerta.mensaje(this, "Precio no válido");
				txtPre.setText("");
				txtPre.requestFocus();
			}
			else{
				/*Luego de accionar boton ingresar,
				se añade datos y se habilita*/
				if(btnIngresar.isEnabled() == false){
					Cama nc = new Cama(numero, precio, estado);
					ac.adicionar(nc);
					btnIngresar.setEnabled(true);
				}
				/*Luego de accionar el boton modificar,
				 se cambia los datos y se habilita*/
				if(btnModificar.isEnabled() == false){
					Cama c = ac.buscar(numero);
					c.setNumeroCama(numero);
					c.setPrecioDia(precio);
					c.setEstado(estado);
					btnModificar.setEnabled(true);
				}
				listar();
				dispoDatos(false);
			}
			
		} 
		catch (Exception e) {
			Alerta.mensaje(this,"Ingrese precio correcto");
			txtPre.setText("");
			txtPre.requestFocus();
		}
	}
	
	protected void Boton_Modificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if(ac.tamaño()>0){
			btnHecho.setEnabled(true);
			dispoDatos(true);
			editFil();
		}
		else{
			btnHecho.setEnabled(false);
			dispoDatos(false);
			Alerta.mensaje(this, "No hay camas");
		}
	}
	
	protected void Boton_Eliminar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnHecho.setEnabled(false);
		if (ac.tamaño() > 0) {
			btnEliminar.setEnabled(true);
			int co = Alerta.confirmar(this, "¿Desea eliminar el registro?");
			if (co == 0) {
				ac.eliminar(ac.buscar(leerNumero()));
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
		btnHecho.setEnabled(false);
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
		else{
			Alerta.mensaje(this,"La lista de camas está vacía");
			limpieza();
		}
	}
	
	protected void Boton_Grabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnHecho.setEnabled(false);
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
	
	protected void Boton_Salir(ActionEvent arg0) {
		dispose();
	}
	
	/*Obtener datos de cama para poder editarlos al hacer click, 
	pero ya que se inicio más arriba, no será necesario el click*/
	void editFil(){
		if (ac.tamaño() == 0){
			limpieza();
		}
		else{
			Cama c=ac.obtener(CamaTabla.getSelectedRow());
			txtNum.setText(""+c.getNumeroCama());
			txtPre.setText(""+c.getPrecioDia());
			cboEstado.setSelectedItem(""+c.detalleEstado());
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
		dispoDatos(false);
		dispoBoton(true);
		editFil();
	}
	
	
}
