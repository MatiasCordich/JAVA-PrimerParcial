package menuAlumnos;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Alumno;

public class MenuAlumnos {

    private boolean activo = true;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Alumno> listaAlumnos;

    public MenuAlumnos(Scanner sc, ArrayList<Alumno> listaAlumnos) {
        this.sc = sc;
        this.listaAlumnos = listaAlumnos;
    }

    // Genericos

    public void iniciar() {
        System.out.println("---------------------------------------------");
        System.out.println("Bienvenido al sistema de carga de datos de los alumnos");
        while (this.activo) {
            int opcion = this.elegirOpcion();
            this.realizarOpcion(opcion);
        }
    }

    private void mostrarOpciones() {

        System.out.println("---------------------------------------------");
        System.out.println("Elija una de las siguientes opciones");
        System.out.println(" 0 - Salir");
        System.out.println(" 1 - Cargar alumno");
        System.out.println(" 2 - Mostrar alumnos");
        System.out.println(" 3 - Buscar alumno por id");
        System.out.println(" 4 - Buscar alumno con mayor y menor promedio");
        System.out.println(" 5 - Buscar alumnos aprobados");
        System.out.println(" 6 - Buscar alumnos desaprobados");
        System.out.println("---------------------------------------------");
    }

    private int elegirOpcion() {
        this.mostrarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    private void finalizar() {
        this.activo = false;
    }

    // Menu

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                this.finalizar();
                break;
            case 1:
                this.cargarAlumno();
                break;
            case 2:
                this.mostrarAlumnos();
                break;
            case 3:
                this.buscarPorId();
                break;
            case 4:
                this.mostrarMayorYMenorPromedio();
                break;
            case 5:
                this.mostarAlumnosAprobados();
                break;
            default:
                System.out.println("---------------------------------------------");
                System.out.println("OPCION INCORRECTA, ELIJA UNA OPCION EXISTENTE");
                System.out.println("---------------------------------------------");
                break;
        }
    }

    private void cargarAlumno() {
        System.out.println("---------------------------------------------");
        System.out.print("Ingrese el id del Alumno: ");
        int id = this.sc.nextInt();
        System.out.print("Ingrese el nombre del Alumno: ");
        String nombre = this.sc.next();
        System.out.print("Ingrese el apellido del Alumno: ");
        String apellido = this.sc.next();
        System.out.print("Ingrese la primera nota del Alumno: ");
        int primerNota = this.sc.nextInt();
        System.out.print("Ingrese la segunda nota del Alumno: ");
        int segundaNota = this.sc.nextInt();

        Alumno nuevoAlumno = new Alumno(id, nombre, apellido, primerNota, segundaNota);

        this.listaAlumnos.add(nuevoAlumno);
        System.out.println("---------------------------------------------");
    }

    private void mostrarAlumnos() {
        if (this.listaAlumnos.isEmpty()) {
            System.out.println("---------------------------------------------");
            System.out.println("NO HAY ALUMNOS EN LA LISTA");
        } else {
            for (Alumno alumno : listaAlumnos) {
                this.mostrarAlumno(alumno);
            }
        }
    }

    private void mostrarAlumno(Alumno alumno) {
        System.out.println("---------------------------------------------");
        System.out.println("ID: " + alumno.getId());
        System.out.println("NOMBRE: " + alumno.getNombre());
        System.out.println("APELLIDO: " + alumno.getApellido());
        System.out.println("PRIMER NOTA: " + alumno.getPrimerNota());
        System.out.println("SEGUNDA NOTA: " + alumno.getSegundaNota());
        System.out.println("PROMEDIO: " + alumno.getPromedio());
    }

    private void buscarPorId() {

        if (this.listaAlumnos.isEmpty()) {
            System.out.println("NO HAY ALUMNOS EN LA LISTA");
        } else {
            System.out.println("---------------------------------------------");
            System.out.print("Ingrese un numero de ID: ");
            int numero = this.sc.nextInt();

            Alumno alumnoBuscado = null;

            for (Alumno alumno : listaAlumnos) {
                if (alumno.getId() == numero) {
                    alumnoBuscado = alumno;
                    break;
                }
            }

            if (alumnoBuscado != null) {
                this.mostrarAlumno(alumnoBuscado);
            } else {
                System.out.println("NO SE ENCONTRO EL ALUMNO");
            }
            System.out.println("---------------------------------------------");
        }

    }

    private void mostrarMayorYMenorPromedio() {
        Alumno maxAlumno = null;
        Alumno minAlumno = null;

        for (Alumno alumno : listaAlumnos) {

            // Maximo
            if (maxAlumno == null || alumno.getPromedio() > maxAlumno.getPromedio()) {
                maxAlumno = alumno;
            }

            // Minimo
            if (minAlumno == null || alumno.getPromedio() < minAlumno.getPromedio()) {
                minAlumno = alumno;
            }

        }

        // Mostrar los alumnos

        if (maxAlumno != null && minAlumno != null) {
            System.out.println("-------------- MAYOR PROMEDIO --------------");
            this.mostrarAlumno(maxAlumno);
            System.out.println("-------------- MENOR PROMEDIO --------------");
            this.mostrarAlumno(minAlumno);
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("LA LISTA ESTA VACIA");
            System.out.println("---------------------------------------------");
        }
    }

    private void mostarAlumnosAprobados() {
        if (this.listaAlumnos.isEmpty()) {
            System.out.println("NO HAY ALUMNOS EN LA LISTA");
        } else {
            System.out.println("--------------- ALUMNOS APROBADOS ---------------");
            for (Alumno alumno : listaAlumnos) {
                if (alumno.getPromedio() > 5.99) {
                    this.mostrarAlumno(alumno);
                }
            }
        }
    }
}
