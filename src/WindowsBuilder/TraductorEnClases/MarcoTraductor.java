package TraductorEnClases;

import javax.swing.JFrame;

public class MarcoTraductor extends JFrame{

	public MarcoTraductor() {
		setTitle("TRADUCTOR INGLES-ESPAÑOL");
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
	
		PanelTraductor miPanel = new PanelTraductor();
		add(miPanel);
		
	}
}
