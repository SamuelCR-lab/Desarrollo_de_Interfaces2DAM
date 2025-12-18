package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	public static JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	public static String[] guardados = new String[18];
	public static JScrollPane scrollPane = new JScrollPane();
	public static JTextArea textAreaNoticias = new JTextArea ();
	public static JButton EnviarCorreo,GuardarHistorial;
	JFrame Marco;
	
	public MostradorNoticias(JFrame marco) {
		super();
		this.Marco = marco;
	}
	public JFrame getMarco() {
		return Marco;
	}
	public void setMarco(JFrame marco) {
		this.Marco = marco;
	}

	
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

		lblNewLabel = new JLabel("Aqui tienes tus noticias del momento basadas en tu preferencias.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(256, 33, 672, 31);
		add(lblNewLabel);
		
		JButton Atras = new JButton("Atras");
		Atras.addActionListener(new AccionesDeBotonesSA(0,"MostradorNoticias"));
		Atras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Atras.setBounds(75, 678, 241, 46);
		add(Atras);
		
		GuardarHistorial = new JButton("Guardar Preferencias y Titulares");
		GuardarHistorial.addActionListener(new AccionesDeBotonesSA(1,"GuardarTitulares"));
		GuardarHistorial.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GuardarHistorial.setBounds(870, 678, 241, 46);
		add(GuardarHistorial);
		
		EnviarCorreo = new JButton("Enviar Correo");
		EnviarCorreo.setVisible(false);
		EnviarCorreo.addActionListener(new AccionesDeBotonesSA(1,"EnviarCorreo"));
		EnviarCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		EnviarCorreo.setBounds(870, 678, 241, 46);
		add(EnviarCorreo);
		
		lblNewLabel_1 = new JLabel("Tus noticias se han guardado correctamente");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(422, 678, 355, 46);
		add(lblNewLabel_1);
		lblNewLabel_2 = new JLabel("Tus noticias se enviaron correctamente");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(422, 678, 355, 46);
		add(lblNewLabel_2);
		}
	
}
