import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        //Creación de lista de personas
        ListaPersonas personas = listaPersonas();

        //Xstream para crear archivo XML
        XStream xstream = new XStream();
        //cambiar de nombre a las etiquetas XML
        xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        xstream.alias("DatosPersona", Persona.class);
        //Quitar etiwueta lista (atributo de la clase ListaPersonas)
        xstream.addImplicitCollection(ListaPersonas.class, "lista");
        //Insertar los objetos en el XML
        try {
            xstream.toXML(personas, new FileOutputStream("personas.xml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ListaPersonas listaPersonas(){
        ListaPersonas listaper = new ListaPersonas();

        listaper.add(new Persona("Juan", 20));
        listaper.add(new Persona("Pedro", 30));
        listaper.add(new Persona("Maria", 40));
        listaper.add(new Persona("Luis", 50));
        listaper.add(new Persona("Ana", 60));
        return listaper;

    }
}