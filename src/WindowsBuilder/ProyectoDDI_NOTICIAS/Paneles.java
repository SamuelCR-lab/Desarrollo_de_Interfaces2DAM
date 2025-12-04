package ProyectoDDI_NOTICIAS;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Paneles extends JLayeredPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel lblNewLabel,lblNewLabel1,lblNewLabel2,lblNewLabel3,lblNewLabel4,lblNewLabel5,lblNewLabel6,lblNewLabel7,lblNewLabel8,lblNewLabel9,lblNewLabel10,lblNewLabel11,lblNewLabel12,lblNewLabel13,lblNewLabel14,lblNewLabel15,lblNewLabel16,lblNewLabel17,lblNewLabel18;
	private String[] guardados = new String[18];
	public Paneles () {
		setSize(1200,800);
		//PanelLogin Login = new PanelLogin();
		//add(Login);
		Funciones.BuscadorTitulares();
		/*for (int i = 0; i<Funciones.Noticias.size();i++) {
			guardados[i] = Funciones.Noticias.get(i);
		}
		lblNewLabel = new JLabel(guardados[0]);
		lblNewLabel.setBounds(35, 154, 199, 35);
		add(lblNewLabel);
		lblNewLabel1 = new JLabel(guardados[1]);
		lblNewLabel1.setBounds(135, 204, 259, 75);
		add(lblNewLabel1);
		lblNewLabel2 = new JLabel(guardados[2]);
		lblNewLabel2.setBounds(155, 214, 249, 100);
		add(lblNewLabel2);
		lblNewLabel3 = new JLabel(guardados[3]);
		lblNewLabel3.setBounds(255, 314, 349, 200);
		add(lblNewLabel3);
		lblNewLabel4 = new JLabel(guardados[0]);
		lblNewLabel4.setBounds(185, 154, 199, 35);
		add(lblNewLabel4);
		lblNewLabel5 = new JLabel(guardados[1]);
		lblNewLabel5.setBounds(300, 204, 259, 75);
		add(lblNewLabel5);
		lblNewLabel6 = new JLabel(guardados[2]);
		lblNewLabel6.setBounds(500, 214, 249, 100);
		add(lblNewLabel6);
		lblNewLabel7 = new JLabel(guardados[3]);
		lblNewLabel7.setBounds(255, 314, 349, 200);
		add(lblNewLabel7);
		lblNewLabel8 = new JLabel(guardados[0]);
		lblNewLabel8.setBounds(35, 154, 199, 35);
		add(lblNewLabel8);
		lblNewLabel9 = new JLabel(guardados[1]);
		lblNewLabel9.setBounds(135, 204, 259, 75);
		add(lblNewLabel9);
		lblNewLabel10 = new JLabel(guardados[2]);
		lblNewLabel10.setBounds(155, 214, 249, 100);
		add(lblNewLabel10);
		lblNewLabel11 = new JLabel(guardados[3]);
		lblNewLabel11.setBounds(255, 314, 349, 200);
		add(lblNewLabel11);
		lblNewLabel12 = new JLabel(guardados[0]);
		lblNewLabel12.setBounds(35, 154, 199, 35);
		add(lblNewLabel12);
		lblNewLabel13 = new JLabel(guardados[1]);
		lblNewLabel13.setBounds(135, 204, 259, 75);
		add(lblNewLabel13);
		lblNewLabel14 = new JLabel(guardados[2]);
		lblNewLabel14.setBounds(155, 214, 249, 100);
		add(lblNewLabel14);
		lblNewLabel15 = new JLabel(guardados[3]);
		lblNewLabel15.setBounds(255, 314, 349, 200);
		add(lblNewLabel15);
		lblNewLabel16 = new JLabel(guardados[1]);
		lblNewLabel16.setBounds(135, 204, 259, 75);
		add(lblNewLabel16);
		lblNewLabel17 = new JLabel(guardados[2]);
		lblNewLabel17.setBounds(155, 214, 249, 100);
		add(lblNewLabel17);
		lblNewLabel18 = new JLabel(guardados[3]);
		lblNewLabel18.setBounds(255, 314, 349, 200);
		add(lblNewLabel18);*/
		
		
	}
}
