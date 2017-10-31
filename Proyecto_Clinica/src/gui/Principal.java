package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivos;
	private JMenu mnMantenimiento;
	private JMenu mnInternamiento;
	private JMenu mnAtencin;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCama;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmMedicina;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeClnica;
	private JLabel lblSegundaActualizacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 475);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivos = new JMenu("Archivos");
		mnArchivos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnArchivos.setIcon(new ImageIcon(Principal.class.getResource("/img/archivo.png")));
		menuBar.add(mnArchivos);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivos.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnMantenimiento.setIcon(new ImageIcon(Principal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmCama = new JMenuItem("Cama");
		mnMantenimiento.add(mntmCama);
		
		mntmPaciente = new JMenuItem("Paciente");
		mnMantenimiento.add(mntmPaciente);
		
		mntmMedicina = new JMenuItem("Medicina");
		mnMantenimiento.add(mntmMedicina);
		
		mnInternamiento = new JMenu("Internamiento");
		mnInternamiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnInternamiento.setIcon(new ImageIcon(Principal.class.getResource("/img/configuracion.png")));
		menuBar.add(mnInternamiento);
		
		mnAtencin = new JMenu("Atenci\u00F3n");
		mnAtencin.setIcon(new ImageIcon(Principal.class.getResource("/img/discount.png")));
		mnAtencin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAtencin);
		
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
		
		mntmAcercaDeClnica = new JMenuItem("Acerca de Cl\u00EDnica");
		mntmAcercaDeClnica.setIcon(new ImageIcon(Principal.class.getResource("/img/question.png")));
		mnAyuda.add(mntmAcercaDeClnica);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSegundaActualizacion = new JLabel("Ves esto menn?");
		lblSegundaActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSegundaActualizacion.setBounds(97, 193, 362, 21);
		contentPane.add(lblSegundaActualizacion);
	}
}
