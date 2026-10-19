package tm1_4;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UD1_B4_T2_RubenSerralbo {

	public static ArrayList<Pelicula> cargarPeliculas(File f) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Pelicula");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemPelicula = (Element) node;
                    Pelicula p = new Pelicula();

                    
                    NodeList nlTitulo = elemPelicula.getElementsByTagName("Titulo");
                    if (nlTitulo.getLength() == 0 || nlTitulo.item(0).getTextContent().trim().isEmpty()) {
                        throw new NullPointerException("El título es un elemento requerido en el XML.");
                    }
                    p.setTitulo(nlTitulo.item(0).getTextContent().trim());
                 

              
                    NodeList nlDuracion = elemPelicula.getElementsByTagName("Duracion");
                    if (nlDuracion.getLength() > 0) {
                        String txt = nlDuracion.item(0).getTextContent().trim();
                        if (!txt.isEmpty()) {
                            p.setDuracion(Integer.parseInt(txt));
                        }
                    }

                
                    NodeList nlGenero = elemPelicula.getElementsByTagName("Genero");
                    if (nlGenero.getLength() > 0) {
                        p.setGenero(nlGenero.item(0).getTextContent().trim());
                    }

                  
                    NodeList nlSinopsis = elemPelicula.getElementsByTagName("sinopsis");
                    if (nlSinopsis.getLength() > 0) {
                        String textoSinopsis = nlSinopsis.item(0).getTextContent();
                       
                        textoSinopsis = textoSinopsis.replaceAll("[\\r\\n\\t]+", " ").replaceAll("\\s+", " ").trim();
                        p.setSinopsis(textoSinopsis);
                    }

                   
                    NodeList nlActores = elemPelicula.getElementsByTagName("Actor");
                    for (int j = 0; j < nlActores.getLength(); j++) {
                        String nombreActor = nlActores.item(j).getTextContent().trim();
                        if (!nombreActor.isEmpty()) {
                            p.getActores().add(nombreActor);
                        }
                    }

                
                    NodeList nlFecha = elemPelicula.getElementsByTagName("Fecha");
                    if (nlFecha.getLength() > 0) {
                        String txt = nlFecha.item(0).getTextContent().trim();
                        if (!txt.isEmpty()) {
                            p.setFecha(Integer.parseInt(txt));
                        }
                    }

                    
                    NodeList nlDirector = elemPelicula.getElementsByTagName("Director");
                    if (nlDirector.getLength() > 0) {
                        p.setDirector(nlDirector.item(0).getTextContent().trim());
                    }

                    listaPeliculas.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPeliculas;
    }

    public static void main(String[] args) {
    	File f = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"AD"+System.getProperty("file.separator")+"bb", "peliculas.xml");
        
        if (f.exists()) {
            ArrayList<Pelicula> peliculas = cargarPeliculas(f);
            
            System.out.println("--- LISTA DE PELÍCULAS ---");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
        } else {
            System.out.println("El archivo 'peliculas.xml' no se encuentra en la raíz del proyecto.");
        }
    }

}
