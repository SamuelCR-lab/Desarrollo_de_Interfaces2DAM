package ProyectoDDI_NOTICIAS;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class AccionesDeBotonesSA implements ActionListener{
	public static String correoSalida = "";
    public static String contraseniaSalida = "";
    private String MostradoNoticias;
	static int controldeUsuariosConPreferencias=0;
	int OcultarOMostrar,IDUsuarioNuevasPreferencias;
	String NombreAccion;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (getOcultarOMostrar() == 1) {
			if ((Funciones.controlDeErrores(Login.textField.getText()))){
				if (NombreAccion.equals("Login")) {
					for (Usuario a : Usuario.listaUsuarios) {
						String guardarPass = "";
						char[] password = Login.passwordField.getPassword();
							for (int i =0;i<password.length;i++) {
								guardarPass += password[i];
							}
						if ((Login.textField.getText().equals(a.nombre))&&(guardarPass.equals(a.contraseña))){
							nombreUsuario=a.nombre;
							if(a.rol.equals("admin")) {
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
					}//Cierra bucle de el login 
					
				}else if (NombreAccion.equals("Preferencias")) {
					for (Usuario a : Usuario.listaUsuarios) {
						int preferenciasSeleccionadas = Preferencias.guardarSeleccion(a.id);
						if (preferenciasSeleccionadas == 1){
							if(a.nombre.equals(nombreUsuario)) {
								controldeUsuariosConPreferencias=1;
								a.Preferencias+=controldeUsuariosConPreferencias;
								ComprobacionDePreferencias();
								Paneles.PanelEleccion.setVisible(false);
								Usuario.escrituraUsuarios(a.nombre,0);
								MostradorDeNoticias();
								Paneles.PanelNoticias.setVisible(true);
							}
						}else {
							Preferencias.ErrorEleccionPreferencias.setVisible(true);
						}
					}
				}else if (NombreAccion.equals("GuardarTitulares")){
					
				}else if(NombreAccion.equals("MostradorNoticias")) {
						Paneles.PanelAdmin.setVisible(false);
						ComprobacionDePreferencias();
						MostradorNoticias.Siguiente.setVisible(true);
						Paneles.PanelNoticias.setVisible(true);
				}else if(NombreAccion.equals("EnviarCorreo")){
					lecturaCorreoClave();
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
									return new PasswordAuthentication(correoSalida, contraseniaSalida);
								}
							};		
							Session session = Session.getDefaultInstance(props, auth);//CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL "LOGIN"
						    sendEmail(session, a.email,"Noticias De UltimaHora", MostradoNoticias);
						}
					}
						
					}
				/*else if (NombreAccion.equals("CreacionUsuarios")) {
					Usuario.escrituraUsuarios(a.nombre,1);
				}*/
			}else {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
			}
		}else {
			if (NombreAccion.equals("Preferencias")) {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
				Paneles.PanelEleccion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
			}else if (NombreAccion.equals("MostradorNoticias")){
				System.out.println(controldeUsuariosConPreferencias);
				if(controldeUsuariosConPreferencias==1) {
					for (Usuario a : Usuario.listaUsuarios) {
						if(a.nombre.equals(nombreUsuario)) {
							a.Preferencias-=1;
							Paneles.PanelNoticias.setVisible(false);
							Preferencias.guardarSeleccion(a.id);
							Usuario.escrituraUsuarios(a.nombre,0);
							MostradorDeNoticias();
							
							Paneles.PanelEleccion.setVisible(true);
							controldeUsuariosConPreferencias=0;
						}
					}
				}else {
					Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
					Paneles.PanelNoticias.setVisible(false);
					Paneles.panelLogin.setVisible(true);
				}
			}else {
				
			}
			
		}
	}
	private void MostradorDeNoticias() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<Funciones.Noticias.size();i++) {
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
	      System.out.println("MENSAJE CREADO");  	  
	      Transport.send(msg);
	      System.out.println("¡EMAIL ENVIADO!");//SI NO DA ERROR
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
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
	public static void lecturaCorreoClave() {
		File ficheroConfiguracion = new File("Usuarios//Configuracion.txt");
    	try (FileReader archivoConfiguracion = new FileReader(ficheroConfiguracion);
	            BufferedReader lectorArchivo = new BufferedReader(archivoConfiguracion)) {
	            String cadena;
	            	while ((cadena = lectorArchivo.readLine()) != null){
	            		cadena = cadena.trim();
	            		//Lee las lineas vacias y no pasa nada no guarda ni incrementa nada es solo vacio hasta que sea null el readline del while
		                if (!cadena.isEmpty()){
		                	//Aqui al ser una cadena sencilla lo hago con el StartWith para que compare entre cadenas y si exite pues cogemos la cadena que existe despues del StartWith con el substring 
			                if (cadena.startsWith("EMAIL DE SALIDA:")) {
			                	correoSalida = cadena.substring("EMAIL DE SALIDA:".length()).trim();
			                }else if (cadena.startsWith("CONTRASENIA EMAIL DE SALIDA:")) {
			                    contraseniaSalida = cadena.substring("CONTRASENIA EMAIL DE SALIDA:".length()).trim();
			                }
		                }
	            	}
System.out.println(correoSalida+", contraseña: "+contraseniaSalida);
	          
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
