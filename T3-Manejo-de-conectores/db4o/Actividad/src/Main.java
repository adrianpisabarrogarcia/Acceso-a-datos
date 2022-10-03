/***
 * @autor Adrián Pisabarro García
 * Acceso a datos
 * @date 2022-10-26 19:52:00
 */

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
    public static void main(String[] args) {
        insertarDepartamentos();
        insertarEmpleados();

        //Buscar empleados de un departamento
        final int departamentoNum = 20;
        ObjectContainer db = conectar();
        Empleado empleadoBuscar = new Empleado();
        empleadoBuscar.setDepartamento(departamentoNum);
        Departamento departamentoBuscar = new Departamento();
        departamentoBuscar.setId(departamentoNum);
        ObjectSet<Departamento> result = db.queryByExample(departamentoBuscar);
        if (result.size() == 0) {
            System.out.println("No existe el departamento");
        } else {
            Departamento departamento = result.next();
            System.out.println("Búsqueda de departamento: " + departamento.getNombre());
            ObjectSet<Empleado> result2 = db.queryByExample(empleadoBuscar);
            if (result2.size() == 0) {
                System.out.println("No hay empleados en este departamento");
            } else {
                System.out.println("Empleados del departamento: ");
                while (result2.hasNext()) {
                    System.out.println(result2.next());
                }
            }
        }
        db.close();


        String pregunta1 = "¿Se respeta la integridad de la BBDD al almacenar, modificar o eliminar los objetos?";
        String respuesta1 = "Sí, se respeta la integridad de la BBDD al almacenar, modificar o eliminar los objetos.";
        respuesta1 += " Esto se debe a que la BBDD almacena, modifica y elimina los objetos sin ningún problema, a no ser que haya una mala práctica de bbdd no relacional.";
        String pregunta2 = "¿Se respeta la integridad referencial al almacenar, modificar o eliminar los objetos?";
        String respuesta2 = "No, no se respeta la integridad referencial al almacenar, modificar o eliminar los objetos, ya que no se puede hacer de forma automática (delete on cascade), es una base de datos no sql.";


        // Respuestas a preguntas
        System.out.println("\n\n");
        System.out.println("Pregunta 1");
        System.out.println(pregunta1);
        System.out.println(respuesta1);
        System.out.println("Pregunta 2");
        System.out.println(pregunta2);
        System.out.println(respuesta2);

    }

    public static ObjectContainer conectar() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "EMPLEDEP.db4o");
        return db;
    }

    public static void insertarDepartamentos(){
        ObjectContainer db = conectar();

        Departamento dep1 = new Departamento(10, "CONTABILIDAD", "SEVILLA");
        Departamento dep2 = new Departamento(20, "INVESTIGACIÓN", "MADRID");
        Departamento dep3 = new Departamento(30, "VENTAS", "BARCELONA");

        db.store(dep1);
        db.store(dep2);
        db.store(dep3);

        db.close();
    }

    public static void insertarEmpleados(){
        ObjectContainer db = conectar();

        Empleado emp1 = new Empleado(7369, "SÁNCHEZ", "EMPLEADO", 20);
        Empleado emp2 = new Empleado(7499, "ARROYO", "VENDEDOR", 30);
        Empleado emp3 = new Empleado(7521, "SALA", "VENDEDOR", 30);
        Empleado emp4 = new Empleado(7566, "JIMÉNEZ", "DIRECTOR", 20);
        Empleado emp5 = new Empleado(7782, "CEREZO", "DIRECTOR", 10);
        Empleado emp6 = new Empleado(7839, "REY", "PRESIDENTE", 10);

        db.store(emp1);
        db.store(emp2);
        db.store(emp3);
        db.store(emp4);
        db.store(emp5);
        db.store(emp6);

        db.close();
    }

}