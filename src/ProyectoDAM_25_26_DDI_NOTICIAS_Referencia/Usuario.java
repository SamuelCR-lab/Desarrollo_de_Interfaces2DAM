package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
	 	private static final Pattern PATRON_ADMIN = Pattern.compile("^administrador:(.*?)(?://.*)?$");
	    private static final Pattern PATRON_USER = Pattern.compile("^usuario:(.*?)(?://.*)?$");
	    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	    public static String[] datosUsuariosTemporal;


	    	int id;
	        String nombre;
	        String contraseña; 
	        int Preferencias; 
	        String email;
	        String rol; 

	        public Usuario(int id,String nombre, String contraseña, int Preferencias, String email, String rol) {
	            this.id=id;
	        	this.nombre = nombre;
	            this.contraseña = contraseña;
	            this.Preferencias = Preferencias;
	            this.email = email;
	            this.rol = rol;
	        }

		public static ArrayList<Usuario> lecturaUsuarios() {
			ArrayList<Usuario> comprobacionUsuarios = null;
	    
	        File FicheroUsuarios = new File("Usuarios//Usuarios.txt");
	        if (FicheroUsuarios.exists()) {
		        try (FileReader archivoUsuarios = new FileReader(FicheroUsuarios);
		             BufferedReader lectorArchivo = new BufferedReader(archivoUsuarios)) {
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
			                    rolDetectado = "administrador";
			                    datosLimpios = matchAdmin.group(1); 
			                } else if (matchUser.matches()) {
			                    rolDetectado = "usuario";
			                    datosLimpios = matchUser.group(1);
			                    
			                }else {
			                	comprobacionUsuarios = null;
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
			                        	e.getMessage();
			                        	comprobacionUsuarios = null;
				        	        	return comprobacionUsuarios;
			                        }
			                        String email = datosUsuariosTemporal[3];
			                        Usuario nuevoUsuario = new Usuario(contadorUsuarios,nombre, contraseña, preferencia, email, rolDetectado);
			                        listaUsuarios.add(nuevoUsuario);
			                        
			                    }else {
			                    	comprobacionUsuarios = null;
			        	        	return comprobacionUsuarios;
			                    }
			                }
		                }
		            } 
		            comprobacionUsuarios = listaUsuarios;
		        } catch (IOException i) {
		            i.printStackTrace();

		        }
	        }else {
	        	comprobacionUsuarios = null;
	        	return comprobacionUsuarios;
	        }
	        return comprobacionUsuarios;
	    }
	   public static void escrituraUsuarios(ArrayList <Usuario> arrayAImprimir) {
			File ficheroUsuarios = new File("Usuarios//Usuarios.txt");
			
				//Para que cuando se elimine o se cree un nuevo usuario solo se guarden los datos en el array donde los guardamos de froma temporal
				if (ficheroUsuarios.exists()) {
					try {
						ficheroUsuarios.delete();
						ficheroUsuarios.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					FileWriter escritura = new FileWriter(ficheroUsuarios,true);
					try (BufferedWriter escribirFichero = new BufferedWriter(escritura)){
						
							for (Usuario UsuarioAEscribir : arrayAImprimir) {
								String rol = UsuarioAEscribir.rol;
								String Nombre = UsuarioAEscribir.nombre;
								String Contraseña = UsuarioAEscribir.contraseña;
								int preferencias = UsuarioAEscribir.Preferencias;
								String Correo = UsuarioAEscribir.email;
		
								escribirFichero.write(rol+":"+Nombre+";"+Contraseña+";"+preferencias+";"+Correo+"\n");
							
						}
					}
			}catch(IOException o){
				o.printStackTrace();
			}
		}
	    
	    
}
