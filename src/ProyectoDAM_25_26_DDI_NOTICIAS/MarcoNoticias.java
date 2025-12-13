package ProyectoDAM_25_26_DDI_NOTICIAS;


import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MarcoNoticias extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Paneles misPaneles = new Paneles();
	public MarcoNoticias () {
		
		setTitle("Buscador Noticias");
		setSize(1200,800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icono_noticias_globales.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1183, 22);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Acerca de");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Invent@r");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem.addActionListener(e->{
			JOptionPane.showMessageDialog(MarcoNoticias.this, "Samuel Carías Ramos","Desarrollador",JOptionPane.INFORMATION_MESSAGE);
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Version");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(e->{
			JOptionPane.showMessageDialog(MarcoNoticias.this, "Version 1.0","",JOptionPane.INFORMATION_MESSAGE);
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent i) {
				int opcion = JOptionPane.showConfirmDialog(MarcoNoticias.this, "¿Estas seguro de quieres salir?","",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (opcion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		add(misPaneles);
		
	}

}
