import com.mysql.cj.conf.PropertyDefinitions;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("***************************************");
        System.out.println("******** INFORMACIÓN DE LA BBDD *******");
        System.out.println("***************************************");

        informacionBBDD();


        System.out.println();
        System.out.println();
        System.out.println("***************************************");
        System.out.println("********* INSERTAR UN EMPLEADO ********");
        System.out.println("***************************************");

        insertarEmpleado();

    }

    private static int comprobarSalario() {
        Scanner sc = new Scanner(System.in);
        int salario = sc.nextInt();
        while (salario <= 0) {
            System.out.println("El salario no puede ser negativo, introduce un salario válido: ");
            salario = sc.nextInt();
        }
        return salario;
    }

    public static void informacionBBDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet rs = null;
            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();
            System.out.println("Nombre: " + nombre);
            System.out.println("Driver: " + driver);
            System.out.println("URL: " + url);
            System.out.println("Usuario: " + usuario);
            System.out.println("*********");
            //tables
            rs = dbmd.getTables("empresa", null, null, null);
            while (rs.next()) {
                //Catalogo
                System.out.println("Catalogo: " + rs.getString(1));
                //Esquema
                System.out.println("Esquema: " + rs.getString(2));
                //Nombre de la tabla
                System.out.println("Tabla: " + rs.getString(3));
                //Tipo de tabla
                System.out.println("Tipo: " + rs.getString(4));
            }
            System.out.println("*********");

            //columns
            rs = dbmd.getColumns("empresa", null, "empleado", null);
            while (rs.next()) {
                //Catalogo
                System.out.println("Catalogo: " + rs.getString(1));
                //Esquema
                System.out.println("Esquema: " + rs.getString(2));
                //Nombre de la tabla
                System.out.println("Tabla: " + rs.getString(3));
                //Nombre de la columna
                System.out.println("Columna: " + rs.getString(4));
                //Tipo de dato
                System.out.println("Tipo: " + rs.getString(5));
                //Tamaño
                System.out.println("Tamaño: " + rs.getString(7));
                //Nulo
                System.out.println("Nulo: " + rs.getString(18));
            }
            System.out.println("*********");

            System.out.println("Columnas de la tabla departamento");
            rs = dbmd.getColumns("empresa", null, "departamento", null);
            while (rs.next()) {
                //Nombre columna
                System.out.println("Nombre de columna: " + rs.getString("COLUMN_NAME"));
                //Type name
                System.out.println("Tipo: " + rs.getString("TYPE_NAME"));
                //Tamaño
                System.out.println("Tamaño de la columna: " + rs.getString("COLUMN_SIZE"));
                //Nulo
                System.out.println("Es nulo?: " + rs.getString("IS_NULLABLE"));
                System.out.println("*********");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int seleccionarDepartamento() {
        Scanner sc = new Scanner(System.in);
        String deparamentos = "";
        String queryDepartamentos = "SELECT nombre FROM departamento";
        ResultSet rs = null;
        int i = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            Statement st = con.createStatement();
            rs = st.executeQuery(queryDepartamentos);
            while (rs.next()) {
                deparamentos += i + " - " + rs.getString("nombre") + "\n";
                i++;
            }
            System.out.println(deparamentos);
        } catch (Exception e) {
            System.out.println(e);
        }
        int dept = sc.nextInt();
        if (dept < 1 || dept > i){
            System.out.println("No existe ese departamento, inserta uno válido");
            seleccionarDepartamento();
        }
        return dept;
    }

    public static int seleccionarEmpleado() {
        Scanner sc = new Scanner(System.in);
        String empleados = "";
        String queryEmpleados = "SELECT id, apellido FROM empleado";
        ResultSet rs = null;
        int i = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            Statement st = con.createStatement();
            rs = st.executeQuery(queryEmpleados);
            while (rs.next()) {
                empleados += rs.getInt("id") + " - " + rs.getString("apellido") + "\n";
                i++;
            }
            System.out.println(empleados);
        } catch (Exception e) {
            System.out.println(e);
        }
        int empleado = sc.nextInt();
        if (empleado < 1 || empleado > i){
            System.out.println("No existe ese empleado, inserta uno válido");
            seleccionarEmpleado();
        }
        return empleado;
    }

    public static int compobarSiExisteEmpleado() {
        Scanner sc = new Scanner(System.in);
        int numEmpleado = sc.nextInt();
        String queryDepartamentos = "SELECT id FROM empleado WHERE id = " + numEmpleado;
        ResultSet rs = null;
        boolean existe = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            Statement st = con.createStatement();
            rs = st.executeQuery(queryDepartamentos);
            while (rs.next()) {
                existe = true;
                break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (existe){
            System.out.println("Ya existe este empleado, inserta uno válido");
            compobarSiExisteEmpleado();
        }
        return numEmpleado;
    }

    public static String noNull() {
        Scanner sc = new Scanner(System.in);
        String noNull = sc.nextLine();
        if (noNull.equals("")){
            System.out.println("No puede estar vacío, inserta un valor válido");
            noNull();
        }
        return noNull;
    }

    public static void insertarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número del empleado: ");
        int num = compobarSiExisteEmpleado();
        System.out.println("Introduce el apellido del empleado: ");
        String apellido = noNull();
        System.out.println("Introduce el oficio del empleado: ");
        String oficio = noNull();
        System.out.println("Introduce el director del empleado: ");
        int dir = seleccionarEmpleado();
        System.out.println("Introduce el salario del empleado: ");
        int salario = comprobarSalario();
        System.out.println("Introduce el la comisión del empleado: ");
        int comision = sc.nextInt();
        System.out.println("Introduce el número de departamento al que le quieres asignar: ");
        int numDepartamento = seleccionarDepartamento();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            //Prepare the statement
            PreparedStatement ps = con.prepareStatement("INSERT INTO empleado VALUES (?,?,?,?,?,?,?,?)");
            //Set the values
            ps.setInt(1, num);
            ps.setString(2, apellido);
            ps.setString(3, oficio);
            ps.setInt(4, dir);
            ps.setDate(5, sqlDate);
            ps.setInt(6, salario);
            ps.setInt(7, comision);
            ps.setInt(8, numDepartamento);
            //Execute the statement
            ps.executeUpdate();
            System.out.println("Empleado insertado correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}