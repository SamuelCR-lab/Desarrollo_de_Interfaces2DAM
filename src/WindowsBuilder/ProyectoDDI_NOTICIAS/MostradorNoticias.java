package ProyectoDDI_NOTICIAS;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MostradorNoticias extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel lblNewLabel,lblNewLabel1,lblNewLabel2,lblNewLabel3,lblNewLabel4,lblNewLabel5,lblNewLabel6,lblNewLabel7,lblNewLabel8,lblNewLabel9,lblNewLabel10,lblNewLabel11,lblNewLabel12,lblNewLabel13,lblNewLabel14,lblNewLabel15,lblNewLabel16,lblNewLabel17,lblNewLabel18;
	public static String[] guardados = new String[18];
	public static JScrollPane scrollPane = new JScrollPane();
	public static JTextArea textAreaNoticias = new JTextArea ();
	
	public MostradorNoticias () {
		setName("Mostrador Noticias");
		setSize(1200,800);
		setLayout(null);
		
		textAreaNoticias = new JTextArea();
		textAreaNoticias.setBounds(75, 128, 800, 581);
		textAreaNoticias.setEditable(false);
		textAreaNoticias.setLineWrap(true);
		textAreaNoticias.setWrapStyleWord(true);
		
		// 2. IMPORTANTE: Configuramos el ScrollPane y metemos el Area de Texto dentro
		scrollPane.setBounds(75, 128, 800, 581); // Las coordenadas se las damos al Scroll, no al texto
		scrollPane.setViewportView(textAreaNoticias); // Metemos el texto dentro del scroll
				
				// 3. IMPORTANTE: Añadimos el ScrollPane al Panel
		add(scrollPane);

		
		
		JButton Atras = new JButton("Atras");
		Atras.addActionListener(new AccionesDeBotonesSA(0,"MostradorNoticias"));
		Atras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Atras.setBounds(58, 678, 135, 46);
		add(Atras);
		JButton Siguiente = new JButton("Siguiente");
		Siguiente.addActionListener(new AccionesDeBotonesSA(1,"MostradorNoticias"));
		Siguiente.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Siguiente.setBounds(994, 678, 135, 46);
		add(Siguiente);
		/*
		
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
		lblNewLabel4 = new JLabel(guardados[4]);
		lblNewLabel4.setBounds(185, 154, 199, 35);
		add(lblNewLabel4);
		lblNewLabel5 = new JLabel(guardados[5]);
		lblNewLabel5.setBounds(300, 204, 259, 75);
		add(lblNewLabel5);
		lblNewLabel6 = new JLabel(guardados[6]);
		lblNewLabel6.setBounds(500, 214, 249, 100);
		add(lblNewLabel6);
		lblNewLabel7 = new JLabel(guardados[7]);
		lblNewLabel7.setBounds(255, 314, 349, 200);
		add(lblNewLabel7);
		lblNewLabel8 = new JLabel(guardados[8]);
		lblNewLabel8.setBounds(35, 154, 199, 35);
		add(lblNewLabel8);
		lblNewLabel9 = new JLabel(guardados[9]);
		lblNewLabel9.setBounds(135, 204, 259, 75);
		add(lblNewLabel9);
		lblNewLabel10 = new JLabel(guardados[10]);
		lblNewLabel10.setBounds(155, 214, 249, 100);
		add(lblNewLabel10);
		lblNewLabel11 = new JLabel(guardados[11]);
		lblNewLabel11.setBounds(255, 314, 349, 200);
		add(lblNewLabel11);
		lblNewLabel12 = new JLabel(guardados[12]);
		lblNewLabel12.setBounds(35, 154, 199, 35);
		add(lblNewLabel12);
		lblNewLabel13 = new JLabel(guardados[13]);
		lblNewLabel13.setBounds(135, 204, 259, 75);
		add(lblNewLabel13);
		lblNewLabel14 = new JLabel(guardados[14]);
		lblNewLabel14.setBounds(155, 214, 249, 100);
		add(lblNewLabel14);
		lblNewLabel15 = new JLabel(guardados[15]);
		lblNewLabel15.setBounds(255, 314, 349, 200);
		add(lblNewLabel15);
		lblNewLabel16 = new JLabel(guardados[16]);
		lblNewLabel16.setBounds(135, 204, 259, 75);
		add(lblNewLabel16);
		lblNewLabel17 = new JLabel(guardados[17]);
		lblNewLabel17.setBounds(155, 214, 249, 100);
		add(lblNewLabel17);
		lblNewLabel18 = new JLabel(guardados[18]);
		lblNewLabel18.setBounds(255, 314, 349, 200);
		add(lblNewLabel18);*/
		}
	
}
