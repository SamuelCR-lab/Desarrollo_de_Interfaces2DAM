package ProyectoDDI_NOTICIAS;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Funciones {

	public static ArrayList <String> Noticias = new ArrayList<>(); 
	private static ArrayList <String> Enlaces = new ArrayList<>(); 
	private static ArrayList <String> Claves = new ArrayList<>(); 
	
	private static void guardadoClaves () {
		
		String webDeporte1 = "h2.ue-c-cover-content__headline";
		String webDeporte2 = "h3.s_t a";
		String webDeporte3 = "h2.title a";
		
		String webEconomia1 = "h2.h1 a";
		String webEconomia2 = "h2.art__title a";
		String webEconomia3 = "h2.ue-c-cover-content__headline";
		
		String webNoticiasEspanolN = "h2.art__title a";
		String webNoticiaMundoN = "h2.ue-c-cover-content__headline";
		String webNoticiaElPais= "h2.c_t a";
		
		String webNoticiasEspanolI = "h2.art__title a";
		String webNoticiaMundoI = "h2.ue-c-cover-content__headline";
		String webNoticiaElPaisI = "h2.c_t a";
		
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
		Claves.add(webNoticiaElPais);
		
		
		Claves.add(webNoticiasEspanolI);
		Claves.add(webNoticiaMundoI);
		Claves.add(webNoticiaElPaisI);
		
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
		String webDeporte3 = "https://www.mundodeportivo.com/";
		
		String webEconomia1 = "https://www.eleconomista.es/";
		String webEconomia2 = "https://www.elespanol.com/invertia/economia/";
		String webEconomia3 = "https://www.elmundo.es/economia.html";
		
		String webNoticiasEspanolN = "https://www.elespanol.com/";
		String webNoticiaMundoN = "https://www.elmundo.es/espana.html";
		String webNoticiaElPaisN= "https://elpais.com/espana/";
		
		String webNoticiasEspanolI = "https://www.elespanol.com/mundo/";
		String webNoticiaMundoI = "https://www.elmundo.es/internacional.html";
		String webNoticiaElPaisI = "https://elpais.com/internacional/";
		
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
		Enlaces.add(webNoticiaElPaisN);
		
		
		Enlaces.add(webNoticiasEspanolI);
		Enlaces.add(webNoticiaMundoI);
		Enlaces.add(webNoticiaElPaisI);
		
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
		guardadoEnlaces();
		guardadoClaves();
		
		Document documento;
		String resultado ="No existe";
		/*String webMarca = Enlaces.get(0);
		String clave = Claves.get(0);*/
		System.out.println(Enlaces.size());
		for(int i=0;i<Enlaces.size();i++) {
			try {
				//for (String webs : Noticias) {
				documento = Jsoup.connect(Enlaces.get(i)).get();
				Element titular = documento.select(Claves.get(i)).get(0);
				resultado=titular.html().toUpperCase();
				Noticias.add(resultado);
				System.out.println(resultado);
	
			} catch (IOException e)  {
				e.getStackTrace();
				
			}
		}
		
		//return Noticias;
	}



}
