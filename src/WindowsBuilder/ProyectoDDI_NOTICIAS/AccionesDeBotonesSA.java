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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (OcultarOMostrar == 1) {
			if (nombrePanel.equals("Login")) {
				for (Usuario a : Usuario.listaUsuarios) {
					if ((Login.textField.getText() == a.nombre)&&(Login.textField_1.getText() == a.contraseña)){
						if(a.Preferencias != 0) {
							nombreUsuario=a.nombre;
							Paneles.panelLogin.setVisible(false);
							Paneles.PanelEleccion.setVisible(true);
							a.Preferencias = 1;
							Funciones.escrituraUsuarios(a.nombre);
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
				Paneles.PanelEleccion.setVisible(false);
				Paneles.panelLogin.setVisible(true);
			}else {
				
			}
			
		}
	}

	

}
