package modelos;

public class Pokemon {
    
    // Atributos
    private int id;
    private String nombre;
    private String tipo;
    private int ataque;

    // Constructor
    public Pokemon(int id, String nombre, String tipo, int ataque) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    

    
}
