import java.io.*;

public class Ejercicio1 {


    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            String ruta = "/Users/adrianpisabarrogarcia/Desktop/Git/Acceso-a-datos/T1-Manejo-de-ficheros/assets/";
            System.out.print("Introduce el nombre del archivo: ");
            String nombreArchivo =  br.readLine();

            archivo = new File (ruta + nombreArchivo);


            //Nombre del archivo
            System.out.println("Nombre del archivo: " + archivo.getName());
            //Ruta del archivo
            System.out.println("Ruta del archivo: " + archivo.getPath());
            //Ruta absoluta del archivo
            System.out.println("Ruta absoluta del archivo: " + archivo.getAbsolutePath());
            //Tamaño del archivo
            System.out.println("Tamaño del archivo: " + archivo.length());
            //¿Lectura?
            System.out.println("¿Lectura?: " + archivo.canRead());
            //¿Escritura?
            System.out.println("¿Escritura?: " + archivo.canWrite());
            //¿Es un directorio?
            System.out.println("¿Es un directorio?: " + archivo.isDirectory());
            //¿Es un archivo?
            System.out.println("¿Es un archivo?: " + archivo.isFile());



        }
        catch (FileNotFoundException e){
            System.out.println("El archivo no existe");
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

