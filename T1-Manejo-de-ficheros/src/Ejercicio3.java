import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio3 {


    public static void main(String[] args) {
        //Visualizar el contenido del archivo 'fichero.txt'

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            String ruta = "/Users/adrianpisabarrogarcia/Desktop/Git/Acceso-a-datos/T1-Manejo-de-ficheros/assets/";
            String nombreArchivo = "fichero.txt";
            archivo = new File (ruta + nombreArchivo);
            fr = new FileReader (archivo);
            int i;
            while((i = fr.read())!=-1){
                System.out.print(((char) i));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}

