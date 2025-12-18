package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class preferenciasIniciador {
	 	 int Id;
	     int Marca = 0;
	     int AS = 0;
	     int OKdiario = 0;
	     int eleconomista = 0;
	     int elespanolECO = 0;
	     int elmundoECO = 0;
	     int elespanolN = 0;
	     int elmundoN = 0;
	     int okdiarioN = 0;
	     int elespanolI = 0;
	     int elmundoI = 0;
	     int okdiarioI = 0;
	     int xataka = 0;
	     int applesfera = 0;
	     int mundoxiaomi = 0;
	     int vandal = 0;
	     int directoalpaladar = 0;
	     int sensacine = 0;
	     private static final Pattern PATRON_PREFERENCIAS = Pattern.compile("^ID:(.*?)(?://.*)?$");
		 public static String[] datosPreferenciasTemporal;
		 public static  ArrayList<preferenciasIniciador> listaPreferencias = new ArrayList<>();
	    // CONSTRUCTOR VACÍO (Necesario para inicializarlo en la pantalla de preferencias)
	    public preferenciasIniciador() {
	        // Inicializa todo a 0 por defecto
	    }

	    // Constructor completo (lo mantenemos por si lo usas en otro lado)
	    public preferenciasIniciador(int Id, int marca, int aS, int oKdiario, int eleconomista, int elespanolECO, int elmundoECO,
	            int elespanolN, int elmundoN, int okdiarioN, int elespanolI, int elmundoI, int okdiarioI, int xataka,
	            int applesfera, int mundoxiaomi, int vandal, int directoalpaladar, int sensacine) {
	        super();
	        this.Id = Id;
	        this.Marca = marca;
	        this.AS = aS;
	        this.OKdiario = oKdiario;
	        this.eleconomista = eleconomista;
	        this.elespanolECO = elespanolECO;
	        this.elmundoECO = elmundoECO;
	        this.elespanolN = elespanolN;
	        this.elmundoN = elmundoN;
	        this.okdiarioN = okdiarioN;
	        this.elespanolI = elespanolI;
	        this.elmundoI = elmundoI;
	        this.okdiarioI = okdiarioI;
	        this.xataka = xataka;
	        this.applesfera = applesfera;
	        this.mundoxiaomi = mundoxiaomi;
	        this.vandal = vandal;
	        this.directoalpaladar = directoalpaladar;
	        this.sensacine = sensacine;
	    }
	    
	    public static boolean lecturaPreferencias() {
	    	boolean comprobacionConfiguracion = true; 
	    	File ficheroPreferencias = new File("Usuarios//Configuracion.txt");
	    	if (ficheroPreferencias.exists()) {
	    		try (FileReader archivoPREFERENCIAS = new FileReader(ficheroPreferencias);
		            BufferedReader lectorArchivo = new BufferedReader(archivoPREFERENCIAS)) {
		            String cadena;
		            while ((cadena = lectorArchivo.readLine()) != null){
		       
		                if (cadena.trim().isEmpty()) {//Lee las lineas vacias y no pasa nada no guarda ni incrementa nada es solo vacio hasta que sea null el readline del while
		                
		                }else {
		                	String datosLimpios = null;
			                Matcher matchPreferencias = PATRON_PREFERENCIAS.matcher(cadena);

			                // Verificamos si coincide con el patron de Preferencias que es el ID que luego usaremos para asignarle las preferencias a cada uno de los usuarios
			                if (matchPreferencias.matches()) {
			                    datosLimpios = matchPreferencias.group(1); 
			                }

			                // Igual que en el de lectura de usuarios al encontrar el patron dividimos los datos y los guardamos en el array datosPreferenciasTemporales para luego
			                //extraerlos y darle una estrucutra como de la clase Preferencias Iniciador
			                if (datosLimpios != null) {
			                	datosPreferenciasTemporal = datosLimpios.split(";");

			                    if (datosPreferenciasTemporal.length >= 19) {
			                    	int ID = Integer.parseInt(datosPreferenciasTemporal[0]);
			                        int Marca = Integer.parseInt(datosPreferenciasTemporal[1]);
			                        int AS = Integer.parseInt(datosPreferenciasTemporal[2]);
			                        int OKdiario = Integer.parseInt(datosPreferenciasTemporal[3]);
			                        int eleconomista = Integer.parseInt(datosPreferenciasTemporal[4]);
			                        int elespanolECO = Integer.parseInt(datosPreferenciasTemporal[5]);
			                        int elmundoECO = Integer.parseInt(datosPreferenciasTemporal[6]);
			                        int elespanolN = Integer.parseInt(datosPreferenciasTemporal[7]);
			                        int elmundoN = Integer.parseInt(datosPreferenciasTemporal[8]);
			                        int okdiarioN = Integer.parseInt(datosPreferenciasTemporal[9]);
			                        int elespanolI = Integer.parseInt(datosPreferenciasTemporal[10]);
			                        int elmundoI = Integer.parseInt(datosPreferenciasTemporal[11]);
			                        int okdiarioI = Integer.parseInt(datosPreferenciasTemporal[12]);
			                        int xataka = Integer.parseInt(datosPreferenciasTemporal[13]);
			                        int applesfera = Integer.parseInt(datosPreferenciasTemporal[14]);
			                        int mundoxiaomi = Integer.parseInt(datosPreferenciasTemporal[15]);
			                        int vandal = Integer.parseInt(datosPreferenciasTemporal[16]);
			                        int directoalpaladar = Integer.parseInt(datosPreferenciasTemporal[17]);
			                        int sensacine = Integer.parseInt(datosPreferenciasTemporal[18]);
			                        preferenciasIniciador preferenciasCargadas = new preferenciasIniciador(ID,Marca, AS,OKdiario, eleconomista, elespanolECO, elmundoECO, elespanolN, elmundoN, okdiarioN, elespanolI, elmundoI, okdiarioI, xataka, applesfera, mundoxiaomi, vandal, directoalpaladar,sensacine);
			                        listaPreferencias.add(preferenciasCargadas);
			                              
			                }
			            }
		            }	    	
		        }
	    	}catch(Exception i) {
	    		JOptionPane.showMessageDialog(null, "Error leyendo preferencias del usuario: " + i.getMessage());
	    	}
	    }else {
	    	comprobacionConfiguracion = false;
	    	return comprobacionConfiguracion;
	    }
			return comprobacionConfiguracion;
	 }
	    public static int escrituraPreferencias(int idUsuarioPN) {
	    	int comprobacion = 0;
	    	File ficheroPreferencias = new File("Usuarios//Configuracion.txt");

	    	try (FileWriter archivoPREFERENCIAS = new FileWriter(ficheroPreferencias,true);
		             BufferedWriter escribirArchivo = new BufferedWriter(archivoPREFERENCIAS)) {
	    		int ID = 0,Marca = 0,AS = 0,OKdiario = 0,eleconomista = 0,elespanolECO = 0,elmundoECO = 0,elespanolN = 0,elmundoN = 0,okdiarioN = 0,elespanolI = 0,elmundoI = 0,okdiarioI = 0,xataka = 0,applesfera = 0,mundoxiaomi = 0,vandal = 0,directoalpaladar = 0,sensacine = 0;
		            for(preferenciasIniciador UsuarioPreferencia : listaPreferencias){
		            		if(UsuarioPreferencia.Id==idUsuarioPN) {
			                   ID = UsuarioPreferencia.Id;
			                   Marca =UsuarioPreferencia.Marca;
			                   AS = UsuarioPreferencia.AS;
			                   OKdiario = UsuarioPreferencia.OKdiario;
			                   eleconomista = UsuarioPreferencia.eleconomista;
			                   elespanolECO = UsuarioPreferencia.elespanolECO;
			                   elmundoECO = UsuarioPreferencia.elmundoECO;
			                   elespanolN = UsuarioPreferencia.elespanolN;
			                   elmundoN = UsuarioPreferencia.elmundoN;
			                   okdiarioN = UsuarioPreferencia.okdiarioN;
			                   elespanolI = UsuarioPreferencia.elespanolI;
			                   elmundoI = UsuarioPreferencia.elmundoI;
			                   okdiarioI = UsuarioPreferencia.okdiarioI;
			                   xataka = UsuarioPreferencia.xataka;
			                   applesfera = UsuarioPreferencia.applesfera;
			                   mundoxiaomi = UsuarioPreferencia.mundoxiaomi;
			                   vandal = UsuarioPreferencia.vandal;
			                   directoalpaladar = UsuarioPreferencia.directoalpaladar;
			                   sensacine = UsuarioPreferencia.sensacine;
			                  
		            		}  
		            }
		            comprobacion++;
		            escribirArchivo.write("ID:"+ID+";"+Marca+";"+AS+";"+OKdiario+";"+eleconomista+";"+elespanolECO+";"+elmundoECO+";"+elespanolN+";"+elmundoN+";"+okdiarioN+";"+elespanolI+";"+elmundoI+";"+okdiarioI+";"+xataka+";"+applesfera+";"+mundoxiaomi+";"+vandal+";"+directoalpaladar+";"+sensacine+"\n");
	    	}catch(Exception i) {
	    		JOptionPane.showMessageDialog(null, "Error en la escritura de las preferencias del usuario: " + i.getMessage());
	    		return comprobacion;
	    	}
	    	return comprobacion;
	    }
	
	  
}
