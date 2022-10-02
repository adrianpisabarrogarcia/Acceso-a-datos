import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AnadirElementoAleatorio {
    static final int POSICION_CADA_ELEMENTO = 36;

    public static void main(String[] args) throws FileNotFoundException {
        try {

            //Random Access File
            RandomAccessFile raf = new RandomAccessFile("empleados.dat", "rw");

            //Pedimos los datos de un nuevo empleado
            String[] nuevoEmpleado = entradaEmpleado();

            //Escribimos el nuevo empleado
            insertarEmpleado(nuevoEmpleado, raf);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int ultimoID(RandomAccessFile raf) throws IOException {
        //Posicionarse en el 0
        raf.seek(0);
        int posicion = (int) raf.getFilePointer();
        int id = 1;

        while (posicion < raf.length()) {
            //Identificador de registro
            id = raf.readInt();
            raf.seek(posicion + POSICION_CADA_ELEMENTO);
            posicion = posicion + POSICION_CADA_ELEMENTO;
        }
        return id;
    }


        private static void insertarEmpleado(String[] empleado, RandomAccessFile raf) {
        try {
            raf.seek(raf.length());

            //Crear un identificador de registro
            int id = ultimoID(raf) + 1;
            //Escribir el identificador en 4 bytes
            raf.writeInt(id);
            //Escribir el apellido en 20 bytes
            String apellido = empleado[0];
            if (apellido.length() > 20) {
                apellido = apellido.substring(0, 20);
            } else {
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

            //Traza
            System.out.println("Numero de bytes que tiene el archivo: " + raf.length());

        } catch (Exception e) {
            System.out.println("Error al escribir en el fichero");
        }


    }


    public static String[] entradaEmpleado() {
        Scanner entrada = new Scanner(System.in);
        String[] empleado = new String[3];

        try {

            System.out.println("Escribe un appellido:");
            empleado[0] = entrada.nextLine();

            System.out.println("Escribe un departamento (entero):");
            empleado[1] = entrada.nextLine();
            int departamento = Integer.parseInt(empleado[1]);

            System.out.println("Escribe un salario (decimal):");
            empleado[2] = entrada.nextLine();
            double salario = Double.parseDouble(empleado[2]);

        } catch (NumberFormatException e) {
            System.out.println("El departamento y el salario deben de ser un número");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return empleado;

    }
}