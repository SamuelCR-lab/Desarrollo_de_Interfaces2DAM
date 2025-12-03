package ProyectoDDI_NOTICIAS;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PantalladeCarga extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void PantallaCarga() {
        // 1. Cargar la imagen
        // Asegúrate de cambiar "/splash_imagen.png" por la ruta real de tu imagen de carga
        ImageIcon imagenIcon = new ImageIcon(getClass().getResource("/icono_noticias_globales.png"));
        JLabel etiquetaImagen = new JLabel(imagenIcon);

        // 2. Agregar la imagen al contenedor del JWindow
        // Usamos BorderLayout para que la imagen ocupe todo el espacio
        getContentPane().add(etiquetaImagen, BorderLayout.CENTER);

        // 3. Configuración de la ventana
        pack(); // Ajusta el tamaño de la ventana automáticamente al tamaño de la imagen
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        // Hacemos visible la pantalla de carga inmediatamente al crearla
        setVisible(true);
    }
}
