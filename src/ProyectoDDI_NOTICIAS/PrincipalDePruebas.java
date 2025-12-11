package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class PrincipalDePruebas {

	private static final Action cambio = null;
	private JFrame frame;
	private JLabel lblNewLabel = new JLabel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalDePruebas window = new PrincipalDePruebas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalDePruebas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1184, 761);
		frame.getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1183, 761);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(71, 119, 1033, 525);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setText("pRUEBA");
		panel.add(textArea);
		
		lblNewLabel = new JLabel("Bienvenido "+AccionesDeBotonesSA.nombreUsuario+" por primera vez. \n Elige tus medios de comunicacion preferidos.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(256, 33, 672, 31);
		panel.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		
		chckbxNewCheckBox.setAction(cambio );
		chckbxNewCheckBox.setBounds(102, 23, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panel_1);
		JButton CerrarSesion = new JButton("Cerrar Sesion");
		CerrarSesion.addActionListener(new AccionesDeBotonesSA(0,"Preferencias"));
		CerrarSesion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		CerrarSesion.setBounds(58, 678, 135, 46);
		panel.add(CerrarSesion);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1183, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
	}
	public static void cambio() {
		System.out.println("Cambio");
	}
}
