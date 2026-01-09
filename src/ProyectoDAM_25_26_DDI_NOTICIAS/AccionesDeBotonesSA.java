package ProyectoDAM_25_26_DDI_NOTICIAS;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;



public class AccionesDeBotonesSA implements ActionListener{
    public static String MostradoNoticias;
	static int controldeUsuariosConPreferencias=0,id;
	int OcultarOMostrar,IDUsuarioNuevasPreferencias;
	String NombreAccion;
	private static String rol;
	public static String nombreUsuario;
	public AccionesDeBotonesSA(int ocultarOMostrar, String nombrePanel) {
		super();
		this.OcultarOMostrar = ocultarOMostrar;
		this.NombreAccion = nombrePanel;

	}

	public int getOcultarOMostrar() {
		return OcultarOMostrar;
	}

	public void setOcultarOMostrar(int ocultarOMostrar) {
		OcultarOMostrar = ocultarOMostrar;
	}

	public String getNombrePanel() {
		return NombreAccion;
	}

	public void setNombrePanel(String nombrePanel) {
		this.NombreAccion = nombrePanel;
	}
	//Creamos el ecuchar de eventos Comun para todos los botones, por eso tenemos en el su constructor nombre de panel de donde viene y un 1 o un 0 para saber si quiere ir para atras o adelante el usuario.
	@Override
	public void actionPerformed(ActionEvent e) {
		//Comprobamos si el boton es para delante/realizar una accion que no sea volver (1) o si es para atras (0) 
		if (getOcultarOMostrar() == 1) {
			//Tenemos dentro un Switch Case que dependiendo del nombre que le da el boton al crear el evento, que realiza distintas funcionalidades
				switch(NombreAccion) {
				case "Login":
					if ((Funciones.controlDeErrores(Login.textField.getText()))){
						for (Usuario a : Usuario.listaUsuarios) {
							String guardarPass = "";
							char[] password = Login.passwordField.getPassword();
								for (int i =0;i<password.length;i++) {
									guardarPass += password[i];
								}
							if ((Login.textField.getText().equals(a.nombre))&&(guardarPass.equals(a.contraseña))){
								//Guardamos estos dos valores de forma estatica porque seran importantes para identificar bien a los usuarios
								nombreUsuario=a.nombre;
								rol= a.rol;
								id=a.id;
								if(a.rol.equals("administrador")) {
									Paneles.panelLogin.setVisible(false);
									Paneles.PanelAdmin.setVisible(true);
										
								}else {
									if(a.Preferencias == 0) {
										Paneles.panelLogin.setVisible(false);
										Paneles.PanelEleccion.setVisible(true);
									}else {
										Paneles.panelLogin.setVisible(false);
										ComprobacionDePreferencias();
										Paneles.PanelNoticias.setVisible(true);
									}
								}
							}else {
								Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
							}
						}
					}else {
						Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
					}
					break;
				case "Preferencias":
					for (Usuario a : Usuario.listaUsuarios) {
						int preferenciasSeleccionadas = Preferencias.guardarSeleccion(a.id);
						if (preferenciasSeleccionadas == 1){
							if(a.nombre.equals(nombreUsuario)) {
								controldeUsuariosConPreferencias=1;//Guardamos el aumento de las preferencias
								a.Preferencias+=controldeUsuariosConPreferencias;
								ComprobacionDePreferencias();
								Funciones.GuardarTitulares();
								Paneles.PanelEleccion.setVisible(false);
								Usuario.escrituraUsuarios();
								preferenciasIniciador.escrituraPreferencias(id);
								MostradorDeNoticias();
								Paneles.PanelNoticias.setVisible(true);
							}
						}else {
							Preferencias.ErrorEleccionPreferencias.setVisible(true);
						}
					}
					break;
				case "MostradorNoticias":
					Paneles.PanelAdmin.setVisible(false);
					ComprobacionDePreferencias();
					Funciones.GuardarTitulares();
					MostradorNoticias.GuardarHistorial.setVisible(false);
					MostradorNoticias.EnviarCorreo.setVisible(true);
					Paneles.PanelNoticias.setVisible(true);
					break;
				case "GuardarTitulares":
					preferenciasIniciador.escrituraPreferencias(id);
					controldeUsuariosConPreferencias=0;
					Funciones.Historial();
					MostradorNoticias.lblNewLabel_1.setVisible(true);
					break;
				case "EnviarCorreo":
					for (Usuario a : Usuario.listaUsuarios) {
						if (a.nombre.equals(nombreUsuario)) {
							ComprobacionDePreferencias();
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
						    sendEmail(session, a.email,"NOTICIAS DAM", "Las Noticias actuales de tu preferencias.\nA fecha :"+HoraDefnitiva+"\n"+MostradoNoticias);
						}
					}
					
					break;
				case "CreardorUsuario":
					Paneles.PanelAdmin.setVisible(false);
					Paneles.PanelcreacionUsuarios.setVisible(true);
					break;
				case "BorrardorUsuario":
					BorrarUsuarios.textFieldNombreUsuario.setVisible(true);
					Paneles.PanelAdmin.setVisible(false);
					Paneles.BorradoUsuarios.setVisible(true);
					break;
				case "BorrarUsuario":
					if(BorrarUsuarios.borrarUsuario()){
						Usuario.escrituraUsuarios();
						Usuario.lecturaUsuarios();
						
					}
					break;
				case "CrearUsuario":
					if(CreacionUsuarios.guardarNuevoUsuario()){
						Usuario.escrituraUsuarios();
						Usuario.lecturaUsuarios();
					}

					break;
				}
		}else {
			switch(NombreAccion) {
			case "Preferencias":
				Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
				Paneles.PanelEleccion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
				break;
			case "MostradorNoticias":
				if(controldeUsuariosConPreferencias==1) {
					for (Usuario a : Usuario.listaUsuarios) {
						if(a.nombre.equals(nombreUsuario)) {
							a.Preferencias-=1;
							Paneles.PanelNoticias.setVisible(false);
							Preferencias.guardarSeleccion(a.id);
							Usuario.escrituraUsuarios();
							MostradorDeNoticias();
							
							Paneles.PanelEleccion.setVisible(true);
							controldeUsuariosConPreferencias=0;
						}
					}
				}else {
					if (rol.equals("administrador")) {
						Paneles.PanelNoticias.setVisible(false);
						Paneles.PanelAdmin.setVisible(true);
					}else{
						Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
						Paneles.PanelNoticias.setVisible(false);
						Paneles.panelLogin.setVisible(true);
					}
					
				}
				break;
			case "CrearUsuario":
				
				Paneles.PanelcreacionUsuarios.setVisible(false);
				Paneles.PanelAdmin.setVisible(true);
				break;
			case "BorrarUsuario":
				BorrarUsuarios.textFieldNombreUsuario.setVisible(false);
				Paneles.PanelcreacionUsuarios.setVisible(false);
				Paneles.PanelAdmin.setVisible(true);
				break;
			case "Administrador":
				Paneles.PanelAdmin.setVisible(false);
				Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
				break;
			}
		}
	}
	private void MostradorDeNoticias() {
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
		MostradorNoticias.textAreaNoticias.setText(MostradoNoticias);
	}
	private void sendEmail(Session session, String toEmail, String subject, String body){
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
		MostradorNoticias.lblNewLabel_2.setVisible(true);
	}
	private void ComprobacionDePreferencias() {
		for (Usuario a : Usuario.listaUsuarios) {
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
	
}
