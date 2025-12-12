package ProyectoDDI_NOTICIAS;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MostradorNoticias extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel lblNewLabel,lblNewLabel1,lblNewLabel2,lblNewLabel3,lblNewLabel4,lblNewLabel5,lblNewLabel6,lblNewLabel7,lblNewLabel8,lblNewLabel9,lblNewLabel10,lblNewLabel11,lblNewLabel12,lblNewLabel13,lblNewLabel14,lblNewLabel15,lblNewLabel16,lblNewLabel17,lblNewLabel18;
	public static String[] guardados = new String[18];
	public static JScrollPane scrollPane = new JScrollPane();
	public static JTextArea textAreaNoticias = new JTextArea ();
	public static JButton Siguiente;
	public MostradorNoticias () {
		setName("Mostrador Noticias");
		setSize(1200,800);
		setLayout(null);
		
		textAreaNoticias = new JTextArea();
		textAreaNoticias.setBounds(75, 128, 1033, 450);
		textAreaNoticias.setEditable(false);
		textAreaNoticias.setLineWrap(true);
		textAreaNoticias.setWrapStyleWord(true);
		
		
		scrollPane.setBounds(75, 128, 1033, 450);
		scrollPane.setViewportView(textAreaNoticias); 
		add(scrollPane);

		lblNewLabel = new JLabel("Aqui tienes tus noticias por preferencias, del momento.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(256, 33, 672, 31);
		add(lblNewLabel);
		
		JButton Atras = new JButton("Atras");
		Atras.addActionListener(new AccionesDeBotonesSA(0,"MostradorNoticias"));
		Atras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Atras.setBounds(75, 678, 200, 46);
		add(Atras);
		Siguiente = new JButton("Enviar Correo");
		Siguiente.addActionListener(new AccionesDeBotonesSA(1,"EnviarCorreo"));
		Siguiente.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Siguiente.setBounds(911, 678, 200, 46);
		Siguiente.setVisible(false);
		add(Siguiente);
		
		}
	
}
