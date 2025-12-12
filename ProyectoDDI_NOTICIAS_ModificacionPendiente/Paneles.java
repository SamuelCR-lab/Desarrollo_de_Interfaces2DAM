package ProyectoDDI_NOTICIAS;


import javax.swing.JLayeredPane;

public class Paneles extends JLayeredPane{
	/**
	 * 
	 */
	public static Login panelLogin = new Login();
	public static Preferencias PanelEleccion = new Preferencias();
	public static MostradorNoticias PanelNoticias = new MostradorNoticias();
	public static admin PanelAdmin = new admin();
	public static CreacionUsuarios PanelcreacionUsuarios = new CreacionUsuarios();
	private static final long serialVersionUID = 1L;

	public Paneles () {
		setSize(1200,800);
		add(panelLogin);
		
		add(PanelEleccion);
		PanelEleccion.setVisible(false);
		add(PanelNoticias);
		PanelNoticias.setVisible(false);
		
		add(PanelAdmin);
		PanelAdmin.setVisible(false);
		add(PanelcreacionUsuarios);
		PanelcreacionUsuarios.setVisible(false);
	}
}
