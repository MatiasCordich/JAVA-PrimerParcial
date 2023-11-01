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

public class menuLogin {

    // Atributos
    private Scanner sc;
    private boolean continuar = true;
    ArrayList<Usuario> listaUsuarios;

    // Constructor
    public menuLogin(Scanner sc, ArrayList<Usuario> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }

    // Iniciar el login
    public void iniciar() {

        // Inicio el menu de iniciar
        System.out.println("------- LOGIN -------");
        System.out.println("Bienvenido/a al sistema de registro de usuarios");

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

                // Variable auxiliar
                Usuario existeUsuario = null;

                // Pido por pantalla la clave de usuario
                System.out.print("Ingrese su nombre de usuario: ");
                String nombreUsuarioIngresado = sc.next();
                System.out.print("Ingrese la contrasenia: ");
                String constraseniaIngresada = sc.next();

                // Recorro la lista de usuarios
                for (Usuario usuario : listaUsuarios) {

                    // Comparo el valor que ingrese por teclado con cada clave del usuario
                    if (nombreUsuarioIngresado.equals(usuario.getNombre())) {
                        // Si existe un usuario que me lo guarde en la variable auxiliar
                        existeUsuario = usuario;
                        break;
                    }
                }

                // Valido el resultado
                if(existeUsuario == null){
                    System.out.println("ERROR USUARIO INEXISTENTE");
                } else {
                    if (existeUsuario.getContrasenia().equals(constraseniaIngresada)) {
                        // CARGAR EL MENU
                    }
                }
            }
        }

    }

    private Usuario buscarUsuario(){
        Usuario usuarioABuscar = null;

        return usuarioABuscar;
    }
}
