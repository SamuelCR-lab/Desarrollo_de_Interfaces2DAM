package ProyectoDDI_NOTICIAS;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class Login extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField textField,textField_1;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	public static JLabel lblNewLabel_ErrorInicioSesion;
	public Login() {
		setName("Login");
		setSize(1200,800);
		setLayout(null);
		

		
		lblNewLabel = new JLabel("Bienvenido a SamuelNews");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(474, 71, 461, 57);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre de tu usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(301, 176, 310, 27);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(310, 232, 310, 27);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(681, 176, 391, 27);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(681, 234, 391, 27);
		add(textField_1);
		
		lblNewLabel_ErrorInicioSesion = new JLabel("Error. No has introducido bien el nombre de usurio o contraseña.");
		lblNewLabel_ErrorInicioSesion.setVisible(false);
		lblNewLabel_ErrorInicioSesion.setForeground(new Color(255, 0, 0));
		lblNewLabel_ErrorInicioSesion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_ErrorInicioSesion.setBounds(600, 410, 438, 72);
		add(lblNewLabel_ErrorInicioSesion);
		
		JButton btnNewButton_1_1 = new JButton("Siguiente");
		btnNewButton_1_1.addActionListener(new AccionesDeBotonesSA(1,"Login"));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(976, 662, 135, 46);
		add(btnNewButton_1_1);
		
    }
	
}
