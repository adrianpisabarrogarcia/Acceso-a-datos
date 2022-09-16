import java.io.*;

public class Ejercicio2 {


    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            String ruta = "/Users/adrianpisabarrogarcia/Desktop/Git/Acceso-a-datos/T1-Manejo-de-ficheros/assets/";

            //Crear un directorio
            System.out.print("Introduce el nombre del directorio: ");
            String nombreDirectorio =  br.readLine();
            File directorio = new File(ruta + nombreDirectorio);
            if(directorio.mkdir()){
                System.out.println("Directorio " + nombreDirectorio + " creado");
            }else{
                System.out.println("No se ha podido crear el directorio " + nombreDirectorio);
            }

            String nombreArchivo = "";
            for (int i = 0; i < 2; i++) {
                //Crear un archivo
                System.out.print("Introduce el nombre del archivo: ");
                nombreArchivo =  br.readLine();
                File archivoNuevo = new File(ruta + nombreDirectorio + "/" + nombreArchivo);
                if(archivoNuevo.createNewFile()){
                    System.out.println("Archivo " + nombreArchivo + " creado");
                }else{
                    System.out.println("El archivo " + nombreArchivo + " ya existe");
                }
                Thread.sleep(3000);

            }

            //Eliminar un archivo
            File archivoEliminar = new File(ruta + nombreDirectorio + "/" + nombreArchivo);
            if(archivoEliminar.delete()){
                System.out.println("No se ha podido eliminar el archivo "+nombreArchivo);
            }else{
                System.out.println("El archivo " + nombreArchivo + " ya existe");
            }

            Thread.sleep(3000);

            //Eliminar un directorio
            if(directorio.delete()){
                System.out.println("Directorio " + nombreDirectorio + " eliminado");
            }else{
                System.out.println("No se ha podido eliminar el directorio, comprueba que este vacio");
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

