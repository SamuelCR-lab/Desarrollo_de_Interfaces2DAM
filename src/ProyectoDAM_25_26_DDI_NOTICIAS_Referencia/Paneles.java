package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Paneles extends JLayeredPane{
	/**
	 * 
	 */
	/*public static Login panelLogin = new Login();
	public static Preferencias PanelEleccion = new Preferencias();
	public static MostradorNoticias PanelNoticias = new MostradorNoticias();
	public static admin PanelAdmin = new admin();
	public static CreacionUsuarios PanelcreacionUsuarios = new CreacionUsuarios();
	public static BorrarUsuarios BorradoUsuarios = new BorrarUsuarios();*/
	private static final long serialVersionUID = 1L;
	JFrame marco;
	JPanel PanelAdmin,PanelNoticias,panelLogin,PanelcreacionUsuarios,BorradoUsuarios;
	
	public Paneles(JFrame marco) {
		super();
		this.marco = marco;
	}
	
	public JPanel getPanelAdmin() {
		return PanelAdmin;
	}
	public void setPanelAdmin(JPanel panelAdmin) {
		PanelAdmin = panelAdmin;
	}
	public JPanel getPanelNoticias() {
		return PanelNoticias;
	}
	public void setPanelNoticias(JPanel panelNoticias) {
		PanelNoticias = panelNoticias;
	}
	public JPanel getPanelLogin() {
		return panelLogin;
	}
	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
	}
	public JPanel getPanelcreacionUsuarios() {
		return PanelcreacionUsuarios;
	}
	public void setPanelcreacionUsuarios(JPanel panelcreacionUsuarios) {
		PanelcreacionUsuarios = panelcreacionUsuarios;
	}
	public JPanel getBorradoUsuarios() {
		return BorradoUsuarios;
	}
	public void setBorradoUsuarios(JPanel borradoUsuarios) {
		BorradoUsuarios = borradoUsuarios;
	}
	
	public JFrame getMarco() {
		return marco;
	}
	public void setMarco(JFrame marco) {
		this.marco = marco;
	}


	public Paneles () {
		setSize(1200,800);
		Login panelLogin = new Login(marco);
		add(panelLogin);
		Preferencias PanelEleccion = new Preferencias(marco);
		add(PanelEleccion);
		PanelEleccion.setVisible(false);
		MostradorNoticias PanelNoticias = new MostradorNoticias(marco);
		add(PanelNoticias);
		PanelNoticias.setVisible(false);
		admin PanelAdmin = new admin(marco);
		add(PanelAdmin);
		PanelAdmin.setVisible(false);
		CreacionUsuarios PanelcreacionUsuarios = new CreacionUsuarios(marco);
		add(PanelcreacionUsuarios);
		PanelcreacionUsuarios.setVisible(false);
		BorrarUsuarios BorradoUsuarios = new BorrarUsuarios(marco);
		add(BorradoUsuarios);
		BorradoUsuarios.setVisible(false);
		
	}
}
