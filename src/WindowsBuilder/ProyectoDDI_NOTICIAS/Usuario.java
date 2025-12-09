package ProyectoDDI_NOTICIAS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
	 	private static final Pattern PATRON_ADMIN = Pattern.compile("^admin:(.*?)(?://.*)?$");
	    private static final Pattern PATRON_USER = Pattern.compile("^user:(.*?)(?://.*)?$");
	    private static final Pattern PATRON_PREFERENCIAS = Pattern.compile("^UD%d:(.*?)(?://.*)?$");
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
	        File FicheroUsuarios = new File("src//Usuarios//Usuarios.txt");
	        
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

		                // Verificamos si coincide con alguno de los patrones de admin o user
		                if (matchAdmin.matches()) {
		                    rolDetectado = "admin";
		                    datosLimpios = matchAdmin.group(1); 
		                } else if (matchUser.matches()) {
		                    rolDetectado = "user";
		                    datosLimpios = matchUser.group(1);
		                }

		                // Si se encontró un patrón válido, procedemos a leer los datos y guardarlos en unun array temporal los trozos de strings leidos
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
				try (FileWriter escritura = new FileWriter(ficheroUsuarios,true)) {
					if (ContadorNuevoUsuario == 0) {
						for (Usuario UsuarioAEscribir : listaUsuarios) {
							String rol = UsuarioAEscribir.rol;
							String Nombre = UsuarioAEscribir.nombre;
							String Contraseña = UsuarioAEscribir.contraseña;
							int preferencias = UsuarioAEscribir.Preferencias;
							String Correo = UsuarioAEscribir.email;
							escritura.write(rol+":"+Nombre+";"+Contraseña+";"+preferencias+";"+Correo+"\n");
						}
						System.out.println("Introduce el rol del nuevo suario: Admin(1) o Usuario(2)");
						int rol = Funciones.controlErroresInt();
						System.out.println("Introduce el nombre del nuevo usuario: ");
						String Nombre = Funciones.entrada.nextLine();
						System.out.println("Introduce la contraseña del nuevo usuario: ");
						String Contraseña = Funciones.entrada.nextLine();
						int preferencias = 0;
						System.out.println("Introduce el correo del nuevo usuario: ");
						String Correo = Funciones.entrada.nextLine();
						System.out.println("Para darle las preferencias al usuario tendras que iniciar sesion con ese usuario.");
						escritura.write(rol+":"+Nombre+";"+Contraseña+";"+preferencias+";"+Correo+"\n");
					}else {
						for (Usuario UsuarioAEscribir : listaUsuarios) {
							String rol = UsuarioAEscribir.rol;
							String Nombre = UsuarioAEscribir.nombre;
							String Contraseña = UsuarioAEscribir.contraseña;
							int preferencias = UsuarioAEscribir.Preferencias;
							String Correo = UsuarioAEscribir.email;
							
							if (UsuarioAEscribir.nombre.equals(nombre)) {
									int idU = UsuarioAEscribir.id;
									escrituraPreferencias(idU);
							}
							escritura.write(rol+":"+Nombre+";"+Contraseña+";"+preferencias+";"+Correo+"\n");
							
						}
						
					}
				}
			}catch(IOException o){
				o.printStackTrace();
			}
		}
	    public static void escrituraPreferencias(int idUsuarioPN) {
	    	File ficheroPreferencias = new File("src//Usuarios//Preferencias.txt");
	    	try (FileReader archivoPREFERENCIAS = new FileReader(ficheroPreferencias);
		             BufferedReader lectorArchivo = new BufferedReader(archivoPREFERENCIAS)) {
		        	int contadorUsuarios = 0;
		            String cadena;
		            while ((cadena = lectorArchivo.readLine()) != null){
		       
		                if (cadena.trim().isEmpty()) {
		                
		                }else {
		                	String datosLimpios = null;
			                String rolDetectado = null;

			                Matcher matchPreferencias = PATRON_PREFERENCIAS.matcher(cadena);

			                // Verificamos si coincide con alguno de los patrones de admin o user
			                if (matchPreferencias.matches()) {
			                    rolDetectado = "ID";
			                    datosLimpios = matchPreferencias.group(1); 
			                }

			                // Si se encontró un patrón válido, procedemos a leer los datos y guardarlos en unun array temporal los trozos de strings leidos
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
	    	}catch(Exception i) {
	    		i.printStackTrace();
	    	}
	    }
	    
}
