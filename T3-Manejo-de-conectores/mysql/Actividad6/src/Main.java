import java.sql.*;

/***
 * @Author: Adrián Pisabarro García
 * Acceso a datos
 * @Date: 2022-10-3
 */

public class Main {
    public static void main(String[] args) {

        BBDD bbdd = new BBDD();


        try {
            String sql = "";

            //Obtén el apellido, oficio y salario de los empleados del departamento 10
            System.out.println("Obtén el apellido, oficio y salario de los empleados del departamento 10");
            Departamento departamento = new Departamento(10);
            sql = "SELECT * FROM empleado WHERE id_departamento = "+departamento.getId();
            Empleado empleado1 = selectEmpleado(departamento, sql);
            if(empleado1 != null){
                System.out.println("Apellido: "+empleado1.getApellido());
                System.out.println("Oficio: "+empleado1.getRol());
                System.out.println("Salario: "+empleado1.getSalario());
            }


            //•Realiza otro programa Java que visualice el Apellido del empleado con máximo salario, visualizatambién su salario.
            System.out.println("\nRealiza otro programa Java que visualice el Apellido del empleado con máximo salario, visualiza también su salario.");
            sql = "SELECT * FROM empleado WHERE salario = (SELECT MAX(salario) FROM empleado)";
            Empleado empleado = selectEmpleado(null, sql);
            if (empleado != null) {
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("Salario máximo: " + empleado.getSalario());
            }



        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido");
            System.out.println(e.getMessage());
        }

    }


    public static Empleado selectEmpleado(Departamento departamento, String sql) throws SQLException {
        BBDD bbdd = new BBDD();
        Connection conexion = bbdd.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        Empleado empleado = null;
        while (resultado.next()) {
            empleado = new Empleado();
            empleado.setId(resultado.getInt("id"));
            empleado.setApellido(resultado.getString("nombre"));
            empleado.setRol(resultado.getString("rol"));
            empleado.setSalario(resultado.getDouble("salario"));
            empleado.setDepartamento(departamento);

        }

        bbdd.desconectar(conexion, resultado, sentencia);

        return empleado;
    }
}