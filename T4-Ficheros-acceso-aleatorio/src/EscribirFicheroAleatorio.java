import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EscribirFicheroAleatorio {
    public static void main(String[] args) throws FileNotFoundException {
        //Random Access File
        RandomAccessFile raf = new RandomAccessFile("empleados.dat", "rw");

        //Generar un array de strings
        String empleado1[] = {"Perez", "1", "2"};
        String empleado2[] = {"Garcia", "2", "15"};
        String empleado3[] = {"Lopez", "3", "18"};

        //Escribir en el fichero
        try {
            //Crear un identificador de registro
            int id = 1;
            //Escribir el registro
            for (String empleado[] : new String[][]{empleado1, empleado2, empleado3}) {
                //Escribir el identificador en 4 bytes
                raf.writeInt(id);
                //Escribir el apellido en 20 bytes
                String apellido = empleado[0];
                if(apellido.length() > 20){
                    apellido = apellido.substring(0, 20);
                }else {
                    for (int i = apellido.length(); i < 20; i++) {
                        apellido += " ";
                    }
                }
                //To unicode
                byte[] b = apellido.getBytes("UTF-8");
                raf.write(b);

                //Escribir el departamento
                int departamento = Integer.parseInt(empleado[1]);
                raf.writeInt(departamento);

                //Escribir el salario
                double salario = Double.parseDouble(empleado[2]);
                raf.writeDouble(salario);

                //Incrementar el identificador
                id++;
            }

            //Traza
            System.out.println("Numero de bytes que tiene el archivo: " + raf.length());

        } catch (Exception e) {
            System.out.println("Error al escribir en el fichero");
        }
    }
}