package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class admin extends JPanel{
	
	
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Usuario> listaUsuariosEnAdmin;
	public admin(String rolDeLosUsuarios,String NombreUsuario,ArrayList<Usuario> listaUsuarios,int id) {
		listaUsuariosEnAdmin= listaUsuarios; 
		setName("Administrador");
		setSize(1200,800);
		setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Crear un nuevo usuario");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaUsuarios.size() <= 11) {
					if(CreacionUsuarios.guardarNuevoUsuario()){
						CreacionUsuarios panelCreacionUsuarios = new CreacionUsuarios(rolDeLosUsuarios,NombreUsuario,listaUsuariosEnAdmin, id);
						MarcoNoticias.mostradorPaneles(panelCreacionUsuarios);
					}
				}else {
					JOptionPane.showMessageDialog(null, "No puedes crear un nuevo usuario porque has llegado al limite de 10 Usuarios.");
				}
			}
		});
		btnNewButton.setBounds(253, 328, 305, 70);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar usuario");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaUsuarios.size() >= 4) {
					BorrarUsuarios panelBorradoUsuarios = new BorrarUsuarios(rolDeLosUsuarios,NombreUsuario,listaUsuariosEnAdmin, id);
					MarcoNoticias.mostradorPaneles(panelBorradoUsuarios);
				}else {
					JOptionPane.showMessageDialog(null, "No puedes borrar un nuevo usuario porque has llegado al limite de 10 Usuarios.");
				}
			}
		});
		btnNewButton_1.setBounds(642, 330, 305, 70);
		add(btnNewButton_1);
		
		JButton btnEnviarCorreo = new JButton("Enviar Correo");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Usuario a : listaUsuariosEnAdmin) {
					if (a.nombre.equals(NombreUsuario)) {
						MostradorNoticias.ComprobacionDePreferencias(NombreUsuario,Usuario.lecturaUsuarios());
						Properties props = new Properties();
						props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP de GMAIL en este caso
						props.put("mail.smtp.socketFactory.port", "465"); //PUERTO SSL 
						props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
						props.put("mail.smtp.auth", "true"); //ACTIVAR SMTP AUTENTIFICACI�N
						props.put("mail.smtp.port", "465"); //SMTP Port		
						Authenticator auth = new Authenticator() {		
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(Funciones.correoSalida, Funciones.contraseniaSalida);
							}
						};		
						LocalTime horaGuardada = java.time.LocalTime.now();
						 DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");//Usamos el Date Time Fromatter para darle un formato mas legible, que de la forma de local time salen mili y nano segundos
			    		 String HoraDefnitiva = horaGuardada.format(formato);
						Session session = Session.getDefaultInstance(props, auth);//CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL "LOGIN"
					    sendEmail(session, a.email,"NOTICIAS DAM", "Las Noticias actuales de tu preferencias.\nA fecha :"+HoraDefnitiva+"\n"+MostradorNoticias.MostradoNoticias);
					}
				}
			}
		});
		btnEnviarCorreo.setBounds(253, 450, 305, 70);
		add(btnEnviarCorreo);
		
		JButton btnVerTodasLas = new JButton("Ver todas las noticias");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVerTodasLas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostradorNoticias noticiasPreferidas = new MostradorNoticias(rolDeLosUsuarios,NombreUsuario,"administrador",listaUsuariosEnAdmin,id);
				MostradorNoticias.ComprobacionDePreferencias(NombreUsuario,Usuario.lecturaUsuarios());
				MarcoNoticias.mostradorPaneles(noticiasPreferidas);
			}
		});
		btnVerTodasLas.setBounds(642, 450, 305, 70);
		add(btnVerTodasLas);
		
		JLabel lblNewLabel = new JLabel("Menú de Administrador");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(253, 29, 694, 221);
		add(lblNewLabel);
		
		JButton CerrarSesion = new JButton("Cerrar Sesion");
		CerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login volverInicio = new Login();
				MarcoNoticias.mostradorPaneles(volverInicio);
			}
		});
		CerrarSesion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		CerrarSesion.setBounds(75, 678, 192, 46);
		add(CerrarSesion);
	}
	
	private static void sendEmail(Session session, String toEmail, String subject, String body){
		try{
	      MimeMessage msg = new MimeMessage(session);
	      //Configurar Cabeceras
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("no_reply@example.com", "Correo Infromativo de tus Preferencias "));//Datos de ejemplo	      	      
	      msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));	      
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8");
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));	     
	      Transport.send(msg);
	      
	      //System.out.println("¡EMAIL ENVIADO!");//SI NO DA ERROR
	    }
	    catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error Enviando Email: " + e.getMessage());
	    }
	}
}
