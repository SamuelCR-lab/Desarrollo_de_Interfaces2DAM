package ProyectoDDI_NOTICIAS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class PantalladeCarga extends JFrame{

    private static final long serialVersionUID = 1L;
    private JProgressBar barraProgreso;
    private Timer temporizador; // Variable para el Timer

    public PantalladeCarga() {
        setUndecorated(true);
        setLayout(new BorderLayout());
        
        
        ImageIcon imagenIcon = null;
        try {
            // Icono de la ventana (aunque no tenga bordes, es buena práctica)
            setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icono_noticias_globales.png")));
            // Imagen central
            java.net.URL urlImagen = getClass().getResource("/ImagenPantallaCarga.jpg");
            imagenIcon = new ImageIcon(urlImagen);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel etiquetaImagen = new JLabel(imagenIcon);
        // Si no hay imagen, ponemos texto para que se vea algo
        if (imagenIcon == null || imagenIcon.getIconWidth() == -1) {
            etiquetaImagen.setText("Cargando Noticias...");
            etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);
            etiquetaImagen.setPreferredSize(new Dimension(400, 300));
        }
        add(etiquetaImagen, BorderLayout.CENTER);

        // --- Barra de Progreso ---
        barraProgreso = new JProgressBar();
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setStringPainted(true);
        barraProgreso.setForeground(new Color(50, 205, 50)); // Verde lime
        barraProgreso.setPreferredSize(new Dimension(getWidth(), 30));
        add(barraProgreso, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        // Iniciamos la carga con Timer en lugar de Thread
        iniciarCargaConTimer();
    }

    private void iniciarCargaConTimer() {
        // Creamos un Timer que se ejecuta cada 50 milisegundos
        temporizador = new Timer(50, new ActionListener() {
            int progreso = 0;
            boolean comprobacionArrayNoticias=true,comprobacionPreferencias=true,comprobacionUsuarios=true;
            @Override
            public void actionPerformed(ActionEvent e) {
                progreso++;
                barraProgreso.setValue(progreso);
                barraProgreso.setString("Cargando sistema... " + progreso + "%");
                
                if(progreso==50) {
                	comprobacionArrayNoticias = Funciones.lecturaConfiguracion();
                	comprobacionPreferencias =preferenciasIniciador.lecturaPreferencias();
                	comprobacionUsuarios = Usuario.lecturaUsuarios();
                }
                
                if ((!comprobacionArrayNoticias)||(!comprobacionPreferencias)||(!comprobacionUsuarios)) {
                	JOptionPane.showMessageDialog(PantalladeCarga.this, "No se han podido cargar los datos debido a que no existen los archivos","Error catastrofico",JOptionPane.ERROR_MESSAGE);
                	temporizador.stop(); // Detenemos el temporizador de 50milisegundos que hace que llegue al 100%
                    dispose();  
                    System.exit(1);
                }
                // Cuando llega al 100%, paramos y abrimos la ventana principal
                if (progreso == 100) {
                    temporizador.stop(); // Detenemos el temporizador de 50milisegundos que hace que llegue al 100%
                    dispose();           // Cerrar pantalla de carga
                    
                    // Configurar y mostrar la ventana principal
                    Principal.window.setLocationRelativeTo(null); 
                    Principal.window.setVisible(true);
                }
            }
        });
        
        temporizador.start();
    }
}
    

