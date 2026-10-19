package tm1_4;


import java.io.File;
import java.io.IOException;


import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class UD1_B4_T1_RubenSerralbo {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File f = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"AD"+System.getProperty("file.separator")+"bb", "peliculas.xml");
			Document document = builder.parse(f);
			NodeList list = document.getElementsByTagName("Pelicula");
			
			for (int i = 0; i < list.getLength(); i++) {
				Element e = (Element) list.item(i);
				
				System.out.println("TITULO----" + e.getElementsByTagName("Titulo").item(0).getTextContent());
				System.out.println("Fecha: " + e.getElementsByTagName("Fecha").item(0).getTextContent());
				System.out.println("Director: " + e.getElementsByTagName("Director").item(0).getTextContent());
				System.out.print("Autores principales: " + e.getElementsByTagName("Actores").item(0).getTextContent());
				System.out.println();
			}
			
			} catch (ParserConfigurationException | IOException | SAXException e) 
		{ e.printStackTrace();}
		
		
	}	
}
