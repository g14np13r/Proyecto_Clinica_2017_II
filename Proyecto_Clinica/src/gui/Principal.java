package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivos;
	private JMenu mnMantenimiento;
	private JMenu mnInternamiento;
	private JMenu mnAtencion;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCama;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmMedicina;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeClinica;
	private JLabel lblNewLabel;
	private JMenuItem mntmInternar;
	private JMenuItem mntmAtencin;
	private JMenuItem mntmControlDePagos;
	private JMenuItem mntmGenerarReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
				    frame.setLocationRelativeTo(null);//centrando la ventana by REUZ
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("CL\u00CDNICA: SISTEMA DE INTERNAMIENTO Y LIQUIDACI\u00D3N");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/user.png")));
		setDefaultCloseOperation(0);/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);Quitamos la acci�n de cerrar(x)*/
		this.setResizable(false);//Para mantenga del mismo tama�o()
		setBounds(100, 100, 866, 466);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivos = new JMenu("Archivos");
		mnArchivos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnArchivos.setIcon(new ImageIcon(Principal.class.getResource("/img/archivo.png")));
		menuBar.add(mnArchivos);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/img/salir.png")));
		mnArchivos.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnMantenimiento.setIcon(new ImageIcon(Principal.class.getResource("/img/configuracion.png")));
		menuBar.add(mnMantenimiento);
		
		mntmCama = new JMenuItem("Cama");
		mntmCama.addActionListener(this);
		mntmCama.setIcon(new ImageIcon(Principal.class.getResource("/img/cama2.JPG")));
		mnMantenimiento.add(mntmCama);
		
		mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		mntmPaciente.addActionListener(this);
		mnMantenimiento.add(mntmPaciente);
		
		mntmMedicina = new JMenuItem("Medicina");
		mntmMedicina.setIcon(new ImageIcon(Principal.class.getResource("/img/registrar.png")));
		mntmMedicina.addActionListener(this);
		mnMantenimiento.add(mntmMedicina);
		
		mnInternamiento = new JMenu("Internamiento");
		mnInternamiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnInternamiento.setIcon(new ImageIcon(Principal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnInternamiento);
		
		mntmInternar = new JMenuItem("Internar");
		mntmInternar.addActionListener(this);
		mntmInternar.setIcon(new ImageIcon(Principal.class.getResource("/img/reportar.png")));
		mnInternamiento.add(mntmInternar);
		
		mnAtencion = new JMenu("Atenci\u00F3n");
		mnAtencion.setIcon(new ImageIcon(Principal.class.getResource("/img/discount.png")));
		mnAtencion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAtencion);
		
		mntmAtencin = new JMenuItem("Atenci\u00F3n");
		mntmAtencin.addActionListener(this);
		mntmAtencin.setIcon(new ImageIcon(Principal.class.getResource("/img/registro.png")));
		mnAtencion.add(mntmAtencin);
		
		mnPago = new JMenu("Pago");
		mnPago.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnPago.setIcon(new ImageIcon(Principal.class.getResource("/img/vend.png")));
		menuBar.add(mnPago);
		
		mntmControlDePagos = new JMenuItem("Control de Pagos");
		mntmControlDePagos.addActionListener(this);
		mntmControlDePagos.setIcon(new ImageIcon(Principal.class.getResource("/img/controlar.png")));
		mnPago.add(mntmControlDePagos);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnReporte.setIcon(new ImageIcon(Principal.class.getResource("/img/report.png")));
		menuBar.add(mnReporte);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mntmGenerarReportes.setIcon(new ImageIcon(Principal.class.getResource("/img/reportes.png")));
		mnReporte.add(mntmGenerarReportes);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/img/acerca.png")));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeClinica = new JMenuItem("Acerca de Cl\u00EDnica");
		mntmAcercaDeClinica.addActionListener(this);
		mntmAcercaDeClinica.setIcon(new ImageIcon(Principal.class.getResource("/img/question.png")));
		mnAyuda.add(mntmAcercaDeClinica);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/portada.jpg")));
		lblNewLabel.setBounds(0, 0, 850, 400);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmGenerarReportes) {
			MenuIt_GenerarReportes(arg0);
		}
		if (arg0.getSource() == mntmControlDePagos) {
			MenuIt_ControlDePagos(arg0);
		}
		if (arg0.getSource() == mntmAtencin) {
			MenuIt_Atencin(arg0);
		}
		if (arg0.getSource() == mntmInternar) {
			MenuIt_Internar(arg0);
		}
		if (arg0.getSource() == mntmMedicina) {
			MenuIt_Medicina(arg0);
		}
		if (arg0.getSource() == mntmPaciente) {
			MenuIt_Paciente(arg0);
		}
		if (arg0.getSource() == mntmCama) {
			MenuIt_Cama(arg0);
		}
		if (arg0.getSource() == mntmAcercaDeClinica) {
			MenuIt_AcercaDeClinica(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			MenuIt_Salir(arg0);
		}
	}
	public int salida() {
		return JOptionPane.showConfirmDialog(this,
			   "� Desea salir del programa ?", "                       Programa Cl�nica 1.0              ",  JOptionPane.OK_CANCEL_OPTION);
	}
	protected void MenuIt_Salir(ActionEvent arg0) {
		int out = salida();
		if (out == 0)
		System.exit(0);//cerrar software
	}
	protected void MenuIt_AcercaDeClinica(ActionEvent arg0) {
		Acerca_clinica ac = new Acerca_clinica();
		ac.setLocationRelativeTo(this);
		ac.setVisible(true);
		
	}
	protected void MenuIt_Cama(ActionEvent arg0) {
		CamaDLG cd = new CamaDLG();
		cd.setLocationRelativeTo(this);
		cd.setVisible(true);
	}
	protected void MenuIt_Paciente(ActionEvent arg0) {
		PacienteDLG pd = new PacienteDLG();
		pd.setLocationRelativeTo(this);
		pd.setVisible(true);
	}
	protected void MenuIt_Medicina(ActionEvent arg0) {
		MedicinaDLG md = new MedicinaDLG();
		md.setLocationRelativeTo(this);
		md.setVisible(true);
	}
	protected void MenuIt_Internar(ActionEvent arg0) {
		InternamientoDLG id = new InternamientoDLG();
		id.setLocationRelativeTo(this);
		id.setVisible(true);
	}
	protected void MenuIt_Atencin(ActionEvent arg0) {
		AtencionDLG ad = new AtencionDLG();
		ad.setLocationRelativeTo(this);
		ad.setVisible(true);
	}
	protected void MenuIt_ControlDePagos(ActionEvent arg0) {
	}
	protected void MenuIt_GenerarReportes(ActionEvent arg0) {
		
	}
}
