package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.awt.EventQueue;

import javax.swing.JOptionPane;






public class Principal {

	/**
	 * Launch the application.
	 */
	public static MarcoNoticias window;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
                    
                    
					new PantalladeCarga();
					window = new MarcoNoticias();
					window.setSize(1200,800);
					
					
		
				} catch (Exception|ExceptionInInitializerError e) {
					JOptionPane.showMessageDialog(null, "No se han podido cargar los datos debido a que no existen los archivos","Error catastrofico",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
	}
	
}
