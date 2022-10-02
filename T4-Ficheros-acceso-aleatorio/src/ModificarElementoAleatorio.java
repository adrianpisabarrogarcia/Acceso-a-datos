import javax.annotation.processing.SupportedSourceVersion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ModificarElementoAleatorio {
    static final int POSICION_CADA_ELEMENTO = 36;

    public static void main(String[] args) throws IOException {
        //Pedimos un id de un elemento
        int id = LeerElementoAleatorio.entradaIdentificador();
        //Vemos si existe
        //Abrimos el fichero para encontrarlo
        RandomAccessFile raf = new RandomAccessFile("empleados.dat", "rw");
        if (LeerElementoAleatorio.encontrado(id, raf)) {
            //Si existe, pedimos los datos del nuevo importe
            double importe = nuevoImporte();
            //Modificamos el elemento
            modificarElemento(id, importe, raf);
        } else {
            System.out.println("No encontrado");
        }
    }

    private static void modificarElemento(int id, double importe, RandomAccessFile raf) throws IOException {

        //Posicionarse en el elemento
        int posicion = POSICION_CADA_ELEMENTO * id;
        raf.seek(posicion - POSICION_CADA_ELEMENTO);

        //Leer el identificador
        int idLeido = raf.readInt();
        System.out.println("ID: " + idLeido);

        //Leer el apellido
        String apellido = "";
        byte[] b = new byte[20];
        raf.read(b);
        apellido = new String(b, "UTF-8");
        System.out.println("Apellido: " + apellido);

        //Leer el departamento
        int departamento = raf.readInt();
        System.out.println("Departamento: " + departamento);

        //Leer el salario
        double salario = raf.readDouble();
        System.out.println("Salario viejo: " + salario);
        raf.seek(raf.getFilePointer() - 8);
        salario += importe;
        System.out.println("Salario nuevo: " + salario);
        raf.writeDouble(salario);

    }

    private static double nuevoImporte() {
        double importe = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nuevo importe");
            importe = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Error al introducir el importe");
            System.exit(0);
        }

        return importe;
    }
}
