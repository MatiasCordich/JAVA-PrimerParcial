package modelos;

public class ArticuloConDescuentoPorStock extends Articulo {

    // Atributo
    private double precioDescuento;
    private int cantidad;

    // Constructor
    public ArticuloConDescuentoPorStock(int codigo, String nombre, String descripcion, double precio) {
        super(codigo, nombre, descripcion, precio);
        this.precioDescuento = 0;
        this.cantidad = 0;
    }

    // GETTERS
    public double getPrecioDescuento() {
        return precioDescuento;
    }

    public int getCantidad() {
        return cantidad;
    }
    

    // SETTERS
    public void setPrecioDescuento(double precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo especifico de ArticuloConDescuentoPorStock
    public double getDescuento() {

        // Variables auxiliares
        double descuento = 0;
        double importeDescuento = 0;

        if (this.getCantidad() < 10) {

            // Aplicamos el descuento 

            // Vemos el importe de descuento
            descuento = this.getPrecio() * (20 / 100);

            // Aplicamos el precio del articulo menos el descuento
            importeDescuento = this.getPrecio() - descuento;

            // Seteo de descuento para el articulo
            this.setPrecioDescuento(importeDescuento);
        }

        // Retorna el precio de descuento
        return this.precioDescuento;

    }

}
