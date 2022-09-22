import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Ejercicio7 {
    public static void main(String[] args) {
        //Crear objetos de tipo Persona
        ArrayList<Persona> personas = new ArrayList<>();
        personas = crearPersonas();

        try {
            String nombreFichero = "FichObjectEj7.dat";
            String ruta = "."+"/assets/"+nombreFichero;

            //Esribir fichero
            EscribirFichObject.escribirFichero(ruta, personas);

            //Leer fichero
            imprimirPersonas(LeerFichObject.leerFichero(ruta));



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<Persona> crearPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 20));
        personas.add(new Persona("Pedro", 21));
        personas.add(new Persona("Maria", 22));
        personas.add(new Persona("Jose", 23));
        personas.add(new Persona("Luis", 24));
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Rosa", 26));
        personas.add(new Persona("Luisa", 27));
        personas.add(new Persona("Miguel", 28));
        personas.add(new Persona("Carlos", 29));

        return personas;
    }

    private static void imprimirPersonas(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}