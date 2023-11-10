package modelos;

import java.util.Scanner;

public class ArticuloConDescuentoPorCategoria extends Articulo {

    // Atributo
    private double precioDescuento;
    private String categoria;
    private Scanner sc;

    // Constructor
    public ArticuloConDescuentoPorCategoria(int codigo, String nombre, String descripcion, double precio) {
        super(codigo, nombre, descripcion, precio);
        this.precioDescuento = 0;
        this.categoria = null;
    }

    // GETTERS
    public double getPrecioDescuento() {
        return this.precioDescuento;
    }

    public String getCategoria() {
        return this.categoria;
    }

    // SETTERS
    public void setPrecioDescuento(double precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Metodo especifico de ArticuloConDescuentoPorStock
    public double getDescuento() {

        // Variables auxiliares
        double descuento = 0;
        double importeDescuento = 0;

        // Pregunto por la categoria
        System.out.println("A que categoria pertenece el articulo: ");
        String categoriaIngresada = this.sc.next();

        // Seteamos ese articulo con la categoria ingresada
        this.setCategoria(categoriaIngresada);

        // Comparamos
        if (categoriaIngresada.equalsIgnoreCase("Enlatados")) {

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
