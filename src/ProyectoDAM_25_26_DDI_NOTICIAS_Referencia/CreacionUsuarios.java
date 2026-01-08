package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class CreacionUsuarios extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_1_1,lblNewLabel_1_1_1,ErrorCamposConEspacios,ErrorLimiteUsuarios,MensajeUsuarioAñadido;
	private static JButton Atras,CrearUsuario;
	private static JTextField textFieldNombreUsuario,textFieldCorreoUsuario;
	private static JPasswordField passwordFieldCreacionUsuarios;
	private String rolDeLosUsuarios,nombreUsuario;
	private int id;

	
	
	public CreacionUsuarios(String rolDeLosUsuarios,String nombreUsuario,int id) {
		this.rolDeLosUsuarios = rolDeLosUsuarios;
		this.nombreUsuario = nombreUsuario;
		this.id = id;
		setName("Crear Usuarios");
		setSize(1200,800);
		setLayout(null);
		
		lblNewLabel = new JLabel("Crear un nuevo usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(255, 47, 672, 31);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Introduce el nombre del nuevo usuario");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(151, 192, 381, 46);
		add(lblNewLabel_1);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setBounds(648, 202, 381, 31);
		add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		lblNewLabel_1_1 = new JLabel("Introduce la contraseña del nuevo usuario");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(151, 280, 381, 46);
		add(lblNewLabel_1_1);
		
		passwordFieldCreacionUsuarios = new JPasswordField();
		passwordFieldCreacionUsuarios.setBounds(648, 290, 381, 31);
		add(passwordFieldCreacionUsuarios);
		
		//Guardamos(el punto) que es el caracter predeterminado para ocultar la contraseña en este passwordField
		char defaultChar = passwordFieldCreacionUsuarios.getEchoChar();
		//Creamos un botón de tipo Toggle, ya que he visto que es un boton que se queda presionado y le creamos un escuchador para el toggle
		JToggleButton btnMostrarOcultarContrasenia = new JToggleButton("Mostrar Contraseña");
		btnMostrarOcultarContrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnMostrarOcultarContrasenia.setBounds(885, 332, 144, 22);
		btnMostrarOcultarContrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMostrarOcultarContrasenia.isSelected()) {
					// Si está presionado, mostramos el texto (carácter nulo) que significa ningun caracter de ocultacion que el predeterminado es el punto 
					passwordFieldCreacionUsuarios.setEchoChar((char) 0);
					btnMostrarOcultarContrasenia.setText("Ocultar Contraseña");
				} else {
					// Si vuelve a pulsar, volvemos a poner el puntito original
					passwordFieldCreacionUsuarios.setEchoChar(defaultChar);
					btnMostrarOcultarContrasenia.setText("Mostrar Contraseña");
				}
			}
		});
		add(btnMostrarOcultarContrasenia);
		
		lblNewLabel_1_1_1 = new JLabel("Introduce el correo del nuevo usuario");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(151, 372, 381, 46);
		add(lblNewLabel_1_1_1);
		
		textFieldCorreoUsuario = new JTextField();
		textFieldCorreoUsuario.setColumns(10);
		textFieldCorreoUsuario.setBounds(648, 382, 381, 31);
		add(textFieldCorreoUsuario);
		
		CrearUsuario = new JButton("Crear Usuario");
		CrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CreacionUsuarios.guardarNuevoUsuario()){
					Usuario.escrituraUsuarios();
					Usuario.lecturaUsuarios();
				}
			}
		});
		CrearUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		CrearUsuario.setBounds(911, 678, 200, 46);
		add(CrearUsuario);
		
		
		Atras = new JButton("Atras");
		Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin panelAdmin = new admin(rolDeLosUsuarios,nombreUsuario,id);
				MarcoNoticias.mostradorPaneles(panelAdmin);
			}
		});
		Atras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Atras.setBounds(75, 678, 200, 46);
		add(Atras);
		ErrorCamposConEspacios = new JLabel("Error. Tienes que introducir bien los datos y rellenar todos los huecos.");
		ErrorCamposConEspacios.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorCamposConEspacios.setVisible(false);
		ErrorCamposConEspacios.setForeground(new Color(255, 0, 0));
		ErrorCamposConEspacios.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ErrorCamposConEspacios.setBounds(331, 678, 538, 46);
		add(ErrorCamposConEspacios);
		
		ErrorLimiteUsuarios = new JLabel("Error. Limite de usuarios alcansado.");
		ErrorLimiteUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorLimiteUsuarios.setVisible(false);
		ErrorLimiteUsuarios.setForeground(new Color(255, 0, 0));
		ErrorLimiteUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ErrorLimiteUsuarios.setBounds(387, 621, 421, 46);
		add(ErrorLimiteUsuarios);
		
		MensajeUsuarioAñadido = new JLabel("Usuario añadido correctamente");
		MensajeUsuarioAñadido.setVisible(false);
		MensajeUsuarioAñadido.setHorizontalAlignment(SwingConstants.CENTER);
		MensajeUsuarioAñadido.setBounds(387, 687, 408, 31);
		add(MensajeUsuarioAñadido);
	}
	public static boolean guardarNuevoUsuario() {
		boolean comprobacionNuevoUsuario= true;
		String rol = "usuario";
		
		char[] contrasenia = passwordFieldCreacionUsuarios.getPassword();
		if ((Funciones.controlDeErrores(textFieldNombreUsuario.getText()))&&
				((Funciones.controlCorreo(textFieldCorreoUsuario.getText())))&&
				(passwordFieldCreacionUsuarios.getPassword()!=null || contrasenia.length >0)) {
			String guardarContrasenia = "";
				for (int i =0;i<contrasenia.length;i++) {
					guardarContrasenia += contrasenia[i];
				}
			String nombreUsuario = textFieldNombreUsuario.getText() ; 	
			String correo = textFieldCorreoUsuario.getText();
			int idNuevosUsuarios = Usuario.listaUsuarios.size()+1;
			if (idNuevosUsuarios<=10) {
				Usuario NuevoUsuario = new Usuario(idNuevosUsuarios,nombreUsuario,guardarContrasenia,0,correo,rol);
				Usuario.listaUsuarios.add(NuevoUsuario);

			}else {
				ErrorLimiteUsuarios.setVisible(true);
				CrearUsuario.setVisible(false);
				comprobacionNuevoUsuario = false;
				return comprobacionNuevoUsuario;
			}
		}else {
			ErrorCamposConEspacios.setVisible(true);
			comprobacionNuevoUsuario = false;
			return comprobacionNuevoUsuario;
		}
		MensajeUsuarioAñadido.setVisible(true);
		return comprobacionNuevoUsuario;
	}
}
