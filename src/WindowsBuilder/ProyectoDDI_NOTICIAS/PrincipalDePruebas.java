package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import ProyectoDDI_NOTICIAS.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class PrincipalDePruebas {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

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
		
	
		
		JLabel lblNewLabel = new JLabel("Bienvenido a SamuelNews");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(359, 147, 461, 57);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de tu usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(181, 280, 310, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(181, 350, 310, 27);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(571, 282, 421, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("Siguiente");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Usuario a : Usuario.listaUsuarios) {
					if (textField.getText() == a.nombre){
						
					}
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(715, 451, 135, 46);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Error. No has introducido bien el nombre de usurio o contraseña.");
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(571, 394, 421, 46);
		panel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(571, 352, 421, 27);
		panel.add(passwordField);
		
	}
}
