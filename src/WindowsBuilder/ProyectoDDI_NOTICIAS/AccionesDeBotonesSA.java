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
			if (nombrePanel.equals("Login")) {
				for (Usuario a : Usuario.listaUsuarios) {
					String guardarPass = "";
					char[] password = Login.passwordField.getPassword();
					for (int i =0;i<password.length;i++) {
						guardarPass += password[i];
					}
					if ((Login.textField.getText().equals(a.nombre))&&(guardarPass.equals(a.contraseña))){
						if(a.Preferencias == 0) {
							nombreUsuario=a.nombre;
							Paneles.panelLogin.setVisible(false);
							Paneles.PanelEleccion.setVisible(true);
							a.Preferencias = 1;
							Usuario.escrituraUsuarios(a.nombre,1);
						}else {
							
						}
					}else {
						Login.lblNewLabel_ErrorInicioSesion.setVisible(true);
					}
				}
				
				
			}else if (nombrePanel.equals("Preferencias")) {
				Paneles.PanelEleccion.setVisible(false);
				
			}else if (nombrePanel.equals(e)){
				
			}
		}else {
			if (nombrePanel.equals("Preferencias")) {
				Login.lblNewLabel_ErrorInicioSesion.setVisible(false);
				Paneles.PanelEleccion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
			}else if (nombrePanel.equals("Preferencias")){
				
			}else {
				
			}
			
		}
	}

	

}
