package ProyectoDDI_NOTICIAS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Funciones {


	public static ArrayList <String> Noticias = new ArrayList<>(); 
	private static ArrayList <String> Enlaces = new ArrayList<>(); 
	private static ArrayList <String> Claves = new ArrayList<>(); 
    private static Pattern WebsYClaves = Pattern.compile("^WebsYclaves:(.*?)(?://.*)?$");
    
    
	private static void guardadoClaves () {
		
		String webDeporte1 = "h2.ue-c-cover-content__headline";
		String webDeporte2 = "h3.s_t a";
		String webDeporte3 = "h2.segmento-title a";
		
		String webEconomia1 = "h2.h1 center";
		String webEconomia2 = "h2.art__title a";
		String webEconomia3 = "h2.ue-c-cover-content__headline";
		
		String webNoticiasEspanolN = "h2.art__title a";
		String webNoticiaMundoN = "h2.ue-c-cover-content__headline";
		String webNoticiaOkDiarioN= "h2.segmento-title a";
		
		String webNoticiasEspanolI = "h2.art__title a";
		String webNoticiaMundoI = "h2.ue-c-cover-content__headline";
		String webNoticiaOkDiarioI = "h2.article-title";
		
		String webTecnologia1 = "h2.poster-title a";
		String webTecnologia2 = "h2.poster-title a";
		String webTecnologia3 = "h2.poster-title a";
		

		String webVideoJuegos = "div.titularportada b";
		String webGastronomia = "h2.poster-title a";
		String webCine = "a.title";
		
		Claves.add(webDeporte1);
		Claves.add(webDeporte2);
		Claves.add(webDeporte3);
		
		Claves.add(webEconomia1);
		Claves.add(webEconomia2);
		Claves.add(webEconomia3);
		
		Claves.add(webNoticiasEspanolN);
		Claves.add(webNoticiaMundoN);
		Claves.add(webNoticiaOkDiarioN);
		
		
		Claves.add(webNoticiasEspanolI);
		Claves.add(webNoticiaMundoI);
		Claves.add(webNoticiaOkDiarioI);
		
		Claves.add(webTecnologia1);
		Claves.add(webTecnologia2);
		Claves.add(webTecnologia3);

		Claves.add(webVideoJuegos);
		Claves.add(webGastronomia);
		Claves.add(webCine);
		
	}
	public static void guardadoEnlaces() {
		String webDeporte1 = "https://www.marca.com/";
		String webDeporte2 = "https://as.com/";
		String webDeporte3 = "https://okdiario.com/diariomadridista/";
		
		String webEconomia1 = "https://www.eleconomista.es/";
		String webEconomia2 = "https://www.elespanol.com/invertia/economia/";
		String webEconomia3 = "https://www.elmundo.es/economia.html";
		
		String webNoticiasEspanolN = "https://www.elespanol.com/";
		String webNoticiaMundoN = "https://www.elmundo.es/espana.html";
		String webNoticiaOkDiarioN= "https://okdiario.com/";
		
		String webNoticiasEspanolI = "https://www.elespanol.com/mundo/";
		String webNoticiaMundoI = "https://www.elmundo.es/internacional.html";
		String webNoticiaOkDiarioI = "https://okdiario.com/internacional/";
		
		String webTecnologia1 = "https://www.xataka.com/";
		String webTecnologia2 = "https://www.applesfera.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webTecnologia3 = "https://www.mundoxiaomi.com/?utm_source=genbeta&utm_medium=network&utm_campaign=favicons";
		

		String webVideoJuegos1 = "https://vandal.elespanol.com/";
		String webGastronomia = "https://www.directoalpaladar.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webCine = "https://www.sensacine.com/#utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		
		Enlaces.add(webDeporte1);
		Enlaces.add(webDeporte2);
		Enlaces.add(webDeporte3);
		
		Enlaces.add(webEconomia1);
		Enlaces.add(webEconomia2);
		Enlaces.add(webEconomia3);
		
		Enlaces.add(webNoticiasEspanolN);
		Enlaces.add(webNoticiaMundoN);
		Enlaces.add(webNoticiaOkDiarioN);
		
		
		Enlaces.add(webNoticiasEspanolI);
		Enlaces.add(webNoticiaMundoI);
		Enlaces.add(webNoticiaOkDiarioI);
		
		Enlaces.add(webTecnologia1);
		Enlaces.add(webTecnologia2);
		Enlaces.add(webTecnologia3);

		Enlaces.add(webVideoJuegos1);
		Enlaces.add(webGastronomia);
		Enlaces.add(webCine);
		
	}
	
	public static void GuardarTitulares() {
		Document documento;
		String resultado ="No existe";
		for(int i=0;i<Enlaces.size();i++) {
			try {
				documento = Jsoup.connect(Enlaces.get(i)).get();
				Element titular = documento.select(Claves.get(i)).get(0);
				resultado= titular.html().toUpperCase();
				Noticias.add(resultado);
	
			} catch (IOException e)  {
				e.getStackTrace();
				
			}
		}
		
		
	}
	public static void escribirConfiguracion(File fichero){
		guardadoClaves();
		guardadoEnlaces();
		
		try {
			FileWriter FicheroGuardadoEnlaces = new FileWriter(fichero);
             try (BufferedWriter escritura = new BufferedWriter(FicheroGuardadoEnlaces)) {
            	 escritura.write("WebsYclaves:");
				for (int i =0;i<Enlaces.size();i++) {
					if (i==0) {
						escritura.write(Claves.get(i));
					}
					escritura.write(";"+Enlaces.get(i));
				}
				for (int i =0;i<Claves.size();i++) {
					
					escritura.write(";"+Claves.get(i));
				}

			}
             FileWriter imprimirEspacio = new FileWriter(fichero,true);
             try (BufferedWriter imprimirSoloEspacio = new BufferedWriter(imprimirEspacio)) {
				imprimirSoloEspacio.write("\nEMAIL DE SALIDA:samcr9112@gmail.com\n"
						+ "CONTRASENIA EMAIL DE SALIDA:uyce vzdu gkpc rwov\n"
						+ "ID:1;1;1;1;1;1;1;1;1;1;1;1;1;1;1;1;1;1;1\n"
				 		+ "ID:3;0;1;0;1;0;1;0;1;0;1;0;1;0;1;0;1;0;1\n");
			}
	     } catch (IOException i) {
	         i.printStackTrace();
	     }
	}
	
	public static boolean lecturaConfiguracion(){
		boolean comprobacionConfiguracion = true;
		File fichero = new File("Usuarios//Configuracion.txt");
		
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			escribirConfiguracion(fichero);
		}
		
			if (fichero.exists()) {
				try {
					FileReader FicheroLecturaEnlacesYClaves= new FileReader(fichero);
					 try (BufferedReader lectura = new BufferedReader(FicheroLecturaEnlacesYClaves)) {
						 
						 int contadorUsuarios = 0;
				            String cadena;
				            while ((cadena = lectorArchivo.readLine()) != null){
				       
				                if (cadena.trim().isEmpty()) {//Para que salte lineas leidas que estan vacias.
				                
				                }else {
				                	String datosLimpios = null;
					                String rolDetectado = null;
			
					                Matcher matchAdmin = PATRON_ADMIN.matcher(cadena);
					                Matcher matchUser = PATRON_USER.matcher(cadena);
			
					                // Verificamos si coincide con alguno de los patrones de admin o user
					                if (matchAdmin.matches()) {
					                    rolDetectado = "admin";
					                    datosLimpios = matchAdmin.group(1); 
					                } else if (matchUser.matches()) {
					                    rolDetectado = "user";
					                    datosLimpios = matchUser.group(1);
					                    
					                }else {
					                	comprobacionUsuarios = false;
					    	        	return comprobacionUsuarios;
					                }
			
					                // Si se encontró un patrón válido, pasamos a leer el archivo linea por linea y dividirla separarla por ;
					                if (datosLimpios != null) {
					                   datosUsuariosTemporal = datosLimpios.split(";");
			
					                    if (datosUsuariosTemporal.length >= 4) {//Hacemos este if porque esperamos que hayan 4 campos y si hay menos saldria null y con el un posterior error
					                        String nombre = datosUsuariosTemporal[0];
					                        String contraseña = datosUsuariosTemporal[1];
					                        int preferencia = 0;
					                        contadorUsuarios+=1;
					                        try {
					                        	preferencia = Integer.parseInt(datosUsuariosTemporal[2]);
					                        } catch (NumberFormatException e) {
					                            System.err.println("Error de formato numérico: " + datosUsuariosTemporal[2]);
					                        }
					                        String email = datosUsuariosTemporal[3];
					                        Usuario nuevoUsuario = new Usuario(contadorUsuarios,nombre, contraseña, preferencia, email, rolDetectado);
					                        listaUsuarios.add(nuevoUsuario);
					                    }
					                }
				                }
				            }
					 
						
					}
					 return comprobacionConfiguracion;
			        } catch (IOException | ClassNotFoundException i) {
			            i.printStackTrace();
			        }
			}else {
				comprobacionConfiguracion = false;
				return comprobacionConfiguracion;
			}
			
			 return comprobacionConfiguracion;
		
		
	}
	
	public static boolean controlDeErrores(String palabra) {
		Pattern comprueba = Pattern.compile("^([a-zA-Z1-9]+)$");
		Matcher match = comprueba.matcher(palabra);
			if(match.find()) {
				return true;
			}
			return false;
	}


}
