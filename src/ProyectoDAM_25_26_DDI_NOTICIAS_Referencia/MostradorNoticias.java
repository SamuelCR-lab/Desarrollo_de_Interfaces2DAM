package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class MostradorNoticias extends JPanel {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	public static String[] guardados = new String[18];
	public static JScrollPane scrollPane = new JScrollPane();
	private static JTextArea textAreaNoticias = new JTextArea ();
	public static JButton EnviarCorreo,GuardarHistorial;
	public static String MostradoNoticias;
	private static ArrayList<Usuario> listaUsuariosComprobacion;

	public MostradorNoticias (String rolDeLosUsuarios,String nombreUsuario,String claseDeProcedencia,ArrayList<Usuario> listaUsuarios,int id) {
		listaUsuariosComprobacion = listaUsuarios;
		setSize(1200,800);
		setLayout(null);
		
		textAreaNoticias = new JTextArea();
		textAreaNoticias.setBounds(75, 128, 1033, 450);
		textAreaNoticias.setEditable(false);
		textAreaNoticias.setLineWrap(true);
		textAreaNoticias.setWrapStyleWord(true);
		
		
		scrollPane.setBounds(75, 128, 1033, 450);
		scrollPane.setViewportView(textAreaNoticias); 
		add(scrollPane);

		lblNewLabel = new JLabel("Aqui tienes tus noticias del momento basadas en tu preferencias.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(256, 33, 672, 31);
		add(lblNewLabel);
		
		JButton Atras = new JButton("Atras");
		Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (claseDeProcedencia.equals("Login")) {
					Login vueltaAlInicio = new Login();
					MarcoNoticias.mostradorPaneles(vueltaAlInicio);
				}else if (claseDeProcedencia.equals("Administrador")) {
					admin vueltaAMenuAdmin = new admin(rolDeLosUsuarios,nombreUsuario,listaUsuariosComprobacion,id);
					MarcoNoticias.mostradorPaneles(vueltaAMenuAdmin);
				}else {
					Preferencias vueltaAPreferencias = new Preferencias(rolDeLosUsuarios,nombreUsuario,listaUsuariosComprobacion,id);
					MarcoNoticias.mostradorPaneles(vueltaAPreferencias);
				}
				
				}
			});
		Atras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Atras.setBounds(75, 678, 241, 46);
		add(Atras);
		if (rolDeLosUsuarios.equals("administrador")) {
			EnviarCorreo = new JButton("Enviar Correo");
			EnviarCorreo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Usuario a : listaUsuariosComprobacion) {
						if (a.nombre.equals(nombreUsuario)) {
							ComprobacionDePreferencias(nombreUsuario);
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
						    admin.sendEmail(session, a.email,"NOTICIAS DAM", "Las Noticias actuales de tu preferencias.\nA fecha :"+HoraDefnitiva+"\n"+MostradoNoticias);
						}
					}
				}
			});
			EnviarCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			EnviarCorreo.setBounds(870, 678, 241, 46);
			add(EnviarCorreo);
			
		}else {
			GuardarHistorial = new JButton("Guardar Preferencias y Titulares");
			GuardarHistorial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			GuardarHistorial.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GuardarHistorial.setBounds(870, 678, 241, 46);
			add(GuardarHistorial);
		}
		
		lblNewLabel_1 = new JLabel("Tus noticias se han guardado correctamente");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(422, 678, 355, 46);
		add(lblNewLabel_1);
		lblNewLabel_2 = new JLabel("Tus noticias se enviaron correctamente");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(422, 678, 355, 46);
		add(lblNewLabel_2);
		}
	
	
	public static void ComprobacionDePreferencias(String nombreUsuario) {
		for (Usuario a : listaUsuariosComprobacion) {
				if(a.nombre.equals(nombreUsuario)) {
					for (preferenciasIniciador prefe : preferenciasIniciador.listaPreferencias) {
						int idListaUsuarios = a.id;
						int idListaPreferencias = prefe.Id;
						if (idListaUsuarios==idListaPreferencias) {
							Preferencias.PrefeTemp[0] = prefe.Marca;
							Preferencias.PrefeTemp[1] = prefe.AS;
							Preferencias.PrefeTemp[2] = prefe.OKdiario;
							Preferencias.PrefeTemp[3] = prefe.eleconomista;
							Preferencias.PrefeTemp[4] = prefe.elespanolECO;
							Preferencias.PrefeTemp[5] = prefe.elespanolECO;
							Preferencias.PrefeTemp[6] = prefe.elespanolN;
							Preferencias.PrefeTemp[7] = prefe.elmundoN;
							Preferencias.PrefeTemp[8] = prefe.okdiarioN;
							Preferencias.PrefeTemp[9] = prefe.elespanolI;
							Preferencias.PrefeTemp[10] = prefe.elmundoI;
							Preferencias.PrefeTemp[11] = prefe.okdiarioI;
							Preferencias.PrefeTemp[12] = prefe.xataka;
							Preferencias.PrefeTemp[13] = prefe.applesfera;
							Preferencias.PrefeTemp[14] = prefe.mundoxiaomi;
							Preferencias.PrefeTemp[15] = prefe.vandal;
							Preferencias.PrefeTemp[16] = prefe.directoalpaladar;
							Preferencias.PrefeTemp[17] = prefe.sensacine;
						}
						MostradorDeNoticias();
					}
				}
		}
	}
	private static void MostradorDeNoticias() {
		StringBuilder sb = new StringBuilder();
		int limiteSeguro = Math.min(Funciones.Noticias.size(), Preferencias.PrefeTemp.length);
		for (int i = 0; i<limiteSeguro;i++) {
			if (i<=2) {
				if (i==0)sb.append("1. Deportes:\n");
				if(Preferencias.PrefeTemp[i] == 1) {
					MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
					sb.append("\t"+MostradorNoticias.guardados[i]+"\n");
				}
			}else if (i<=5) {
				if (i==3)sb.append("\n2. Economia:\n");
				if(Preferencias.PrefeTemp[i] == 1) {
					MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
					sb.append("\t"+MostradorNoticias.guardados[i]+"\n");
				}
			}else if (i<=8) {
				if (i==6)sb.append("\n3. Noticias Nacionales:\n");
				if(Preferencias.PrefeTemp[i] == 1) {
					MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
					sb.append("\t"+MostradorNoticias.guardados[i]+"\n");
				}
			}else if (i<=11) {
				if (i==9)sb.append("\n4. Noticias Internacionales:\n");
				if(Preferencias.PrefeTemp[i] == 1) {
					MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
					sb.append("\t"+MostradorNoticias.guardados[i]+"\n");
				}
			}else if (i<=14) {
				if (i==12)sb.append("\n5. Tecnologia:\n");
				if(Preferencias.PrefeTemp[i] == 1) {
					MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
					sb.append("\t"+MostradorNoticias.guardados[i]+"\n");
				}
			}else {
				if (i==15)sb.append("\n6. Variedad:\n");
				if(Preferencias.PrefeTemp[i] == 1) {
					MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
					sb.append("\t"+MostradorNoticias.guardados[i]+"\n");
				}
			}
		}
		MostradoNoticias = sb.toString();
		textAreaNoticias.setText(MostradoNoticias);
	}
	
}
