package menues;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Usuario;

public class menuRegistro {
    // Atributos
    private Scanner sc;
    private boolean continuar = true;
    private boolean avanzar = true;
    ArrayList<Usuario> listaUsuarios;

    // Constructor
    public menuRegistro(Scanner sc, ArrayList<Usuario> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }

    public void iniciar() {
        while (continuar) {

            System.out.println("------- REGISTRARSE -------");
            System.out.println("Bienvenido/a al sistema de registro de usuarios");
            System.out.println("Vamos a comenzar con el registro");

            // Ingreso los datos para registrarse

            // Ingreso el nombre de usuario
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = this.sc.next();

            // Primeor valido que no haya un usuario que ya exista con el nombre

            Usuario existeUsuario = this.buscarUsuario(nombreUsuario);

            // Valido el resultado obtenido
            if (existeUsuario != null) {
                System.out.println("EL USUARIO YA EXISTE");
            } else {
                // Hago el registro de la clave

                String contraseniaUsuario = this.registroClave();

                // Creo un nuevo usuario

                Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseniaUsuario);

                // Guardo ese usuario en la lista
                listaUsuarios.add(nuevoUsuario);

                // Muestro por pantalla un mensaje de registro exitoso
                System.out.println("REGISTRO EXITOSO!!!");

                // Cambio la variable continuar por el valor false

                this.continuar = false;

                // Vuelvo a login

                MenuLogin mLogin = new MenuLogin(sc, listaUsuarios);
                mLogin.iniciar();
            }

        }

    }

    private Usuario buscarUsuario(String nombreUsuario) {

        // Variable axiliar para guardar el resultado de la busqueda
        Usuario usuarioEncontrado = null;

        // Recorro la lista de Usuarios
        for (Usuario usuario : listaUsuarios) {

            // Si el nombre del usuario de turno de la lista es igual al nombre ingresado
            // entonces hago lo siguiente
            if (usuario.getNombre().equals(nombreUsuario)) {

                // Guardo el usuario en la variable de al principio
                usuarioEncontrado = usuario;
            }
        }

        // Devuelvo lo que tenga usuarioEncontrado
        return usuarioEncontrado;
    }

    private String registroClave() {

        // Variable axiliar para guardar el resultado de la busqueda
        String clave = "";

        // Entro en el bucle para realizar el registro de la clave
        while (avanzar) {

            // Ingreso la clave
            System.out.print("Ingrese su constrasenia: ");
            String contraseniaUsuario = this.sc.next();

            // Reingreso la clave
            System.out.print("Vuelva a ingresar su contrasenia: ");
            String contraseniaReingresadaUsuario = this.sc.next();

            // Valido si son iguales con el metodo validarClaves()
            boolean sonIguales = this.validarClaves(contraseniaUsuario, contraseniaReingresadaUsuario);

            // Si son iguales, es decir, es true
            if (sonIguales) {

                // la variable clave va a guardar la constrasenia
                clave = contraseniaUsuario;

                // seteo la variable avanzar en false para que salga del bucle
                this.avanzar = false;
            } else {
                System.out.println("--------------- LAS CLAVES NO COINCIDEN, VUELVA A INTENTARLO ---------------");
            }

        }

        return clave;
    }

    private boolean validarClaves(String clave, String claveReingresada) {

        // Variable donde guardo el valor de la comparacion de las claves
        boolean sonIguales = false;

        // Valido si la clave ingresasa y la clave reingresada son iguales
        if (clave.equals(claveReingresada)) {

            // Si son iguales, entonces que la variable sonIguales tenga el valor de true
            sonIguales = true;
        }

        // Devuelvo el valor de la variable sonIguales
        return sonIguales;
    }

}
