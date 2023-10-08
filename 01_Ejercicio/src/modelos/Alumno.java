package modelos;

public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private double primerNota;
    private double segundaNota;

    // Constructor

    public Alumno(int id, String nombre, String apellido, double primerNota, double segundaNota) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.primerNota = primerNota;
        this.segundaNota = segundaNota;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPrimerNota(double primerNota) {
        this.primerNota = primerNota;
    }

    public void setSegundaNota(double segundaNota) {
        this.segundaNota = segundaNota;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getPrimerNota() {
        return primerNota;
    }

    public double getSegundaNota() {
        return segundaNota;
    }

    // Metodos 

    public double getPromedio() {

        double promedio = (this.primerNota + this.segundaNota) / 2;

        return promedio;
    }

}
