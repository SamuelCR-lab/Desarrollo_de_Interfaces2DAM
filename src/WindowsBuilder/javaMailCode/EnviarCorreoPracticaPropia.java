package javaMailCode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class EnviarCorreoPracticaPropia {

	private JFrame frame;
	private JTextField textField;
	private static JLabel lblNewLabel,lblNewLabel_1;
	final String fromEmail = "samcr9112@gmail.com"; //EMAIL DE SALIDA
	final String password = "uyce vzdu gkpc rwov"; //CONTRASEÑA DEL EMAIL DE SALIDA (Acecedrar a este enlace: )
	//(aplicaciones de 3ros) Contraseñas de aplicación -- Verificación en 2 pasos
	String toEmail = ""; // EMAIL DESTINATARIO
	private static JButton btnNewButton,salida;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblAsuntoDelCorreo;
	private JLabel lblCuerpoDelCorreo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EnviarCorreoPracticaPropia() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Introduce un Correo");
		lblNewLabel.setBounds(10, 60, 131, 21);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Se ha enviado el correo");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(150, 202, 143, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(151, 60, 273, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 91, 273, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 133, 283, 23);
		frame.getContentPane().add(textField_2);
		
		lblAsuntoDelCorreo = new JLabel("Asunto del correo");
		lblAsuntoDelCorreo.setBounds(10, 95, 131, 21);
		frame.getContentPane().add(lblAsuntoDelCorreo);
		
		lblCuerpoDelCorreo = new JLabel("Cuerpo del correo");
		lblCuerpoDelCorreo.setBounds(10, 134, 131, 21);
		frame.getContentPane().add(lblCuerpoDelCorreo);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correo = textField.getText();
				toEmail = correo;
				
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP de GMAIL en este caso
				props.put("mail.smtp.socketFactory.port", "465"); //PUERTO SSL 
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
				props.put("mail.smtp.auth", "true"); //ACTIVAR SMTP AUTENTIFICACI�N
				props.put("mail.smtp.port", "465"); //SMTP Port		
				Authenticator auth = new Authenticator() {		
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				};		
				Session session = Session.getDefaultInstance(props, auth);//CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL "LOGIN"
			    sendEmail(session, toEmail,textField_1.getText(), textField_2.getText());
			}
		});
		btnNewButton.setBounds(184, 168, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		salida = new JButton("Salida");
		salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		salida.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(salida);
		
		
		
		

	}
	
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try{
	      MimeMessage msg = new MimeMessage(session);
	      //Configurar Cabeceras
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("no_reply@example.com", "NO BIZUM NO RESPONDER"));//Datos de ejemplo	      	      
	      msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));	      
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8");
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));	    
	      Transport.send(msg);
	      lblNewLabel_1.setVisible(true);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarCorreoPracticaPropia window = new EnviarCorreoPracticaPropia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
