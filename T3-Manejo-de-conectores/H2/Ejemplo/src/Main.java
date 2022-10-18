import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //H2 connection
        String conexionURL = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String password = "";
        String schema = "PUBLIC";
        String catalog = "PUBLIC";
        Connection con = null;
        try {
            con = DriverManager.getConnection(conexionURL, user, password);
            System.out.println("Connected to the H2 database successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

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
        System.out.println("********* tablas:");
        //tables
        rs = dbmd.getTables("TEST", null, null, null);
        while (rs.next()) {
            //Catalogo
            System.out.print("Catalogo: " + rs.getString(1) + " ");
            //Esquema
            System.out.print("Esquema: " + rs.getString(2) + " ");
            //Nombre de la tabla
            System.out.print("Tabla: " + rs.getString(3) + " ");
            //Tipo de tabla
            System.out.print("Tipo: " + rs.getString(4));
            System.out.println();
        }
        System.out.println("********* columnas de empleado:");

        //columns of empleado
        rs = dbmd.getColumns("TEST", "PUBLIC", "EMPLEADO", null);
        while (rs.next()) {
            //Catalogo
            System.out.print("Catalogo: " + rs.getString(1) + " ");
            //Esquema
            System.out.print("Esquema: " + rs.getString(2) + " ");
            //Nombre de la tabla
            System.out.print("Tabla: " + rs.getString(3) + " ");
            //Nombre de la columna
            System.out.print("Columna: " + rs.getString(4) + " ");
            //Tipo de dato
            System.out.print("Tipo: " + rs.getString(5) + " ");
            //Tamaño
            System.out.print("Tamaño: " + rs.getString(7) + " ");
            //Nulo
            System.out.print("Nulo: " + rs.getString(18) + " ");
            System.out.println();
        }
        System.out.println("********* Columnas de la tabla departamento:");
        rs = dbmd.getColumns("TEST", "PUBLIC", "DEPARTAMENTO", null);
        while (rs.next()) {
            //Nombre columna
            System.out.print("Nombre de columna: " + rs.getString("COLUMN_NAME") + " ");
            //Type name
            System.out.print("Tipo: " + rs.getString("TYPE_NAME") + " ");
            //Tamaño
            System.out.print("Tamaño de la columna: " + rs.getString("COLUMN_SIZE") + " ");
            //Nulo
            System.out.print("Es nulo?: " + rs.getString("IS_NULLABLE") + " ");
            System.out.println();
        }



    }
}