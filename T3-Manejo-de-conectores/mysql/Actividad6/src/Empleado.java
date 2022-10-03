/***
 * @Author: Adrián Pisabarro García
 * Acceso a datos
 * @Date: 2022-10-3
 */

public class Empleado {

    private int id;
    private String apellido;
    private String rol;
    private double salario;
    private Departamento departamento;

    public Empleado(int id, String apellido, String rol, Departamento departamento) {
        this.id = id;
        this.apellido = apellido;
        this.rol = rol;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Empleado(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", rol='" + rol + '\'' +
                ", salario=" + salario +
                ", departamento=" + departamento +
                '}';
    }
}
