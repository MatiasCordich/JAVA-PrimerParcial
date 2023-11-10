package modelos;

public class ArticuloSinDescuento extends Articulo {
    

    // Constructor
    public ArticuloSinDescuento(int codigo, String nombre, String descripcion, double precio) {
		super(codigo, nombre, descripcion, precio);
	}

    // Metodo especifico getDescuento de ArticuloSinDescuento
    public double getDescuento(){
        return 0;
    }
}
