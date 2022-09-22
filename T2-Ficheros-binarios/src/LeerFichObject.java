import java.io.*;
import java.util.ArrayList;

public class LeerFichObject {
    public static ArrayList<Persona> leerFichero(String rutaFichero) {
        try {
            //Comprobar si el fichero existe
            File fichero = new File(rutaFichero);
            if (!fichero.exists()) {
                throw new IOException("El fichero no existe");
            }

            //Leer fichero
            ArrayList<Persona> personas = new ArrayList<>();
            //Crear flujo de entrada
            FileInputStream filein = new FileInputStream(rutaFichero);
            //Crear flujo de datos
            ObjectInputStream dataIS = new ObjectInputStream(filein);
            //Leer datos del fichero
            while (filein.available() != 0) {
                personas.add((Persona) dataIS.readObject());
            }
            return personas;

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Cerrar flujos
        return null;
    }
}
