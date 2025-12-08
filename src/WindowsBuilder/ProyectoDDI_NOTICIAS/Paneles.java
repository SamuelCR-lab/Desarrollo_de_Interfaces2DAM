package ProyectoDDI_NOTICIAS;


import javax.swing.JLayeredPane;

public class Paneles extends JLayeredPane{
	/**
	 * 
	 */
	public static Login panelLogin = new Login();
	public static Preferencias PanelEleccion = new Preferencias();
	public static MostradorNoticias PanelNoticias = new MostradorNoticias();
	private static final long serialVersionUID = 1L;

	public Paneles () {
		setSize(1200,800);
		add(panelLogin);
		
		add(PanelEleccion);
		PanelEleccion.setVisible(false);
		add(PanelNoticias);
		PanelNoticias.setVisible(false);
	}
}
