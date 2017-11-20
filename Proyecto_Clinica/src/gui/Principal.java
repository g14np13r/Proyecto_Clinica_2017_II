package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);Quitamos la acción de cerrar(x)*/
		this.setResizable(false);//Para mantenga del mismo tamaño()
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
		mnMantenimiento.setIcon(new ImageIcon(Principal.class.getResource("/img/mantenimiento.png")));
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
		mnInternamiento.setIcon(new ImageIcon(Principal.class.getResource("/img/configuracion.png")));
		menuBar.add(mnInternamiento);
		
		mnAtencion = new JMenu("Atenci\u00F3n");
		mnAtencion.setIcon(new ImageIcon(Principal.class.getResource("/img/discount.png")));
		mnAtencion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAtencion);
		
		mnPago = new JMenu("Pago");
		mnPago.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnPago.setIcon(new ImageIcon(Principal.class.getResource("/img/vend.png")));
		menuBar.add(mnPago);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnReporte.setIcon(new ImageIcon(Principal.class.getResource("/img/report.png")));
		menuBar.add(mnReporte);
		
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
			   "¿ Desea salir del programa ?", "                       Programa Clínica 1.0              ",  JOptionPane.OK_CANCEL_OPTION);
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
		CamaDLG cf = new CamaDLG();
		cf.setLocationRelativeTo(this);
		cf.setVisible(true);
	}
	protected void MenuIt_Paciente(ActionEvent arg0) {
		PacienteDLG pf = new PacienteDLG();
		pf.setLocationRelativeTo(this);
		pf.setVisible(true);
	}
	protected void MenuIt_Medicina(ActionEvent arg0) {
		MedicinaDLG mf = new MedicinaDLG();
		mf.setLocationRelativeTo(this);
		mf.setVisible(true);
	}
}
