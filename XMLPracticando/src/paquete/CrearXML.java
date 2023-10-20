package paquete;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearXML {
	 public static void CrearXML() {
		 try {
			    // Crea un objeto DocumentBuilderFactory
			    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			    
			    // Crea un objeto DocumentBuilder
			    DocumentBuilder builder = factory.newDocumentBuilder();
			    
			    // Crea un nuevo documento XML
			    Document document = builder.newDocument();
			    
			    // Crea el elemento ra�z
			    Element raiz = document.createElement("libros");
			    
			    // Agrega el elemento ra�z al documento
			    document.appendChild(raiz);
			    
			    // Crea elementos y atributos
			    Element libro = document.createElement("libro");
			    Element titulo = document.createElement("titulo");
			    Element autor = document.createElement("autor");
			    Element edadautor = document.createElement("edadautor");
			    Element paginas = document.createElement("paginas");
			    
			    
			    // Agrega elementos hijos al elemento ra�z
			    libro.appendChild(titulo);
			    libro.appendChild(autor);
			    libro.appendChild(paginas);
			    autor.appendChild(edadautor);
			    raiz.appendChild(libro);
			    
			    
			    // Crea un objeto Transformer para escribir el archivo XML
			    TransformerFactory transformerFactory = TransformerFactory.newInstance();
			    Transformer transformer = transformerFactory.newTransformer();
			    
			    // Crea un objeto DOMSource para el documento
			    DOMSource source = new DOMSource(document);
			    
			    // Crea un objeto StreamResult para el archivo XML de salida
			    File archivoXML = new File("coleccionlibros.xml");
			    StreamResult result = new StreamResult(archivoXML);
			    
			    // Transforma el documento a un archivo XML
			    transformer.transform(source, result);
			    
			    System.out.println("Archivo XML creado correctamente en " + archivoXML.getAbsolutePath());
			    
			} catch (Exception e) {
			    e.printStackTrace();
			}

	 }

}
