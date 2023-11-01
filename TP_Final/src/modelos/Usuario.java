package modelos;

public class Usuario {
    
    // ATRIBUTOS
    private String nombre;
    private String contrasenia;
    // private String rol;


    // Constructor
    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        // this.rol = rol;
    }


    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    // public void setRol(String rol) {
    //     this.rol = rol;
    // }


    // Getters
    public String getNombre() {
        return nombre;
    }


    public String getContrasenia() {
        return contrasenia;
    }


    // public String getRol() {
    //     return rol;
    // }


    // toString
    @Override
    public String toString() {
        return "Usuario: " + this.nombre;
    }
}
