import javax.imageio.IIOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscribirFichObject {

    public static void escribirFichero(String ruta, ArrayList<Persona> personas) {
        try {
            //Crear fichero
            File fichero = new File(ruta);
            //Crear flujo de salida
            FileOutputStream fileout = new FileOutputStream(ruta);
            //Crear flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
            for (Persona persona : personas) {
                //Escribir datos en el fichero
                dataOS.writeObject(persona);
            }
            //Cerrar flujos
            dataOS.close();
        } catch (IIOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
