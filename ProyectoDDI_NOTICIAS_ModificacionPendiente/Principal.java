package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;






public class Principal {

	/**
	 * Launch the application.
	 */
	public static MarcoNoticias window = new MarcoNoticias();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
                    
                    
					new PantalladeCarga();
					window.setSize(1200,800);
					
					
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
