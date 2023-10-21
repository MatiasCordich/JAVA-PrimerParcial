package menuesEmpleados;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Empleado;

public class MenuEmpleados {

    // ATRIBUTOS
    private boolean continuar = true;
    private Scanner sc;
    private ArrayList<Empleado> listaEmpleados;

    // CONSTRUCTOR
    public MenuEmpleados(Scanner sc, ArrayList<Empleado> listaEmpleados) {
        this.sc = sc;
        this.listaEmpleados = listaEmpleados;
    }

    // GENERICOS
    public void iniciar() {

        while (continuar) {
            int opcion = this.elegirOpcion();
            this.realizarOpcion(opcion);
        }
    }

    private void finalizar() {
        this.continuar = false;
        System.out.println("----------------------------------------------");
        System.out.println("HAS SALIDO DEL PROGRAMA, QUE TENGA UN BUEN DIA");
        System.out.println("----------------------------------------------");
    }

    private void menuOpciones() {
        System.out.println("---------------------------------------------");
        System.out.println("Elija una de las siguientes opciones");
        System.out.println(" 0 - Salir");
        System.out.println(" 1 - Cargar empleado");
        System.out.println(" 2 - Mostrar empleados");
        System.out.println(" 3 - Buscar empleado por ID");
        System.out.println(" 4 - Buscar empleado con mayor y menor sueldo");
        System.out.println(" 5 - Buscar empleados que ganen mas de 800 dolares");
        System.out.println("---------------------------------------------");
    }

    private int elegirOpcion() {
        this.menuOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    // MENU OPCIONES

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                this.finalizar();
                break;
            case 1:
                this.cargarEmpleado();
                break;
            case 2:
                this.mostrarEmpleados();
                break;
            case 3:
                this.buscarEmpleadoPorId();
                break;
            case 4:
                this.buscarEmpleadosConMayorYMenorSueldo();
                break;
            case 5:
                this.buscarEmpleadosQueGanenMasDe800Dolares();
                break;

            default:
                System.out.println("----------------------------------------------");
                System.out.println("OPCION INCORRECTA, INGRESE UNA OPCION VALIDA");
                System.out.println("----------------------------------------------");
                break;
        }
    }

    // METODOS DEL MENU
    private boolean estaVacia() {
        boolean estaVacia = false;

        if (this.listaEmpleados.isEmpty()) {
            estaVacia = true;
        }

        return estaVacia;
    }

    private void cargarEmpleado() {

        System.out.println("--------------- CARGAR EMPLEADO ---------------");
        System.out.print("Ingrese en ID del empleado: ");
        int idIngresado = this.sc.nextInt();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombreIngresado = this.sc.next();
        System.out.print("Ingrese la ocupacion del empleado: ");
        String ocupacionIngresada = this.sc.next();
        System.out.print("Ingrese sueldo del empleado: ");
        double sueldoIngresado = this.sc.nextDouble();

        Empleado nuevoEmpleado = new Empleado(idIngresado, nombreIngresado, ocupacionIngresada, sueldoIngresado);

        this.listaEmpleados.add(nuevoEmpleado);
        System.out.println("---------------------------------------------");
    }

    private void mostrarEmpleado(Empleado empleadoAMostar) {

        System.out.println("---------------------------------------------");
        System.out.println("ID: " + empleadoAMostar.getIdEmpleado());
        System.out.println("NOMBRE: " + empleadoAMostar.getNombre());
        System.out.println("OCUPACION: " + empleadoAMostar.getOcupacion());
        System.out.println("SUELDO: " + empleadoAMostar.getSueldo());
        System.out.println("---------------------------------------------");

    }

    private void mostrarEmpleados() {
        boolean estaVacia = this.estaVacia();

        if (estaVacia) {
            System.out.println("----------------------------------------------");
            System.out.println("NO HAY EMPLEADOS EN LA LISTA");
            System.out.println("----------------------------------------------");
        } else {
            for (Empleado empleado : listaEmpleados) {
                this.mostrarEmpleado(empleado);
            }
        }
    }

    private void buscarEmpleadoPorId() {

        boolean estaVacia = this.estaVacia();

        if (estaVacia) {
            System.out.println("----------------------------------------------");
            System.out.println("NO HAY EMPLEADOS EN LA LISTA");
            System.out.println("----------------------------------------------");
        } else {

            Empleado empleadoABuscar = null;
            System.out.print("Ingrese un ID por favor: ");
            int idIngresado = this.sc.nextInt();

            for (Empleado empleado : listaEmpleados) {
                if (idIngresado == empleado.getIdEmpleado()) {
                    empleadoABuscar = empleado;
                    break;
                }
            }

            if (empleadoABuscar != null) {
                this.mostrarEmpleado(empleadoABuscar);
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("NO SE ENCONTRO UN EMPLEADO CON EL ID INGRESADO");
                System.out.println("----------------------------------------------");
            }

        }
    }

    private void buscarEmpleadosConMayorYMenorSueldo() {
        boolean estaVacia = this.estaVacia();

        if (estaVacia) {
            System.out.println("----------------------------------------------");
            System.out.println("NO HAY EMPLEADOS EN LA LISTA");
            System.out.println("----------------------------------------------");
        } else {

            Empleado maxEmpleado = null;
            Empleado minEmpleado = null;

            for (Empleado empleado : listaEmpleados) {
                if (maxEmpleado == null || empleado.getSueldo() > maxEmpleado.getSueldo()) {
                    maxEmpleado = empleado;
                }

                if (minEmpleado == null || empleado.getSueldo() < minEmpleado.getSueldo()) {
                    minEmpleado = empleado;
                }
            }

            System.out.println("------------- EMPLEADO CON MAYOR SUELDO -------------");
            this.mostrarEmpleado(maxEmpleado);
            System.out.println("------------- EMPLEADO CON MENOR SUELDO -------------");
            this.mostrarEmpleado(minEmpleado);

        }
    }

    private void buscarEmpleadosQueGanenMasDe800Dolares() {
        boolean estaVacia = this.estaVacia();

        if (estaVacia) {
            System.out.println("----------------------------------------------");
            System.out.println("NO HAY EMPLEADOS EN LA LISTA");
            System.out.println("----------------------------------------------");
        } else {
            for (Empleado empleado : listaEmpleados) {
                if (empleado.getSueldo() >= 800) {
                    this.mostrarEmpleado(empleado);
                }
            }
        }
    }

}
