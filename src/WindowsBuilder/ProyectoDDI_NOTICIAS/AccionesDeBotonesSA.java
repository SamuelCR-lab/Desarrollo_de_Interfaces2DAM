package ProyectoDDI_NOTICIAS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccionesDeBotonesSA implements ActionListener{
	
	int OcultarOMostrar;
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
										
									}
							}else {
								if(a.Preferencias == 0) {
									nombreUsuario=a.nombre;
									Paneles.panelLogin.setVisible(false);
									Paneles.PanelEleccion.setVisible(true);
								}else {
									Paneles.panelLogin.setVisible(false);
									MostradorDeNoticias();
									//Usuario.escrituraUsuarios(a.nombre,1);
									Paneles.PanelNoticias.setVisible(true);
								}
							}
						}else {
							Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
						}
					}
					
					
				}else if (nombrePanel.equals("Preferencias")) {
					
					for (Usuario a : Usuario.listaUsuarios) {
						a.Preferencias = 1;
						Paneles.PanelEleccion.setVisible(false);
						if (nombrePanel.equals("Preferencias")) {
							Preferencias.guardarSeleccion();
							MostradorDeNoticias();
							//Usuario.escrituraUsuarios(a.nombre,1);
						}
						Paneles.PanelNoticias.setVisible(true);
					}
				}else if (nombrePanel.equals(e)){
					
				}
			}else {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
			}
		}else {
			if (nombrePanel.equals("Preferencias")) {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
				Paneles.PanelEleccion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
			}else if (nombrePanel.equals("")){
				
			}else {
				
			}
			
		}
	}
	private void MostradorDeNoticias() {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<Funciones.Noticias.size();i++) {
			if(Preferencias.PrefeTemp[i] == 1) {
				MostradorNoticias.guardados[i] = Funciones.Noticias.get(i);
				sb.append(i+1+":"+MostradorNoticias.guardados[i]+"\n");
			}
		}
		String MostradoNoticias = sb.toString();
		MostradorNoticias.textAreaNoticias.setText(MostradoNoticias);
	}
	

}
