package ProyectoDDI_NOTICIAS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class PantalladeCarga extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar barraProgreso;

    public PantalladeCarga() {
        setUndecorated(true);
        
        Funciones.escribirWebs();
        
        setLayout(new BorderLayout());
        
        ImageIcon imagenIcon = null;
        try {
        	setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icono_noticias_globales.png")));
            java.net.URL urlImagen = getClass().getResource("/ImagenPantallaCarga.jpg");
            
            if (urlImagen != null) {
                imagenIcon = new ImageIcon(urlImagen);
            } else {
                System.out.println("No se encontró la imagen.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel etiquetaImagen = new JLabel(imagenIcon);
        add(etiquetaImagen, BorderLayout.CENTER);

        barraProgreso = new JProgressBar();
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setStringPainted(true); // Muestra el porcentaje %
        barraProgreso.setForeground(new Color(50, 205, 50)); // Color verde
        barraProgreso.setPreferredSize(new Dimension(getWidth(), 30)); // Altura de la barra
        add(barraProgreso, BorderLayout.SOUTH);


        pack(); // Ajusta tamaño a la imagen
        setLocationRelativeTo(null); // Centrar en pantalla
        setAlwaysOnTop(true); // Mantiene la ventana encima de otras aplicaciones
        
        // Hacer visible la ventana
        setVisible(true);

        // 6. Iniciar la carga en un Hilo separado (CRUCIAL para que la barra se mueva)
        iniciarCarga();
    }


	


	private void iniciarCarga() {
        Thread hiloCarga = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        int progreso = i;
                        SwingUtilities.invokeLater(() -> {
                            barraProgreso.setValue(progreso);
                            barraProgreso.setString("Cargando sistema... " + progreso + "%");
                        });
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SwingUtilities.invokeLater(() -> {
                    dispose(); // Cierra la pantalla de carga
        			MarcoNoticias window = new MarcoNoticias();
					window.setSize(1200,800);
					window.setVisible(true);
                });
            }
        });
        hiloCarga.start();
    }

    // Método auxiliar para crear una imagen gris con texto si no tienes tu .png a mano
    
}
