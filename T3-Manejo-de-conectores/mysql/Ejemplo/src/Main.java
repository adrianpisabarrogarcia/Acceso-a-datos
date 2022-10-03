import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {

            //Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establecer la conexión
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");

            //Preparar la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM departamento");

            //Recorrer el resultado
            while (resultado.next()) {
                System.out.println(
                        resultado.getInt("id") + " " +
                                resultado.getString("nombre") + " " +
                                resultado.getString("ciudad")
                );
            }

            //Cerrar la conexión, resultado y sentencia
            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver");
            System.out.println(e.getMessage());
            System.out.println("Error en la conexión");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido");
            System.out.println(e.getMessage());
        }




    }
}