/***
 * @autor Adrián Pisabarro García
 * Acceso a datos
 * @date 2022-10-26 19:52:00
 */


public class Empleado {

    private int id;
    private String nombre;
    private String rol;
    private int departamento;

    public Empleado(Integer id, String nombre, String rol, int departamento) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.departamento = departamento;
    }

    public Empleado (){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }


}
