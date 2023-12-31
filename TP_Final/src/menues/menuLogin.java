package menues;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Usuario;

/*
 * MENU LOGIN
 * 
 * Clase menuLogin cuya funcion es realizar el login tanto de empleados como de clientes
 * 
 */

public class MenuLogin {

    // Atributos
    private Scanner sc;
    private boolean continuar = true;
    ArrayList<Usuario> listaUsuarios;

    // Constructor
    public MenuLogin(Scanner sc, ArrayList<Usuario> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }

    // Iniciar el login
    public void iniciar() {

        // Inicio el menu de iniciar
        System.out.println("------- LOGIN -------");
        System.out.println("Bienvenido/a al sistema de logueo de usuarios");

        // Pregunto si es la primera vez que ingreso al sistema
        System.out.print("Es la primera vez que ingresa? (si/no): ");
        String sRespuesta = this.sc.next();
        char cRespuesta = sRespuesta.toLowerCase().charAt(0);

        // Si me respuesta es 'si', es decir 's', etonces que me dirija al menu de
        // Registro
        if (cRespuesta == 's') {

            // Creo el menu de registro
            menuRegistro mRegistro = new menuRegistro(sc, listaUsuarios);

            // Llamo la funcion iniciar() del menu de registro
            mRegistro.iniciar();

        } else {
            // Si mi respuesta es 'no', es decir 'n', entonces procedo con el login

            while (continuar) {

                // Pido por pantalla el nombre del usuario
                System.out.print("Ingrese su nombre de usuario: ");
                String nombreUsuarioIngresado = sc.next();

                // Ingreso la clave del usuario
                System.out.print("Ingrese su clave: ");
                String constraseniaIngresada = sc.next();

                // Valido si el usuario que ingrese existe
                Usuario existeUsuario = this.validarNombreUsuario(nombreUsuarioIngresado);

                // Valido el resultado obtenido
                if(existeUsuario == null){

                    // Si es null, quiere decir que el usuario no existe por lo que mando un mensaje de error
                    System.out.println("ERROR USUARIO INEXISTENTE");

                    return;
                }
                
                // Si el usuario existe entonces valido ahora la clave

                // Llamo a la funcion validarClave(), que me va a devolver un booleano, lo guardo en una variable de tipo boolean
                boolean sonIguales = this.validarClave(constraseniaIngresada, existeUsuario);

                // Si sonIguales es false, entonces muestro un mensaje por pantalla de error
                if (!sonIguales) {
                    System.out.println("CLAVE INCORRECTA");
                } else {
                    // Si son iguales muestro un mensaje de exito y procedo a ir al menu siguiente
                    System.out.println("LOGUEO EXITOSO!");
                    // ACA IRIA EL MENU
                }

            }
        }

    }

    // Funcion para validar la existencia del nombre del usuario 
    private Usuario validarNombreUsuario(String nombreUsuario){

        // Variable auxiliar para guadar el resultado
        Usuario usuarioEncontrado = null;

        // Recorro la listaUsuarios
        for (Usuario usuario : listaUsuarios) {
            // Si el nommbre ingresado es igual a algun usuario de la lista lo guardo
            if (nombreUsuario.equals(usuario.getNombre())) {
                usuarioEncontrado = usuario;
            }
        }

        // Devuelvo el resultado obtenido
        return usuarioEncontrado;
    }

    // Funcion para validar la clave 
    private boolean validarClave(String claveIngresada, Usuario usuario){

        // Variable auxiliar
        boolean sonIguales = false;

        // Si claveIngresada es igual al usuario existente (del cual obtengo su clave)
        // Entonces la variable sonIguales pasa a ser true
        if (claveIngresada.equals(usuario.getContrasenia())) {
            sonIguales = true;
        }

        // Devuelvo el valor de la variable sonIguales
        return sonIguales;
    }
}
