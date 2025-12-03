package ProyectoDDI_NOTICIAS;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Funciones {

	private static ArrayList <String> Noticias = new ArrayList<>(); 
	
	private static void guardadoWeb () {
		String webDeporte1 = "https://www.marca.com/";
		String webDeporte2 = "https://as.com/";
		String webDeporte3 = "https://www.sport.es/es/";
		String webDeporte4 = "https://www.mundodeportivo.com/";
		String webNoticiasEspanolN = "https://www.elespanol.com/";
		String webNoticiasEspanolI = "https://www.elespanol.com/mundo/";
		String webNoticiaMundoN = "https://www.elmundo.es/";
		String webNoticiaMundoI = "https://www.elmundo.es/internacional.html";
		String webNoticia3 = "https://www.abc.es/";
		String webNoticia4 = "https://elpais.com/";
		String webTecnologia1 = "https://www.xataka.com/";
		String webTecnologia2 = "https://www.applesfera.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webTecnologia3 = "https://www.xatakandroid.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webTecnologia4 = "https://www.genbeta.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webGastronomia = "https://www.directoalpaladar.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webVideoJuegos1 = "https://www.vidaextra.com/?utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webVideoJuegos2 = "https://www.3djuegospc.com/#utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		String webVideoJuegos3 = "https://vandal.elespanol.com/";
		String webCine = "https://www.sensacine.com/#utm_source=xataka&utm_medium=network&utm_campaign=favicons";
		
		
		
		
		
	}
	
	
	
	public static String BuscadorTitulares(String web) {
		
		Document documento;
		String resultado ="No existe";
		String palabraIntroducida = "";
		try {
			documento = Jsoup.connect(web).get();
			Elements palabraTraducida = documento.select("div#quickdef1-en a.tCur1iYh");
			if (palabraTraducida.isEmpty()) {
				palabraTraducida.add(traducirAIngles(palabraIntroducida));
				Element elementoPalabraTraducida=palabraTraducida.getLast();
				
				resultado=elementoPalabraTraducida.html().toUpperCase();
				System.out.println(resultado);
			}else {
				Element elementoPalabraTraducida=palabraTraducida.first();
				resultado=elementoPalabraTraducida.html().toUpperCase();
				System.out.println(resultado);
			}
			/*if (resultado.indent(0)==resultado.length()) {
				resultado=traducirAIngles(palabraIntroducida);
			}*/
		} catch (IOException e)  {
			e.printStackTrace();
			
		}
		return resultado;
	}



	private static Element traducirAIngles(String palabraIntroducida) {
		// TODO Auto-generated method stub
		return null;
	}
}
