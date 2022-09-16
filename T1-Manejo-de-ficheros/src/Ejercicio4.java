import java.io.*;
import java.lang.reflect.Array;

public class Ejercicio4 {
    public static void main(String[] args) {
        File archivo;
        FileReader fr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            String ruta = "/Users/adrianpisabarrogarcia/Desktop/Git/Acceso-a-datos/T1-Manejo-de-ficheros/assets/";
            String nombreArchivo = "escribirfichero.txt";

            //String que va a contener el contenido del archivo
            String contenido = "AdrianProgramaSuperBien";
            char[] contenidoCharArray = contenido.toCharArray();

            //Lectura del archivo
            archivo = new File (ruta + nombreArchivo);
            fr = new FileReader (archivo);

            // Escritura del archivo
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < contenidoCharArray.length; i++) {
                bw.write(contenidoCharArray[i]);
                if (i == contenidoCharArray.length - 1)
                    System.out.println("El archivo se ha escrito correctamente");
            }
            bw.close();
        }
        //File not found exception
        catch(FileNotFoundException e){
            System.out.println("El archivo no existe");
        }
        //General exception
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

