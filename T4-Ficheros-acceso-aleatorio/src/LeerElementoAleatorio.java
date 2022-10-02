import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class LeerElementoAleatorio {
    static final int POSICION_CADA_ELEMENTO = 36;

    public static void main(String[] args) throws IOException {
        try {
            //Pedimos un id de un elemento
            int id = entradaIdentificador();

            //Abrimos el fichero para encontrarlo
            RandomAccessFile raf = new RandomAccessFile("empleados.dat", "r");
            if (encontrado(id, raf)) {
                System.out.println("Encontrado");
                //Mostar el elemento encontrado
                mostrarElemento(id, raf);
            } else {
                System.out.println("No encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al acceder al fichero");
        }
    }

    public static void mostrarElemento(int id, RandomAccessFile raf) throws IOException {
        int posicion = POSICION_CADA_ELEMENTO * id;
        raf.seek(posicion - POSICION_CADA_ELEMENTO);

        //Identificador de registro
        id = 0;
        id = raf.readInt();
        System.out.println("ID: " + id);

        //Apellido
        String apellido = "";
        byte[] b = new byte[20];
        raf.read(b);
        apellido = new String(b, "UTF-8");
        System.out.println("Apellido: " + apellido);

        //Departamento
        int departamento = 0;
        departamento = raf.readInt();
        System.out.println("Departamento: " + departamento);

        //Salario
        double salario = 0;
        salario = raf.readDouble();
        System.out.println("Salario: " + salario);
    }

    public static boolean encontrado(int idConsola, RandomAccessFile raf) throws IOException {

        //Posicionarse en el 0
        raf.seek(0);

        int posicion = 0;
        while (posicion < raf.length()) {
            //Identificador de registro
            int id = 0;
            id = raf.readInt();

            if (id == idConsola) {
                raf.seek(posicion);
                return true;
            }
            raf.seek(posicion + POSICION_CADA_ELEMENTO);
            posicion = posicion + POSICION_CADA_ELEMENTO;
        }
        return false;
    }


    public static int entradaIdentificador() {
        String identificador = "";
        int id = 0;

        try {
            System.out.println("Elige un elemento a leer con su identificador:");
            //Input del usuario
            Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
            identificador = entradaEscaner.nextLine();
            if (identificador.length() > 4) {
                System.out.println("El identificador debe tener 4 caracteres");
                System.exit(0);
            }
            id = Integer.parseInt(identificador);
        } catch (NumberFormatException e) {
            System.out.println("El identificador debe ser un número");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return id;

    }

}
