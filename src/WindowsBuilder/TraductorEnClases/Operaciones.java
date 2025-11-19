package TraductorEnClases;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	
	public static String traducir (String palabraIntroducida) {
		String web = "https://www.spanishdict.com/translate/"+palabraIntroducida;
		Document documento;
		String resultado ="No existe";
		try {
			documento = Jsoup.connect(web).get();
			Element palabraTraducida = documento.select("div#quickdef1-en a.tCur1iYh").get(0);
			resultado=palabraTraducida.html().toUpperCase();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}


}
