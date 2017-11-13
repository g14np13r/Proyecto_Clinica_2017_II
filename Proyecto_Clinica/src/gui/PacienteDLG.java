package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import clases.Paciente;
import libreria.Alerta;
import arreglos.ArregloPaciente;

public class PacienteDLG extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApePat;
	private JLabel lblApeMat;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApePat;
	private JTextField txtApeMat;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnIngresar;
	private JButton btnListar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;

	ArregloPaciente ap=new ArregloPaciente("pacientes.txt");
	private JButton btnAceptar;
	public static void main(String[] args) {
		try {
			PacienteDLG dialog = new PacienteDLG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PacienteDLG() {
		setModal(true);
		setTitle("Mantenimiento |  Paciente");
		setResizable(false);
		setSize(1000,600);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(725, 10, 111, 23);
		getContentPane().add(lblCodigo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(725, 40, 111, 23);
		getContentPane().add(lblNombres);
		

		lblApePat = new JLabel("Apellido Paterno");
		lblApePat.setBounds(725, 70, 111, 23);
		getContentPane().add(lblApePat);
		
		lblApeMat = new JLabel("Apellido Materno");
		lblApeMat.setBounds(725, 100, 111, 23);
		getContentPane().add(lblApeMat);
		
		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(725, 130, 111, 23);
		getContentPane().add(lblTelefono);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(725, 160, 111, 23);
		getContentPane().add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(830, 10, 151, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(830, 40, 151, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApePat = new JTextField();
		txtApePat.setBounds(830, 70, 151, 23);
		getContentPane().add(txtApePat);
		txtApePat.setColumns(10);
		
		txtApeMat = new JTextField();
		txtApeMat.setBounds(830, 100, 151, 23);
		getContentPane().add(txtApeMat);
		txtApeMat.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(830, 130, 151, 23);
		getContentPane().add(txtTelefono);
	
		txtDni = new JTextField();
		txtDni.setBounds(830, 160, 151, 23);
		getContentPane().add(txtDni);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(812, 194, 91, 23);
		getContentPane().add(btnIngresar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(812, 228, 91, 23);
		getContentPane().add(btnListar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(812, 262, 91, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(812, 296, 91, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(812, 330, 91, 23);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(812, 364, 91, 23);
		getContentPane().add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 700, 550);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Ap. Paterno");
		modelo.addColumn("Ap. Materno");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		
		table.setModel(modelo);
		
		txtCodigo.setEditable(false);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(812, 473, 91, 23);
		getContentPane().add(btnAceptar);
		//Faltan llamar metodos
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna( 8));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna( 8));  // ApePat
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 8));  // ApeMat
		tcm.getColumn(8).setPreferredWidth(anchoColumna( 9));  // Telefono
		tcm.getColumn(9).setPreferredWidth(anchoColumna( 8));  // Dni
		}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
		if (e.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		txtCodigo.setText("" + ap.codigoCorrelativo());
		habilitarEntradas(true);
		txtNombres.requestFocus();
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		
	}
	protected void do_btnConsultar_actionPerformed(ActionEvent e) {
		
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (ap.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			Alerta.mensaje(this, "No existen empleados");	
		}
		else {
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtNombres.requestFocus();
		}
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ap.tamaño() == 0)
			Alerta.mensaje(this, "No existen clientes");
		else {
			int ok = Alerta.confirmar(this, "¿ Desea eliminar el registro ?");
			if (ok == 0) {
				ap.eliminar(ap.buscar(leerCodigo()));
				listar();
				editarFila();
			}
		}
	}
	protected void do_btnGrabar_actionPerformed(ActionEvent e) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ap.existeArchivo()) {
			int ok = Alerta.confirmar(this, "¿ Desea actualizar \"" + ap.getArchivo() + "\" ?");
			if (ok == 0) {
				ap.grabarClientes();
				Alerta.mensaje(this, "\"" + ap.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this, "No se actualizó  \"" + ap.getArchivo() + "\"");
		}
		else {
			ap.grabarClientes();
			Alerta.mensaje(this, "\"" + ap.getArchivo() + "\" ha sido creado");
		}
	}
	void listar() {
		Paciente x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == ap.tamaño()-1)
			posFila = ap.tamaño()-1;
		if (posFila == ap.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamaño(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigoPaciente(), 
						      x.getNombres(),
						      x.getApepat(),
						      x.getApemat(),
						      x.getTelefono(),
						      x.getDni(),
						      };
			modelo.addRow(fila);
		}
		if (ap.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void limpieza() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApePat.setText("");
		txtApeMat.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
	}
	void editarFila() {
		if (ap.tamaño() == 0)
			limpieza();
		else {
			Paciente x = ap.obtener(table.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoPaciente());
			txtNombres.setText(x.getNombres());
			txtApePat.setText(x.getApepat());
			txtApeMat.setText(x.getApemat());
			txtTelefono.setText(x.getTelefono());
			txtDni.setText(x.getDni());
			}
	}
	void habilitarEntradas(boolean sino) {
		txtNombres.setEditable(sino);
		txtApePat.setEditable(sino);
		txtApeMat.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombres() {
		return txtNombres.getText().trim();
	}
	String leerApePat() {
		return txtApePat.getText().trim();
	}
	String leerApeMat() {
		return txtApeMat.getText().trim();
	}
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();		
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		int codigo = leerCodigo();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apePat = leerApePat();
			if (apePat.length() > 0) {
				String apeMat = leerApeMat();
				if (apeMat.length() > 0) {
					String telefono = leerTelefono();
					if (telefono.length() > 0) {
						String dni = leerDni();
						if (dni.length() > 0) {
							if (btnIngresar.isEnabled() == false) {
								Paciente nuevo = new Paciente(codigo, nombres, apePat, apeMat, telefono, dni);
											ap.adicionar(nuevo);
											btnIngresar.setEnabled(true);
										}
										if (btnModificar.isEnabled() == false) {
											Paciente x = ap.buscar(codigo);
											x.setNombres(nombres);
											x.setApepat(apePat);
											x.setApemat(apeMat);
											x.setTelefono(telefono);
											x.setDni(dni);
											btnModificar.setEnabled(true);
										}	
										listar();
										habilitarEntradas(false);
									}
							else {
								Alerta.mensaje(this, "Ingrese DNI correcto");
								txtDni.setText("");
								txtDni.requestFocus();
						}
					}
						else {
							Alerta.mensaje(this, "Ingrese TELEFONO correcto");
							txtTelefono.setText("");
							txtTelefono.requestFocus();
						}
				}
				else {
					Alerta.mensaje(this, "Ingrese APELLIDO MATERNO correcto");
					txtApeMat.setText("");
					txtApeMat.requestFocus();
				}
			}
			else {
				Alerta.mensaje(this, "Ingrese APELLIDO PATERNO correcto");
				txtApePat.setText("");
				txtApePat.requestFocus();
			}
		}
		else {
			Alerta.mensaje(this, "Ingrese NOMBRES correctos");
			txtNombres.setText("");
			txtNombres.requestFocus();
		}
	}
}