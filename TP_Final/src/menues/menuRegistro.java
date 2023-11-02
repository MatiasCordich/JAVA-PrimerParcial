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

    // Funcion para iniciar el menu de registro
    public void iniciar() {
        while (continuar) {

            System.out.println("------- REGISTRARSE -------");
            System.out.println("Bienvenido/a al sistema de registro de usuarios");
            System.out.println("Vamos a comenzar con el registro");

            // Ingreso los datos para registrarse

            // Ingreso el nombre de usuario
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = this.sc.next();

            // Primero valido que no haya un usuario que ya exista con el nombre ingresado
            Usuario existeUsuario = this.buscarUsuario(nombreUsuario);

            // Valido el resultado obtenido
            if (existeUsuario != null) {
                // Si el nombre de usuario ya existe entonces salto un mensaje de error
                System.out.println("EL USUARIO YA EXISTE");
            } else {

                // Si el nombre del usuario es nuevo entonces procedo a hacer ahora el registro de la calve

                // Hago el registro de la clave llamando a la funcion registroClave() que me va a devolver un string y ese valor
                // Lo guardo en una variable
                String contraseniaUsuario = this.registroClave();

                // Creo un nuevo usuario
                Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseniaUsuario);

                // Guardo ese usuario en la lista
                listaUsuarios.add(nuevoUsuario);

                // Muestro por pantalla un mensaje de registro exitoso
                System.out.println("REGISTRO EXITOSO!!!");

                // Cambio la variable continuar por el valor false asi salgo del bucle
                this.continuar = false;

                // Vuelvo a login
                MenuLogin mLogin = new MenuLogin(sc, listaUsuarios);
                mLogin.iniciar();
            }

        }

    }

    // Funcion para validar la existencia del nombre del usuario 
    private Usuario buscarUsuario(String nombreUsuario) {

        // Variable axiliar para guardar el resultado de la busqueda
        Usuario usuarioEncontrado = null;

        // Recorro la lista de Usuarios
        for (Usuario usuario : listaUsuarios) {

            // Si el nombreIngresado es igual al nombre del usuario de turno de la lista 
            if (nombreUsuario.equals(usuario.getNombre())) {
                // Guardo el usuario en la variable de al principio
                usuarioEncontrado = usuario;
            }
        }

        // Devuelvo lo que tenga usuarioEncontrado
        return usuarioEncontrado;
    }

    // Funcion para realizar el registro de la clave del usuario
    private String registroClave() {

        // Variable axiliar para guardar el resultado una vez que hayamos hecho la clave
        String clave = "";

        // Entro en el bucle para realizar el registro de la clave
        while (avanzar) {

            // Ingreso la clave
            System.out.print("Ingrese su constrasenia: ");
            String contraseniaUsuario = this.sc.next();

            // Reingreso la clave
            System.out.print("Vuelva a ingresar su contrasenia: ");
            String contraseniaReingresadaUsuario = this.sc.next();

            // Valido si son iguales con el metodo validarClaves(), el resultado va a ser un valor booleano
            boolean sonIguales = this.validarClaves(contraseniaUsuario, contraseniaReingresadaUsuario);

            // Si son iguales, es decir, es true
            if (sonIguales) {
                // la variable clave va a guardar la constrasenia
                clave = contraseniaUsuario;

                // seteo la variable avanzar en false para salir del bucle
                this.avanzar = false;
            } else {

                // Si sonIguales es false, muestro un mesaje de error y vuelvo a registrar la clave
                System.out.println("--------------- LAS CLAVES NO COINCIDEN, VUELVA A INTENTARLO ---------------");
            }

        }

        // Una vez hecho todo el proceso devuelvo el valor de la clave
        return clave;
    }

    // Valido si ambas claves ingresadas en el registro son iguales
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
