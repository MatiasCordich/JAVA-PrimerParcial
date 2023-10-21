package modelos;

public class Empleado {

    // ATRIBUTOS
    private int idEmpleado;
    private String nombre;
    private String ocupacion;
    private double sueldo;

    // CONSTRUCTOR
    public Empleado(int idEmpleado, String nombre, String ocupacion, double sueldo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.sueldo = sueldo;
    }

    // SETTERS
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // GETTERS
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public double getSueldo() {
        return sueldo;
    }

}
