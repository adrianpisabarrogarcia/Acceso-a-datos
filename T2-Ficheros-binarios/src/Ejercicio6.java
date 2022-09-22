import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) {
        //Array de nombres de personas
        String[] nombres = {"Juan", "Pedro", "Maria", "Jose", "Luis", "Ana", "Rosa", "Luisa", "Miguel", "Carlos"};
        //Array de edades de personas
        int[] edades = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

        //Insertar datos en FichData.dat
        try {
            //Crear fichero
            File fichero = new File("./assets/FichData.dat");
            //Crear flujo de salida
            FileOutputStream fileout = new FileOutputStream(fichero);
            //Crear flujo de datos
            DataOutputStream dataOS = new DataOutputStream(fileout);

            //Escribir datos en el fichero
            for (int i = 0; i < nombres.length; i++) {
                dataOS.writeUTF(nombres[i]);
                dataOS.writeInt(edades[i]);
            }

            //Cerrar flujos
            dataOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}