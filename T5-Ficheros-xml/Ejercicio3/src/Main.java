import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        //Leer archivo XML
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        xstream.alias("DatosPersona", Persona.class);
        xstream.addImplicitCollection(ListaPersonas.class, "lista");


        try {
            FileInputStream fis = new FileInputStream("personas.xml");
            ListaPersonas personas = (ListaPersonas) xstream.fromXML(fis);
            System.out.println("Lista de personas: " + personas.getLista().size());
            for (Persona persona : personas.getLista()) {
                System.out.println(persona);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}