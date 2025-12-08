package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;
import javax.swing.SwingUtilities;





public class Principal {

	/**
	 * Launch the application.
	 */
	public static MarcoNoticias window = new MarcoNoticias();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					SwingUtilities.invokeLater(() -> {
			            new PantalladeCarga();
			            
			        });
					Usuario.lecturaUsuarios();
					Funciones.lecturaWebs();
					window.setSize(1200,800);
					
					
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
