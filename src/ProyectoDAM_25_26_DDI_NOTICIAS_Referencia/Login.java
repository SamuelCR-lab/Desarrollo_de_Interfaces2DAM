package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;




public class Login extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField textField;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	public static JLabel lblNewLabel_ErrorInicioSesion;
	public static JPasswordField passwordField;


	public Login() {
		setName("Login");
		setSize(1200,800);
		setLayout(null);
		
		lblNewLabel = new JLabel("Bienvenido a SamuelNews");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(359, 147, 461, 57);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre de tu usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(151, 280, 310, 27);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(151, 354, 310, 27);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(521, 282, 421, 27);
		add(textField);
		textField.setColumns(10);
		
		
		//Mensaje de error si la contraseña o el nombre no coinciden
		lblNewLabel_ErrorInicioSesion = new JLabel("Error. No has introducido bien el nombre de usurio o contraseña.");
		lblNewLabel_ErrorInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_ErrorInicioSesion.setVisible(false);
		lblNewLabel_ErrorInicioSesion.setForeground(new Color(255, 0, 0));
		lblNewLabel_ErrorInicioSesion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_ErrorInicioSesion.setBounds(521, 390, 421, 46);
		add(lblNewLabel_ErrorInicioSesion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(521, 352, 421, 27);
		add(passwordField);		
		
		//Guardamos(el punto) que es el caracter predeterminado para ocultar la contraseña en este passwordField
		char defaultChar = passwordField.getEchoChar();
		//Creamos un botón de tipo Toggle, ya que he visto que es un boton que se queda presionado y le creamos un escuchador para el toggle
		JToggleButton btnMostrarOcultarContrasenia = new JToggleButton("Mostrar Contraseña");
		btnMostrarOcultarContrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnMostrarOcultarContrasenia.setBounds(964, 352, 146, 27);
		btnMostrarOcultarContrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMostrarOcultarContrasenia.isSelected()) {
					// Si está presionado, mostramos el texto (carácter nulo) que significa ningun caracter de ocultacion que el predeterminado es el punto 
					passwordField.setEchoChar((char) 0);
					btnMostrarOcultarContrasenia.setText("Ocultar Contraseña");
				} else {
					// Si vuelve a pulsar, volvemos a poner el puntito original
					passwordField.setEchoChar(defaultChar);
					btnMostrarOcultarContrasenia.setText("Mostrar Contraseña");
				}
			}
		});
		add(btnMostrarOcultarContrasenia);
		JButton btnNewButton_1_1 = new JButton("Iniciar Sesion");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Usuario> listadeUsuarios = new ArrayList<>();
				listadeUsuarios = Usuario.lecturaUsuarios();
				if(listadeUsuarios!=null) {
					listadeUsuarios = Usuario.listaUsuarios;
					if ((listadeUsuarios != null)||(Funciones.controlDeErrores(textField.getText()))){
						for (Usuario a : listadeUsuarios) {
							String guardarPass = "";
							char[] password = Login.passwordField.getPassword();
								for (int i =0;i<password.length;i++) {
									guardarPass += password[i];
								}
								
							if ((textField.getText().equals(a.nombre))&&(guardarPass.equals(a.contraseña))){
								//Guardamos estos dos valores de forma estatica porque seran importantes para identificar bien a los usuarios
								String nombreUsuario = a.nombre;
								String rol = a.rol;
								int id = a.id;
								if(rol.equals("administrador")) {
										admin panelAdmin = new admin(rol,nombreUsuario,id);
										MostradorNoticias.ComprobacionDePreferencias(nombreUsuario);
										MarcoNoticias.mostradorPaneles(panelAdmin);
										
								}else {
									if(a.Preferencias == 0) {
										Preferencias eleccionPreferencias = new Preferencias(rol,nombreUsuario,id);
										MarcoNoticias.mostradorPaneles(eleccionPreferencias);
									}else {
										MostradorNoticias noticiasPreferidas = new MostradorNoticias(rol,nombreUsuario,id);
										MostradorNoticias.ComprobacionDePreferencias(nombreUsuario);
										MarcoNoticias.mostradorPaneles(noticiasPreferidas);
									}
								}
							}else {
								Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
							}
						}
					}else {
						Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
					}
				}
			}
		});
		
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(807, 457, 135, 46);
		add(btnNewButton_1_1);
		
    }
	
}
