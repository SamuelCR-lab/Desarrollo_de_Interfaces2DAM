package ProyectoDDI_NOTICIAS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class AccionesDeBotonesSA implements ActionListener{
	
	int OcultarOMostrar,IDUsuarioNuevasPreferencias;
	String nombrePanel;
	public static String nombreUsuario;
	public AccionesDeBotonesSA(int ocultarOMostrar, String nombrePanel) {
		super();
		this.OcultarOMostrar = ocultarOMostrar;
		this.nombrePanel = nombrePanel;

	}

	public int getOcultarOMostrar() {
		return OcultarOMostrar;
	}

	public void setOcultarOMostrar(int ocultarOMostrar) {
		OcultarOMostrar = ocultarOMostrar;
	}

	public String getNombrePanel() {
		return nombrePanel;
	}

	public void setNombrePanel(String nombrePanel) {
		this.nombrePanel = nombrePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (getOcultarOMostrar() == 1) {
			if ((Funciones.controlDeErrores(Login.textField.getText()))){
				if (nombrePanel.equals("Login")) {
					for (Usuario a : Usuario.listaUsuarios) {
						String guardarPass = "";
						char[] password = Login.passwordField.getPassword();
							for (int i =0;i<password.length;i++) {
								guardarPass += password[i];
							}
						if ((Login.textField.getText().equals(a.nombre))&&(guardarPass.equals(a.contraseña))){
							if(a.rol.equals("admin")) {
								nombreUsuario=a.nombre;
								Paneles.panelLogin.setVisible(false);
								Paneles.PanelAdmin.setVisible(true);
									if(nombrePanel.equals("MostradorNoticias")) {
										Paneles.PanelAdmin.setVisible(false);
										ComprobacionDePreferencias();
										Paneles.PanelNoticias.setVisible(true);
									}else if(nombrePanel.equals("EnviarNoticias")){
										
									}else if (nombrePanel.equals("CreacionUsuarios")) {
										Usuario.escrituraUsuarios(a.nombre,1);
									}
									
							}else {
								if(a.Preferencias == 0) {
									nombreUsuario=a.nombre;
									Paneles.panelLogin.setVisible(false);
									Paneles.PanelEleccion.setVisible(true);
								}else {
									nombreUsuario=a.nombre;
									Paneles.panelLogin.setVisible(false);
									ComprobacionDePreferencias();
									Paneles.PanelNoticias.setVisible(true);
								}
							}
						}else {
							Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
						}
					}//Cierra bucle de el login 
					
				}else if (nombrePanel.equals("Preferencias")) {
					for (Usuario a : Usuario.listaUsuarios) {
						if(nombreUsuario.equals(a.nombre)) {
							a.Preferencias =1;
							ComprobacionDePreferencias();
							Paneles.PanelEleccion.setVisible(false);
							Preferencias.guardarSeleccion(a.id);
							System.out.println(a.nombre);
							Usuario.escrituraUsuarios(a.nombre,0);
							MostradorDeNoticias();
							Paneles.PanelNoticias.setVisible(true);
						}
					}
				}else if (nombrePanel.equals("MostradorNoticias")){
					
				}
			}else {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
			}
		}else {
			if (nombrePanel.equals("Preferencias")) {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
				Paneles.PanelEleccion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
			}else if (nombrePanel.equals("MostradorNoticias")){
				
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
		String MostradoNoticias = sb.toString();
		MostradorNoticias.textAreaNoticias.setText(MostradoNoticias);
	}
	private void sendEmail(Session session, String toEmail, String subject, String body){
		try{
	      MimeMessage msg = new MimeMessage(session);
	      //Configurar Cabeceras
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("no_reply@example.com", "NO BIZUM NO RESPONDER"));//Datos de ejemplo	      	      
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
			for (preferenciasIniciador prefe : Usuario.listaPreferencias) {
				//Usuario.escrituraUsuarios(a.nombre,1);
					if (a.id == prefe.Id) {
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
