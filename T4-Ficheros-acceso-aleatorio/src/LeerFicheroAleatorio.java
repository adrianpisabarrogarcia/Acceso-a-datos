import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFicheroAleatorio {
    public static void main(String[] args) {
        final int LONGITUD_REGISTRO = 36;
        //Acceder al archivo

        try {
            RandomAccessFile raf = new RandomAccessFile("empleados.dat", "r");
            //Posicionarse en el 0
            raf.seek(0);

            int posicion = (int) raf.getFilePointer();
            System.out.println("Leyendo el fichero: " + raf.length());
            while (posicion < raf.length()) {
                //Identificador de registro
                int id = 0;
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

                //Psición actual del archivo
                System.out.println("\n" + "Núm bytes leidos: " + (int) raf.getFilePointer() + "\n");
                posicion = posicion + LONGITUD_REGISTRO;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al acceder al fichero");
            System.out.println(e.getMessage());
        }
    }
}
