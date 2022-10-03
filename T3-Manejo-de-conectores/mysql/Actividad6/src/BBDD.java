import java.sql.*;

/***
 * @Author: Adrián Pisabarro García
 * Acceso a datos
 * @Date: 2022-10-3
 */

public class BBDD {


    public BBDD() {

    }

    public void cargarDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public Connection conectar() {
        try {
            //Establecer la conexión
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
        } catch (Exception e){
            System.out.println("Error desconocido");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void desconectar(Connection conexion, ResultSet resultado, PreparedStatement sentencia) throws SQLException {
        try {
            //Cerrar la conexión, resultado y sentencia
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (Exception e){
            System.out.println("Error desconocido");
            System.out.println(e.getMessage());
        }

    }


}
