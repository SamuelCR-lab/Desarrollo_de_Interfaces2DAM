package ProyectoDAM_25_26_DDI_NOTICIAS_Referencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Funciones {

	public static String correoSalida = "";
    public static String contraseniaSalida = "";
	public static ArrayList <String> Noticias = new ArrayList<>(); 
	private static ArrayList <String> Enlaces = new ArrayList<>(); 
	private static ArrayList <String> Claves = new ArrayList<>(); 
    private static String[] datosConfiguracionTemporal;
    
    public static boolean GuardarTitulares() {
		boolean comprobacionArray = true;
		Document documento;
		String resultado ="No existe";
		for(int i=0;i<Enlaces.size();i++) {
			try {
				documento = Jsoup.connect(Enlaces.get(i)).get();
				Element titular = documento.select(Claves.get(i)).get(0);
				resultado= titular.html().toUpperCase();
				Noticias.add(resultado);

			} catch (IOException | IllegalArgumentException e)  {
				e.getStackTrace();
				comprobacionArray = false;
					return comprobacionArray;
			}
		}
		return comprobacionArray;
		
	}
	
	public static boolean lecturaConfiguracion(){
		boolean comprobacionConfiguracion = true;
		File fichero = new File("Usuarios//Configuracion.txt");
			if (fichero.exists()) {
				try {
					FileReader FicheroLecturaEnlacesYClaves= new FileReader(fichero);
					 try (BufferedReader lecturaEnlacesYClaves = new BufferedReader(FicheroLecturaEnlacesYClaves)) {
						 
				            String cadena;
				            if((cadena = lecturaEnlacesYClaves.readLine()) != null){
				       
				          
				                	String datosLimpios = null;
			
				                	if (cadena.startsWith("WebsYclaves:")) {
					                    datosLimpios = cadena.substring("WebsYclaves:".length()).trim(); 
					                }else {
					                	comprobacionConfiguracion = false;
					    	        	return comprobacionConfiguracion;
					                }
			
					                // Si se encontró un patrón válido, pasamos a leer el archivo linea por linea y dividirla separarla por ;
					                if (datosLimpios != null) {
					                	datosConfiguracionTemporal = datosLimpios.split(";");
					                    if (datosConfiguracionTemporal.length >= 36) {//Hacemos este if porque esperamos que hayan 4 campos y si hay menos saldria null y con el un posterior error
					                        
					                    	for(int i = 0;i<datosConfiguracionTemporal.length;i++) {
					                    		if(i<18) {
					                    			String enlace = datosConfiguracionTemporal[i];
					                    			Enlaces.add(enlace);
					                    		}else {
					                    			String clave = datosConfiguracionTemporal[i];
					                    			Claves.add(clave);
					                    		}
					                    	}
					                   
					                    }
					                }
				                
				            }
					 }
					 boolean confirmacionArrayNoticias = GuardarTitulares();
					 if (confirmacionArrayNoticias == false){
						 comprobacionConfiguracion = false;
						return comprobacionConfiguracion;
					 }
			       } catch (IOException i) {
			           i.printStackTrace();
			         
			       }
			}else {
				comprobacionConfiguracion = false;
				return comprobacionConfiguracion;
			}
			
			 return comprobacionConfiguracion;
		
		
	}
	public static boolean lecturaCorreoClave() {
		boolean comprobacionCorreoClaveSalida = true;
		File ficheroConfiguracion = new File("Usuarios//Configuracion.txt");
    	try (FileReader archivoConfiguracion = new FileReader(ficheroConfiguracion);
	            BufferedReader lectorArchivo = new BufferedReader(archivoConfiguracion)) {
	            String cadena;
	            int contadorEncontrados=0;
	            	while ((cadena = lectorArchivo.readLine()) != null){
	            		
	            		cadena = cadena.trim();
	            		//Lee las lineas vacias y no pasa nada no guarda ni incrementa nada es solo vacio hasta que sea null el readline del while
		                if (!cadena.isEmpty()){

		                	//Aqui al ser una cadena sencilla lo hago con el StartWith para que compare entre cadenas y si exite pues cogemos la cadena que existe despues del StartWith con el substring 
			                if (cadena.startsWith("EMAIL DE SALIDA:")) {
			                	contadorEncontrados++;
			                	correoSalida = cadena.substring("EMAIL DE SALIDA:".length()).trim();
			                }else if (cadena.startsWith("CONTRASENIA EMAIL DE SALIDA:")) {
			                	contadorEncontrados++;
			                    contraseniaSalida = cadena.substring("CONTRASENIA EMAIL DE SALIDA:".length()).trim();
			                }
		                }
	            	}
	            	
	            	if ((contadorEncontrados < 2)||(controlCorreo(correoSalida)==false)) {
	            		comprobacionCorreoClaveSalida = false;
	    	        	return comprobacionCorreoClaveSalida;
	            	}
		} catch (IOException | PatternSyntaxException e) {
			e.printStackTrace();
			comprobacionCorreoClaveSalida = false;
        	return comprobacionCorreoClaveSalida;
		}
    	return comprobacionCorreoClaveSalida;
	}
	public static boolean controlDeErrores(String palabra) {
        if (palabra == null || palabra.trim().isEmpty()) {
            return false; // Rechaza vacíos inmediatamente
        }
        //Agregue las ñ y Ñ porque dentro del a-z y A-Z no existe y si el administrador escribia un nuevo usuario con Ñ en el nombre iba a dar error 
        Pattern comprueba = Pattern.compile("^([a-zA-Z0-9]+)$");
        
        Matcher match = comprueba.matcher(palabra);
        return match.find();
    }


    // Para el correo del nuevo usuario he tenido buscar otra expresion que permita el @ y que si no lo utiliza de error 
    public static boolean controlCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) { //Comprobamos que no este vacio el campo al darle crear usuario
        	return false;
        }else {
        	 // Debido a que Este patrón busca: texto + @ + texto + . + texto
            Pattern pat = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            Matcher mat = pat.matcher(correo);
            boolean patronEncontrado = mat.find();
            return patronEncontrado;
        }
    }
    public static void Historial(ArrayList <Usuario> guardarHistorial,String nombreUsuario,String noticias) {
    	File historico = new File("Usuarios//Historico.txt");
    	if (!historico.exists()) {
    		try {
				historico.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

    	try(FileWriter historicoAEscribir = new FileWriter(historico,true);
    			BufferedWriter escrituraHistorico = new BufferedWriter(historicoAEscribir)){
    		for(Usuario buscarIDUsuario : guardarHistorial) {
    			if(buscarIDUsuario.nombre.equals(nombreUsuario)) {
		    		LocalTime horaGuardada = java.time.LocalTime.now();
		    		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");//Usamos el Date Time Fromatter para darle un formato mas legible, que de la forma de local time salen mili y nano segundos
		    		 String HoraDefnitiva = horaGuardada.format(formato);
		    		escrituraHistorico.write("Noticias del Usuario de nombre : "+buscarIDUsuario.nombre+" y id = "+buscarIDUsuario.id+"\nA la hora : "+HoraDefnitiva+"\n"+noticias+"\n");
    			}
    		}
    	}catch (IOException o){
    		JOptionPane.showMessageDialog(null, "Error escribiendo el historial del usuario: " + o.getMessage());
    	}
    	
    }
    
    public static void iniciarCorreoHoraEstipuladaConTimer() {

			Timer temporizador = new Timer(10,new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String correoAdmin = "";
					ArrayList <Usuario> correoAEnviar = Usuario.lecturaUsuarios();
					for (Usuario a : correoAEnviar) {
						if(a.rol.equals("administrador")) {
							correoAdmin = a.email;
							MostradorNoticias.ComprobacionDePreferencias(a.nombre,correoAEnviar);
						}
					}
					
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP de GMAIL en este caso
					props.put("mail.smtp.socketFactory.port", "465"); //PUERTO SSL 
					props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
					props.put("mail.smtp.auth", "true"); //ACTIVAR SMTP AUTENTIFICACI�N
					props.put("mail.smtp.port", "465"); //SMTP Port		
					Authenticator auth = new Authenticator() {		
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(Funciones.correoSalida, Funciones.contraseniaSalida);
						}
					};		
					LocalTime horaGuardada = java.time.LocalTime.now();
		    		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");//Usamos el Date Time Fromatter para darle un formato mas legible, que de la forma de local time salen mili y nano segundos
		    		 String HoraDefnitiva = horaGuardada.format(formato);
		    		 Session session = Session.getDefaultInstance(props, auth);//CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL "LOGIN"
					if (HoraDefnitiva.equals("13:50:00")) {
						admin.sendEmail(session, correoAdmin,"NOTICIAS DAM", "Las Noticias actuales de tu preferencias.\nA fecha :"+HoraDefnitiva+"\n"+MostradorNoticias.MostradoNoticias);
					}
				}
			});

    }

}
