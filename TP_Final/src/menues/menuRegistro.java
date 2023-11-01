package menues;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Usuario;

public class menuRegistro {
    // Atributos
    private Scanner sc;
    private boolean continuar = true;
    ArrayList<Usuario> listaUsuarios;

    // Constructor
    public menuRegistro(Scanner sc, ArrayList<Usuario> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }

    public void iniciar() {
        while (continuar) {

            // Variable auxiliar

            Usuario usuarioRepetido = null;

            System.out.println("------- REGISTRARSE -------");
            System.out.println("Bienvenido/a al sistema de registro de usuarios");
            System.out.println("Vamos a comenzar con el registro");

            // Ingreso los datos para registrarse
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = this.sc.next();
            System.out.print("Ingrese su constrasenia: ");
            String constraseniaUsuario = this.sc.next();

            // Recorro la lista de usuarios para validar
            for (Usuario usuario : listaUsuarios) {

                // Si el nombre o la contrasenia ingresada coincide con algun usuario de la lista
                if (nombreUsuario.equals(usuario.getNombre())) {

                    // Guardo el usuario encontrado en la variable auxiliar
                    usuarioRepetido = usuario;
                    break;
                }
            }

            // Valido el resutlado obtenido

            if (usuarioRepetido != null) {
                // Si el usuario repetido existe encontes que me muestre un mensaje de error
                System.out.println("EL USUARIO YA EXISTE, VUELVA A RESGISTRARSE");
            } else {

                // Caso contrario prosigo con la creacion del nuevo usuario

                // Creo un nuevo usuario
                Usuario nuevoUsuario = new Usuario(nombreUsuario, constraseniaUsuario);

                // Lo agrego a la lista
                listaUsuarios.add(nuevoUsuario);

                // Muestro por pantalla un mensaje de registro exitoso
                System.out.println("USUARIO REGISTRADO EXITOSAMENTE !!!!");

                // Salgo del bucle del programa de registro
                continuar = false;

            }
        }

    }
}
