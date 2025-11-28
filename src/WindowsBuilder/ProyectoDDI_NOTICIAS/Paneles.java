package ProyectoDDI_NOTICIAS;

import javax.swing.JLayeredPane;

public class Paneles extends JLayeredPane{
	public Paneles () {
		setSize(800,600);
	
		PanelLogin Login = new PanelLogin();
		add(Login);
		
		
		
	}
}
