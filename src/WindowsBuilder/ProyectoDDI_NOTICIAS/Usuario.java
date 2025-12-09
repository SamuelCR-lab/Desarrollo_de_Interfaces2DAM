package ProyectoDDI_NOTICIAS;

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
	 	private static final Pattern PATRON_ADMIN = Pattern.compile("^admin:(.*?)(?://.*)?$");
	    private static final Pattern PATRON_USER = Pattern.compile("^user:(.*?)(?://.*)?$");
	    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
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

	        @Override
	        public String toString() {
	            return "Rol: " + rol + ", Nombre: " + nombre + ", Contraseña: " + contraseña + ", Tipo: " + Preferencias + ", Email: " + email;
	        }
	   

	    public static void lecturaUsuarios() {
	        File FicheroUsuarios = new File("src//Usuarios.txt");
	        
	        try (FileReader archivoUsuarios = new FileReader(FicheroUsuarios);
	             BufferedReader lectorArchivo = new BufferedReader(archivoUsuarios)) {
	        	int contadorUsuarios = 0;
	            String cadena;
	            while ((cadena = lectorArchivo.readLine()) != null){
	       
	                if (cadena.trim().isEmpty()) {
	                
	                }else {
	                	String datosLimpios = null;
		                String rolDetectado = null;

		                Matcher matchAdmin = PATRON_ADMIN.matcher(cadena);
		                Matcher matchUser = PATRON_USER.matcher(cadena);

		                // Verificamos si coincide con alguno de los patrones
		                if (matchAdmin.matches()) {
		                    rolDetectado = "admin";
		                   
		                    datosLimpios = matchAdmin.group(1); 
		                } else if (matchUser.matches()) {
		                    rolDetectado = "user";
		                    datosLimpios = matchUser.group(1);
		                }

		                // Si se encontró un patrón válido, procesamos los datos
		                if (datosLimpios != null) {
		                   datosUsuariosTemporal = datosLimpios.split(";");

		                    if (datosUsuariosTemporal.length >= 4) {
		                        String nombre = datosUsuariosTemporal[0];
		                        System.out.println(nombre);
		                        String contraseña = datosUsuariosTemporal[1];
		                        System.out.println(contraseña);
		                        int preferencia = 0;
		                        contadorUsuarios++;
		                        try {
		                        	preferencia = Integer.parseInt(datosUsuariosTemporal[2]);
		                        } catch (NumberFormatException e) {
		                            System.err.println("Error de formato numérico: " + datosUsuariosTemporal[2]);
		                        }
		                        String email = datosUsuariosTemporal[3];

		                        Usuario nuevoUsuario = new Usuario(contadorUsuarios,nombre, contraseña, preferencia, email, rolDetectado);
		                        listaUsuarios.add(nuevoUsuario);
		                        
		                        System.out.println("Leído con Pattern: " + nuevoUsuario);
		                        
		                    }
		                }
	                }
	            } 

	        } catch (IOException i) {
	            System.err.println("Error leyendo el archivo Usuarios.txt");
	            i.printStackTrace();
	        }
	    }
	    public static void escrituraUsuarios(String nombre,int ContadorNuevoUsuario) {
			File ficheroUsuarios = new File("Usuarios.txt");
			try {
				
				if (ficheroUsuarios.exists()) {
					ficheroUsuarios.delete();
					ficheroUsuarios.createNewFile();
				}
				if (ContadorNuevoUsuario == 0) {
					
				}else {
					FileWriter escritura = new FileWriter(ficheroUsuarios);
					BufferedWriter escribirUsuarios = new BufferedWriter(escritura);
					for (Usuario UsuarioAEscribir : listaUsuarios) {
						if (UsuarioAEscribir.nombre.equals(nombre)) {
							UsuarioAEscribir.Preferencias = 1;
							int idU = UsuarioAEscribir.id;
							String Nombre = UsuarioAEscribir.nombre;
							String Contraseña = UsuarioAEscribir.contraseña;
							int preferencias = UsuarioAEscribir.Preferencias;
				
						}
					}
					
				}
			}catch(IOException o){
				o.printStackTrace();
			}
		}
	    
}
