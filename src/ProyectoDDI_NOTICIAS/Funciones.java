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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Funciones {


	public static ArrayList <String> Noticias = new ArrayList<>(); 
	private static ArrayList <String> Enlaces = new ArrayList<>(); 
	private static ArrayList <String> Claves = new ArrayList<>(); 
    public static Scanner entrada = new Scanner(System.in);
    
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
	public static void buscadorCategoria(int categoria) {
		String titular = "";
		switch(categoria) {
			case 1: 
				
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
				
		}
		
		
		
	}
	
	public static void BuscadorTitulares() {
		//ArrayList<String>
		
		Document documento;
		String resultado ="No existe";
		/*String webMarca = Enlaces.get(0);
		String clave = Claves.get(0);
		System.out.println(Enlaces.size());*/
		for(int i=0;i<Enlaces.size();i++) {
			try {
				//for (String webs : Noticias) {
				documento = Jsoup.connect(Enlaces.get(i)).get();
				Element titular = documento.select(Claves.get(i)).get(0);
				resultado= titular.html().toUpperCase();
				Noticias.add(resultado);
				System.out.println(Noticias.get(i));
	
			} catch (IOException e)  {
				e.getStackTrace();
				
			}
		}
		
		
	}
	public static void escribirWebs(File fichero){
		guardadoClaves();
		guardadoEnlaces();
		
		try {
			 FileOutputStream FicheroGuardadoEnlaces = new FileOutputStream(fichero);
             try (ObjectOutputStream escritura = new ObjectOutputStream(FicheroGuardadoEnlaces)) {
				escritura.writeObject(Enlaces);
				escritura.writeObject(Claves);
			}
	        } catch (IOException i) {
	            i.printStackTrace();
	        }
	}
	
	public static void lecturaWebs(){
		File dir = new File("Medios");
		File fichero = new File("Medios//EnlacesWeb.txt");
		try {	
			if (!dir.exists()) {
				dir.mkdir();
				
			}
			if(!fichero.exists()) {
				fichero.createNewFile();
				escribirWebs(fichero);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 FileInputStream FicheroLecturaEnlacesYClaves= new FileInputStream(fichero);
			 try (ObjectInputStream lectura = new ObjectInputStream(FicheroLecturaEnlacesYClaves)) {
				Enlaces= (ArrayList<String>) lectura.readObject();
				Claves = (ArrayList<String>) lectura.readObject();
			}
			
	        } catch (IOException | ClassNotFoundException i) {
	            i.printStackTrace();
	        }
		BuscadorTitulares();
		
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
