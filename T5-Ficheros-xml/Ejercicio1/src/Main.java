import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //Obtenemos los empleados del fichero empleados.dat
        LeerFicheroAleatorio leerFicheroAleatorio = new LeerFicheroAleatorio();
        ArrayList<Empleado> empleados = leerFicheroAleatorio.listaEmpleados();

        //Creamos el documento XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //Creamos el documento
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");

            //se añaden los hijos al nodo raiz
            for (Empleado empleado : empleados) {
                //Crea y añade el nodo empleado al documento
                Element raiz = document.createElement("empleado"); //nodo empleado
                document.getDocumentElement().appendChild(raiz); //lo añade a la raíz del documento
                crearElemento("id", Integer.toString(empleado.getId()), raiz, document);
                crearElemento("apellido", empleado.getApellido(), raiz, document);
                crearElemento("departamento", Integer.toString(empleado.getDepartamento()), raiz, document);
                crearElemento("salario", Double.toString(empleado.getSalario()), raiz, document);
            }

            //Creamos el fichero XML
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("empleados.xml")); //nombre del fichero
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println("Error al crear el documento XML");
        }
    }


    static void crearElemento(String datoEmple, String valor, Element raiz, Document document)
    {
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}