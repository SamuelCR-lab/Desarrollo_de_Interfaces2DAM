package ProyectoDDI_NOTICIAS;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Preferencias extends JPanel{
	private static JCheckBox chckbxNewCheckBox,chckbxNewCheckBox_1,chckbxNewCheckBox_2,chckbxNewCheckBox_3,chckbxNewCheckBox_4,chckbxNewCheckBox_5,chckbxNewCheckBox_6,chckbxNewCheckBox_7,chckbxNewCheckBox_8,chckbxNewCheckBox_9,chckbxNewCheckBox_10,chckbxNewCheckBox_11,chckbxNewCheckBox_12,chckbxNewCheckBox_13,chckbxNewCheckBox_14,chckbxNewCheckBox_15,chckbxNewCheckBox_16,chckbxNewCheckBox_17;
	private static JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6;
	private static final long serialVersionUID = 1L;
	public static JLabel ErrorEleccionPreferencias;
	public static int [] PrefeTemp = new int[18] ;
	public Preferencias () {
		setName("Preferencias");
		setSize(1200,800);
		setLayout(null);
		
		
		chckbxNewCheckBox = new JCheckBox("Marca");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(131, 131, 107, 23);
		add(chckbxNewCheckBox);
		
		lblNewLabel = new JLabel("Bienvenido por primera vez, elige tus medios de comunicacion preferidos.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(256, 33, 672, 31);
		add(lblNewLabel);
		
		chckbxNewCheckBox_1 = new JCheckBox("AS");
		chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_1.setBounds(131, 157, 107, 23);
		add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Diario  Madridista");
		chckbxNewCheckBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_2.setBounds(131, 183, 173, 23);
		add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("El Economista");
		chckbxNewCheckBox_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_3.setBounds(131, 397, 144, 23);
		add(chckbxNewCheckBox_3);
		
		chckbxNewCheckBox_4 = new JCheckBox("Economia elEspañol");
		chckbxNewCheckBox_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_4.setBounds(131, 423, 173, 23);
		add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_5 = new JCheckBox("El Español");
		chckbxNewCheckBox_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_5.setBounds(464, 131, 107, 23);
		add(chckbxNewCheckBox_5);
		
		chckbxNewCheckBox_6 = new JCheckBox("El Mundo");
		chckbxNewCheckBox_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_6.setBounds(464, 157, 107, 23);
		add(chckbxNewCheckBox_6);
		
		chckbxNewCheckBox_7 = new JCheckBox("Okdiario");
		chckbxNewCheckBox_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_7.setBounds(464, 183, 107, 23);
		add(chckbxNewCheckBox_7);
		
		chckbxNewCheckBox_8 = new JCheckBox("El Español Internacional");
		chckbxNewCheckBox_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_8.setBounds(464, 397, 241, 23);
		add(chckbxNewCheckBox_8);
		
		chckbxNewCheckBox_9 = new JCheckBox("El Mundo Internacional");
		chckbxNewCheckBox_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_9.setBounds(464, 423, 199, 23);
		add(chckbxNewCheckBox_9);
		
		chckbxNewCheckBox_10 = new JCheckBox("Xataka");
		chckbxNewCheckBox_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_10.setBounds(868, 131, 107, 23);
		add(chckbxNewCheckBox_10);
		
		chckbxNewCheckBox_11 = new JCheckBox("Applesfera");
		chckbxNewCheckBox_11.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_11.setBounds(868, 157, 121, 23);
		add(chckbxNewCheckBox_11);
		
		chckbxNewCheckBox_12 = new JCheckBox("Mundo Xiaomi");
		chckbxNewCheckBox_12.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_12.setBounds(868, 183, 144, 23);
		add(chckbxNewCheckBox_12);
		
		chckbxNewCheckBox_13 = new JCheckBox("Vandal (VideoJuegos)");
		chckbxNewCheckBox_13.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_13.setBounds(868, 397, 187, 23);
		add(chckbxNewCheckBox_13);
		
		chckbxNewCheckBox_14 = new JCheckBox("Directo al Paladar");
		chckbxNewCheckBox_14.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_14.setBounds(868, 423, 187, 23);
		add(chckbxNewCheckBox_14);
		
		chckbxNewCheckBox_15 = new JCheckBox("Economia ElMundo");
		chckbxNewCheckBox_15.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_15.setBounds(131, 449, 173, 23);
		add(chckbxNewCheckBox_15);
		
		chckbxNewCheckBox_16 = new JCheckBox("Okdiario Internacional");
		chckbxNewCheckBox_16.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_16.setBounds(464, 449, 199, 23);
		add(chckbxNewCheckBox_16);
		
		chckbxNewCheckBox_17 = new JCheckBox("Sensacine (Cine)");
		chckbxNewCheckBox_17.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxNewCheckBox_17.setBounds(868, 449, 187, 23);
		add(chckbxNewCheckBox_17);
		
		JButton btnNewButton = new JButton("Cerrar Sesion");
		btnNewButton.addActionListener(new AccionesDeBotonesSA(0,"Preferencias"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(75, 678, 200, 46);
		add(btnNewButton);
		
		JButton Siguiente = new JButton("Siguiente");
		Siguiente.addActionListener(new AccionesDeBotonesSA(1,"Preferencias"));
		Siguiente.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Siguiente.setBounds(911, 678, 200, 46);
		add(Siguiente);
		
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
		
		ErrorEleccionPreferencias = new JLabel("Error. Tienes que seleecionar una opcion como minimo.");
		ErrorEleccionPreferencias.setVisible(false);
		ErrorEleccionPreferencias.setForeground(new Color(255, 0, 0));
		ErrorEleccionPreferencias.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ErrorEleccionPreferencias.setBounds(420, 678, 421, 46);
		add(ErrorEleccionPreferencias);
	}
	public static int guardarSeleccion(int id) {

		int marca = chckbxNewCheckBox.isSelected() ? 1 : 0;
		int aS = chckbxNewCheckBox.isSelected() ? 1 : 0;
		int okDiario =chckbxNewCheckBox_2.isSelected() ? 1 : 0;
		int elEconomia = chckbxNewCheckBox_3.isSelected() ? 1 : 0;
		int elEspaniolECO = chckbxNewCheckBox_4.isSelected() ? 1 : 0;
		int elMundoECO = chckbxNewCheckBox_15.isSelected() ? 1 : 0;
		int elEspaniolN = chckbxNewCheckBox_5.isSelected() ? 1 : 0;
		int elMundoN = chckbxNewCheckBox_6.isSelected() ? 1 : 0;
		int okDiarioN = chckbxNewCheckBox_7.isSelected() ? 1 : 0;
		int elEspaniolI = chckbxNewCheckBox_8.isSelected() ? 1 : 0;
		int elMundoI = chckbxNewCheckBox_9.isSelected() ? 1 : 0;
		int okDiarioI = chckbxNewCheckBox_16.isSelected() ? 1 : 0;
		int xataka = chckbxNewCheckBox_10.isSelected() ? 1 : 0;
		int appleSfera = chckbxNewCheckBox_11.isSelected() ? 1 : 0;
		int mundoXiaomi = chckbxNewCheckBox_12.isSelected() ? 1 : 0;
		int vandal = chckbxNewCheckBox_13.isSelected() ? 1 : 0;
		int directoAlPaladar = chckbxNewCheckBox_14.isSelected() ? 1 : 0;
		int sensaCine = chckbxNewCheckBox_17.isSelected() ? 1 : 0;
		
		PrefeTemp[0] = marca;
		PrefeTemp[1] = aS;
		PrefeTemp[2] = okDiario;
		PrefeTemp[3] = elEconomia;
		PrefeTemp[4] = elEspaniolECO;
		PrefeTemp[5] = elMundoECO;
		PrefeTemp[6] = elEspaniolN;
		PrefeTemp[7] = elMundoN;
		PrefeTemp[8] = okDiarioN;
		PrefeTemp[9] = elEspaniolI;
		PrefeTemp[10] = elMundoI;
		PrefeTemp[11] = okDiarioI;
		PrefeTemp[12] = xataka;
		PrefeTemp[13] = appleSfera;
		PrefeTemp[14] = mundoXiaomi;
		PrefeTemp[15] = vandal;
		PrefeTemp[16] = directoAlPaladar;
		PrefeTemp[17] = sensaCine;
		int comprobacionSeleccion=0;
		for (int i=0;i<PrefeTemp.length;i++) {
			if(PrefeTemp[i] == 1){
				comprobacionSeleccion+=1;
			}
		}
		if(comprobacionSeleccion != 0) {
			preferenciasIniciador nuevasPreferenciasCargadas = new preferenciasIniciador(id,marca,aS ,okDiario,elEconomia,elEspaniolECO,elMundoECO,elEspaniolN,elMundoN,okDiarioN,elEspaniolI,elMundoI,okDiarioI,xataka,appleSfera,mundoXiaomi,vandal,directoAlPaladar,sensaCine);
			preferenciasIniciador.listaPreferencias.add(nuevasPreferenciasCargadas);
			return 1;
		}else {
			return 0;
		}
		
	}
}
