package ProyectoDDI_NOTICIAS;

import javax.swing.JFrame;



public class MarcoNoticias extends JFrame{
	public MarcoNoticias () {
		setTitle("Buscador Noticias");
		setSize(800,600);
		
		setLocationRelativeTo(null);
		setResizable(false);
	
		Paneles misPaneles = new Paneles();
		add(misPaneles);
	}
}
