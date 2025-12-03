package ProyectoDDI_NOTICIAS;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Paneles extends JLayeredPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel lblNewLabel;
	public Paneles () {
		setSize(800,600);
		//PanelLogin Login = new PanelLogin();
		//add(Login);
		lblNewLabel = new JLabel(""+Funciones.BuscadorTitulares());
		lblNewLabel.setBounds(35, 154, 199, 35);
		add(lblNewLabel);
		
		
	}
}
