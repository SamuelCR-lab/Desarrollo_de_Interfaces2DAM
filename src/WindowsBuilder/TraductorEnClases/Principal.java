package TraductorEnClases;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcoTraductor miVentana =  new MarcoTraductor();
					miVentana.setSize(1200,800);
					miVentana.setVisible(false);
					
				}catch (Exception i){i.getStackTrace();}
			}
		});
	}

}
