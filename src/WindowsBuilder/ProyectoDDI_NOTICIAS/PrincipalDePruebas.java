package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class PrincipalDePruebas {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 434, 1);
		frame.getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 260);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(0, 0, 97, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 262);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 434, 260);
		layeredPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_4);
		panel_4.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(46, 71, 159, 104);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Preferencias del Usuario");
		lblNewLabel.setBounds(172, 11, 86, 26);
		frame.getContentPane().add(lblNewLabel);
	}
}
