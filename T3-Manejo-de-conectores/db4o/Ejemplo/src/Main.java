/***
 * @author Adrián Pisabarro García
 * Acceso a datos
 * @date 2022-09-26 21:18
 */

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
    public static void main(String[] args) {

        //Abrir la BD
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BDPersonas.db4o");

        // Crear un objeto de la clase Persona
        Persona persona1 = new Persona("Juan", "Bogotá");
        Persona persona2 = new Persona("Pedro", "Medellín");
        Persona persona3 = new Persona("Luis", "Cali");
        Persona persona4 = new Persona("Ana", "Bogotá");

        // Insertar el objeto en la BD
        db.store(persona1);
        db.store(persona2);
        db.store(persona3);
        db.store(persona4);
        System.out.println("Objetos insertados");

        System.out.println("****************************");

        // Abrir la BD
        //Leer todos los objetos de la BD
        Persona persona = new Persona(null, null);
        ObjectSet<Persona> result = db.queryByExample(persona);
        System.out.println("Todas las personas:");
        while (result.hasNext()) {
            System.out.println(result.next());
        }

        System.out.println("****************************");

        // Hacer una búsqueda por nombre
        Persona personaBusqueda = new Persona("Juan", null);
        ObjectSet<Persona> result2 = db.queryByExample(personaBusqueda);
        System.out.println("Persona con nombre Juan: ");
        while (result2.hasNext()) {
            System.out.println(result2.next());
        }

        System.out.println("****************************");

        // Hacer una búsqueda por ciudad
        Persona personaBusqueda2 = new Persona(null, "Bogotá");
        ObjectSet<Persona> result3 = db.queryByExample(personaBusqueda2);
        System.out.println("Personas que viven en Bogotá: ");
        while (result3.hasNext()) {
            System.out.println(result3.next());
        }

        System.out.println("****************************");

        //Eliminar un objeto de la BD
        Persona personaEliminar = new Persona("Luis", null);
        ObjectSet<Persona> result4 = db.queryByExample(personaEliminar);
        while (result4.hasNext()) {
            Persona personaEncontrada = result4.next();
            db.delete(personaEncontrada);
            System.out.println("Persona eliminada: " + personaEncontrada);
        }

        System.out.println("****************************");

        //Modificar un objeto de la BD
        Persona personaModificar = new Persona("Pedro", null);
        ObjectSet<Persona> result5 = db.queryByExample(personaModificar);
        while (result5.hasNext()) {
            Persona personaModificada = result5.next();
            System.out.println("Modificando: " + personaModificada + " a ciudad: Bogotá");
            personaModificada.setCiudad("Bogotá");
            db.store(personaModificada);
        }

        // Cerrar la BD
        db.close();

    }


}