package ProyectoDDI_NOTICIAS;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MarcoNoticias extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarcoNoticias () {
		setTitle("Buscador Noticias");
		setSize(1200,800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icono_noticias_globales.png")));
		setResizable(false);
		Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
		int tamanioyH = (int) monitor.getHeight();
		int tamanioxW = (int) monitor.getWidth();
		setLocation((tamanioxW/2 - getWidth()/2), (tamanioyH/2 - getHeight()/2));
		
		Paneles misPaneles = new Paneles();
		add(misPaneles);
	}
}
