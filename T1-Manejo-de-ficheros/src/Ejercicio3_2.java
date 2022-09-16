import java.io.*;

public class Ejercicio3_2 {
    public static void main(String[] args) {
        //Visualizar el contenido del archivo 'fichero.txt'

        File archivo;
        FileReader fr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            String ruta = "/Users/adrianpisabarrogarcia/Desktop/Git/Acceso-a-datos/T1-Manejo-de-ficheros/assets/";
            String nombreArchivo;

            //Introduce el nombre del archivo desde terminal
            System.out.print("Introduce el nombre del archivo: ");
            nombreArchivo =  br.readLine();

            //Lectura del archivo
            archivo = new File (ruta + nombreArchivo);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del cada linea del fichero
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
        }
        //File not found exception
        catch(FileNotFoundException e){
            System.out.println("El archivo no existe");
        }
        //IOException
        catch(IOException e){
            System.out.println("Error de entrada/salida");
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

