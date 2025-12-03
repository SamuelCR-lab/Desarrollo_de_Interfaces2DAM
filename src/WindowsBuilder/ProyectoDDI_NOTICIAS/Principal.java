package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;




public class Principal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*PantalladeCarga pantallaCarga = new PantalladeCarga();
					pantallaCarga.setSize(1200,800);
					pantallaCarga.setVisible(true);*/
					MarcoNoticias window = new MarcoNoticias();
					window.setSize(1200,800);
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
