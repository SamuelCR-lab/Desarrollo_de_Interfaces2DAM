package ProyectoDDI_NOTICIAS;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Preferencias extends JPanel{
	private static JCheckBox chckbxNewCheckBox,chckbxAs,chckbxNewCheckBox_2_1,chckbxNewCheckBox_2_2,chckbxNewCheckBox_2_3,chckbxNewCheckBox_2_4,chckbxNewCheckBox_2_5,chckbxNewCheckBox_2_6,chckbxNewCheckBox_2_7,chckbxNewCheckBox_2_8,chckbxNewCheckBox_2_9,chckbxNewCheckBox_2_10,chckbxNewCheckBox_2_11,chckbxNewCheckBox_2_12,chckbxNewCheckBox_2_13,chckbxNewCheckBox_2_14,chckbxNewCheckBox_2_15,chckbxNewCheckBox_2_16;
	private static JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6;
	private static final long serialVersionUID = 1L;
	
	public Preferencias () {
		setName("Preferencias");
		setSize(1200,800);
		setLayout(null);
		
		chckbxNewCheckBox = new JCheckBox("Marca");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(131, 131, 107, 23);
		add(chckbxNewCheckBox);
		
		lblNewLabel = new JLabel("Bienvenido "+AccionesDeBotonesSA.nombreUsuario+" por primera vez. \n Elige tus medios de comunicacion preferidos.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(384, 11, 502, 31);
		add(lblNewLabel);
		
		chckbxAs = new JCheckBox("AS");
		chckbxAs.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxAs.setBounds(131, 157, 107, 23);
		add(chckbxAs);
		
		chckbxNewCheckBox_2_1 = new JCheckBox("Diario  Madridista");
		chckbxNewCheckBox_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_1.setBounds(131, 183, 173, 23);
		add(chckbxNewCheckBox_2_1);
		
		chckbxNewCheckBox_2_2 = new JCheckBox("El Economista");
		chckbxNewCheckBox_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_2.setBounds(131, 397, 144, 23);
		add(chckbxNewCheckBox_2_2);
		
		chckbxNewCheckBox_2_3 = new JCheckBox("Economia elEspañol");
		chckbxNewCheckBox_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_3.setBounds(131, 423, 173, 23);
		add(chckbxNewCheckBox_2_3);
		
		chckbxNewCheckBox_2_4 = new JCheckBox("El Español");
		chckbxNewCheckBox_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_4.setBounds(464, 131, 107, 23);
		add(chckbxNewCheckBox_2_4);
		
		chckbxNewCheckBox_2_5 = new JCheckBox("El Mundo");
		chckbxNewCheckBox_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_5.setBounds(464, 157, 107, 23);
		add(chckbxNewCheckBox_2_5);
		
		chckbxNewCheckBox_2_6 = new JCheckBox("Okdiario");
		chckbxNewCheckBox_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_6.setBounds(464, 183, 107, 23);
		add(chckbxNewCheckBox_2_6);
		
		chckbxNewCheckBox_2_7 = new JCheckBox("El Español Internacional");
		chckbxNewCheckBox_2_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_7.setBounds(464, 397, 241, 23);
		add(chckbxNewCheckBox_2_7);
		
		chckbxNewCheckBox_2_8 = new JCheckBox("El Mundo Internacional");
		chckbxNewCheckBox_2_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_8.setBounds(464, 423, 199, 23);
		add(chckbxNewCheckBox_2_8);
		
		chckbxNewCheckBox_2_9 = new JCheckBox("Xataka");
		chckbxNewCheckBox_2_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_9.setBounds(868, 131, 107, 23);
		add(chckbxNewCheckBox_2_9);
		
		chckbxNewCheckBox_2_10 = new JCheckBox("Applesfera");
		chckbxNewCheckBox_2_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_10.setBounds(868, 157, 121, 23);
		add(chckbxNewCheckBox_2_10);
		
		chckbxNewCheckBox_2_11 = new JCheckBox("Mundo Xiaomi");
		chckbxNewCheckBox_2_11.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_11.setBounds(868, 183, 144, 23);
		add(chckbxNewCheckBox_2_11);
		
		chckbxNewCheckBox_2_12 = new JCheckBox(" Vandal (VideoJuegos)");
		chckbxNewCheckBox_2_12.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_12.setBounds(868, 397, 187, 23);
		add(chckbxNewCheckBox_2_12);
		
		chckbxNewCheckBox_2_13 = new JCheckBox("Directo al Paladar");
		chckbxNewCheckBox_2_13.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_13.setBounds(868, 423, 187, 23);
		add(chckbxNewCheckBox_2_13);
		
		chckbxNewCheckBox_2_14 = new JCheckBox("Economia ElMundo");
		chckbxNewCheckBox_2_14.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_14.setBounds(131, 449, 173, 23);
		add(chckbxNewCheckBox_2_14);
		
		chckbxNewCheckBox_2_15 = new JCheckBox("Okdiario Internacional");
		chckbxNewCheckBox_2_15.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_15.setBounds(464, 449, 199, 23);
		add(chckbxNewCheckBox_2_15);
		
		chckbxNewCheckBox_2_16 = new JCheckBox("Sensacine (Cine)");
		chckbxNewCheckBox_2_16.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2_16.setBounds(868, 449, 187, 23);
		add(chckbxNewCheckBox_2_16);
		
		JButton btnNewButton = new JButton("Anterior");
		btnNewButton.addActionListener(new AccionesDeBotonesSA(0,"Preferencias"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(58, 678, 135, 46);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new AccionesDeBotonesSA(1,"Preferencias"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(994, 678, 135, 46);
		add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("Deportes");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(244, 164, 96));
		lblNewLabel_1.setBounds(131, 87, 107, 23);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Economia");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBackground(new Color(244, 164, 96));
		lblNewLabel_2.setBounds(131, 359, 88, 31);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Noticias Internacionales");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBackground(new Color(244, 164, 96));
		lblNewLabel_3.setBounds(464, 359, 204, 31);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Noticias España");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBackground(new Color(244, 164, 96));
		lblNewLabel_4.setBounds(464, 89, 146, 18);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Informaticas");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBackground(new Color(244, 164, 96));
		lblNewLabel_5.setBounds(868, 87, 162, 23);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Variedad");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBackground(new Color(244, 164, 96));
		lblNewLabel_6.setBounds(868, 359, 121, 31);
		add(lblNewLabel_6);
	}
}
