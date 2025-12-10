package ProyectoDDI_NOTICIAS;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class admin extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public admin() {
		setName("Administrador");
		setSize(1200,800);
		setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Crear un nuevo Usuario");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(226, 328, 305, 70);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar Usuario");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(615, 328, 305, 70);
		add(btnNewButton_1);
		
		JButton btnEnviarCorreo = new JButton("Enviar Correo");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviarCorreo.setBounds(226, 450, 305, 70);
		add(btnEnviarCorreo);
		
		JButton btnVerTodasLas = new JButton("Ver todas las noticias");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnVerTodasLas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerTodasLas.setBounds(615, 450, 305, 70);
		add(btnVerTodasLas);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al menú de Administrador "+AccionesDeBotonesSA.nombreUsuario+".");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(226, 29, 694, 221);
		add(lblNewLabel);
		
		JButton CerrarSesion = new JButton("Cerrar Sesion");
		CerrarSesion.addActionListener(new AccionesDeBotonesSA(0,"Preferencias"));
		CerrarSesion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		CerrarSesion.setBounds(58, 678, 135, 46);
		add(CerrarSesion);
	}
}
