package modelos;

public class Auto {

    // ATRIBUTOS
    private String patente;
    private String marca;
    private String modelo;
    private String estadoVenta;
    private int anio;
    private double precio;
    private boolean enVenta;

    // CONSTRUCTOR
    public Auto(String patente, String marca, String modelo, int anio, double precio) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.estadoVenta = "EN VENTA";
        this.enVenta = true;
    }

    // SETTERS

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    // GETTERS

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean getEnVenta() {
        return enVenta;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

}
