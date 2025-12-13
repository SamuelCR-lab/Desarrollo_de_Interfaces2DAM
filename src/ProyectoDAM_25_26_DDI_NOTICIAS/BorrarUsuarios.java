package ProyectoDAM_25_26_DDI_NOTICIAS;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BorrarUsuarios extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel lblNewLabel,lblNewLabel_1,ErrorCamposConEspacios,MensajeUsuarioBorrado,UsuarioNoEncontrado;
	private static JButton Atras,BorrarUsuario;
	public static JTextField textFieldNombreUsuario;
	
	public BorrarUsuarios() {
		setSize(1200,800);
		setName("Borrar Usuarios");
		setLayout(null);
		
		lblNewLabel = new JLabel("Borrar un usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(266, 166, 667, 55);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Introduce el nombre del usuario a borrar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(409, 301, 381, 46);
		add(lblNewLabel_1);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setVisible(false);
		textFieldNombreUsuario.setBounds(367, 384, 465, 46);
		add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		
		
		BorrarUsuario = new JButton("Crear Usuario");
		BorrarUsuario.addActionListener(new AccionesDeBotonesSA(1,"BorrarUsuario"));
		BorrarUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		BorrarUsuario.setBounds(911, 678, 200, 46);
		add(BorrarUsuario);
		
		
		Atras = new JButton("Atras");
		Atras.addActionListener(new AccionesDeBotonesSA(0,"BorrarUsuario"));
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
		
		UsuarioNoEncontrado = new JLabel("Error. Introduce el nombre de un usuario existente.");
		UsuarioNoEncontrado.setHorizontalAlignment(SwingConstants.CENTER);
		UsuarioNoEncontrado.setVisible(false);
		UsuarioNoEncontrado.setForeground(new Color(255, 0, 0));
		UsuarioNoEncontrado.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		UsuarioNoEncontrado.setBounds(393, 678, 414, 46);
		add(UsuarioNoEncontrado);
		
		MensajeUsuarioBorrado = new JLabel("Usuario eliminado correctamente");
		MensajeUsuarioBorrado.setVisible(false);
		MensajeUsuarioBorrado.setHorizontalAlignment(SwingConstants.CENTER);
		MensajeUsuarioBorrado.setBounds(396, 687, 408, 31);
		add(MensajeUsuarioBorrado);
	}
	public static boolean borrarUsuario() {
		boolean comprobacionUsuarioBorrado= true;
		Usuario usuarioAborrar = null;
			if ((Funciones.controlDeErrores(textFieldNombreUsuario.getText()))) {
				String nombreUsuario = textFieldNombreUsuario.getText() ; 	
				
				for (Usuario usuarioAeliminar : Usuario.listaUsuarios) {
					if(usuarioAeliminar.nombre.equals(nombreUsuario)) {
						usuarioAborrar = usuarioAeliminar;
					}
				}
				if (usuarioAborrar == null) {
					UsuarioNoEncontrado.setVisible(true);
					comprobacionUsuarioBorrado = false;
				}else {
					Usuario.listaUsuarios.remove(usuarioAborrar);
					MensajeUsuarioBorrado.setVisible(true);
				}
			}else {
				ErrorCamposConEspacios.setVisible(true);
			}
		return comprobacionUsuarioBorrado;
	}


}
