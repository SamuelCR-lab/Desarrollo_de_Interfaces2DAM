package ProyectoDDI_NOTICIAS;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;




public class Principal {

	/**
	 * Launch the application.
	 */
	public static MarcoNoticias window = new MarcoNoticias();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					/*PantalladeCarga pantallaCarga = new PantalladeCarga();
					pantallaCarga.setSize(1200,800);
					pantallaCarga.setVisible(true);*/
					SwingUtilities.invokeLater(() -> {
			            new PantalladeCarga();
			            
			        });
					Funciones.BuscadorTitulares();
					window.setSize(1200,800);
					
					
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
