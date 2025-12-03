package ProyectoDDI_NOTICIAS;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Funciones {

	private static ArrayList <String> Noticias = new ArrayList<>(); 
	
	private static void guardadoWeb () {
		
		String webDeporte1 = "https://www.marca.com/";
		String webDeporte2 = "https://as.com/";
		String webDeporte3 = "https://www.sport.es/es/";
		String webDeporte4 = "https://www.mundodeportivo.com/";
		String webEconomia1 = "https://www.eleconomista.es/";
		String webEconomia2 = "https://www.expansion.com/";
		String webEconomia3 = "https://www.abc.es/economia/";
		String webEconomia4 = "https://www.elmundo.es/economia.html";
		String webNoticiasEspanolN = "https://www.elespanol.com/";
		String webNoticiasEspanolI = "https://www.elespanol.com/mundo/";
		String webNoticiaMundoN = "https://www.elmundo.es/";
		String webNoticiaMundoI = "https://www.elmundo.es/internacional.html";
		String webNoticiaABCN= "https://www.abc.es/";
		String webNoticiaABCI = "https://www.abc.es/internacional/";
		String webTecnologia1 = "https://www.xataka.com/";
		String webTecnologia2 = "https://www.applesfera.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webTecnologia3 = "https://www.xatakandroid.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webTecnologia4 = "https://www.genbeta.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webGastronomia = "https://www.directoalpaladar.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webVideoJuegos1 = "https://www.vidaextra.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webVideoJuegos2 = "https://www.3djuegospc.com/#utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webVideoJuegos3 = "https://vandal.elespanol.com/";
		String webCine = "https://www.sensacine.com/#utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		
		Noticias.add(webDeporte1);
		Noticias.add(webDeporte2);
		Noticias.add(webDeporte3);
		Noticias.add(webDeporte4);
		Noticias.add(webEconomia1);
		Noticias.add(webEconomia2);
		Noticias.add(webEconomia3);
		Noticias.add(webEconomia4);
		Noticias.add(webNoticiasEspanolN);
		Noticias.add(webNoticiasEspanolI);
		Noticias.add(webNoticiaMundoN);
		Noticias.add(webNoticiaMundoI);
		Noticias.add(webNoticiaABCN);
		Noticias.add(webNoticiaABCI);
		Noticias.add(webTecnologia1);
		Noticias.add(webTecnologia2);
		Noticias.add(webTecnologia3);
		Noticias.add(webTecnologia4);
		Noticias.add(webGastronomia);
		Noticias.add(webVideoJuegos1);
		Noticias.add(webVideoJuegos2);
		Noticias.add(webVideoJuegos3);
		Noticias.add(webCine);
		
	}
	
	
	
	public static String BuscadorTitulares() {
		
		Document documento;
		String resultado ="No existe";
		String clave = "h2 data-mrf-layout-title=";
		try {
			//for (String webs : Noticias) {
			documento = Jsoup.connect("https://www.marca.com/").get();
			Element titular = documento.select(clave).get(0);
			resultado=titular.html().toUpperCase();
			System.out.println(resultado);
			/*if (resultado.indent(0)==resultado.length()) {
				resultado=traducirAIngles(palabraIntroducida);
			}*/
			//}
		} catch (IOException e)  {
			e.printStackTrace();
			
		}
		return resultado;
	}



}
